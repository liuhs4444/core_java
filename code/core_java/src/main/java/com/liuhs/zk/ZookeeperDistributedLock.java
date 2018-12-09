package com.liuhs.zk;


import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;

public class ZookeeperDistributedLock {

    // 2.使用Fluent风格的Api创建会话
    private static String lockPath = "/curator/lock";

    private static CuratorFramework client = CuratorFrameworkFactory.builder()
            .connectString("192.168.0.111:2181,192.168.0.122:2181,192.168.0.133:2181")
            .sessionTimeoutMs(5000)
            .connectionTimeoutMs(5000)
            .retryPolicy(new ExponentialBackoffRetry(1000, 3))
            .build();

    public static void main(String[] args) {

        // 1.使用静态工程方法创建客户端
        /*RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
        CuratorFramework client = CuratorFrameworkFactory.newClient(
                "192.168.0.111:2181,192.168.0.122:2181,192.168.0.133:2181",
                5000,
                3000,
                retryPolicy);*/
        client.start();
        // 3.创建分布式锁，锁空间的根节点路径为/curator/lock
        InterProcessMutex mutex = new InterProcessMutex(client, lockPath);

        final CountDownLatch countDownLatch = new CountDownLatch(1);

        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                try {
                    countDownLatch.await();
                    //获得了锁, 进行业务流程
                    mutex.acquire();
                } catch (Exception e) {

                }
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss|SSS");

                String orderNo = sdf.format(new Date());
                System.out.println("订单号：" + orderNo);
                //完成业务流程, 释放锁
                try {
                    mutex.release();
                } catch (Exception e) {
                }
            }).start();
        }
        countDownLatch.countDown();
    }
}

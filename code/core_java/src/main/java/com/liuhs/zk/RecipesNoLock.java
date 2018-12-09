package com.liuhs.zk;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;

public class RecipesNoLock {

    public static void main(String[] args) {

        final CountDownLatch countDownLatch = new CountDownLatch(1);

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    countDownLatch.await();
                } catch (Exception e) {

                }
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss|SSS");
                String orderNo = sdf.format(new Date());
                System.err.println(orderNo);
            }).start();
        }
        System.out.println("countDownLatch = " + countDownLatch);
        countDownLatch.countDown();
    }
}

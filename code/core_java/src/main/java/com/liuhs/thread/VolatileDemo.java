package com.liuhs.thread;

/**
 * <B>功能简述</B><br>
 * volatile关键字
 *
 * @author liuhongshen
 * @date 2018/6/29 下午4:08
 */
public class VolatileDemo {

    static boolean flag = false;

    public static void main(String[] args) {

        // 线程1
        new Thread(() -> {
            while (!flag) {
                System.out.println(Thread.currentThread().getName() + "0000");
            }
        }).start();

        // 线程2
        new Thread(() -> flag = true).start();

    }

}

package com.liuhs.thread;

/**
 * 子线程循环10次，接着主线程循环100次，接着又回到子线程循环10次，接着主线程又循环100次，如此循环50次
 */
public class TraditionalThreadCommunication {

    public static void main(String args[]) {

        new Thread(() -> {
            for (int i = 1; i <= 50; i++) {
                synchronized (TraditionalThreadCommunication.class) {
                    for (int j = 1; j <= 10; j++) {
                        System.out.println("sub thread seq of " + j + " ,loop of " + i);
                    }
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }
            }
        }).start();

        for (int i = 1; i <= 50; i++) {
            synchronized (TraditionalThreadCommunication.class) {
                for (int j = 1; j <= 100; j++) {
                    System.out.println("main thread seq of " + j + " ,loop of " + i);
                }
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
        }
    }
}

package com.liuhs.thread;

public class TraditionalThreads {
    public static void main(String args[]) {
        new Thread(() -> {
            while (true) {
                System.out.println("runnable:" + Thread.currentThread().getName());
            }
        }) {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                    }
                    System.out.println("thread:" + Thread.currentThread().getName());
                }
            }
        }.start();

        // 从面向对象的角度思考问题
    }
}

package com.liuhs.thread;

public class TraditionalThread {
    public static void main(String args[]) {
        Thread thread = new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("1:" + Thread.currentThread().getName());
                    System.out.println("2:" + this.getName());
                }
            }
        };
        thread.start();

        Thread thread1 = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("1:" + Thread.currentThread().getName());
                System.out.println("2:" + Thread.currentThread().getName());
            }
        });
        thread1.start();
    }
}




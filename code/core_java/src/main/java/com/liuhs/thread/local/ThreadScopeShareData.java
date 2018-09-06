package com.liuhs.thread.local;

import java.util.Random;

public class ThreadScopeShareData {

    private static int data = 0;

    public static void main(String args[]) throws InterruptedException {
        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                data = new Random().nextInt(9);
                System.out.println(Thread.currentThread().getName() + " has put data:" + data);
                new A().get();
                new B().get();
            }).start();
            Thread.sleep(1);
        }
    }


    static class A {
        public void get() {
            System.out.println("A " + Thread.currentThread().getName() + " has put data:" + data);
        }
    }

    static class B {
        public void get() {
            System.out.println("B " + Thread.currentThread().getName() + " has put data:" + data);
        }
    }
}


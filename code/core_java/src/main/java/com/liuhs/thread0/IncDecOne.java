package com.liuhs.thread0;

public class IncDecOne {

    private int j;

    public static void main(String[] args) {
        IncDecOne incDecOne = new IncDecOne();
        for (int i = 0; i < 2; i++) {
            new Thread(incDecOne.new Inc()).start();
            new Thread(incDecOne.new Dec()).start();
        }

    }

    public synchronized void inc() {
        j++;
        System.out.println(Thread.currentThread().getName() + "inc");
    }

    public synchronized void dec() {
        j--;
        System.out.println(Thread.currentThread().getName() + "dec");
    }

    class Inc implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                inc();
            }
        }
    }

    class Dec implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                dec();
            }
        }
    }
}

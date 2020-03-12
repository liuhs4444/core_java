package com.liuhs.thread0.abcd;

public class ThreadPrintAbcd {

    public static void main(String[] args) {

        Business business = new Business();

        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                business.printA(i);
            }
        }).start();

        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                business.printB(i);
            }
        }).start();

        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                business.printC(i);
            }
        }).start();
    }


}

class Business {

    // 此刻为了便于理解采用字符串控制状态 a b c
    private String status = "a";

    public synchronized void printA(int i) {
        while (!"a".equalsIgnoreCase(status)) {
            try {
                this.wait();
            } catch (InterruptedException e) {
            }
        }
        System.out.println("A_" + i);
        status = "b";
        this.notifyAll();
    }


    public synchronized void printB(int i) {
        while (!"b".equalsIgnoreCase(status)) {
            try {
                this.wait();
            } catch (InterruptedException e) {
            }
        }
        System.out.println("B_" + i);
        status = "c";
        this.notifyAll();
    }

    public synchronized void printC(int i) {
        while (!"c".equalsIgnoreCase(status)) {
            try {
                this.wait();
            } catch (InterruptedException e) {
            }
        }
        System.out.println("C_" + i);
        status = "a";
        this.notifyAll();
    }

}



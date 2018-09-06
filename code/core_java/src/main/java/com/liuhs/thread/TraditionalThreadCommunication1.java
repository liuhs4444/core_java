package com.liuhs.thread;

public class TraditionalThreadCommunication1 {

    public static void main(String args[]) {

        final Business business = new Business();
        new Thread(() -> {
            for (int i = 1; i <= 50; i++) {
                business.sub(i);
            }
        }).start();


        for (int i = 1; i <= 50; i++) {
            business.main(i);
        }
    }

}

class Business {

    public synchronized void sub(int i) {
        for (int j = 1; j <= 10; j++) {
            System.out.println("sub thread seq of " + j + " ,loop of " + i);
        }
    }

    public synchronized void main(int i) {
        for (int j = 1; j <= 100; j++) {
            System.out.println("main thread seq of " + j + " ,loop of " + i);
        }
    }
}

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

    private boolean bShouldSub = true;

    synchronized void sub(int i) {

        // wait必须放在synchronized里面
        while (!bShouldSub) {
            try {
                this.wait();
            } catch (InterruptedException e) {
            }
        }

        for (int j = 1; j <= 10; j++) {
            System.out.println("sub thread seq of " + j + " ,loop of " + i);
        }
        this.bShouldSub = false;
        this.notify();
    }

    public synchronized void main(int i) {
        while (bShouldSub) {
            try {
                this.wait();
            } catch (InterruptedException ignored) {
            }
        }
        for (int j = 1; j <= 100; j++) {
            System.out.println("main thread seq of " + j + " ,loop of " + i);
        }
        this.bShouldSub = true;
        this.notify();
    }
}

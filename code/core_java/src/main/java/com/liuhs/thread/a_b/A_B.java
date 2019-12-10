package com.liuhs.thread.a_b;

/**
 * <B>功能简述</B><br>
 * 两个线程交替打印A B
 *
 * @author liuhongshen
 * @date 2018/12/9 下午8:25
 */
public class A_B {

    public static void main(String[] args) {

        Business business = new Business();

        new Thread(() -> {
            while (true)
                business.printA(0);

        }).start();

        new Thread(() -> {
            while (true)
                business.printB(0);

        }).start();
    }


}

class Business {
    private boolean isA = true;

    public synchronized void printA(int i) {
        while (!isA) {
            try {
                this.wait();
            } catch (InterruptedException e) {
            }
        }
        System.out.println("A_" + i);
        isA = false;
        this.notify();
    }


    public synchronized void printB(int i) {
        while (isA) {
            try {
                this.wait();
            } catch (InterruptedException e) {
            }
        }
        System.out.println("B_" + i);
        isA = true;
        this.notify();
    }
}

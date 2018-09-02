package com.liuhs.thread.sync;

public class TraditionalThreadSynchronized {
    public static void main(String args[]) {
        new TraditionalThreadSynchronized().init();
    }

    public void init() {
        final Outputer outputer = new Outputer();
        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
                outputer.output("wuchunyu");
            }
        }).start();

        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
                outputer.output("liuhongshen");
            }
        }).start();
    }

    // 输出器
    static class Outputer {

        // private String sync = "xxx";

        void output(String name) {
            int len = name.length();
            synchronized (Outputer.class) {
                for (int i = 0; i < len; i++) {
                    System.out.print(name.charAt(i));
                }

                System.out.println();
            }
        }

        synchronized void output2(String name) {
            int len = name.length();
            for (int i = 0; i < len; i++) {
                System.out.print(name.charAt(i));
            }

            System.out.println();
        }

        static synchronized void output3(String name) { // static synchronized
            int len = name.length();
            for (int i = 0; i < len; i++) {
                System.out.print(name.charAt(i));
            }

            System.out.println();
        }
    }
}

package com.liuhs.thread.timer;

import java.util.Timer;
import java.util.TimerTask;

public class MyTimerTask {

    public static void main(String args[]) {

        class Task extends TimerTask {
            @Override
            public void run() {
                System.out.println("bombing ...");
                new Timer().schedule(new Task(), 2000);
            }
        }

        new Timer().schedule(new Task(), 2000);
    }
}

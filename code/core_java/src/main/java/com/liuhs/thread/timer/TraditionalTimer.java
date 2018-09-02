package com.liuhs.thread.timer;

import java.util.Timer;
import java.util.TimerTask;

public class TraditionalTimer {

    public static void main(String args[]) {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("timer_task:" + Thread.currentThread().getName());
            }
        }, 5000, 3000); // 第一次5秒后打印，以后每3秒打印一次
    }
}

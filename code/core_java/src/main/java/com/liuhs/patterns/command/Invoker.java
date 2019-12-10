package com.liuhs.patterns.command;

/**
 * 调用者
 */
public class Invoker {

    private Command command;

    public Invoker(Command command) {
        this.command = command;
    }

    /**
     * 调用方法
     */
    public void invoke() {
        command.execute();
    }


}

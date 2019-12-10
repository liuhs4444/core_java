package com.liuhs.patterns.command;

/**
 * 具体的命令
 */
public class ConcreteCommand implements Command {

    private Receiver receiver;

    public ConcreteCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        // 调用真正的接收者来执行命令
        receiver.doAction();
    }
}

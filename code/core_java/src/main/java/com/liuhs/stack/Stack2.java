package com.liuhs.stack;

import java.util.LinkedList;

public class Stack2 {

    /**
     * 实现一个有min方法的栈，返回栈里最小的元素，且时间复杂度为o(1)
     */
    private LinkedList<Integer> dataStack = new LinkedList<>();

    private LinkedList<Integer> minStack = new LinkedList<>();

    public void push(int data) {
        dataStack.push(data);
        // minStack为空或者栈顶元素大于data
        if (minStack.isEmpty() || minStack.peek() > data) {
            minStack.push(data);
        } else {
            minStack.push(minStack.peek());
        }
    }

    public void pop() {
        dataStack.pop();
        minStack.pop();
    }

    public Integer min() {
        return minStack.peek();
    }

    public static void main(String[] args){
        Stack2 stack2 = new Stack2();
        stack2.push(2);
        stack2.push(3);
        stack2.push(6);
        stack2.push(1);
        stack2.pop();

        System.out.println("stack2 = " + stack2.min());
    }
}

package com.liuhs.stack;

import java.util.LinkedList;

/**
 * 用栈来计算后缀表达式
 */
public class Stack1 {

    // ["4", "13", "5", "/", "+"]

    // 思路
    // 1.使用for循环遍历数组，对每一个元素做如下操作:
    // 2.如果元素不是 + - * / 中的某一个，就压入栈中
    // 3.如果元素是 + - * / 中的某一个，则从栈里连续弹出两个元素，并对这两个元素进行计算，
    // 将计算结果压入栈中

    public static String isPostfixExpression(String[] postfixExpression) {
        LinkedList<String> stack = new LinkedList<>();
        for (String s : postfixExpression) {
            if (!s.matches("/+|-|/*|/")) {
                stack.push(s);
            } else {
                System.out.println("stack = " + stack);
                int i = Integer.parseInt(stack.pop());
                int i1 = Integer.parseInt(stack.pop());
                System.out.println("stack = " + stack);
                stack.push(String.valueOf(i1 / i));
                System.out.println("stack = " + stack);
            }
        }
        return stack.size() == 1 ? stack.getFirst() : null;
    }

    public static void main(String[] args) {
        String[] postfixExpression = {"4", "13", "5", "/", "+"};
        String postfixExpression1 = isPostfixExpression(postfixExpression);
        System.out.println("postfixExpression1 = " + postfixExpression1);
    }
}

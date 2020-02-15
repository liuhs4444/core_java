package com.liuhs.stack;

import java.util.LinkedList;

/**
 * 栈的练习题
 */
public class StackExercise {

    /**
     * 1.下面的字符串中包含小括号，请编写一个函数判断字符串中的括号是否合法，所谓合法，就是
     * 括号成对出现
     * (daf(d(dfs)666)fss)
     * (11(1234)(12345)11)
     * ()()sx()(ss()fw))(
     */
    public static boolean isCorrectParentheses(String parentheses_1) {
        String[] chars_1 = parentheses_1.split("");
        LinkedList<String> list_1 = new LinkedList<>();
        for (String c : chars_1) {
            // 遇到左括号入栈
            if ("(".equalsIgnoreCase(c)) {
                list_1.push(c);
                // 遇到右括号判断是否为空
            } else if (")".equalsIgnoreCase(c)) {
                if (list_1.isEmpty()) {
                    return false;
                } else {
                    list_1.pop(); // 弹出左括号
                }
            }
        }
        // 如果栈为空，说明括号合法
        return list_1.isEmpty();
    }

    // 思路
    // 1.遇到左括号，就把左括号压入栈中
    // 2.遇到右括号，判断栈是否为空，为空说明没有座括号与之对应，缺少左括号，字符串
    // 括号不合法，如何栈不为空，则把栈顶元素移除，这对括号抵消掉了
    // 当for循环结束之后，如果栈是空的，就说明所有的括号都低效掉了，如果栈里还有元素，
    // 则说明缺少右括号，字符串括号不合法

    public static void main(String[] args) {
        // 判断括号是否正确
        String parentheses_1 = "(daf(d(dfs)666)fss)"; // 括号1
        String parentheses_2 = "(11(1234)(12345)11)"; // 括号2
        String parentheses_3 = "()()sx()(ss()fw))("; // 括号3
        boolean correctParentheses1 = isCorrectParentheses(parentheses_1);
        boolean correctParentheses2 = isCorrectParentheses(parentheses_2);
        boolean correctParentheses3 = isCorrectParentheses(parentheses_3);
        System.out.println("括号是否规范1： " + correctParentheses1);
        System.out.println("括号是否规范2： " + correctParentheses2);
        System.out.println("括号是否规范3： " + correctParentheses3);
    }
}

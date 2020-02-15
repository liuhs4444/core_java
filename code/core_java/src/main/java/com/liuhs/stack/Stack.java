package com.liuhs.stack;

import java.util.LinkedList;

/**
 * 栈
 */
public class Stack<E> {

    private transient LinkedList<E> elementData;

    public Stack() {
        elementData = new LinkedList<>();
    }

    /**
     * 添加一个元素到栈顶
     */
    public void push(E element) {
        elementData.push(element);
    }

    /**
     * pop 弹出栈顶元素
     */
    public E pop() {
        return elementData.pop();
    }

    /**
     * top 返回栈顶元素
     */
    public E top() {
        return elementData.peek();
    }

    /**
     * isEmpty 判断栈是否为空
     */
    public boolean isEmpty() {
        return elementData.isEmpty();
    }

    /**
     * size返回栈里元素的个数
     */
    public int size() {
        return elementData.size();
    }

    /**
     * 清空栈
     */
    public void clear() {
        elementData.clear();
    }

}

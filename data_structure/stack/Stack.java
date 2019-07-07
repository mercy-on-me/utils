package com.example.datastructure.datastructure.stack;

/**
 * @program: Stack
 * @description: Stack 接口,实现 5 中基本方法
 * @author: cy
 **/
public interface Stack<E> {

    /** 入栈. */
    void push(E element);

    /** 出栈. */
    E pop();

    /** 获取栈顶的元素. */
    E peek();

    /** 获取栈内元素的个数. */
    int getSize();

    /** 判断栈是否为空. */
    boolean isEmpty();
}

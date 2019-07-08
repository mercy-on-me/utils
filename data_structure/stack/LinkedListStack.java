package com.example.datastructure.datastructure.stack;

import com.example.datastructure.datastructure.linkedList.LinkedList;
import com.example.datastructure.datastructure.stack.Stack;

/**
 * @program: utils
 * @description: 基于链表实现栈
 * @author: cy
 **/

public class LinkedListStack<E> implements Stack<E> {

    private LinkedList<E> list;

    public LinkedListStack() {
        list = new LinkedList<>();
    }

    @Override
    public void push(E element) {
        list.addFirst(element);
    }

    @Override
    public E pop() {
        return list.removeFirst();
    }

    @Override
    public E peek() {
        return list.getFirst();
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("stack : top [ ");
        sb.append(list);
        return sb.toString();
    }
}

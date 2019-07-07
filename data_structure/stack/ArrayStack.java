package com.example.datastructure.datastructure.stack;

import com.example.datastructure.datastructure.array.sync.Array;

/**
 * @program: demo
 * @description: 基于动态数组实现的 Stack, 需要引入自己封装的动态数据
 * @See: /Documents/doc/utils/array/Array.java      /Documents/doc/utils/stack/Stack.java
 * @author: cy
 **/

public class ArrayStack<E> implements Stack<E> {

    Array<E> array;

    public ArrayStack(int capocity) {
        array = new Array<>(capocity);
    }

    public ArrayStack(){
        array = new Array<>();
    }

    @Override
    public void push(E element) {
        array.addLast(element);
    }

    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public E peek() {
        return array.getLast();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }


    public int getCapacity(){
        return array.getCapocity();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Stack: bottom [");
        for (int i = 0; i < array.getSize(); i++) {
            sb.append(array.get(i));
            if ( i != array.getSize() -1) {
                sb.append(", ");
            }
        }
        sb.append("] top");
        return sb.toString();
    }
}

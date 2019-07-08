package com.example.datastructure.datastructure.queue.arrayqueue;

import com.example.datastructure.datastructure.array.sync.Array;

/**
 * @program: utils
 * @description: 基于动态数组的数组队列 Queue. 需要引入动态数组 Array
 *  数组队列的问题 : 出队的时候, 每出队一个元素(从队首, 也就是最左边移除一个元素,就需要将后边的元素都向前移动一位),
 *                  如果有 100 万个元素,每出队一个元素, 就需要移动将近 100 万次, 所以需要升级为 [ 循环队列 ]
 * @author: cy
 **/

public class ArrayQueue<E> implements Queue<E> {

    private Array<E> array;

    public ArrayQueue(int capacity) {
        array = new Array<>(capacity);
    }

    public ArrayQueue() {
        array = new Array<>();
    }

    @Override
    public void enqueue(E element) {
        array.addLast(element);
    }

    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    @Override
    public E getFront() {
        return array.getFirst();
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
        sb.append("Queue : Front [");
        for (int i = 0; i < array.getSize(); i++) {
            sb.append(array.get(i));
            if (i != array.getSize() - 1) {
                sb.append(", ");
            }
        }
        sb.append("] tail");
        return sb.toString();
    }
}

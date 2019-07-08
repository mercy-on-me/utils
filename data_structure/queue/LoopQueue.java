package com.example.datastructure.datastructure.queue.loop;

/**
 * @program: utils
 * @description: 循环队列
 * @author: cy
 **/

public class LoopQueue<E> implements Queue<E> {

    /** 存放元素的数组. */
    private E[] data;

    /** 指向队首位置. */
    private int front;

    /** 指向下一个元素存放的位置. */
    private int tail;

    /** 队列中的元素的个数. */
    private int size;

    public LoopQueue(int capacity) {
        data = (E[])new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue() {
        this(10);
    }

    public int getCapacity(){
        return data.length - 1;
    }

    @Override
    public void enqueue(E element) {
         if ((tail + 1) % data.length == front) {
             resize(getCapacity() * 2);
         }
         data[tail] = element;
         tail = (tail + 1) % data.length;
         size++;
    }

    @Override
    public E dequeue() {
        if (tail == front) {
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        }
        E frontE = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        if (size < getCapacity()/4 && getCapacity()/2 != 0) {
            resize(getCapacity()/2);
        }
        return frontE;
    }

    @Override
    public E getFront() {
        if (tail == front) {
            throw new IllegalArgumentException("queue is  empty.");
        }
        return data[front];
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    /**
     * 扩容
     * @param newCapacity 扩大后的容量.
     */
    private void resize(int newCapacity){
        E[] newData = (E[])new Object[newCapacity + 1];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(front + i) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Queue: size = %d, capacity = %d\n", size, getCapacity()));
        sb.append("front [");
        for (int i = front; i != tail; i = (i + 1) % data.length) {
            sb.append(data[i]);
            if ((i + 1) % data.length != tail) {
                sb.append(", ");
            }
        }
        sb.append("] tail");
        return sb.toString();
    }
}

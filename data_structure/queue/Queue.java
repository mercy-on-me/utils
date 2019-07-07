package com.example.datastructure.datastructure.queue;

/**
 * @program: demo
 * @description: 队列接口
 * @author: cy
 **/
public interface Queue<E> {

    /** 入队. */
    public void enqueue(E element);

    /** 出队. */
    public E dequeue();

    /** 获取队首的元素. */
    public E getFront();

    /** 获取队列长度. */
    public int getSize();

    /** 判断队列是否为空. */
    public boolean isEmpty();

}

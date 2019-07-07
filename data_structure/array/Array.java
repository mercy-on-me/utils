package com.example.datastructure.datastructure.array.sync;

/**
 * @program: Array
 * @description: 封装自定义的动态数组. github : /Documents/doc/utils/array/Array.java
 * @author: cy
 **/

public class Array<E> {

    /** 要操作的 java 数组. */
    private E[] data;

    /** 数组内实际存放的元素的个数. */
    private int size;

    /**
     * 无参构造函数. 默认容量为 10.
     */
    public Array() {
        this(10);
    }

    /**
     * 构造函数, 根据传入的数组的容量 capocity 构造 Array.
     * @param capacity 要构造的数组的容量.
     */
    public Array(int capacity) {
        data = (E[])new Object[capacity];
        size = 0;
    }


    /**
     * 获取数组中的元素的个数.
     * @return
     */
    public int getSize(){
        return size;
    }

    /**
     * 获取数组的容量.
     * @return
     */
    public int getCapocity(){
        return data.length;
    }

    /**
     * 判断数组中是否有元素.
     * @return
     */
    public boolean isEmpty(){
        return size == 0;
    }

    //============添加元素=================

    /**
     * 在数组的首部插入元素.
     * @param element 待插入元素
     */
    public void addFirst(E element){
        addAtIndex(0, element);
    }

    /**
     * 向数组的末尾插入元素.
     * @param element 待插入元素
     */
    public void addLast(E element){
        addAtIndex(size, element);
    }

    /**
     * 在数组中指定位置插入元素.
     * @param index 要插入元素的位置
     * @param element 待插入的元素
     */
    public void addAtIndex(int index, E element){
        if (size == data.length) {
            resize(data.length + data.length/2);
        }
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("method [addAtIndex] failed. Require index >= 0 && index <= size .");
        }
        for (int i = size - 1; i >= index ; i--) {
            data[i + 1] = data[i];
        }
        data[index] = element;
        size++;
    }


    //============获取元素=================

    /**
     * 获取指定索引的元素
     * @param index 目标索引
     * @return
     */
    public E get(int index){
        if (isEmpty()) {
            return null;
        }
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("method [getElementAtIndex] failed. Index is illegal .");
        }
        return data[index];
    }


    public E getLast(){
        return get(size - 1);
    }

    public E getFirst(){
        return get(0);
    }


    //============更新元素=================

    /**
     * 修改 index 位置的元素为 element
     * @param index 要修改的元素的索引
     * @param element 值
     */
    public void set(int index, E element){
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("method [getElementAtIndex] failed. Index is illegal .");
        }
        data[index] = element;
    }


    //============删除元素=================

    /**
     * 移除 index 位置的元素,并返回删除的元素.
     * @param index
     * @return
     */
    public E remove(int index){
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("method [getElementAtIndex] failed. Index is illegal .");
        }
        E element = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        data[size] = null;
        if (size < data.length/2) {
            resize(data.length/2);
        }
        return element;
    }

    /**
     * 移除数组中的最后一个元素, 并返回移除的元素
     * @return
     */
    public E removeLast(){
        return remove(size - 1);
    }

    /**
     * 移除数组中的第一个元素, 并返回移除的元素
     * @return
     */
    public E removeFirst(){
        return remove(0);
    }

    /**
     * 移除指定元素. 如果有多个相同的元素element, 则只删除第一个.
     * @param element
     * @return
     */
    public void removeElement(E element){
        int index = indexOf(element);
        if (-1 != index) {
            remove(index);
        }

    }


    /**
     * 判断数据中是否包含目标元素
     * @param element 目标元素
     * @return
     */
    public boolean contains(E element){
        for (int i = 0; i < size; i++) {
            if (data[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 获取元素第一次出现的索引. 如果存在此元素,返回索引.如果不存在则返回-1
     * @param element
     * @return
     */
    public int indexOf(E element){
        for (int i = 0; i < size; i++) {
            if (data[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }


    //==============[动态数组]================

    /**
     * 修改数组的容量. 每次扩容 50% / 每次缩短 50%
     */
    private void resize(int capacity){
        E[] newData = (E[])new Object[capacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
        newData = null;
    }




    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Array: size = %d, capacity = %d\n", size, data.length));
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i != size-1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }


}

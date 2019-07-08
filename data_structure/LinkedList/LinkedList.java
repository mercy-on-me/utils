package com.example.datastructure.datastructure.linkedList;

/**
 * @program: utils
 * @description: 有虚拟头结点的 LinkedList
 * @author: cy
 * @create: 2019-07-08 13:40
 **/

public class LinkedList<E> {

    /** 节点.*/
    private class Node{
        public E element;
        public Node next;

        public Node(E element, Node next) {
            this.element = element;
            this.next = next;
        }

        public Node(E element) {
            this(element,  null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return element.toString();
        }
    }

    /** 虚拟头结点,指向头. */
    private Node dummyHead;

    /** 链表中元素个数. */
    private int size;

    public LinkedList() {
        dummyHead = new Node(null, null);
        size = 0;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }


    /**
     * 在链表的 index 位置添加元素 element  O(n)
     * @param element 待添加的元素
     * @param index 要添加的位置
     */
    public void addAtIndex(E element, int index){
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed, Illegal index.");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        prev.next = new Node(element, prev.next);
        size++;

    }

    /** 在链表头添加元素.   O(1) */
    public void addFirst(E element){
        addAtIndex(element, 0);
    }


    /** 在链表尾部添加元素.   O(n) */
    public void addLast(E element){
        addAtIndex(element, size);
    }

    /**
     * 获取指定索引位置的元素
     * @param index
     * @return
     */
    public E get(int index){
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Get failed, Illegal index.");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.element;
    }

    /** 获取第一个节点. */
    public E getFirst(){
        return get(0);
    }

    /** 获取最后一个节点. */
    public E getLast(){
        return get(size - 1);
    }


    /**
     * 修改指定索引的节点值为 element
     * @param element
     * @param index
     */
    public void set(E element, int index){
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Update failed, Illegal index.");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.element = element;
    }

    /**
     * 判断链表中是否存在 element
     * @param element
     * @return
     */
    public boolean contains(E element){
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.element.equals(element)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    /**
     * 删除指定位置的节点
     * @param index
     */
    public E remove(int index){
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Remove failed, Illegal index.");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node delNode = prev.next;
        prev.next = delNode.next;
        delNode.next = null;
        size--;
        return delNode.element;
    }

    /** 移除第一个元素. */
    public E removeFirst(){
        return remove(0);
    }

    /** 移除最后一个元素. */
    public E removeLast(){
        return remove(size - 1);
    }



    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node cur = dummyHead.next;
        sb.append("LinkedList : [ ");
        while (cur != null){
            sb.append(cur + " --> ");
            cur = cur.next;
        }
        sb.append("NULL ]");
        return sb.toString();
    }
}

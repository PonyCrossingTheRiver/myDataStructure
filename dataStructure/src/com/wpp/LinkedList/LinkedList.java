package com.wpp.LinkedList;

import java.util.List;

public class LinkedList<E> {

    private class Node{
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }
        public Node(E e) {
            this(e,null);
        }

        public Node() {
            this(null,null);
        }
        @Override
        public String toString() {
            return e.toString();
        }
    }
    private Node dummyHead;
    int size;
    public LinkedList() {
        dummyHead = new Node();
        size = 0;
    }
    // 获取链表中的元素个数
    public int getSize() {
        return size;
    }
    // 返回链表是否为空
    public boolean isEmpty() {
        return size == 0;
    }
    // 在链表index(0-based)位置添加新的元素w
    // 在链表中不是一个常用的操作，练习用
    public void add(int index,E e) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("add fail, index is illegal");

        Node prev = dummyHead;
        for (int i = 0; i < index; i++)
            prev = prev.next;
//            Node node = new Node(e);
//            node.next = prev.next;
//            prev.next = node;
        prev.next = new Node(e,prev.next);
        size++;
    }
    public void addFirst(E e) {
//        Node node = new Node(e);
//        node.next = head;
//        head = node;
        add(0,e);
    }
    public void addLast(E e){
        add(size,e);
    }

    // 获得链表的第index(0-index)个位置的元素
    // 在链表中不是一个常用的操作，练习用
    public E get(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("get failed,Illegal index");
        Node curr = dummyHead.next;
        for (int i = 0;i < index;i++)
            curr = curr.next;
        return curr.e;
    }
    //
    public E getFirst() {
        return get(0);
    }
    public E getLast() {
        return get(size -1);
    }
    // 修改链表的第index（0-baseed)个位置的元素为e
    // 在链表中不是一个常见的操作 练习使用
    public void set(int index,E e) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("set failed, Illegal index");
        Node curr = dummyHead.next;
        for (int i =0; i < index; i++) {
            curr = curr.next;
        }
        curr.e = e;
    }
    // 查找链表中是否有元素e
    public boolean contains(E e) {
        /*for (int i = 0; i < size; i++) {
            if (get(i).equals(e)) {
                return true;
            }
        }*/
        Node curr = dummyHead.next;
        while (curr != null) {
            if (curr.e.equals(e))
                return true;
            curr = curr.next;
        }
        return false;
    }
    //  修删除链表的第index（0-baseed)个位置的元素为e
    //  在链表中不是一个常见的操作 练习使用
    public E remove(int index) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("remove failed, index is illegal");
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node retNode = prev.next;
        prev.next = retNode.next;
        retNode.next = null;
        size--;
        return retNode.e;
    }

    public E removeFitst() {
      return   remove(0);
    }

    public E removeLast() {
        return remove(size-1);
    }
    @Override
    public String toString () {
        StringBuilder res = new StringBuilder();
//        Node curr = dummyHead.next;
//        while (curr != null) {
//            res.append(curr + "->");
//            curr = curr.next;
//        }
        for (Node curr = dummyHead.next; curr != null; curr = curr.next)
            res.append(curr +"->");

        res.append("NULL");
        return res.toString();
    }
}

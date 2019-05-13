package com.wpp.stackandqueue.queue;

/**
 * 链表头是 队首  链表尾是队尾
 * @param <E>
 */
public class LinkedListQueue<E> implements Queue<E> {

    private class Node{
        public E e;
        public Node next;

        public   Node (E e, Node next) {
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

    private Node head, tail;
    private int size;

    public LinkedListQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    // 入队操作
    @Override
    public void enqueue(E e) {
        if (tail == null) {
            tail = new Node(e);
            head = tail;
        } else {
            tail.next = new Node(e);
            tail = tail.next;
        }
        size++;
    }

    // 出队操作
    @Override
    public E dequeue() {
        if(size == 0)
            throw new IllegalArgumentException("LinkedListQueue is empty");
         Node retNode = head;
         head = head.next;
         if (head == null)
             tail = null;
         size--;
        return retNode.e;
    }

    @Override
    public E getFont() {
        if (isEmpty())
            throw new IllegalArgumentException("LlinkedListQueue is empay");

        return head.e;
    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Queue:front ");
        Node cur = head;
        while (cur != null) {
            sb.append(cur+"->");
            cur = cur.next;
        }
        sb.append("null tail");
        return sb.toString();
    }
}

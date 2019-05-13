package com.wpp.stackandqueue.stack;


import com.wpp.LinkedList.LinkedList;

public class LinkedListStack<E> implements StackInterface<E> {
    private LinkedList<E> list;

    public LinkedListStack() {
        this.list = new LinkedList();
    }
    @Override
    public void push(E e) {
        list.addFirst(e);
    }

    @Override
    public E pop() {
        return list.removeLast();
    }

    @Override
    public E peek() {
        return list.getFirst();
    }


    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public int getSize() {
        return list.getSize();
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("top->");
        sb.append(list);
        sb.append("->tail");
        return sb.toString();
    }
}

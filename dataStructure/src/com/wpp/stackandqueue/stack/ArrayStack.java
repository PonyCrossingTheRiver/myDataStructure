package com.wpp.stackandqueue.stack;

import com.wpp.arr.Array;

public class ArrayStack<E> implements StackInterface<E>{

    private Array<E> data;

    public ArrayStack(int cap) {
        data = new Array(cap);
    }
    public ArrayStack(){
        data = new Array(10);
    }
    @Override
    public int getSize() {
        return data.getSize();
    }
    @Override
    public void push(E e) {
        data.addFirst(e);
    }
    @Override
    public E pop() {
        return data.removeFirst();
    }

    @Override
    public E peek() {
        return data.getFirst();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("stack: ");
        sb.append("[");
        for (int i = 0; i < data.getSize(); i++) {
            sb.append(data.get(i));
            if (i != data.getSize() -1)
                sb.append(",");
        }
        sb.append("] top");
        return sb.toString();
    }
}
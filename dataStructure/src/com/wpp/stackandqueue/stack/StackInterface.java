package com.wpp.stackandqueue.stack;

public interface StackInterface<E>{

    public void push(E e);

    public E pop();

    public E peek();

    public boolean isEmpty();

    public int getSize();
}

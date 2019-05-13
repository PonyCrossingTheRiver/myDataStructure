package com.wpp.stackandqueue.queue;

import com.wpp.arr.Array;

/**
 * @param <E>
 */
public interface Queue<E> {

    int getSize();
    boolean isEmpty();
    void enqueue(E e);
    E dequeue();
    E getFont();
}

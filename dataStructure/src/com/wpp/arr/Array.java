package com.wpp.arr;

import java.util.Objects;

/**
 * 自定义数组
 * @param <E>
 */
public class Array<E> {
    private E[] data;
    private int size;
    /**
     * 构造函数
     * @param  capacity 初始化最大容量
      */
    public Array(int capacity) {
        data = (E[])new Object[capacity];
        size = 0;
    }
    /**
     * 默认容量为10
     */
    public Array () {
        this(10);
    }
    /**
     * 得到数组有效长度
     *  @return
     */
    public int getSize() {
        return  size;
    }

    /**
     * 得到数组容量
     * @return
     */
    public int getCapactiy() {
        return data.length;
    }
    /**
     * 返回数组是否为空
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     *向所有元素后添加一个元素
     * @param e
     */
    public void addLast(E e) {
        add(size,e);
    }
    public void addFirst(E e) {
        add(0,e);
    }

    /**
     * 向指定位置 第index个位置添加元素
     * @param index
     * @param e
     */
    public void add(int index, E e) {

        if (index <0 || index > size)
            throw new IllegalArgumentException("Add filed, required index >=0 and index <= size");
        if (size == data.length)
            resize(2*data.length);
        for (int i = size-1; i >= index; i--)
            data[i +1] = data[i];
        data[index] = e;
        size++;
    }

    public E get(int index){
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Get filed,index is illegal");
        return data[index];
    }
    public E getFirst() {
        return get(0);
    }
    public E getLast() {
        return get(size-1);
    }
    public void set(int index, E e) {
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Set filed,index is illegal");
        data[index] = e;
    }
    public boolean contaion (E e) {
        for (int i = 0; i < size; i ++) {
            if (data[i].equals(e)) return true;
        }
        return false;
    }
    public int find(E e) {
        for (int i = 0; i < size; i++)
            if (data[i].equals(e)) return i;
        return -1;
    }

    /**
     * 从数组中删除index位置的元素 返回删除的元素
     * @param index
     * @return
     */
    public E remove(int index) {
        if (index < 0 || index >= size)
            throw  new IllegalArgumentException("delete filed, index is illegal");
//        if (index == data.length)
//            throw  new IllegalArgumentException("delete filed,index is full");
        E ret = data[index];
        for (int i = index+1; i < size; i++)
            data[i-1] = data[i];
        size--;
        data[size] = null;// loitering objects != memory lesk
        if (size == data.length/4 && data.length/2 != 0)// 防止复杂度震荡
            resize(data.length/2);
        return ret;
    }
    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size-1);
    }
    public void removeElement(E e) {
       int index = find(e);
       if (index != -1) remove(index);
    }
    @Override
    public  String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array：size = %d , capacity = %d\n",size,data.length));
        res.append('[');
        for(int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size-1) {
                res.append(",");
            }
        }
        res.append("]");
        return res.toString();
    }
    private void resize(int newCapacity) {
        E[] newData = (E[])new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }
}

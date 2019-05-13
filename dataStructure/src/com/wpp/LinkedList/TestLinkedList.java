package com.wpp.LinkedList;

public class TestLinkedList {

    public static void main(String[] args) {
        LinkedList<Integer> e =  new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            e.addFirst(i);
            System.out.println(e);
        }
        e.add(2,666);
        System.out.println(e);
        e.remove(2);
        System.out.println(e);
        e.removeFitst();
        System.out.println(e);
        e.removeLast();
        System.out.println(e);
    }
}

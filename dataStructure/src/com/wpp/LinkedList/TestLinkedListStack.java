package com.wpp.LinkedList;

import com.wpp.stackandqueue.stack.LinkedListStack;

public class TestLinkedListStack {
    public static void main(String[] args) {
        LinkedListStack stack = new LinkedListStack();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
            System.out.println(stack);
        }
        stack.pop();
        System.out.println(stack);
    }
}

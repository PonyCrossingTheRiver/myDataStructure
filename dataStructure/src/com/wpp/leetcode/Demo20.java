package com.wpp.leetcode;


import java.util.Stack;

public class Demo20 {

    public boolean isVaild(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0;i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{')
                stack.push(c);
            else {
                if (stack.isEmpty())
                    return false;
                char topChar = stack.pop();
                if (c == ')' && topChar != '(')
                    return  false;
                if (c == ']' && topChar != '[')
                    return false;
                if (c == '}' && topChar != '{')
                    return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(new Demo20().isVaild("({[[]]})"));
    }
}

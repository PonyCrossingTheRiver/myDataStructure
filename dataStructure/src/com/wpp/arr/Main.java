package com.wpp.arr;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++)
            arr[i] = i;
        int[] srores = new int[]{100,90,98};
        for (int score: srores) {
            System.out.println(score);
        }
    }
}

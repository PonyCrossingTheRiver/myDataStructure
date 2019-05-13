package com.wpp.LinkedAndRecursion;

/**
 * 递归学习
 */
public class Recursion {
    public static void main(String[] args) {
            int[] nums = {1,2,3,4,5,6,7,8};
        System.out.println((new Case1()).sum1(nums));
    }



}

/**
 * 案例1 两数求和
 */
class Case1 {
    // case1  两数求和
    public static int sum1(int[] arr) {
        return sum1(arr,0);
    }

    // 计算arr[l…n] 这个区间内所有数字的和
    private static int sum1(int[] arr, int l) {
        if (l== arr.length)
            return 0;
        return arr[l] + sum1(arr,l+1);
    }
}

/**
 * 案例 leetcode 203th
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 */
class Case2{

}

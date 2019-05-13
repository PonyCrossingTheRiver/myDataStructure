package com.wpp.TwoForkTree;

public class TestTree {
    public static void main(String[] args) {
        BST<Integer> bst = new BST();
        int[] arr = {5,3,1,4,2,7,6,8};
        for (int i = 0; i < arr.length; i++) {
            bst.add(arr[i]);
        }
        bst.preOrder();
        System.out.println();
        System.out.println(bst);
        System.out.println();
        bst.inOrder();
        System.out.println("flag");
        bst.preOrderNR();
        System.out.println("flag1");
        bst.levelOrder();
        System.out.println("flag2");
        System.out.println(bst.removeMin());
        System.out.println(bst.removeMax());
    }
}

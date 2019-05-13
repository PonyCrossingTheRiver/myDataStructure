package com.wpp.TwoForkTree;

import com.wpp.stackandqueue.queue.LinkedListQueue;
import com.wpp.stackandqueue.queue.Queue;

import java.util.Stack;

/**
 * 二分搜索树--也称平衡二叉树
 * note:不包含重复的元素
 * 遍历方式：深度遍历 和层序遍历
 * 深度遍历：前序遍历 中序遍历 后序遍历
 * 层序遍历：又名广度优先遍历，
 *
 * 某元素值的floor ceil
 * 某元素值的rank select
 */
public class BST<E extends Comparable<E>> {

    private class Node{
        public E e;
        public Node left,right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    private  Node root;
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    // 向二分搜索树中添加新的元素e -- 优化前
    public void add1(E e) {
        if (root == null) {
            root = new Node(e);
            size++;
        } else {
            add(root,e);
        }
    }

    // 向以node为根的二分搜索树中插入元素E,递归算法---优化前的插入元素部分
    private void add1(Node node, E e) {
        // 递归终止条件
       if (e.equals(node.e)) {
            return;
       } else if (e.compareTo(node.e) < 0 && node.left == null) {
           node.left = new Node(e);
           size++;
           return;
       } else if (e.compareTo(node.e) > 0 && node.right == null) {
           node.right = new Node(e);
           size++;
           return;
       }
       if (e.compareTo(node.e) < 0 && node.left != null) {
           add(node.left,e);
       } else if (e.compareTo(node.e) > 0 && node.right != null) {
           add(node.right,e);
       }
    }
    // 向二分搜索树中添加新的元素e -- 优化后
    public void add(E e) {
       root = add(root,e);
    }
    // 向以node为根的二分搜索树中插入元素E,递归算法---优化后的插入元素部分
    // null 也是一个二叉树来考虑
    private Node add(Node node, E e) {
        // 递归终止条件
        if (node == null) {
            size++;
            return new Node(e);
        }
       if (e.compareTo(node.e) < 0) {
          node.left = add(node.left,e);
       } else if (e.compareTo(node.e) > 0) {
           node.right = add(node.right,e);
       }
       return node;
    }

    // 查询操作
    public boolean contains(E e) {
        return contains(root,e);
    }

    // 递归算法
    private boolean contains(Node node, E e) {
        if (node == null)
            return false;
        if (e.compareTo(node.e) == 0)
            return true;
        else if (e.compareTo(node.e) < 0)
            return contains(node.left,e);
        else //e.compareTo(node.e) > 0
            return contains(node.right,e);
    }
    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if (node == null)
            return;
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    // 非递归的前序遍历
    public void preOrderNR (){

        Stack<Node> stack = new Stack();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            System.out.println(cur.e);
            if (cur.right != null) stack.push(cur.right);
            if (cur.left != null)  stack.push(cur.left);
        }
    }
    // 层序遍历(广度优先遍历)--更快的找到问题的解（常用于算法设计中-最短路径）
    public void levelOrder (){
        LinkedListQueue <Node> queue = new LinkedListQueue();
        queue.enqueue(root);
        while (!queue.isEmpty()) {
            Node cur = queue.dequeue();
            System.out.println(cur.e);
            if (cur.left != null)   queue.enqueue(cur.left);
            if (cur.right != null)  queue.enqueue(cur.right);

        }
    }
    // 中序遍历
    public void inOrder(){
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node == null)
            return;
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }


    // 后序遍历
    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node) {
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);

    }

    public E miniMum(){
        if (size == 0)
            throw new IllegalArgumentException("BST is empty");
       return miniMum(root).e;
    }
    private Node miniMum(Node node) {
        if (node.left == null)
            return node;
        return miniMum(node.left);
    }
    public E maxMum(){
        if (size == 0)
            throw new IllegalArgumentException("BST is empty");
        return maxMum(root).e;
    }
    private Node maxMum(Node node) {
        if (node.right == null)
            return node;
        return maxMum(node.right);
    }

    public E removeMin(){
        E  ret = miniMum();
        root = removeMin(root);
        return ret;
    }
    // 删除掉以node为根的二分搜索树中的最小节点
    // 返回删除节点后新的二分搜索树的根
    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }public E removeMax(){
        E  ret = maxMum();
        root = removeMax(root);
        return ret;
    }
    // 删除掉以node为根的二分搜索树中的最大节点
    // 返回删除节点后新的二分搜索树的根
    private Node removeMax(Node node) {
        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }
        node.right = removeMin(node.right);
        return node;
    }
    public void remove(E e) {
        remove(root,e);
    }
    //  删除掉以node为根的二分搜索树中的值为e的节点，递归算法
    // 返回删除节点后新的二分搜索树的根
    private Node remove(Node node, E e) {
        if (node == null)
            return null;
        if (e.compareTo(node.e) < 0) {
            node.left = remove(node.left,e);
            return node;
        } else if (e.compareTo(node.e) > 0) {
           node.right = remove(node.right,e);
           return node;
        } else { // e == node.e 伪比较
            // 待删除节点左子树为空的情况
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }
            // 待删除节点右子树为空的情况
            if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }
            // 待删除节点左右子树均不为空的情况
            // 找到比待删除节点大的最小节点，即待删出节点右子树的最小节点
            // 用这个节点替换待删除节点的位置
            Node successor = miniMum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;
            node.left = node.right = null;
            return successor;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        generateBSTString(root,0,sb);
        return sb.toString();
    }
    private void generateBSTString(Node node,int depth,StringBuilder sb){
        if (node == null) {
            sb.append(generateDepthString(depth)+"null\n");
            return;
        }
        sb.append(generateDepthString(depth) + node.e+"\n");
        generateBSTString(node.left,depth+1,sb);
        generateBSTString(node.right,depth+1,sb);

    }
    private String generateDepthString(int depth) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            sb.append("--");
        }
        return sb.toString();
    }
}

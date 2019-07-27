package com.wy.dataStructure._05binarySearchTree;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 名称: JavaDataStructure.com.wy.dataStructure._05binarySearchTree.BST
 * 用户: _VIEW
 * 时间: 2019/7/27,20:39
 * 描述: 二分搜索树,不包含重复元素
 */
public class BST<E extends Comparable<E>> {
    private class Node {
        public E e;
        public Node left, right;

        public Node(E e) {
            this.e = e;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 插入元素，方式一
     * @param e
     */
//    public void add(E e) {
//        if (root == null) {
//            root = new Node(e);
//            size++;
//        } else {
//            add(root, e);
//        }
//    }
//
//    private void add(Node node, E e) {
//        if (node.e.compareTo(e) == 0)
//            return;
//        if (e.compareTo(node.e) < 0 && node.left == null) {
//            node.left = new Node(e);
//            size++;
//            return;
//        }
//        if (e.compareTo(node .e) >0 && node.right == null){
//            node.right = new Node(e);
//            size++;
//            return;
//        }
//        if (node.e.compareTo(e) < 0)
//            add(node.left, e);
//        else        //==0的情况开头已经判断过了，在这里的情况不是>0就是<0
//            add(node.right, e);
//    }

    /**
     * 插入元素，方式二
     *
     * @param e
     */
    public void add(E e) {
        root = add(root, e);
    }

    private Node add(Node node, E e) {
        if (node == null) {
            node = new Node(e);
            size++;
            return new Node(e);
        }
        if (e.compareTo(node.e) < 0)
            node.left = add(node.left, e);
        else
            node.right = add(node.right, e);
        return node;
    }

    /**
     * 是否包含元素e
     *
     * @param e
     * @return
     */
    public boolean contains(E e) {
        return contains(root, e);
    }

    private boolean contains(Node node, E e) {
        if (node == null)
            return false;
        if (e.compareTo(e) == 0)
            return true;
        if (e.compareTo(e) < 0)
            return contains(node.left, e);
        else
            return contains(node.right, e);
    }

    /**
     * 前序遍历,递归实现
     */
    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if (node == null)
            return;
        System.out.print(node.e + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * 非递归实现前序遍历
     */
    public void NRpreOrder() {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node currentNode = stack.pop();
            System.out.print(currentNode.e + " ");
            if (currentNode.right != null)
                stack.push(currentNode.right);
            if (currentNode.left != null)
                stack.push(currentNode.left);
        }
    }

    /**
     * 中序遍历
     */
    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node == null)
            return;
        preOrder(node.left);
        System.out.print(node.e + " ");
        preOrder(node.right);
    }

    /**
     * 后续遍历
     */
    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node) {
        if (node == null)
            return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.e + " ");
    }

    public void levelOrder() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node currentNode = queue.remove();
            System.out.print(currentNode.e+" ");
            if (currentNode.left != null) {
                queue.add(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.add(currentNode.right);
            }
        }
    }
}

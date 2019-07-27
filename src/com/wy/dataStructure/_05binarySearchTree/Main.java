package com.wy.dataStructure._05binarySearchTree;

/**
 * 名称: JavaDataStructure.com.wy.dataStructure._05binarySearchTree.Main
 * 用户: _VIEW
 * 时间: 2019/7/27,21:59
 * 描述: 二分搜索树测试类
 */
public class Main {
    private static BST<Integer> bst = new BST<>();

    public static void main(String[] args) {
        initData();
        printOrder();
    }

    private static void printOrder() {
        bst.preOrder();
        System.out.println();
        bst.NRpreOrder();
        System.out.println();
        bst.inOrder();
        System.out.println();
        bst.postOrder();
        System.out.println();
        bst.levelOrder();
    }

    private static void initData() {
        bst.add(5);
        bst.add(3);
        bst.add(4);
        bst.add(6);
        bst.add(8);
    }
}

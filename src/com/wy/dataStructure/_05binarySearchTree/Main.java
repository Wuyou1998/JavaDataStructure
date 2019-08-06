package com.wy.dataStructure._05binarySearchTree;

import com.wy.dataStructure._00TestUtil.FileOperation;

import java.util.ArrayList;
import java.util.Random;

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
        //printOrder();
        System.out.println(bst);
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
        Random random=new Random();
        for (int i = 0; i < 10; i++) {
            bst.add(random.nextInt(10000));
        }
    }
}

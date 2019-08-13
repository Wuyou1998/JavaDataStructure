package com.wy.dataStructure._13AVLTree;

import com.wy.dataStructure._00TestUtil.FileOperation;

import java.util.ArrayList;

/**
 * 名称: JavaDataStructure.com.wy.dataStructure._13AVLTree.Main
 * 用户: _VIEW
 * 时间: 2019/8/13,23:35
 * 描述: AVL测试类
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Pride and Prejudice");
        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile("src/com/wy/dataStructure/_00TestUtil/pride-and-prejudice.txt", words)) {
            System.out.println("一共有" + words.size() + "个单词");
            AVLTree<String, Integer> avlTree = new AVLTree<>();
            for (String word : words) {
                if (avlTree.contains(word))
                    avlTree.add(word, avlTree.get(word) + 1);
                else
                    avlTree.add(word, 1);
            }
            System.out.println("不同的单词个数：" + avlTree.getSize());
            System.out.println("pride 出现的次数：" + avlTree.get("pride"));
            System.out.println("prejudice 出现的次数：" + avlTree.get("prejudice"));
        }
    }
}

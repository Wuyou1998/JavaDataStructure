package com.wy.dataStructure._13AVLTree;

import com.wy.dataStructure._00TestUtil.FileOperation;
import com.wy.dataStructure._00TestUtil.TestTimeUtil;
import com.wy.dataStructure._07map.BSTMap;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 名称: JavaDataStructure.com.wy.dataStructure._13AVLTree.Main
 * 用户: _VIEW
 * 时间: 2019/8/13,23:35
 * 描述: AVL测试类
 */
public class Main {
    public static void main(String[] args) {
        Runnable runnable1 = () -> {
            ArrayList<String> words = new ArrayList<>();
            if (FileOperation.readFile("src/com/wy/dataStructure/_00TestUtil/pride-and-prejudice.txt", words)) {
                AVLTree<String, Integer> avlTree = new AVLTree<>();
                //排下序，直接让BST走最坏情况，成为一个链表
                Collections.sort(words);
                for (String word : words) {
                    if (avlTree.contains(word))
                        avlTree.set(word, avlTree.get(word) + 1);
                    else
                        avlTree.add(word, 1);
                }
//                for (String word : words) {
//                    avlTree.remove(word);
//                    if (!avlTree.isBST() || !avlTree.isBalanced())
//                        throw new RuntimeException("remove 操作出了问题");
//                }
//                System.out.println("remove 操作是正确无误的");
            }
        };

        Runnable runnable2 = () -> {
            ArrayList<String> words = new ArrayList<>();
            if (FileOperation.readFile("src/com/wy/dataStructure/_00TestUtil/pride-and-prejudice.txt", words)) {
                BSTMap<String, Integer> avlTree = new BSTMap<>();
                //排下序，直接让BST走最坏情况，成为一个链表
                Collections.sort(words);
                for (String word : words) {
                    if (avlTree.contains(word))
                        avlTree.set(word, avlTree.get(word) + 1);
                    else
                        avlTree.add(word, 1);
                }
            }
        };
        System.out.println("AVL用时: " + TestTimeUtil.getRunTime(runnable1) + "s");
        System.out.println("BST用时: " + TestTimeUtil.getRunTime(runnable2) + "s");

        /*一般情况
         *AVL用时: 0.1985519s
         * BST用时: 0.1396889s
         */

        /*BST走最坏情况，成为一个链表：
         * AVL用时: 0.2316407s
         * BST用时: 15.617311s
         */
    }

    private static void testAVL() {
        System.out.println("Pride and Prejudice");
        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile("src/com/wy/dataStructure/_00TestUtil/pride-and-prejudice.txt", words)) {
            System.out.println("一共有" + words.size() + "个单词");
            AVLTree<String, Integer> avlTree = new AVLTree<>();
            for (String word : words) {
                if (avlTree.contains(word))
                    avlTree.set(word, avlTree.get(word) + 1);
                else
                    avlTree.add(word, 1);
            }
            System.out.println("不同的单词个数：" + avlTree.getSize());
            System.out.println("pride 出现的次数：" + avlTree.get("pride"));
            System.out.println("prejudice 出现的次数：" + avlTree.get("prejudice"));
            System.out.println("是BST吗：" + avlTree.isBST());
            System.out.println("平衡吗：" + avlTree.isBalanced());
        }
    }
}

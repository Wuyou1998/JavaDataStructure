package com.wy.dataStructure._14RBTree;

import com.wy.dataStructure._00TestUtil.FileOperation;
import com.wy.dataStructure._00TestUtil.TestTimeUtil;
import com.wy.dataStructure._07map.BSTMap;
import com.wy.dataStructure._13AVLTree.AVLTree;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 名称: JavaDataStructure.com.wy.dataStructure._14RBTree.Main
 * 用户: _VIEW
 * 时间: 2019/8/15,13:04
 * 描述: 红黑树测试类
 */
public class Main {
    public static void main(String[] args) {
        compare();
    }

    private static void compare() {
        Runnable runnable = () -> {
            ArrayList<String> words = new ArrayList<>();
            if (FileOperation.readFile("src/com/wy/dataStructure/_00TestUtil/pride-and-prejudice.txt", words)) {
                RBTree<String, Integer> avlTree = new RBTree<>();
                Collections.sort(words);
                for (String word : words) {
                    if (avlTree.contains(word))
                        avlTree.set(word, avlTree.get(word) + 1);
                    else
                        avlTree.add(word, 1);
                }
            }
        };
        Runnable runnable1 = () -> {
            ArrayList<String> words = new ArrayList<>();
            if (FileOperation.readFile("src/com/wy/dataStructure/_00TestUtil/pride-and-prejudice.txt", words)) {
                AVLTree<String, Integer> avlTree = new AVLTree<>();
                Collections.sort(words);
                for (String word : words) {
                    if (avlTree.contains(word))
                        avlTree.set(word, avlTree.get(word) + 1);
                    else
                        avlTree.add(word, 1);
                }
            }
        };

        Runnable runnable2 = () -> {
            ArrayList<String> words = new ArrayList<>();
            if (FileOperation.readFile("src/com/wy/dataStructure/_00TestUtil/pride-and-prejudice.txt", words)) {
                BSTMap<String, Integer> avlTree = new BSTMap<>();
                Collections.sort(words);
                for (String word : words) {
                    if (avlTree.contains(word))
                        avlTree.set(word, avlTree.get(word) + 1);
                    else
                        avlTree.add(word, 1);
                }
            }
        };
        System.out.println("红黑树用时: " + TestTimeUtil.getRunTime(runnable) + "s");
        System.out.println("AVL用时: " + TestTimeUtil.getRunTime(runnable1) + "s");
        System.out.println("BST用时: " + TestTimeUtil.getRunTime(runnable2) + "s");
        /*运行结果：
         * 红黑树用时: 0.2754161s
         * AVL用时: 0.2223345s
         * BST用时: 17.588657s
         */
    }
}

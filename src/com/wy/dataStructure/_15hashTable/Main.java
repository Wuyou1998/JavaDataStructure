package com.wy.dataStructure._15hashTable;

import com.wy.dataStructure._00TestUtil.FileOperation;
import com.wy.dataStructure._00TestUtil.TestTimeUtil;
import com.wy.dataStructure._07map.BSTMap;
import com.wy.dataStructure._13AVLTree.AVLTree;
import com.wy.dataStructure._14RBTree.RBTree;

import java.util.ArrayList;

/**
 * 名称: JavaDataStructure.com.wy.dataStructure._15hashTable.Main
 * 用户: _VIEW
 * 时间: 2019/8/15,19:57
 * 描述: 哈希表测试类
 */
public class Main {
    public static void main(String[] args) {
        Runnable runnable0 = () -> {
            ArrayList<String> words = new ArrayList<>();
            if (FileOperation.readFile("src/com/wy/dataStructure/_00TestUtil/pride-and-prejudice.txt", words)) {
                HashTable<String, Integer> avlTree =new HashTable<>();
                for (String word : words) {
                    if (avlTree.contains(word))
                        avlTree.set(word, avlTree.get(word) + 1);
                    else
                        avlTree.add(word, 1);
                }
            }
        };
        Runnable runnable = () -> {
            ArrayList<String> words = new ArrayList<>();
            if (FileOperation.readFile("src/com/wy/dataStructure/_00TestUtil/pride-and-prejudice.txt", words)) {
                RBTree<String, Integer> avlTree = new RBTree<>();
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
                for (String word : words) {
                    if (avlTree.contains(word))
                        avlTree.set(word, avlTree.get(word) + 1);
                    else
                        avlTree.add(word, 1);
                }
            }
        };
        System.out.println("哈希表用时: " + TestTimeUtil.getRunTime(runnable0) + "s");
        System.out.println("红黑树用时: " + TestTimeUtil.getRunTime(runnable) + "s");
        System.out.println("AVL用时: " + TestTimeUtil.getRunTime(runnable1) + "s");
        System.out.println("BST用时: " + TestTimeUtil.getRunTime(runnable2) + "s");
        /*
         * 哈希表用时: 0.1624903s
         * 红黑树用时: 0.1287335s
         * AVL用时: 0.10874s
         * BST用时: 0.0879483s
         */
    }
}

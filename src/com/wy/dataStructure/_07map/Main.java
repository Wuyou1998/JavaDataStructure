package com.wy.dataStructure._07map;

import com.wy.dataStructure._00TestUtil.FileOperation;
import com.wy.dataStructure._00TestUtil.TestTimeUtil;

import java.util.ArrayList;

/**
 * 名称: JavaDataStructure.com.wy.dataStructure._07map.Main
 * 用户: _VIEW
 * 时间: 2019/8/7,12:24
 * 描述: 映射测试类
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("LinkedListMap 用时：" + TestTimeUtil.getRunTime(Main::testLinkedListMap) + "s");
        System.out.println("BSTMap 用时：" + TestTimeUtil.getRunTime(Main::testBSTMap) + "s");
        /*运行结果：
         * LinkedListMap 用时：13.136382s
         * BSTMap 用时：0.1179006s
         * 时间复杂度：
         * LinkedListMap O(n)
         * BSTMap 最好O(h) 最坏O(log n) 最差 O(n) 此时二分搜索树已经退化成一个链表了
         */
    }

    private static void testLinkedListMap() {
        //System.out.println("Pride and Prejudice");
        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile("src/com/wy/dataStructure/_00TestUtil/pride-and-prejudice.txt", words)) {
            //System.out.println("一共有" + words.size() + "个单词");
            LinkedListMap<String, Integer> map = new LinkedListMap<>();
            for (String word : words) {
                if (map.contains(word))
                    map.set(word, map.get(word) + 1);
                else
                    map.add(word, 1);
            }
            //System.out.println("不同的单词个数：" + map.getSize());
            //System.out.println("pride 出现的次数："+map.get("pride"));
            //System.out.println("prejudice 出现的次数："+map.get("prejudice"));
        }
    }

    private static void testBSTMap() {
        // System.out.println("Pride and Prejudice");
        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile("src/com/wy/dataStructure/_00TestUtil/pride-and-prejudice.txt", words)) {
            //System.out.println("一共有" + words.size() + "个单词");
            BSTMap<String, Integer> map = new BSTMap<>();
            for (String word : words) {
                if (map.contains(word))
                    map.set(word, map.get(word) + 1);
                else
                    map.add(word, 1);
            }
//            System.out.println("不同的单词个数：" + map.getSize());
//            System.out.println("pride 出现的次数："+map.get("pride"));
//            System.out.println("prejudice 出现的次数："+map.get("prejudice"));
        }
    }
}

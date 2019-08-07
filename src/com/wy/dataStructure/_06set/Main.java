package com.wy.dataStructure._06set;

import com.wy.dataStructure._00TestUtil.FileOperation;
import com.wy.dataStructure._00TestUtil.TestTimeUtil;

import java.util.ArrayList;

/**
 * 名称: JavaDataStructure.com.wy.dataStructure._06set.Main
 * 用户: _VIEW
 * 时间: 2019/8/6,20:30
 * 描述: set测试类
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("BSTSet用时：" + TestTimeUtil.getRunTime(Main::testBSTSet) + "s");
        System.out.println("LinkedListSet用时：" + TestTimeUtil.getRunTime(Main::testLinkedListSet) + "s");
        /*
         * BSTSet用时：0.2477161s
         * LinkedListSet用时：7.437744s
         * 链表的add contains remove 复杂度都是O(n),二分搜索树则是O(h),
         * h为二分搜索树的深度，若二分搜索树有n个节点，由等比数列求和公式可得
         * 2^h - 1 = n =====> h=log2(n+1)
         * 由上可知BSTSet复杂度为O(log n),LinkedListSet复杂度为O(n)
         * LinkedListSet由于每次add都是addFirst，这部分复杂度为1
         * 若是addLast，则复杂度n，LinkedListSet复杂度也就是O(n^2)了
         */

    }

    private static void testBSTSet() {
        //System.out.println("Pride and Prejudice");
        ArrayList<String> words = new ArrayList<>();
        FileOperation.readFile("src/com/wy/dataStructure/_00TestUtil/pride-and-prejudice.txt", words);
        //System.out.println("Total size:" + words.size());
        BSTSet<String> bstSet = new BSTSet<>();
        for (String word : words) {
            bstSet.add(word);
        }
        //System.out.println("Total different words:" + bstSet.getSize());
        //System.out.println("******************************************************");
        //System.out.println("a tale of two cities");
        ArrayList<String> words2 = new ArrayList<>();
        FileOperation.readFile("src/com/wy/dataStructure/_00TestUtil/a-tale-of-two-cities.txt", words2);
        //System.out.println("Total size:" + words2.size());
        BSTSet<String> bstSet2 = new BSTSet<>();
        for (String word : words2) {
            bstSet2.add(word);
        }
        //System.out.println("Total different words:" + bstSet2.getSize());
    }

    private static void testLinkedListSet() {
        //System.out.println("Pride and Prejudice");
        ArrayList<String> words = new ArrayList<>();
        FileOperation.readFile("src/com/wy/dataStructure/_00TestUtil/pride-and-prejudice.txt", words);
        //System.out.println("Total size:" + words.size());
        LinkedListSet<String> linkedListSet = new LinkedListSet<>();
        for (String word : words) {
            linkedListSet.add(word);
        }
        //System.out.println("Total different words:" + linkedListSet.getSize());
        //System.out.println("******************************************************");
        //System.out.println("a tale of two cities");
        ArrayList<String> words2 = new ArrayList<>();
        FileOperation.readFile("src/com/wy/dataStructure/_00TestUtil/a-tale-of-two-cities.txt", words2);
        //System.out.println("Total size:" + words2.size());
        LinkedListSet<String> linkedListSet2 = new LinkedListSet<>();
        for (String word : words2) {
            linkedListSet2.add(word);
        }
        // System.out.println("Total different words:" + linkedListSet2.getSize());
    }
}

package com.wy.dataStructure._04linkedList;

/**
 * 名称: DataStructure.com.wy.dataStructure._04linkedList.Main
 * 用户: _VIEW
 * 时间: 2019/7/17,11:13
 * 描述: LinkedList测试类
 */
public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 15; i++) {
            linkedList.addLast(i);
        }
        linkedList.remove(14);
        System.out.println(linkedList);
    }
}

package com.wy.dataStructure._10segmentTree;

/**
 * 名称: JavaDataStructure.com.wy.dataStructure._10segmentTree.Main
 * 用户: _VIEW
 * 时间: 2019/8/9,10:28
 * 描述: 线段树测试类
 */
public class Main {
    public static void main(String[] args) {
        Integer[] nums = {-2, 0, 3, -5, 2, -1};
        SegmentTree<Integer> segmentTree = new SegmentTree<>(nums, Integer::sum);
        //System.out.println(segmentTree);
        System.out.println(segmentTree.query(2,5));
    }
}

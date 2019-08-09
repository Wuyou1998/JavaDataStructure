package com.wy.dataStructure._10segmentTree;

/**
 * 名称: JavaDataStructure.com.wy.dataStructure._10segmentTree.Merger
 * 用户: _VIEW
 * 时间: 2019/8/9,10:23
 * 描述: 线段树融合器
 */
public interface Merger<E> {
    E merge(E a,E b);
}

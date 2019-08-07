package com.wy.dataStructure._06set;

import com.wy.dataStructure._04linkedList.LinkedList;

/**
 * 名称: JavaDataStructure.com.wy.dataStructure._05binarySearchTree.LinkedListSat
 * 用户: _VIEW
 * 时间: 2019/8/6,20:57
 * 描述: 基于链表的集合
 */
public class LinkedListSet<E> implements Set<E> {
    private LinkedList<E> linkedList;

    public LinkedListSet() {
        linkedList = new LinkedList<>();
    }

    @Override
    public void add(E e) {
        if (!linkedList.contains(e))
            linkedList.addFirst(e);
    }

    @Override
    public void remove(E e) {
        linkedList.remove(e);
    }

    @Override
    public boolean contains(E e) {
        return linkedList.contains(e);
    }

    @Override
    public int getSize() {
        return linkedList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }
}

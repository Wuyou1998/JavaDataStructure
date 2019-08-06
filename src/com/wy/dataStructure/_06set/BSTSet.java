package com.wy.dataStructure._06set;

import com.wy.dataStructure._05binarySearchTree.BST;

/**
 * 名称: JavaDataStructure.com.wy.dataStructure._06set.BSTSet
 * 用户: _VIEW
 * 时间: 2019/8/6,20:26
 * 描述: 基于二分搜索树的集合
 */
public class BSTSet<E extends Comparable<E>> implements Set<E> {
    private BST<E> bst;

    public BSTSet() {
        bst = new BST<>();
    }

    @Override
    public void add(E e) {
        bst.add(e);
    }

    @Override
    public void remove(E e) {
        bst.remove(e);
    }

    @Override
    public boolean contains(E e) {
        return bst.contains(e);
    }

    @Override
    public int getSize() {
        return bst.getSize();
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }
}

package com.wy.dataStructure._06set;

import com.wy.dataStructure._13AVLTree.AVLTree;

/**
 * 名称: JavaDataStructure.com.wy.dataStructure._06set.AVLSet
 * 用户: _VIEW
 * 时间: 2019/8/14,16:31
 * 描述: 基于平衡二叉树的集合
 */
public class AVLSet<E extends Comparable<E>> implements Set<E> {
    private AVLTree<E, Object> avlTree;

    public AVLSet() {
        avlTree = new AVLTree<>();
    }

    @Override
    public void add(E e) {
        avlTree.add(e, null);
    }

    @Override
    public void remove(E e) {
        avlTree.remove(e);
    }

    @Override
    public boolean contains(E e) {
        return avlTree.contains(e);
    }

    @Override
    public int getSize() {
        return avlTree.getSize();
    }

    @Override
    public boolean isEmpty() {
        return avlTree.isEmpty();
    }
}

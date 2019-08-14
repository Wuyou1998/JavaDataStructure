package com.wy.dataStructure._07map;

import com.wy.dataStructure._13AVLTree.AVLTree;

/**
 * 名称: JavaDataStructure.com.wy.dataStructure._07map.AVLMap
 * 用户: _VIEW
 * 时间: 2019/8/14,16:19
 * 描述: 基于平衡二叉树的映射
 */
public class AVLMap<K extends Comparable<K>, V> implements Map<K, V> {
    private AVLTree<K, V> avlTree;

   public AVLMap() {
        avlTree = new AVLTree<>();
    }

    @Override
    public void add(K key, V value) {
        avlTree.add(key,value);
    }

    @Override
    public V remove(K key) {
        return avlTree.remove(key);
    }

    @Override
    public boolean contains(K key) {
        return avlTree.contains(key);
    }

    @Override
    public V get(K key) {
        return avlTree.get(key);
    }

    @Override
    public void set(K key, V newValue) {
        avlTree.set(key,newValue);
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

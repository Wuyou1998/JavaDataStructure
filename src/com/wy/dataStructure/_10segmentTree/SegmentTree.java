package com.wy.dataStructure._10segmentTree;

/**
 * 名称: JavaDataStructure.com.wy.dataStructure._10segmentTree.SegmentTree
 * 用户: _VIEW
 * 时间: 2019/8/9,9:57
 * 描述: 基于数组的线段树
 */
public class SegmentTree<E> {
    private E[] data;
    private E[] tree;
    private Merger<E> merger;

    public SegmentTree(E[] arr, Merger<E> merger) {
        this.merger = merger;
        data = (E[]) new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }
        tree = (E[]) new Object[4 * arr.length];
        buildSegmentTree(0, 0, data.length - 1);
    }

    //在treeIndex处创建表示[l,r]的线段树
    private void buildSegmentTree(int treeIndex, int l, int r) {
        if (l == r) {
            tree[treeIndex] = data[l];
            return;
        }
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);

        int mid = l + (r - l) / 2;
        buildSegmentTree(leftTreeIndex, l, mid);
        buildSegmentTree(rightTreeIndex, mid + 1, r);
        tree[treeIndex] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
    }

    public E get(int index) {
        if (index < 0 || index >= data.length)
            throw new IllegalArgumentException("index is illegal");
        return data[index];
    }

    public int getSize() {
        return data.length;
    }

    private int leftChild(int index) {
        return 2 * index + 1;
    }

    private int rightChild(int index) {
        return 2 * index + 2;
    }

    public E query(int queryL, int queryR) {
        if (queryL < 0 || queryL > data.length || queryR < 0 || queryR > data.length)
            throw new IllegalArgumentException("Index is illegal");
        return query(0, 0, data.length - 1, queryL, queryR);
    }

    //在treeIndex为根的线段树中[l,r]的范围里，搜索区间[queryL,queryR]
    private E query(int treeIndex, int l, int r, int queryL, int queryR) {
        if (l == queryL && r == queryR)
            return tree[treeIndex];
        int mid = l + (r - l) / 2;
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);
        if (queryL >= mid + 1)//区间刚好在右孩子内
            return query(rightTreeIndex, mid + 1, r, queryL, queryR);
        else if (queryR <= mid)//区间刚好在左孩子内
            return query(leftTreeIndex, l, mid, queryL, queryR);
        //区间横跨左右俩孩子的部分
        E leftResult = query(leftTreeIndex, l, mid, queryL, mid);
        E rightResult = query(rightTreeIndex, mid + 1, r, mid + 1, queryR);
        return merger.merge(leftResult, rightResult);
    }

    //将index处的值更新为e
    public void set(int index, E e) {
        if (index < 0 || index > data.length)
            throw new IllegalArgumentException("Index is illegal");
        data[index] = e;
        set(0, 0, data.length - 1, index, e);
    }

    private void set(int treeIndex, int l, int r, int index, E e) {
        if (l == r) {
            tree[treeIndex] = e;
            return;
        }
        int mid = l + (r - l) / 2;
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);
        if (index >= mid + 1) {
            set(rightTreeIndex, mid + 1, r, index, e);
        } else {
            set(leftTreeIndex, l, mid, index, e);
        }
        tree[treeIndex] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("[");
        for (int i = 0; i < tree.length; i++) {
            if (tree[i] != null)
                result.append(tree[i]);
            else
                result.append("null");
            if (i != tree.length - 1)
                result.append(", ");
        }
        result.append("]");
        return result.toString();
    }
}

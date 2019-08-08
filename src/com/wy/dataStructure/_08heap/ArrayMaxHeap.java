package com.wy.dataStructure._08heap;

import com.wy.dataStructure._01array.Array;

/**
 * 名称: JavaDataStructure.com.wy.dataStructure._08heap.ArrayMaxHeap
 * 用户: _VIEW
 * 时间: 2019/8/8,20:14
 * 描述: 基于数组的二叉最大堆,即将完全二叉树自根向下层序的存入数组中
 */
public class ArrayMaxHeap<E extends Comparable<E>> {
    private Array<E> data;

    public ArrayMaxHeap(int capacity) {
        data = new Array<>(capacity);
    }

    public ArrayMaxHeap() {
        data = new Array<>();
    }

    //heapify
    public ArrayMaxHeap(E[] arr) {
        data = new Array<>(arr);
        for (int i = parent(arr.length - 1); i >= 0; i--) {
            siftDown(i);
        }
    }

    public int getSize() {
        return data.getSize();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    //当前节点的父节点index
    private int parent(int index) {
        if (index == 0)
            throw new IllegalArgumentException("index：0 does't have parent");
        return (index - 1) / 2;
    }

    //当前节点左孩子index
    private int leftChild(int index) {
        return index * 2 + 1;
    }

    //当前节点右孩子index
    private int rightChild(int index) {
        return index * 2 + 2;
    }

    public void add(E e) {
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    private void siftUp(int k) {
        while (k > 0 && data.getElement(parent(k)).compareTo(data.getElement(k)) < 0) {
            data.swap(parent(k), k);
            k = parent(k);
        }
    }

    //查看最大元素
    public E findMax() {
        if (data.getSize() == 0)
            throw new IllegalArgumentException("Can not findMax when heap is empty");
        return data.getElement(0);
    }

    public E extractMax() {
        E ret = findMax();
        data.swap(0, data.getSize() - 1);
        data.removeLast();
        siftDown(0);
        return ret;
    }

    //替换最大元素
    public E replace(E e) {
        E ret = findMax();
        data.set(0, e);
        siftDown(0);
        return ret;
    }


    //下沉
    private void siftDown(int k) {
        //左孩子没有越界
        while (leftChild(k) < data.getSize()) {
            int j = leftChild(k);
            //找到左右孩子中最大的
            if (j + 1 < data.getSize() && data.getElement(j + 1).compareTo(data.getElement(j)) > 0)
                j = rightChild(k);
            //当前节点已经大于左右俩孩子了，满足条件直接退出
            if (data.getElement(k).compareTo(data.getElement(j)) > 0)
                break;
            //将当前节点和左右孩子中最大的那个交换
            data.swap(k, j);
            k = j;
        }
    }
}

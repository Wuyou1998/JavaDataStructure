package com.wy.dataStructure._09priorityQueue;

import com.wy.dataStructure._03queue.Queue;
import com.wy.dataStructure._08heap.ArrayMaxHeap;

/**
 * 名称: JavaDataStructure.com.wy.dataStructure._09priorityQueue.PriorityQueue
 * 用户: _VIEW
 * 时间: 2019/8/8,23:12
 * 描述: 基于二叉堆的优先队列，其本质还是队列，故复用_03Queue的接口
 */
public class PriorityQueue<E extends Comparable<E>> implements Queue<E> {
    private ArrayMaxHeap<E> maxHeap;

    public PriorityQueue() {
        maxHeap = new ArrayMaxHeap<>();
    }

    @Override
    public int getSize() {
        return maxHeap.getSize();
    }

    @Override
    public boolean isEmpty() {
        return maxHeap.isEmpty();
    }

    @Override
    public void enQueue(E e) {
        maxHeap.add(e);
    }

    @Override
    public E deQueue() {
        return maxHeap.extractMax();
    }

    @Override
    public E getFront() {
        return maxHeap.findMax();
    }
}

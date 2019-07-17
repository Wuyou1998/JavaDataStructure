package com.wy.dataStructure._03queue;

import com.wy.dataStructure._01array.Array;

/**
 * 名称: DataStructure.com.wy.dataStructure._03queue.ArrayQueue
 * 用户: _VIEW
 * 时间: 2019/7/13,18:03
 * 描述: 数组队列,有两种实现思路：
 * 1.addLast作为enQueue，这样每次enQueue第n个元素时会把原先的n-1个元素向后挪一位
 * 2.addFirst作为enQueue，这样每次deQueue第n个元素时会把原先的n-1个元素向后挪一位
 */
public class ArrayQueue<E> implements Queue<E> {
    private Array<E> array = new Array<>();

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public void enQueue(E e) {
        array.addFirst(e);

//        array.addLast(e);
    }

    @Override
    public E deQueue() {
        if (isEmpty())
            throw new IllegalArgumentException("can not dequeue from an empty Queue");
        return array.removeLast();

//        return array.removeFirst();
    }

    @Override
    public E getFront() {
        return array.getLastElement();

//        return array.getFirstElement();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        String s = array.toString();
        s = s.substring(s.lastIndexOf("["));
        builder.append("Queue: ").append("tail").append(s).append("front");
//        builder.append("front").append(s).append("tail");
        return builder.toString();
    }
}

package com.wy.dataStructure._03queue;

/**
 * 名称: DataStructure.com.wy.dataStructure._03queue.Queue
 * 用户: _VIEW
 * 时间: 2019/7/13,17:46
 * 描述: 队列的接口
 */
public interface Queue<E> {
    int getSize();

    boolean isEmpty();

    void enQueue(E e);//入队

    E deQueue();//出队

    E getFront();//查看队首元素，类似Stack的peek

    //E getTail();
}

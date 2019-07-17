package com.wy.dataStructure._03queue;

/**
 * 名称: DataStructure.com.wy.dataStructure._03queue.LoopQueue
 * 用户: _VIEW
 * 时间: 2019/7/15,10:24
 * 描述: 循环队列，消耗一个数组空间用于判断数组的空与满
 */
public class LoopQueue<E> implements Queue<E> {
    private E[] data;
    private int tail;
    private int front;
    private int size;

    public LoopQueue(int capacity) {
        data = (E[]) new Object[capacity + 1];
        tail = 0;
        front = 0;
        size = 0;
    }

    public LoopQueue() {
        this(10);
    }

    public int getCapacity() {
        return data.length - 1;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void enQueue(E e) {
        if ((tail + 1) % data.length == front)
            resize(getCapacity() * 2);
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    @Override
    public E deQueue() {
        if (isEmpty())
            throw new IllegalArgumentException("can not dequeue from an empty Queue");
        E result = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        if (getSize() < getCapacity() / 4 && getSize() / 2 != 0)
            resize(getCapacity() / 2);
        return result;
    }

    @Override
    public E getFront() {
        if (isEmpty())
            throw new IllegalArgumentException("Queue is empty");
        return data[front];
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity + 1];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(i + front) % data.length];
        }
        data = newData;
        front = 0;
        size = tail;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("LoopQueue: size=%d,capacity=%d\n", getSize(), getCapacity()));
        builder.append("front[");
        for (int i = front; i != tail; i = (i + 1) % data.length) {
            builder.append(data[i]);
            if ((i + 1) % data.length != tail)
                builder.append(",");
        }
        builder.append("]tail");
        return builder.toString();
    }
}

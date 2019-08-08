package com.wy.dataStructure._01array;

import java.util.ArrayList;
import java.util.List;

/**
 * 名称: DataStructure.com.wy.dataStructure._01array.Array
 * 用户: _VIEW
 * 时间: 2019/7/12,14:52
 * 描述: 最基础的数据结构，数组
 */
public class Array<E> {
    private int size;
    private E[] data;

    /*
    size:数组中有多少元素，以0开始
    data：我们这个数组是基于原始数组封装
    capacity：数组的最大容量
     */
    public Array(int capacity) {
        if (capacity <= 0)
            throw new IllegalArgumentException("capacity must > 0!");
        data = (E[]) new Object[capacity];
        size = 0;
    }

    public Array() {
        this(10);
    }

    public Array(E[] arr) {
        data = (E[]) new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }
        size = arr.length;
    }

    public int getCapacity() {
        return data.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    /**
     * 在index处插入e，并将原始[index,size-1]的元素向后移一位
     *
     * @param index
     * @param e
     */
    public void add(int index, E e) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("The Element's index must > 0 and < size,add failed!");
        if (size + 1 > getCapacity() * 3 / 4)
            reSize(2 * getCapacity());
        if (data[index] == null) {
            data[index] = e;
        } else {
            for (int i = size; i > index; i--) {
                data[i] = data[i - 1];
            }
            data[index] = e;
        }
        size++;
    }

    public void addFirst(E e) {
        add(0, e);
    }

    public void addLast(E e) {
        add(size, e);
    }

    //获取inidex处的元素
    public E getElement(int index) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("The Element's index must > 0 and < size,get failed!");
        return data[index];
    }

    public E getFirstElement() {
        return data[0];
    }

    public E getLastElement() {
        return size == 0 ? null : data[size - 1];
    }

    //是否包含元素e
    public boolean contains(E e) {
        if (findFirst(e) != -1)
            return true;
        return false;
    }

    //交换元素
    public void swap(int i, int j) {
        if (i < 0 || i > size || j < 0 || j > size) {
            throw new IllegalArgumentException("index is illagal");
        }
        E temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    //找到元素e出现的第一个index
    public int findFirst(E e) {
        for (int i = 0; i < data.length; i++) {
            if (e.equals(data[i]))
                return i;
        }
        return -1;
    }

    //找到元素e出现的所有index，返回indexList.size() == 0 ? null : indexList
    public List<Integer> findAll(E e) {
        List<Integer> indexList = new ArrayList<>();
        for (int i = 0; i < data.length; i++) {
            if (e.equals(data[i]))
                indexList.add(i);
        }
        return indexList.size() == 0 ? null : indexList;
    }

    //将index处的元素设置成e
    public void set(int index, E e) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("The Element's index must > 0 and < size,get failed!");
        data[index] = e;
    }

    public void setFirst(E e) {
        data[0] = e;

    }

    public void setLast(E e) {
        data[size - 1] = e;
    }

    //在index处删除e，并将原始[index,size-1]的元素向前移一位
    public E remove(int index) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("The Element's index must > 0 and < size,get failed!");
        E e = data[index];
        for (int i = index; i < size; i++) {
            data[i] = data[i + 1];
        }
        size--;
        if (size - 1 < getCapacity() / 4)
            reSize(getCapacity() / 2);
        return e;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    private void reSize(int newCapacity) {
        if (newCapacity <= 0)
            throw new IllegalArgumentException("newCapacity >0!");
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Array: ").append("[").append("capacity: ").append(getCapacity()).append(" size: ").append(getSize()).append("]").append("[");
        for (int i = 0; i < size; i++) {
            builder.append(data[i]);
            if (i + 1 != size)
                builder.append(",");

        }
        builder.append("]");
        return builder.toString();
    }
}

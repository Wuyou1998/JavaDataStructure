package com.wy.dataStructure._02stack;

import com.wy.dataStructure._01array.Array;

/**
 * 名称: DataStructure.com.wy.dataStructure._02stack.ArrayStack
 * 用户: _VIEW
 * 时间: 2019/7/13,17:23
 * 描述: 在之前封装的Array上二次封装成ArrayStack
 */
public class ArrayStack<E> implements Stack<E> {
    private Array<E> array;

    public ArrayStack() {
        array = new Array<>();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public void push(E e) {
        array.addLast(e);
    }

    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public E peek() {
        return array.getLastElement();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Stack: ").append("[");
        for (int i = 0; i < array.getSize(); i++) {
            builder.append(array.getElement(i));
            if (i != getSize() - 1)
                builder.append(".");
        }
        builder.append("]top");
        return builder.toString();
    }
}

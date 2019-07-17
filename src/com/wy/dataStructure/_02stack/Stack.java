package com.wy.dataStructure._02stack;

/**
 * 名称: DataStructure.com.wy.dataStructure._02stack.Stack
 * 用户: _VIEW
 * 时间: 2019/7/13,16:55
 * 描述: 实现该接口便有了栈的能力
 */
public interface Stack<E> {
    int getSize();

    boolean isEmpty();

    void push(E e);//入栈

    E pop();//出栈

    E peek();//查看栈顶元素
}

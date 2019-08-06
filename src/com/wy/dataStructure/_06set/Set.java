package com.wy.dataStructure._06set;

/**
 * 名称: JavaDataStructure.com.wy.dataStructure._06set.Set
 * 用户: _VIEW
 * 时间: 2019/8/6,20:21
 * 描述: 集合能力接口
 */
public interface Set<E> {
    void add(E e);

    void remove(E e);

    boolean contains(E e);

    int getSize();

    boolean isEmpty();
}

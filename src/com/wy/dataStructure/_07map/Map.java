package com.wy.dataStructure._07map;

/**
 * 名称: JavaDataStructure.com.wy.dataStructure._07map.Map
 * 用户: _VIEW
 * 时间: 2019/8/6,21:57
 * 描述: 映射能力接口
 */
public interface Map<K, V> {
    void add(K key, V value);

    V remove(K key);

    boolean contains(K key);

    V get(K key);

    void set(K key, V newValue);

    int getSize();

    boolean isEmpty();
}

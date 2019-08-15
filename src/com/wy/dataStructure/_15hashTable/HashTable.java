package com.wy.dataStructure._15hashTable;

import java.util.TreeMap;

/**
 * 名称: JavaDataStructure.com.wy.dataStructure._15hashTable.HashTable
 * 用户: _VIEW
 * 时间: 2019/8/15,19:37
 * 描述: 基于TreeMap的哈希表
 */
public class HashTable<K, V> {
    private static final int upperTol = 10;
    private static final int lowerTol = 2;
    private static final int[] capacity
            = {53, 97, 193, 389, 769, 1543, 3079, 6151, 12289, 24593,
            49157, 98317, 196613, 393241, 786433, 1572869, 3145739, 6291469,
            12582917, 25165843, 50331653, 100663319, 201326611, 402653189, 805306457, 1610612741};

    private TreeMap<K, V>[] hashTable;
    private int initCapacityIndex = 0;
    private int M;
    private int size;

    public HashTable() {
        this.M = capacity[initCapacityIndex];
        size = 0;
        hashTable = new TreeMap[M];
        for (int i = 0; i < M; i++) {
            hashTable[i] = new TreeMap<>();
        }
    }

    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public int getSize() {
        return size;
    }

    public void add(K key, V value) {
        TreeMap<K, V> map = hashTable[hash(key)];
        if (map.containsKey(key)) {
            map.put(key, value);
        } else {
            map.put(key, value);
            size++;
            if (size >= upperTol * M && initCapacityIndex + 1 < capacity.length) {
                initCapacityIndex++;
                resize(capacity[initCapacityIndex]);
            }
        }
    }

    public V remove(K key) {
        TreeMap<K, V> map = hashTable[hash(key)];
        V ret = null;
        if (map.containsKey(key)) {
            ret = map.remove(key);
            size--;
            if (size < lowerTol * M && initCapacityIndex - 1 >= 0)
                initCapacityIndex--;
            resize(capacity[initCapacityIndex]);
        }
        return ret;
    }

    public void set(K key, V value) {
        TreeMap<K, V> map = hashTable[hash(key)];
        if (map.containsKey(key)) {
            map.put(key, value);
        } else {
            throw new IllegalArgumentException(key + "doesn't exist");
        }
    }

    public boolean contains(K key) {
        return hashTable[hash(key)].containsKey(key);
    }

    public V get(K key) {
        return hashTable[hash(key)].get(key);
    }

    private void resize(int newM) {
        TreeMap<K, V>[] newHashTable = new TreeMap[newM];
        for (int i = 0; i < newM; i++) {
            newHashTable[i] = new TreeMap<>();
        }
        int oldM = M;
        this.M = newM;
        for (int i = 0; i < oldM; i++) {
            TreeMap<K, V> treeMap = hashTable[i];
            for (K key : treeMap.keySet()) {
                newHashTable[hash(key)].put(key, treeMap.get(key));
            }
        }
        this.hashTable = newHashTable;
    }

}

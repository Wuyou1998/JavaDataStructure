package com.wy.dataStructure._07map;

/**
 * 名称: JavaDataStructure.com.wy.dataStructure._07map.LinkedListMap
 * 用户: _VIEW
 * 时间: 2019/8/7,12:00
 * 描述: 基于链表实现的映射，未使用_04章节的链表
 */
public class LinkedListMap<K, V> implements Map<K, V> {
    /**
     * 链表节点
     */
    private class Node {
        public K key;
        public V value;
        public Node next;

        public Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public Node(K key) {
            this(key, null, null);
        }

        public Node() {
            this(null, null, null);
        }

        @Override
        public String toString() {
            return key.toString() + " : " + value.toString();
        }
    }

    private Node dummyHead;
    private int size;

    public LinkedListMap() {
        dummyHead = new Node();
        size = 0;
    }

    @Override
    public void add(K key, V value) {
        Node node = getNode(key);
        if (node == null) {
            dummyHead.next = new Node(key, value, dummyHead.next);
            size++;
        } else
            node.value = value;

    }

    @Override
    public V remove(K key) {
        Node previousNode = dummyHead;
        while (previousNode.next != null) {
            if (previousNode.next.key.equals(key))
                break;
            previousNode = previousNode.next;
        }
        if (previousNode.next != null) {
            Node deleteNode = previousNode.next;
            previousNode.next = deleteNode.next;
            deleteNode.next = null;
            size--;
            return deleteNode.value;
        }
        return null;
    }

    @Override
    public boolean contains(K key) {
        return getNode(key) != null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(key);
        return node == null ? null : node.value;
    }

    @Override
    public void set(K key, V newValue) {
        Node node = getNode(key);
        if (node == null)
            throw new IllegalArgumentException(key + " doesn't exist!");
        node.value = newValue;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 辅助函数，查找key所对应的节点
     *
     * @param key key
     * @return key对应节点的引用，没有则传null
     */
    private Node getNode(K key) {
        Node currentNode = dummyHead.next;
        while (currentNode != null) {
            if (currentNode.key.equals(key))
                return currentNode;
            currentNode = currentNode.next;
        }
        return null;
    }
}

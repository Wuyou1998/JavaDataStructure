package com.wy.dataStructure._11trie;

import java.util.TreeMap;

/**
 * 名称: JavaDataStructure.com.wy.dataStructure._11trie.Trie
 * 用户: _VIEW
 * 时间: 2019/8/10,20:11
 * 描述: trie字典树
 */
public class Trie {

    private class Node {
        //从根节点到此是否是一个单词
        public boolean isWord;
        public TreeMap<Character, Node> next;

        public Node(boolean isWord) {
            this.isWord = isWord;
            next = new TreeMap<>();
        }

        public Node() {
            this(false);
        }
    }

    private Node root;
    private int size;

    public Trie() {
        root = new Node();
        size = 0;
    }

    public int getSize() {
        return this.size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    //向Trie中插入一个单词
    public void add(String word) {
        Node currentNode = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (currentNode.next.get(c) == null)
                currentNode.next.put(c, new Node());
            currentNode = currentNode.next.get(c);
        }
        if (!currentNode.isWord)
            currentNode.isWord = true;
        size++;
    }

    public boolean contains(String word) {
        Node currentNode = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (currentNode.next.get(c) == null)
                return false;
            currentNode = currentNode.next.get(c);
        }
        //比如说只存储了panda这个单词，查pan时返回false，除非'n'的 isWord为true
        return currentNode.isWord;
    }

    //是否有单词以prefix为前缀
    public boolean isPrefix(String prefix) {
        Node currentNode = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (currentNode.next.get(c) == null)
                return false;
            currentNode = currentNode.next.get(c);
        }
        return true;
    }
}

package com.wy.dataStructure._13AVLTree;


import java.util.ArrayList;

/**
 * 名称: com.wy.dataStructure._13AVLTree.AVLTree
 * 用户: _VIEW
 * 时间: 2019/8/13,20:39
 * 描述: 基于二分搜索树的AVL,不包含重复元素
 */
public class AVLTree<K extends Comparable<K>, V> {
    private class Node {
        public K key;
        public V value;
        public Node left, right;
        public int height;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
            height = 1;
        }
    }

    private Node root;
    private int size;

    public AVLTree() {
        root = null;
        size = 0;
    }

    //获得节点的高度
    private int getHeight(Node node) {
        if (node == null)
            return 0;
        return node.height;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    //判断当前是不是一个二分搜索树，利用中序遍历的性质来判断
    //如果中序遍历后得到了一个升序的数组，表明是二分搜索树
    public boolean isBST() {
        ArrayList<K> keys = new ArrayList<>();
        inOrder(root, keys);
        for (int i = 0; i < keys.size() - 1; i++) {
            if (keys.get(i).compareTo(keys.get(i + 1)) > 0)
                return false;

        }
        return true;
    }

    private void inOrder(Node node, ArrayList<K> keys) {
        if (node == null)
            return;
        inOrder(node.left, keys);
        keys.add(node.key);
        inOrder(node.right, keys);
    }

    //获得节点node的平衡因子
    private int getBalanceFactor(Node node) {
        if (node == null)
            return 0;
        return getHeight(node.left) - getHeight(node.right);
    }

    //判断一个节点是否平衡
    public boolean isBalanced(){
        return isBalanced(root);
    }
    private boolean isBalanced(Node node) {
        if (node == null)
            return true;
        int balanceFactor = getBalanceFactor(node);
        if (Math.abs(balanceFactor) > 1)
            return false;
        return isBalanced(node.left)&&isBalanced(node.right);
    }

    public void add(K key, V value) {
        root = add(root, key, value);
    }

    private Node add(Node node, K key, V value) {
        if (node == null) {
            size++;
            return new Node(key, value);
        }

        if (key.compareTo(node.key) < 0)
            node.left = add(node.left, key, value);
        else if (key.compareTo(node.key) > 0)
            node.right = add(node.right, key, value);
        else
            node.value = value;
        //更新height
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));

        //计算平衡因子
        int balanceFactor = getBalanceFactor(node);
        if (Math.abs(balanceFactor) > 1) {//二分搜索树不再平衡了
            System.out.println("unBalance: " + balanceFactor);
        }
        return node;
    }

    // 返回以node为根节点的二分搜索树中，key所在的节点
    private Node getNode(Node node, K key) {

        if (node == null)
            return null;

        if (key.equals(node.key))
            return node;
        else if (key.compareTo(node.key) < 0)
            return getNode(node.left, key);
        else // if(key.compareTo(node.key) > 0)
            return getNode(node.right, key);
    }

    public boolean contains(K key) {
        return getNode(root, key) != null;
    }

    public V get(K key) {

        Node node = getNode(root, key);
        return node == null ? null : node.value;
    }

    /**
     * 获取最小元素e
     *
     * @return 最小元素节点
     */
    public K getMinimum() {
        if (isEmpty())
            throw new IllegalArgumentException("BST is empty!");
        return getMinimum(root).key;
    }

    private Node getMinimum(Node node) {
        if (node.left == null)
            return node;
        return getMinimum(node.left);
    }

    /**
     * 获取最大元素e
     *
     * @return 最大元素节点
     */
    public K getMaximum() {
        if (isEmpty())
            throw new IllegalArgumentException("BST is empty!");
        return getMaximum(root).key;
    }

    private Node getMaximum(Node node) {
        if (node.right == null)
            return node;
        return getMaximum(node.right);
    }

    public K removeMin() {
        K e = getMinimum();
        root = removeMin(root);
        return e;
    }

    /**
     * 删除最小节点
     *
     * @param node 以node为根
     */
    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    public K removeMax() {
        K e = getMaximum();
        root = removeMax(root);
        return e;
    }

    /**
     * 删除最大节点
     *
     * @param node 以node为根
     */
    private Node removeMax(Node node) {
        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }
        node.right = removeMax(node.right);
        return node;
    }

    public void remove(K e) {
        root = remove(root, e);
    }

    /**
     * 删除节点
     *
     * @param node 根
     * @param key  元素e
     */
    private Node remove(Node node, K key) {
        if (node == null)
            return null;
        if (key.compareTo(node.key) < 0) {
            node.left = remove(node.left, key);
            return node;
        } else if (key.compareTo(node.key) > 0) {
            node.right = remove(node.right, key);
            return node;
        } else {
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            } else if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            } else {//左右子树都不为空，用右子树的最小节点替换待删节点
                Node successor = getMinimum(node.right);
                successor.right = removeMin(node.right);
                //size++;remove做了一次--，需要加回来
                successor.left = node.left;
                node.left = node.right = null;
                //size--;删了node，需要减回去，一加一减抵消了，微妙得很呐
                return successor;
            }
        }
    }

    public void set(K key, V newValue) {
        Node node = getNode(root, key);
        if (node == null)
            throw new IllegalArgumentException(key + " doesn't exist!");

        node.value = newValue;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }

    // 生成以node为根节点，深度为depth的描述二叉树的字符串
    private void generateBSTString(Node node, int depth, StringBuilder res) {

        if (node == null) {
            res.append(generateDepthString(depth) + "null\n");
            return;
        }

        res.append(generateDepthString(depth) + node.key + "\n");
        generateBSTString(node.left, depth + 1, res);
        generateBSTString(node.right, depth + 1, res);
    }

    private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++)
            res.append("-->");
        return res.toString();
    }
}

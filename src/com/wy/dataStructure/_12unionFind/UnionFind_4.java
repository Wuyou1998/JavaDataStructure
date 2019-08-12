package com.wy.dataStructure._12unionFind;

/**
 * 名称: JavaDataStructure.com.wy.dataStructure._12unionFind.UnionFind_
 * 用户: _VIEW
 * 时间: 2019/8/12,21:54
 * 描述: 并查集第四版
 * 在3的基础上添加基于rank优化
 */
public class UnionFind_4 implements Union {
    private int[] parent;
    //rank[i]表示以i为根的集合所表示的树的层数
    private int[] rank;

    public UnionFind_4(int size) {
        parent = new int[size];
        rank = new int[size];
        for (int i = 0; i < parent.length; i++) {
            //初始化后每一个节点都指向自己
            parent[i] = i;
            rank[i] = 1;
        }
    }

    @Override
    public int getSize() {
        return parent.length;
    }

    @Override
    public boolean isConnected(int index1, int index2) {
        return find(index1) == find(index2);
    }

    @Override
    public void unionElements(int index1, int index2) {
        int index1Root = find(index1);
        int index2Root = find(index2);
        if (index1Root == index2Root)
            return;
        //根据两个元素所在树的节点判断，将节点rank低的挂在rank高的上面，减少移动次数
        if (rank[index2Root] > rank[index1Root]) {
            parent[index1Root] = index2Root;
        } else if (rank[index2Root] < rank[index1Root]) {
            parent[index2Root] = index1Root;
        } else {
            //两个rank相等，将index2指向index1，那么index1的rank就发生变化了
            parent[index2Root] = index1Root;
            rank[index1Root] += 1;
        }
    }

    /**
     * 查找 复杂度为O(h) h 为树的高度
     *
     * @param index
     * @return
     */
    private int find(int index) {
        if (index < 0 || index > parent.length)
            throw new IllegalArgumentException(" index is out of bound");
        while (index != parent[index]) {
            index = parent[index];
        }
        return index;
    }
}

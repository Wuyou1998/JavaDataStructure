package com.wy.dataStructure._12unionFind;

/**
 * 名称: JavaDataStructure.com.wy.dataStructure._12unionFind.UnionFind_3
 * 用户: _VIEW
 * 时间: 2019/8/12,19:32
 * 描述: 并查集第三版
 * 在2的基础上基于size优化
 */
public class UnionFind_3 implements Union {
    private int[] parent;
    private int[] sz;

    public UnionFind_3(int size) {
        parent = new int[size];
        sz = new int[size];
        for (int i = 0; i < parent.length; i++) {
            //初始化后每一个节点都指向自己
            parent[i] = i;
            sz[i] = 1;
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
        //根据两个元素所在树的节点判断，将节点少的挂在节点多的上面，减少移动次数
        if (sz[index2Root] > sz[index1Root]) {
            parent[index1Root] = index2Root;
            sz[index2Root] += sz[index1Root];
        } else {
            parent[index2Root] = index1Root;
            sz[index1Root] += sz[index2Root];
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

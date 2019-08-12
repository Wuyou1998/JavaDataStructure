package com.wy.dataStructure._12unionFind;

/**
 * 名称: JavaDataStructure.com.wy.dataStructure._12unionFind.UnionFind_2
 * 用户: _VIEW
 * 时间: 2019/8/12,0:32
 * 描述: 并查集第二版 quickUnion
 *      刚开始时每一个节点都指向自己，合并时找index1指向的根节点，把自己指过去就行了
 *      便于合并，不利查找
 */
public class UnionFind_2 implements Union {
    private int[] parent;

    public UnionFind_2(int size) {
        parent = new int[size];
        for (int i = 0; i < parent.length; i++) {
            //初始化后每一个节点都指向自己
            parent[i] = i;
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
        parent[index2Root] = index1Root;
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

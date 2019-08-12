package com.wy.dataStructure._12unionFind;

/**
 * 名称: JavaDataStructure.com.wy.dataStructure._12unionFind.UnionFind
 * 用户: _VIEW
 * 时间: 2019/8/12,0:02
 * 描述: unionFind第一版，quickFind
 */
public class UnionFind_1 implements Union {
    private int[] id;

    public UnionFind_1(int size) {
        id = new int[size];
        for (int i = 0; i < id.length; i++) {
            /*数组id的 index 表示第 index 个元素
             * id[index] 表示 第 index 个元素对应的集合
             */
            id[i] = i;
        }
    }

    @Override
    public int getSize() {
        return id.length;
    }

    //index1和index2是否在同一个集合
    @Override
    public boolean isConnected(int index1, int index2) {
        return find(index1) == find(index2);
    }

    //合并index1和index2的集合，在此约定：unionElements(index1,index2)表示将index2放入index1集合里
    @Override
    public void unionElements(int index1, int index2) {
        int index1ID = find(index1);
        int index2ID = find(index2);
        if (index1ID == index2ID)
            return;
        for (int i = 0; i < id.length; i++) {
            if (id[i] == index2ID)
                id[i] = index1ID;
        }
    }

    /**
     * 查询第index个元素对应的集合
     *
     * @param index 第n个元素
     * @return 其对应的集合
     */
    private int find(int index) {
        if (index < 0 || index > id.length)
            throw new IllegalArgumentException(" index is out of bound");
        return id[index];
    }
}

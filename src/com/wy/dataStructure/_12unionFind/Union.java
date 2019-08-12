package com.wy.dataStructure._12unionFind;

/**
 * 名称: JavaDataStructure.com.wy.dataStructure._12unionFind.Union
 * 用户: _VIEW
 * 时间: 2019/8/11,23:57
 * 描述: 并查集UnionFind接口
 */
public interface Union {

    int getSize();

    boolean isConnected(int index1, int index2);

    void unionElements(int index1, int index2);

}

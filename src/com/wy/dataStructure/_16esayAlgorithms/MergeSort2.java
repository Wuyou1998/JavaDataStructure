package com.wy.dataStructure._16esayAlgorithms;

/**
 * 名称: JavaDataStructure.com.wy.dataStructure._16esayAlgorithms.MergeSort2
 * 用户: _VIEW
 * 时间: 2019/9/6,10:47
 * 描述: 归并排序 自底向上
 */
public class MergeSort2 {
    public static void mergeSortBU(Comparable[] arr, int n) {
        for (int sz = 1; sz <= n; sz += sz) {
            for (int i = 0; i + sz < n; i += sz + sz) {
                MergeSort.merge(arr, i, i + sz - 1, Math.min(i + sz + sz - 1, n - 1));//min防止下标越界
            }
        }
    }

}

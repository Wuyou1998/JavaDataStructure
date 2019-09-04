package com.wy.dataStructure._16esayAlgorithms;

import com.wy.dataStructure._00TestUtil.SortTestHelper;
import com.wy.dataStructure._00TestUtil.TestTimeUtil;

/**
 * 名称: JavaDataStructure.com.wy.dataStructure._16esayAlgorithms.InsertionSort
 * 用户: _VIEW
 * 时间: 2019/9/4,19:22
 * 描述: 插入排序
 */
public class InsertionSort {
    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    private static void sort(Comparable[] arr) {
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            //写法1
//            for (int j = i; j > 0; j--) {
//                if (arr[j].compareTo(arr[j - 1]) < 0)
//                    swap(arr, j, j - 1);
//                else
//                    break;
//            }
            //写法2
//            for (int j = i; j >0&&arr[j].compareTo(arr[j - 1]) < 0 ; j--) {
//                swap(arr, j, j - 1);
//            }
            Comparable e = arr[i];
            int j = i;
            for (;j>0&& arr[j - 1].compareTo(e) > 0; j--)
                arr[j] = arr[j - 1];
            arr[j] = e;
        }

    }

    public static void main(String[] args) {
        Integer[] arr = SortTestHelper.generateRandomArray(2000, 0, 10000);
        System.out.println(TestTimeUtil.getRunTime(() -> {
            sort(arr);
        }));
    }
}

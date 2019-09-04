package com.wy.dataStructure._16esayAlgorithms;

import com.wy.dataStructure._00TestUtil.SortTestHelper;
import com.wy.dataStructure._00TestUtil.TestTimeUtil;

/**
 * 名称: JavaDataStructure.com.wy.dataStructure._16esayAlgorithms.BubbleSort
 * 用户: _VIEW
 * 时间: 2019/9/4,22:02
 * 描述: 冒泡排序
 */
public class BubbleSort {
    private BubbleSort() {
    }

    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void sort(Comparable[] arr) {
        //写法1
//        for (int i = 0; i < arr.length - 1; i++) {
//            for (int j = 1; j < arr.length; j++) {
//                if (arr[j - 1].compareTo(arr[j]) >= 0)
//                    swap(arr, j - 1, j);
//            }
//        }
        //写法2
        int n = arr.length;
        boolean needSort = true;
        do {
            needSort = false;
            for (int i = 1; i < n; i++) {
                if (arr[i].compareTo(arr[i - 1]) < 0)
                    swap(arr, i, i - 1);
                needSort = true;
            }
            n--;
        } while (needSort);
    }

    public static void main(String[] args) {
        Integer[] arr = SortTestHelper.generateRandomArray(10, 0, 10000);
        SortTestHelper.printArray(arr);
        System.out.println(TestTimeUtil.getRunTime(() -> {
            sort(arr);
        }));
        SortTestHelper.printArray(arr);
    }
}

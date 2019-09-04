package com.wy.dataStructure._16esayAlgorithms;

import com.wy.dataStructure._00TestUtil.SortTestHelper;
import com.wy.dataStructure._00TestUtil.TestTimeUtil;

/**
 * 名称: JavaDataStructure.com.wy.dataStructure._16esayAlgorithms.ShellSort
 * 用户: _VIEW
 * 时间: 2019/9/4,22:14
 * 描述: 希尔排序
 */
public class ShellSort {
    private ShellSort() {
    }

    private static void sort(Comparable[] arr) {
        int n = arr.length;
        int h = 1;
        while (h < n / 3) h = 3 * h + 1;
        while (h >= 1) {
            for (int i = h; i < n; i++) {
                Comparable e = arr[i];
                int j = i;
                for (; j >= h && e.compareTo(arr[j - h]) < 0; j -= h) {
                    arr[j] = arr[j - h];
                }
                arr[j] = e;
            }
            h = h / 3;
        }
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

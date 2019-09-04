package com.wy.dataStructure._16esayAlgorithms;

import com.wy.dataStructure._00TestUtil.SortTestHelper;
import com.wy.dataStructure._00TestUtil.TestTimeUtil;

/**
 * 名称: JavaDataStructure.com.wy.dataStructure._16esayAlgorithms.SelectionSort
 * 用户: _VIEW
 * 时间: 2019/9/4,18:57
 * 描述: 选择排序
 */
public class SelectionSort {
    //排序算法类不允许有实例
    private SelectionSort() {
    }

    private static void swap(Object[] arr, int a, int b) {
        Object temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    private static void selectionSort(Comparable[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i].compareTo(arr[j]) > 0)
                    swap(arr, i, j);
            }
        }
    }

    public static void main(String[] args) {
        // 测试Integer
        Integer[] a = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        selectionSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
            System.out.print(' ');
        }
        System.out.println();

        // 测试Double
        Double[] b = {4.4, 3.3, 2.2, 1.1};
        selectionSort(b);
        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i]);
            System.out.print(' ');
        }
        System.out.println();

        // 测试String
        String[] c = {"D", "C", "B", "A"};
        selectionSort(c);
        for (int i = 0; i < c.length; i++) {
            System.out.print(c[i]);
            System.out.print(' ');
        }
        System.out.println();

        Integer[] arr = SortTestHelper.generateRandomArray(100, 0, 1000);
        System.out.println(TestTimeUtil.getRunTime(() -> selectionSort(arr)));
        SortTestHelper.printArray(arr);
    }
}

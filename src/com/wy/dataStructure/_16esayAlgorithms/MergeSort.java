package com.wy.dataStructure._16esayAlgorithms;

import com.wy.dataStructure._00TestUtil.SortTestHelper;
import com.wy.dataStructure._00TestUtil.TestTimeUtil;

import java.util.Arrays;

/**
 * 名称: JavaDataStructure.com.wy.dataStructure._16esayAlgorithms.MergeSort
 * 用户: _VIEW
 * 时间: 2019/9/6,9:00
 * 描述: 归并排序 自顶向下
 */
public class MergeSort {
    // 我们的算法类不允许产生任何实例
    private MergeSort() {
    }

    public static void sort(Comparable[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    // 递归使用归并排序,对arr[l...r]的范围进行排序
    public static void sort(Comparable[] arr, int l, int r) {
//        if (l >= r)Comparable[] arr
//            return;
        //对于数据量比较小的数组，它近乎有序的可能性较大，可以用插入排序减少归并
        if (r - l <= 15) {
            InsertionSort.insertSort(arr, l, r);
            return;
        }
        int mid = l + (r - l) / 2;
        sort(arr, l, mid);
        sort(arr, mid + 1, r);
        //归并过程保证了[l,mid]以及[mid+1,r]是有序的，如果arr[mid]<arr[mid+1]则数组有序，不需遍历
        if (arr[mid].compareTo(arr[mid + 1]) > 0)
            merge(arr, l, mid, r);
    }

    // 将arr[l...mid]和arr[mid+1...r]两部分进行归并
    public static void merge(Comparable[] arr, int l, int mid, int r) {
        Comparable[] aux = Arrays.copyOfRange(arr, l, r + 1);

        // 初始化，i指向左半部分的起始索引位置l；j指向右半部分起始索引位置mid+1
        int i = l, j = mid + 1;

        for (int k = l; k <= r; k++) {
            if (i > mid) { // 如果左半部分元素已经全部处理完毕
                arr[k] = aux[j - l];
                j++;
            } else if (j > r) {// 如果右半部分元素已经全部处理完毕
                arr[k] = aux[i - l];
                i++;
            } else if (aux[i - l].compareTo(aux[j - l]) < 0) {// 左半部分所指元素 < 右半部分所指元素
                arr[k] = aux[i - l];
                i++;
            } else {// 左半部分所指元素 >= 右半部分所指元素
                arr[k] = aux[j - l];
                j++;
            }
        }
    }

    public static void main(String[] args) {
        Integer[] arr = SortTestHelper.generateRandomArray(1000000, 0, 10000000);
        System.out.println(TestTimeUtil.getRunTime(() -> {
            sort(arr);
        }));
        System.out.println(TestTimeUtil.getRunTime(() -> {
            MergeSort2.mergeSortBU(arr, arr.length - 1);
        }));
//        SortTestHelper.printArray(arr);
//        SortTestHelper.printArray(arr2);
    }
}

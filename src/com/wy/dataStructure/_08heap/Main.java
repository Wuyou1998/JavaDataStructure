package com.wy.dataStructure._08heap;

import java.util.Random;

/**
 * 名称: JavaDataStructure.com.wy.dataStructure._08heap.Main
 * 用户: _VIEW
 * 时间: 2019/8/8,20:58
 * 描述: 数组二叉最大堆测试类
 */
public class Main {
    public static final int COUNT=1000;
    public static void main(String[] args) {
        Random random = new Random();
        Integer[] arr = new Integer[COUNT];
        for (int i = 0; i < COUNT; i++) {
            arr[i] = random.nextInt(COUNT);
        }
        System.out.println("使用heapify耗时：" + testHeap(arr, true) + "s");
        System.out.println("使用add耗时：" + testHeap(arr, false) + "s");
    }

    public static void normalTest() {
        int n = 1000000;
        ArrayMaxHeap<Integer> maxHeap = new ArrayMaxHeap<>();
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            maxHeap.add(random.nextInt(n));
        }
        int[] arr = new int[1000000];
        for (int i = 0; i < n; i++) {
            arr[i] = maxHeap.extractMax();
        }
        ;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] < arr[i + 1])
                throw new IllegalArgumentException("这不是个最大堆");
        }
        System.out.println("最大堆符合要求");
    }

    public static double testHeap(Integer[] testData, boolean isHeapify) {
        long startTime = System.nanoTime();
        ArrayMaxHeap<Integer> maxHeap;
        if (isHeapify) {
            maxHeap = new ArrayMaxHeap<>(testData);
        } else {
            maxHeap = new ArrayMaxHeap<>();
            for (int num : testData) {
                maxHeap.add(num);
            }
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }
}

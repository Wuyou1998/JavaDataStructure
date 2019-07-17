package com.wy.dataStructure._03queue;

/**
 * 名称: DataStructure.com.wy.dataStructure._03queue.Main
 * 用户: _VIEW
 * 时间: 2019/7/15,9:54
 * 描述: 队列测试类
 */
public class Main {
    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enQueue(i);
            System.out.println(queue);
        }
        for (int i = 0; i < 10; i++) {
            queue.deQueue();
            System.out.println(queue);
        }
    }
}

package com.wy.dataStructure._03queue;

/**
 * 名称: DataStructure.com.wy.dataStructure._03queue.LoopMain
 * 用户: _VIEW
 * 时间: 2019/7/17,9:59
 * 描述: 循环队列测试类
 */
public class LoopMain {
    public static void main(String[] args) {
        LoopQueue<Integer> loopQueue=new LoopQueue<>();
        for (int i = 0; i < 10; i++) {
            loopQueue.enQueue(i);
            System.out.println(loopQueue);
        }
    }
}

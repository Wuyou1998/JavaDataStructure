package com.wy.dataStructure._02stack;

/**
 * 名称: DataStructure.com.wy.dataStructure._02stack.Main
 * 用户: _VIEW
 * 时间: 2019/7/13,17:37
 * 描述: ArrayStack测试类
 */
public class Main {
    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<>();
        for (int i = 0; i < 10; i++) {
            //System.out.println(_02stack.peek());
            stack.push(i);
            //System.out.println(_02stack);
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(stack.pop());
            System.out.println(stack);
            System.out.println(stack.peek());
        }
    }
}

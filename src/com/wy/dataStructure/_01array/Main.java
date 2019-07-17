package com.wy.dataStructure._01array;


public class Main {

    public static void main(String[] args) {
        // write your code here
        Array<Integer> array = new Array<>(1);
        for (int i = 0; i < 10; i++) {
            array.addFirst(i);
            //System.out.println(_01array);
        }
        System.out.println(array);
        for (int i = 0; i < 10; i++) {
//            _01array.removeFirst();
            System.out.println(array.removeLast());
            System.out.println(array);
        }
    }
}

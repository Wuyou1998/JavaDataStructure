package com.wy.dataStructure._04linkedList;

/**
 * 名称: DataStructure.com.wy.dataStructure._04linkedList.LinkedList
 * 用户: _VIEW
 * 时间: 2019/7/17,10:25
 * 描述: 链表
 */
public class LinkedList<E> {
    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node() {
            this.e = null;
            this.next = null;
        }

        public Node(E e) {
            this.e = e;
            this.next = null;
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private int size;
    private Node dummyHead;

    public LinkedList() {
        dummyHead = new Node(null, null);
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(int index, E e) {
        if (index > size || index < 0)            //index = 0 处存放的是虚头结点 dummyHead
            throw new IllegalArgumentException("add failed! index must > 0 && < size");
        Node previousNode = dummyHead;
        for (int i = 0; i < index; i++) {
            previousNode = previousNode.next;
        }
//        Node node = new Node(e);
//        node.next = previousNode.next;
//        previousNode.next = node;
        previousNode.next = new Node(e, previousNode.next);
        size++;
    }

    public void addFirst(E e){
        add(0,e);
    }
    public void addLast(E e){
        add(size,e);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("LinkedList: ");
        Node currentNode=dummyHead.next;
        while (currentNode!=null){
            builder.append(currentNode.toString()).append("-->");
            currentNode=currentNode.next;
        }
        builder.append("NULL");
        return builder.toString();
    }
}

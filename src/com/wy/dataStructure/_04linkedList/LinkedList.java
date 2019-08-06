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

    //存储元素的个数
    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
    //添加
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
        //使用构造方法，其效果和上面三行一样
        previousNode.next = new Node(e, previousNode.next);
        size++;
    }

    public void addFirst(E e) {
        add(0, e);
    }

    public void addLast(E e) {
        add(size, e);
    }
    //将index处的元素修改为e
    public void update(int index, E e) {
        if (index > size || index < 0)
            throw new IllegalArgumentException("update failed! index must > 0 && < size");
        Node previousNode = dummyHead.next;
        for (int i = 0; i < index; i++) {
            previousNode = previousNode.next;
        }
        previousNode.e = e;
    }

    public boolean contains(E e){
        Node current=dummyHead.next;
        while (current!=null){
            if (current.e.equals(e))
                return true;
            else
                current=current.next;
        }
        return false;
    }
    //获取index处的元素
    public E getElement(int index) {
        if (index > size || index < 0)
            throw new IllegalArgumentException("get failed! index must > 0 && < size");
        Node currentNode = dummyHead.next;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode.e;
    }

    public E getFirstElement() {
        if (isEmpty())
            throw new IllegalArgumentException("can not get from an empty list!");
        return dummyHead.next.e;
    }

    public E getLastElement() {
        if (isEmpty())
            throw new IllegalArgumentException("can not get from an empty list!");
        Node currentNode = dummyHead.next;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }
        return currentNode.e;
    }
    //删掉index处的节点
    public E delete(int index) {
        if (index > size || index < 0)
            throw new IllegalArgumentException("delete failed! index must > 0 && < size");
        //previousNode为待删元素的上一个节点
        Node previousNode = dummyHead;
        for (int i = 0; i < index; i++) {
            previousNode = previousNode.next;
        }
        Node result = previousNode.next;
        previousNode.next = result.next;
        result.next = null;
        size--;
        return result.e;
    }

    public E deleteFirst() {
        return delete(0);
    }

    public E deleteLast() {
        return delete(size - 1);
    }
    //删除值为e的节点
    public void remove(E e) {
//        if (isEmpty())
//            throw new IllegalArgumentException("can not remove element from an empty list!");
        Node previousNode = dummyHead;
        //在这里已经对空表不做处理，判空已经是无所谓的操作了
        while (previousNode.next != null) {
            if (previousNode.next.e.equals(e))
                break;
            previousNode = previousNode.next;
        }
        if (previousNode.next != null) {
            Node delNode = previousNode.next;
            previousNode.next = delNode.next;
            delNode.next = null;
            size--;
        }

    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("LinkedList: ");
        Node currentNode = dummyHead.next;
        while (currentNode != null) {
            builder.append(currentNode.toString()).append("-->");
            currentNode = currentNode.next;
        }
        builder.append("NULL");
        return builder.toString();
    }
}

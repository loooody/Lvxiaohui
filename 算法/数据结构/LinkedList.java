package com.company;

/**
 * 单链表基本操作
 */
public class LinkedList{
    private class Node{
        private Object obj;
        private Node next;

        Node(Object obj) {
            this.obj = obj;
        }
    }

    private Node first = null;

    public void insertFirst(Object object) {
        Node node = new Node(object);
        node.next = first;
        first = node;
    }

    public Object deleteFirst() throws Exception{
        if (first == null) {
            throw new Exception("empty");
        }
        Node temp = first;
        first = first.next;
        return temp.obj;
    }

    public Object find(Object object) throws Exception {
        if (first == null) {
            throw new Exception("linkedlist is empty");
        }
        Node node = first;
        while (node != null) {
            if (node.obj.equals(object)) {
                return node.obj;
            }
            node = node.next;
        }
        return null;
    }

    public void remove(Object object) throws Exception {
        if (first == null) {
            throw new Exception("LinkedList is empty");
        }
        if (first.obj.equals(object)) {
            first = first.next;
        }else{
            Node pre = first;
            Node node = first.next;
            while (node != null) {
                if (node.obj.equals(object)) {
                    pre.next = node.next;
                }
                pre = node;
                node = node.next;
            }
        }
    }

    public boolean isEmpty(){
        return (first == null);
    }

    public void display(){
        if (first == null) {
            System.out.println("empty");
        }
        Node node = first;
        while (node != null) {
            System.out.print(node.obj.toString() + "->");
            node = node.next;
        }
        System.out.println();
    }


    public static void main(String[] args) throws Exception {
        LinkedList list = new LinkedList();
        list.insertFirst(4);
        list.insertFirst(3);
        list.insertFirst(2);
        list.insertFirst(1);
        list.display();
        list.deleteFirst();
        list.display();
        list.remove(3);
        list.display();
        System.out.println(list.find(5));

    }

}
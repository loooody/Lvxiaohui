package com.company;

/**
 * 单链表基本操作
 */
public class FirstLastLinkedList{
    private class Node{
        private Object obj;
        private Node next = null;

        Node(Object obj){
            this.obj = obj;
        }
    }

    private Node first = null;
    private Node last = null;

    public void insertFirst(Object object) {
        Node node = new Node(object);
        if (first == null) {
            last = node;
        }
        node.next = first;
        first = node;
    }

    public void insertLast(Object object) {
        Node node = new Node(object);
        if (first == null) {
            first = node;
        }else{
            last.next = node;
        }
        last = node;
    }

    public Object deleteFirst() throws Exception {
        if (first == null) {
            throw new Exception("empty");
        }
            Node temp = first;
        if(first.next == null)
            last = null;
            first = first.next;
        return temp.obj;
    }

    public void deleteLast() throws Exception {
        if (first == null) {
            throw new Exception("empty");
        }
        if (first.next == null) {
            first = null;
            last = null;
        }else{
            Node temp = first;
            while (temp.next != null) {
                if (temp.next == last) {
                    last = temp;
                    last.next = null;
                    break;
                }
                temp = temp.next;
            }
        }
    }


    public void display() throws Exception {
        if (first == null) {
            throw new Exception("empty");
        }else{
            Node temp = first;
            while (temp != null) {
                System.out.print(temp.obj.toString() + "->");
                temp = temp.next;
            }
        }
        System.out.println();
    }




    public static void main(String[] args) throws Exception {
        FirstLastLinkedList list = new FirstLastLinkedList();
        list.insertFirst(4);
        list.insertFirst(3);
        list.insertFirst(2);
        list.insertFirst(1);
        list.display();
        list.deleteFirst();
        list.display();
        list.deleteLast();
        list.display();
        list.insertLast(8);
        list.display();

    }

}
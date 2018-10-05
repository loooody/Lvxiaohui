package com.company;

/**
 * 删除链表中的重复元素
 */
public class DeleteDuplication {
    private static class Node{
        Object object;
        Node next = null;

        Node(Object object) {
            this.object = object;
        }
    }

    private static Node head = null;
    private static Node last = null;

    public static Node addNode(Object object) {
        Node node = new Node(object);
        if (head == null) {
            head = node;
        }else{
            last.next = node;
        }
        last = node;
        return node;
    }

    public static void display(){
        if (head == null) {
            return ;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.object + "->");
            temp = temp.next;
        }
        System.out.println();
    }

    //实现代码
    public static void deleteDuplication(Node head1) {
        if (head1 == null) {
            return ;
        }
        Node first = new Node(0);
        first.next = head1;
        Node node = head1;
        Node pre = first;

        while (node != null && node.next != null) {
            if (node.object == node.next.object) {
                Object object = node.object;
                while (node != null && node.object == object) {
                    node = node.next;
                }
                pre.next = node;
            }else{
                pre = node;
                node = node.next;
            }
        }
        head = first.next;
    }

    public static void main(String[] args) {
        addNode(3);
        addNode(3);
        addNode(4);
        addNode(9);
        addNode(5);
        addNode(7);
        addNode(7);
        display();
        deleteDuplication(head);
        display();
    }
}

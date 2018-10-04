package com.company;

public class DeleteNode {
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

    public static void deleteNode(Node pHead, Node pToDelete) {
        if (pHead == null || pToDelete == null) {
            return;
        }

        if (pToDelete.next != null) {
            Node temp = pToDelete.next;
            pToDelete.next = temp.next;
            pToDelete.object = temp.object;
        }
        else{
            Node pTemp = pHead;
            while (pTemp.next != pToDelete) {
                pTemp = pTemp.next;
            }
            pTemp.next = null;
        }
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

    public static void main(String[] args) {
        addNode(3);
        Node temp = addNode(4);
        addNode(5);
        display();
        deleteNode(head,temp);
        display();
    }
}

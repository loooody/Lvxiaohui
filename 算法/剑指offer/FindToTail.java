package com.company;

public class FindToTail {
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

    public static Node FindToTail(Node head, int k) {
        if (head == null || k == 0) {
            return null;
        }

        Node ahead = head;
        Node behind = null;

        for (int i = 1; i <= k; i++) {
            if (ahead != null) {
                ahead = ahead.next;
            } else {
                return null;
            }
        }

            behind = head;

            while (ahead != null) {
                ahead = ahead.next;
                behind = behind.next;
            }

        return behind;
    }

    public static void main(String[] args) {
        addNode(3);
        addNode(4);
        addNode(5);
        addNode(8);

        System.out.println(FindToTail(head, 3).object);
        System.out.println(FindToTail(head, 1).object);
        System.out.println(FindToTail(head, 100).object);
    }
}

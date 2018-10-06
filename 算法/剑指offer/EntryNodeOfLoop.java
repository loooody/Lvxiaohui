package com.company;

public class EntryNodeOfLoop {

    public static class Node{
        int val;
        Node next = null;

        Node(int val) {
            this.val = val;
        }
    }


    public static Node EntryNode(Node pHead) {
        if (pHead == null || pHead.next == null) {
            return null;
        }
        Node fast = pHead;
        Node slow = pHead;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (fast.val == slow.val) {     //meet
                fast = pHead;
                while (fast.val != slow.val) {
                    fast = fast.next;
                    slow = slow.next;
                }
            }
            if (fast.val == slow.val) { //twice meet
                return slow;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Node head = new Node(3);
        Node node1 = new Node(4);
        Node node2 = new Node(5);
        Node node3 = new Node(6);
        Node node4 = new Node(7);
        Node node5 = new Node(8);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node4;
        System.out.println(EntryNode(head).val);
    }
}

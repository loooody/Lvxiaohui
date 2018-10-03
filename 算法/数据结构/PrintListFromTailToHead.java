package com.company;

import java.util.Arrays;
import java.util.Stack;

public class PrintListFromTailToHead{

    private class Node{
        Object val;
        Node next = null;

        Node(Object object) {
            this.val = object;
        }
    }

    private static Node head = null;

    private static Node last = null;

    public static void main(String[] args) throws Exception {
        PrintListFromTailToHead list = new PrintListFromTailToHead();
        list.addNode(3);
        list.addNode(5);
        list.addNode(10);
        list.display();
        System.out.println("Stack:");
        list.printListByStack(head);
        System.out.println();
        System.out.println("digui:");
        list.printList(head);
        System.out.println();
        System.out.println("reverse:");
        list.printListByReverseList(head);
    }

    public void addNode(Object object) {
        Node node = new Node(object);
        if (head == null) {
            head = node;
            last = node;
        }else {
            last.next = node;
            last = node;
        }
    }

    public void display() throws Exception {
        if (head == null) {
            throw new Exception("empty");
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + "->");
            temp = temp.next;
        }
        System.out.println();
    }

    //method1
    public void printListByStack(Node node) {
        Stack<Object> stack = new Stack<Object>();
        while (node != null) {
            stack.push(node.val);
            node = node.next;
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + "->");
        }
    }

    //method2
    public void printList(Node node) {
        if (node != null) {
            if (node.next != null) {
                printList(node.next);
            }
            System.out.print(node.val + "->");
        }else{
            System.out.println("empty");
        }
    }

    public void printListByReverseList(Node node) {
        Node reverseNode = reverse(node);
        while (reverseNode != null) {
            System.out.print(reverseNode.val + "->");
            reverseNode = reverseNode.next;
        }
    }

    private static Node reverse(Node head) {
        if (head.next == null) {
            return head;
        }
        Node reverseNode = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return reverseNode;
    }
}
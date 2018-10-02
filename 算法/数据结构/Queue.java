package com.company;

import java.util.Arrays;
import java.util.Stack;


public class Queue{
    private Object[] objects;
    private int head;
    private int end;
    private int size;

    public Queue(int size) {
        objects = new Object[size];
        this.head = 0;
        this.end = -1;
        this.size = 0;
    }

    public void push(Object object) throws Exception {
        if (this.size > objects.length) {
            throw new Exception("Queue is full");
        }
        if (end == objects.length - 1) {
            end = -1;
        }
        objects[++end] = object;
        size++;
    }

    public Object pop() throws Exception {
        if (this.size == 0) {
            throw new Exception("empty");
        }
        Object temp = objects[head++];
        if (head == objects.length) {
            head = 0;
        }
        size--;
        return temp;
    }

    public Object peek() throws Exception {
        if (this.size == 0) {
            throw new Exception("empty");
        }
        return objects[head];
    }

    public int size(){
        return this.size;
    }

    public boolean isEmpty(){
        return (size == 0);
    }

    public boolean isFull(){
        return (size == objects.length);
    }

    public void display() throws Exception {
        if (this.size == 0) {
            throw new Exception("empty");
        }
        System.out.println("head:" + head + "  length:" + size);

        for (int i = 0; i < size; i++) {
            System.out.print(objects[i] + "->");
        }

        System.out.println();
    }

    public static void main(String[]args) throws Exception {

        Queue s = new Queue(3);
        s.push(1);
        s.push(2);
        s.display();
        System.out.println(s.pop());
        s.display();
        s.push(99);
        s.display();

    }
}
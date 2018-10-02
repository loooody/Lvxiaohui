package com.company;

import java.util.Arrays;


public class Stack{

    private int top = -1;
    private Object[] objects;

    public Stack(int capacity) throws Exception {
        if (capacity < 0) {
            throw new Exception("Illegal capacity:" + capacity);
        }
        objects = new Object[capacity];
    }

    public void push(Object object) throws Exception {
        if (top == objects.length - 1) {
            throw new Exception("Stack is full");
        }
        objects[++top] = object;
    }

    public Object pop() throws Exception{
        if (top == -1) {
            throw new Exception("Stack is empty");
        }
        return objects[top--];
    }

    public void display(){
        System.out.print("bottom -> top: |");
        for (int i = 0; i <= top; i++) {
            System.out.print(objects[i] + "|");
        }
        System.out.println();
    }


    public static void main(String[] args) throws Exception {
        Stack s = new Stack(2);
        s.push(1);
        s.push(2);
        s.display();
        System.out.println(s.pop());
        s.display();
        s.push(99);
        s.display();
   //     s.push(99);

    }
}
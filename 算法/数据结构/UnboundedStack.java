package com.company;

import java.util.Arrays;
import java.util.Stack;


public class UnboundedStack{
    private int top = -1;
    private Object[] objects;

    public UnboundedStack() throws Exception {
        this(10);
    }

    public UnboundedStack(int capacity) throws Exception {
        if (capacity < 0) {
            throw new Exception("Illegal capacity");
        }
        objects = new Object[capacity];
    }

    public void display(){
        System.out.print("bottom -> top: |");
        for (int i = 0; i <= top; i++) {
            System.out.print(objects[i] + "|");
        }
        System.out.println();
    }

    public void push(Object object) throws Exception {
        if (top == objects.length - 1) {
            this.enlarge();
        }
        objects[++top] = object;
    }

    public Object pop() throws Exception {
        if (top == -1) {
            throw new Exception("Stack is empty");
        }
        return objects[top--];
    }

    private void enlarge() {
        int num = objects.length / 3;
        if (num == 0) {
            num = 1;
        }
        objects = Arrays.copyOf(objects, objects.length + num);
    }





    public static void main(String[]args) throws Exception {

        UnboundedStack s = new UnboundedStack(2);
        s.push(1);
        s.push(2);
        s.display();
        System.out.println(s.pop());
        s.display();
        s.push(99);
        s.display();
        s.push(99);
        s.display();
    }
}
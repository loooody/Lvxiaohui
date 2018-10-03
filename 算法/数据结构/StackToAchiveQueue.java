package com.company;

import java.util.Arrays;
import java.util.Stack;

public class StackToAchiveQueue{

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
        System.out.println("insert success:" + node);
    }

    public int pop(){
        if (stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }

        return stack2.pop();
    }

    public static void main(String[] args) {
        StackToAchiveQueue queue = new StackToAchiveQueue();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        System.out.println(queue.pop());
        queue.push(5);
        System.out.println(queue.pop());
    }

}
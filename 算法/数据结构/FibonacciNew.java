package com.company;

import java.util.Arrays;
import java.util.Stack;

public class FibonacciNew{

    public static int fibonacciNew(int n) {
        if (n <= 0) {
            return 0;
        } else if (n <= 2) {
            return 1;
        }else{
            int result = 1;
            int temp = 1;
            for (int i = 3; i <= n; i++) {
                result += temp;
                temp = result - temp;
            }
            return result;
        }
    }

    public static int fibonacci(int n) {
        if (n <= 0) {
            return 0;
        }
        if(n == 1){
            return 1;
        }

        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
       // System.out.println(fibonacci(30));
        System.out.println(fibonacciNew(30));
    }

}
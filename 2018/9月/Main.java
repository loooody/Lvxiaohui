package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        staticFunction();

    }

    static Main st = new Main();

    static
    {
        System.out.println("1");
    }

    {
        System.out.println("2");
    }

    Main()
    {
        System.out.println("3");
        System.out.println("a=" + a + ",b=" + b);
    }

    private static void staticFunction() {
        System.out.println("4");

    }

    int a = 110;
   // static final int b = 112;
    static int b = 112;

    /*
    output:
    2
    3
    a=110,b=0
    1
    4
     */
}

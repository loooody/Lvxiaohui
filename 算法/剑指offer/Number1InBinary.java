package com.company;

/**
 * 求二进制中1的个数
 */
public class Number1InBinary {
    //method1
    public static int number(int n) {
        int count = 0;
        int flag = 1;
        while (flag != 0) {
            if ((n & flag) != 0) {
                count++;
            }
            flag = flag << 1;
        }
        return count;
    }

    //mehtod2
    public static int number2(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int num = 9;

        System.out.println(number2(num));
        System.out.println(number(num));
    }
}

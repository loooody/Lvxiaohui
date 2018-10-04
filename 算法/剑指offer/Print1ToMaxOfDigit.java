package com.company;

public class Print1ToMaxOfDigit {

    public static void main(String[] args) {
        print1ToMax(10);
    }

    public static void print1ToMax(int n) {
        int number = 1;
        int i = 0;
        while (i++ < n) {
            number *= 10;
        }

        for (int j = 1; j < number; j++) {
            System.out.print(j + " ");
            if (j % 10 == 0) {
                System.out.println();
            }
        }
    }
}

package com.company;

/**
 *
 */
public class Power {

    public static void main(String[] args) throws Exception {
        System.out.println(Power(4, -3));
        System.out.println(pow(0,3));
    }

    public static double Power(double base, int exponenet) {
        return Math.pow(base, exponenet);
    }

    public static double pow(double base, int exponent) throws Exception {
        double result = 1.000;
        int ex = Math.abs(exponent);
        boolean flag = true;
        if (exponent < 0) {
            flag = false;
        }
        while (ex > 0) {
            result *= base;
            ex--;
        }
        if (flag == false) {
            if (base == 0) {
                throw new Exception("error");
            }
            result = 1 / result;
        }

        return result;
    }

    public static double Pow(double base, int exponent) {
        int n = Math.abs(exponent);
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return base;
        }
        double result = Pow(base, n >> 1);
        result *= result;
        if ((n & 1) == 1) {
            result *= base;
        }
        if (exponent < 0) {
            result = 1 / result;
        }

        return result;
    }
}

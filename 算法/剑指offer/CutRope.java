package com.company;

/**
 * 面试题：剪绳子
 * 动态规划
 */
public class CutRope {

    public static void main(String[] args) {
        System.out.println(maxAfterCutting(8));
        System.out.println(maxProduct(8));
    }

    private static int maxAfterCutting(int length) {
        if (length < 2) {
            return 0;
        }
        if (length == 2) {
            return 1;
        }
        if (length == 3) {
            return 2;
        }
        //子问题的最优解存储在数组中
        int[] f = new int[length + 1];
        f[0] = 0;
        f[1] = 1;
        f[2] = 2;
        f[3] = 3;
        int result = 0;
        for (int i = 4; i <= length; i++) {
            int max = 0;
            for (int j = 1; j <= i / 2; j++) {
                int num = f[j] * f[i - j];
                if (max < num) {
                    max = num;
                }
                f[i] = max;
            }
        }
        result = f[length];
        return result;
    }

    //贪婪算法
    public static int maxProduct(int len) {
        if (len < 2) {
            return 0;
        }
        if (len == 2) {
            return 1;
        }
        if (len == 3) {
            return 2;
        }

        //先尽可能剪去长度为3
        int timeOfThree = len / 3;

        //判断还有多少
        if (len - timeOfThree * 3 == 1) {
            timeOfThree -= 1;
        }
        int timeOfTwo = (len - timeOfThree*3) / 2;

        return (int) ((Math.pow(3, timeOfThree) * (Math.pow(2, timeOfTwo))));
    }
}

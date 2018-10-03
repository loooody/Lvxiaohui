package com.company;

import java.util.Arrays;
import java.util.Stack;

public class minNumberRotateArray{

    public static int minNumber(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }
        int end = arr.length - 1;
        int begin = 0;
        int mid = (end - begin) / 2 + begin;
        int result = -1;
        while (begin < end) {
            if (begin == (end - 1)) {
                result = arr[end];
                break;
            }
            if (arr[begin] == arr[mid] && arr[mid] == arr[end]) {
                result = findMin(arr);
                break;
            } else if (arr[begin] <= arr[mid]) {
                begin = mid;
            } else if (arr[mid] <= arr[end]) {
                end = mid;
            }
            mid = (end - begin) / 2 + begin;
        }
        return result;
    }

    public static int findMin(int[] arr) {
        int result = -1;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                result = arr[i + 1];
                break;
            }
        }
        return result;
    }


    public static void main(String[] args) {
      //  int[] arr = {1, 1, 1, 1, 1, 0, 1};
        int[] arr = {4, 5, 6, 7, 2, 3};
        System.out.println(minNumber(arr));
    }
}
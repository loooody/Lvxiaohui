package com.company;

import java.util.*;

public class MergeSort{
    public static void main(String[] args){
        int[] a = {9,2,3,4,6,7,8,4,2,2};
        sort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));

    }

    public static int[] sort(int[] nums, int low, int high) {
        int mid = (low + high) / 2;
        if (low < high) {
            //左边
            sort(nums, low, mid);
            //右边
            sort(nums, mid + 1, high);
            //左右归并
            merge(nums, low, mid, high);
        }
        return nums;
    }

    public static void merge(int[] nums, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low;    //左指针
        int j = mid + 1;    //
        int k = 0;

        //把较小的数先移动到新的数组中
        while (i <= mid && j <= high) {
            if (nums[i] < nums[j]) {
                temp[k++] = nums[i++];
            }else{
                temp[k++] = nums[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = nums[i++];
        }

        while (j <= high) {
            temp[k++] = nums[j++];
        }

        //新数组覆盖nums数组
        for (int k2 = 0; k2 < temp.length; k2++) {
            nums[k2 + low] = temp[k2];
        }
    }

}
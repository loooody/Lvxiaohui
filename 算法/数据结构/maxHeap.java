package com.company;

import java.util.Arrays;

/**
 * 单链表基本操作
 */
public class maxHeap{

    public static void PerDown(int[] A, int i, int N) {
        int child;

        int temp;

        for (temp = A[i]; 2 * i + 1 < N; i = child) {
            child = 2 * i + 1;
            if (child != N - 1 && A[child] < A[child + 1]) {
                child++;
            }
            //比较当前父节点与较大子节点
            if (A[i] < A[child]) {
                //交换当前父节点出的元素值与较大子节点的元素值
                temp = A[i];
                A[i] = A[child];
                A[child] = temp;
            }else{
                break;
            }
        }
    }

    public static void HeapSort(int[] A, int N) {
        int i;
        //创建大根堆
        for (i = N / 2; i >= 0; i--) {
            PerDown(A, i, N);
        }

        //调整大根堆
        for (i = N - 1; i > 0; i--) {
            swap(A, 0, i);
            //元素
            PerDown(A, 0, i);
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int tem = nums[i];
        nums[i] = nums[j];
        nums[j] = tem;
    }

    public static void main(String[] args) {
        int[] a = {4, 5, 10, 3, 2, 8, 1};
        HeapSort(a, a.length);
        System.out.println(Arrays.toString(a));
    }

}
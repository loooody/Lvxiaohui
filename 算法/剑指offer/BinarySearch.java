package com.company;

import java.util.*;

public class BinarySearch{
    public static void main(String[] args){
        int[] src = {1,2,4,5,7,8,9};
        System.out.println("循环实现");
        System.out.println(binarySearch(src,78));
        System.out.println("递归实现");
        System.out.println(binarySearch1(src,5,0,src.length - 1));
    }

    /**
     * 二分查找算法
     * @param src
     * @param i
     * @return
     */
    private static int binarySearch(int[] src, int i) {
        int low = 0;
        int high = src.length - 1;
        while(low <= high){
            int middle = (low + high) / 2;
            if(i == src[middle]){
                return middle;
            }else if(i <= src[middle]){
                high = middle -1;
            }else{
                low = middle + 1;
            }
        }
        return -1;
    }

    /**
     *递归实现二分查找
     * @param dataset
     * @param data
     * @param beginIndex
     * @param endIndex
     * @return
     */
    public static int binarySearch1(int[] dataset, int data, int beginIndex, int endIndex){
        int midIndex = (beginIndex + endIndex) / 2;
        if(data < dataset[beginIndex] || data > dataset[endIndex] ||beginIndex > endIndex){
            return -1;
        }
        if(data < dataset[midIndex]){
            return binarySearch1(dataset, data, beginIndex, midIndex - 1);
        }else if(data > dataset[midIndex]){
            return binarySearch1(dataset, data, midIndex + 1, endIndex);
        }else{
            return midIndex;
        }
    }
}
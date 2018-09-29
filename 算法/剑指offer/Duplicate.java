package com.company;

import java.util.*;

public class Duplicate {
    public static void main(String[] args){
        int[] arr = {2,4,6,1,3,2};
        dup(arr);
    }

    public static void dup(int[] arr){
        HashMap map = new HashMap();
        if(arr.length <= 0){
            System.out.println("empty");
            return ;
        }
        int count = 0;
        for(int i = 0; i < arr.length; i++){
            if(map.containsKey(arr[i])) {
                System.out.println(arr[i]);
                count++;
            }else{
                map.put(arr[i],i);
            }
        }
        if(count == 0){
            System.out.println("no duplicate");
        }
    }
}

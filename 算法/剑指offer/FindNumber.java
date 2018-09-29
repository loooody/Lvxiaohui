package com.company;

import java.util.*;

public class FindNumber {
    public static void main(String[] args){
        int[][] arr = {
                {1,2,8,9},
                {2,4,9,12},
                {4,7,10,13},
                {6,8,11,15}

        };
        boolean flag = find(arr,4,4,50);
        System.out.println("result :" + flag);
    }

    public static boolean find(int[][] arr,int rows, int columns, int number){
        boolean found = false;
        if(rows > 0 && columns > 0){
            int row = 0;
            int column = columns - 1;
            while(row < rows && column >= 0){
                if(arr[row][column] == number){
                    found = true;
                    break;
                }else if(arr[row][column] > number)
                    --column;
                else
                    ++row;
            }
        }
        return found;
    }
}

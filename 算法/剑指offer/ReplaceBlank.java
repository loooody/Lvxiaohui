package com.company;

import java.util.*;

public class ReplaceBlank {
//    public static void main(String[] args){
//        String str = "you are good boy";
//        String newStr = replaceStr(str,"%20");
//        System.out.println(newStr);
//    }
//
//    public static String replaceStr(String str,String str1){
//        return str.replaceAll(" ",str1);
//    }

    private static String testString = "hello new world";

    public static int getBlankNum(String testString){
        int count = 0;
        for(int i = 0; i < testString.length(); i++){
            String tempString = String.valueOf(testString.charAt(i));
            if(tempString.equals(" ")){
                count++;
            }
        }
        return count;
    }

    public static void printArray(char[] testArray){
        for(char i : testArray){
            System.out.print(i);
        }
        System.out.println();
    }

    public static void replaceAllBlank(String testString){
        if(testString == null || testString.length() <= 0){
            return ;
        }
        int originLength = testString.length();
        int newLength = getBlankNum(testString) * 2 + originLength;
        char[] tempArray = new char[newLength];
        System.arraycopy(testString.toCharArray(), 0, tempArray, 0, testString.toCharArray().length);
        int indexofOriginal = originLength - 1;
        int indexofNew  = newLength - 1;
        System.out.println("old:");
        printArray(tempArray);
        while(indexofOriginal >= 0 && indexofOriginal != indexofNew){
            if(tempArray[indexofOriginal] == ' '){
                tempArray[indexofNew--] = '%';
                tempArray[indexofNew--] = '2';
                tempArray[indexofNew--] = '0';
            }else{
                tempArray[indexofNew--] = tempArray[indexofOriginal];
            }
            indexofOriginal--;
        }
        System.out.println("new:");
        printArray(tempArray);
    }

    public static void main(String[] args) {
        replaceAllBlank(testString);
    }
}

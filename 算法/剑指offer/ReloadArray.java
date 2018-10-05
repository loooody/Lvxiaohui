package com.company;

/**
 * 输入一个数组，让所有偶数在后面
 */
public class ReloadArray {

    public static void reloadArray(int[] arr) {
        if (arr.length <= 0) {
            return;
        }

        int low = 0;
        int high = arr.length - 1;

        while (low < high) {
            while (low < high && (arr[high] % 2 == 0)) {
                high--;
            }
            while (low < high && (arr[low] % 2 == 1)) {
                low++;
            }
            if (low < high) {
                int temp = arr[low];
                arr[low] = arr[high];
                arr[high] = temp;
            }

        }
    }


    //method2
    public static boolean isEven(int n) {
        return (n & 1) == 0;
    }

    public static void order(int[] arr) {
        if (arr == null) {
            return;
        }

        int i = 0;
        int j = arr.length - 1;
        while (i < j) {
            if (isEven(arr[i]) && !isEven(arr[j])) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            } else if (!isEven(arr[i]) && isEven(arr[j])) {
                i++;
            } else if (isEven(arr[i]) && isEven(arr[j])) {
                j--;
            }else{
                i++;
                j--;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 7, 8, 9, 0, 1, 2};
      //  reloadArray(arr);
        order(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

package date1009;

import java.util.ArrayList;
import java.util.List;

public class PrintArray {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4, 5},
                {5, 6, 7, 8, 9},
                {9, 10, 11, 12, 13},
                {13, 14, 15, 16, 12}
        };

        List list = printMatrix(matrix);
        for (Object i : list) {
            System.out.print(i + " ");
        }
    }

    public static ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList list = new ArrayList();
        int rows = matrix.length;
        int colums = matrix[0].length;
        if (matrix == null || rows == 0 || colums == 0) {
            return list;
        }
        int left = 0;
        int right = colums - 1;
        int top = 0;
        int buttom = rows - 1;

        while (left <= right && top <= buttom) {
            for (int i = left; i <= right; i++) {
                list.add(matrix[top][i]);
            }

            if (buttom > top) {
                for (int i = top + 1; i <= buttom; ++i) {
                    list.add(matrix[i][right]);
                }
            }

            if (right > left && buttom > top) {
                for (int i = right - 1; i >= left; --i) {
                    list.add(matrix[buttom][i]);
                }
            }

            if (buttom - 1 > top && right > left) {
                for (int i = buttom - 1; i > top; i--) {
                    list.add(matrix[i][left]);
                }
            }

            left++;
            right--;
            top++;
            buttom--;
        }
        return list;
    }

}

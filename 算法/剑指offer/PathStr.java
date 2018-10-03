package com.company;

public class PathStr {
    public static boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        boolean[] visit = new boolean[rows * cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (hasPath(matrix, rows, cols, i, j, str, 0, visit)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean hasPath(char[] matrix, int rows, int cols, int row, int col, char[] str, int curr, boolean[] visit) {
        int index = row * col + col;
        if (row < 0 || col < 0 || row >= rows || col >= cols || visit[index] || matrix[index] != str[curr]) {
            return false;
        }
        visit[index] = true;
        if (curr == str.length - 1) {
            return true;
        }
        curr++;

        if(hasPath(matrix, rows, cols, row + 1, col, str, curr, visit) ||
                hasPath(matrix, rows, cols, row - 1, col, str, curr, visit) ||
                hasPath(matrix, rows, cols, row, col + 1, str, curr, visit) ||
                hasPath(matrix, rows, cols, row, col - 1, str, curr, visit))
            return true;

        visit[index] = false;

        return false;
    }

    public static void main(String[] args) {
        char[] matrix = "ABTGCFCSJDEH".toCharArray();
        int rows = 3;
        int cols = 4;
        char[] str = "BFCTB".toCharArray();
        if (!hasPath(matrix, rows, cols, str)) {
            System.out.println("test passed");
        }else{
            System.out.println("test failed");
        }
    }
}

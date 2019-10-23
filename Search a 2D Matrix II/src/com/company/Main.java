package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int j = 0;
        int i = matrix[0].length - 1;
        while (j < matrix.length && i >= 0) {
            if (matrix[j][i] < target) {
                j++;
            } else if (matrix[j][i] > target) {
                i--;
            } else {
                return true;
            }
        }

        return false;
    }
}

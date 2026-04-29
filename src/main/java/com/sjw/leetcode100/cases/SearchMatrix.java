package com.sjw.leetcode100.cases;

import com.sjw.leetcode100.base.BaseCase;

public class SearchMatrix implements BaseCase {
    @Override
    public void run() {
        int[][] matrix = new int[2][2];
        matrix[0] = new int[]{1,4};
        matrix[1] = new int[]{2,5};
        System.out.println(searchMatrix(matrix, 2));

    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int i = 0, j = n - 1;
        while (i < m && j >= 0) {
            if (matrix[i][j] < target) i++;
            else if (matrix[i][j] > target) j--;
            else return true;
        }
        return false;
    }


}

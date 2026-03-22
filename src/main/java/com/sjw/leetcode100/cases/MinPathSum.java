package com.sjw.leetcode100.cases;

import com.sjw.leetcode100.base.BaseCase;

public class MinPathSum implements BaseCase {
    @Override
    public void run() {
        int [][] matrix = new int[3][3];
        matrix[0] =  new int[]{1, 3, 1};
        matrix[1] = new int[]{1, 5, 1};
        matrix[2] = new int[]{4, 2, 1};
        System.out.println(minPathSum(matrix));
    }

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];
        dp[m - 1][n - 1] = grid[m - 1][n - 1];

        for(int i = m - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                if (i + 1 == m && j + 1 == n)
                    dp[i][j] = grid[i][j];
                else {
                    if (i + 1 == m)
                        dp[i][j] = grid[i][j] + dp[i][j + 1];
                    else if (j + 1 == n)
                        dp[i][j] = grid[i][j] + dp[i + 1][j];
                    else
                        dp[i][j] = Math.min(dp[i + 1][j], dp[i][j + 1]) + grid[i][j];
                }
            }
        }

        return dp[0][0];
    }
}

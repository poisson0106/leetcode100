package com.sjw.leetcode100.cases;

import com.sjw.leetcode100.base.BaseCase;

public class UniquePaths implements BaseCase {
    @Override
    public void run() {

    }

    public int uniquePaths(int m, int n) {
        //从i, j位置到m-1, n-1的路径条数
        int[][] dp = new int[m][n];
        dp[m-1][n-1] = 1;
        for (int i = m-1; i >= 0; i--) {
            for (int j = n-1; j >= 0; j--) {
                if (i + 1 < m) {
                    dp[i][j] += dp[i+1][j];
                }

                if (j + 1 < n) {
                    dp[i][j] += dp[i][j+1];
                }
            }
        }

        return dp[0][0];
    }
}

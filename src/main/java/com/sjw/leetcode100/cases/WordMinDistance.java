package com.sjw.leetcode100.cases;

import com.sjw.leetcode100.base.BaseCase;

public class WordMinDistance implements BaseCase {
    @Override
    public void run() {

    }

    public int minDistance(String word1, String word2) {
        //长度为i的word1变化到长度为j的word2需要进行的最少变化次数
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            //删除i个字符
            dp[i][0] = i;
        }

        for (int j = 1; j <= n; j++) {
            //插入j个字符
            dp[0][j] = j;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1),dp[i - 1][j - 1] + 1);
                }
            }
        }

        return dp[m][n];
    }
}

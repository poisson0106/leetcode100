package com.sjw.leetcode100.cases;

import com.sjw.leetcode100.base.BaseCase;

public class LongestCommonSubsequence implements BaseCase {
    @Override
    public void run() {

    }

    public int longestCommonSubsequence(String text1, String text2) {
        //text1长度i和text2长度j的最大公共字串长度
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        char[] cArr1 = text1.toCharArray();
        char[] cArr2 = text2.toCharArray();
        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (cArr1[i - 1] == cArr2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[text1.length()][text2.length()];
    }
}

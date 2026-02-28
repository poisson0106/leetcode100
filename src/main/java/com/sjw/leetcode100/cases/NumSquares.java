package com.sjw.leetcode100.cases;

import com.sjw.leetcode100.base.BaseCase;

import java.util.Arrays;

public class NumSquares implements BaseCase {
    @Override
    public void run() {
        System.out.println(numSquares(12));
    }

    public int numSquares(int n) {
        //i位置用完全平方数组成需要的最小数量
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        double squareNum;
        int thisMin;
        for (int i = 1; i <= n; i++) {
            thisMin = Integer.MAX_VALUE;
            squareNum = Math.sqrt(i);
            for (int j = (int) squareNum; j > 0; j--) {
                if (dp[i - j * j] != -1) {
                    thisMin = Math.min(thisMin, dp[i - j * j] + 1);
                }
            }

            if (thisMin != Integer.MAX_VALUE) {
                dp[i] = thisMin;
            }
        }

        return dp[n];
    }
}

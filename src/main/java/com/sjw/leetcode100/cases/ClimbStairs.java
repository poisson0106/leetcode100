package com.sjw.leetcode100.cases;

import com.sjw.leetcode100.base.BaseCase;

public class ClimbStairs implements BaseCase {
    @Override
    public void run() {

    }

    public int climbStairs(int n) {
        //爬到第i级时的方法数
        int[] dp = new int[n + 1];
        //什么都不走，一种方法
        dp[0] = 1;
        //走一步，一种方法
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}

package com.sjw.leetcode100.cases;

import com.sjw.leetcode100.base.BaseCase;

public class RobI implements BaseCase {
    @Override
    public void run() {

    }

    public int rob(int[] nums) {
        //偷到第i家时
        int[] dp = new int[nums.length+1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i <= nums.length; i++) {
            //不偷当前家or偷当前家不偷前一家
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i-1]);
        }

        return dp[nums.length];
    }
}

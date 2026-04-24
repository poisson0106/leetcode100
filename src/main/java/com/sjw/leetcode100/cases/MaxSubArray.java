package com.sjw.leetcode100.cases;

import com.sjw.leetcode100.base.BaseCase;

public class MaxSubArray implements BaseCase {
    @Override
    public void run() {
        System.out.println(maxSubArray(new int[]{-2, -1}));
    }

    public int maxSubArray(int[] nums) {
        //必须以i位置结尾的子数组最大和
        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            if (dp[i] > max) {
                max = dp[i];
            }
        }

        return max;
    }

    public int maxSubArray2(int[] nums) {
        int result = nums[0];
        int minPre = 0;
        int prefix = 0;
        for (int num : nums) {
            prefix += num;
            result = Math.max(result, prefix - minPre);
            minPre = Math.min(minPre, prefix);
        }

        return result;
    }
}

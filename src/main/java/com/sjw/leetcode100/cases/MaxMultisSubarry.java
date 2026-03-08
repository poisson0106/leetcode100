package com.sjw.leetcode100.cases;

import com.sjw.leetcode100.base.BaseCase;

public class MaxMultisSubarry implements BaseCase {
    @Override
    public void run() {
        System.out.println(maxProduct(new int[]{2,3,-2,4}));
        System.out.println(maxProduct(new int[]{0,-2,-3}));
    }

    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        //必须以i位置结尾的最大子数组乘积
        int[] dp = new int[nums.length];
        //必须以i位置结尾的最小子数组负数乘积
        int[] dp2 = new int[nums.length];
        int max = nums[0];
        dp[0] = nums[0];
        if (nums[0] >= 0)
            dp2[0] = Integer.MIN_VALUE;
        else
            dp2[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= 0) {
                dp[i] = Math.max(dp[i - 1] * nums[i], nums[i]);
                if (dp2[i - 1] != Integer.MIN_VALUE) {
                    dp2[i] = dp2[i - 1] * nums[i];
                } else {
                    dp2[i] = dp2[i - 1];
                }
            } else {
                if (dp2[i - 1] != Integer.MIN_VALUE) {
                    dp[i] = dp2[i - 1] * nums[i];
                    dp2[i] = Math.min(dp[i-1] * nums[i], nums[i]);
                } else {
                    //前面全是正数或0
                    dp[i] = nums[i];
                    dp2[i] = Math.min(dp[i-1] * nums[i], nums[i]);
                }
            }

            if (dp[i] > max) {
                max = dp[i];
            }
        }

        return max;
    }
}

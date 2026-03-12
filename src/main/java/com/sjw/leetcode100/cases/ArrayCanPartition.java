package com.sjw.leetcode100.cases;

import com.sjw.leetcode100.base.BaseCase;

public class ArrayCanPartition implements BaseCase {
    @Override
    public void run() {
        System.out.println(canPartition(new int[]{1,5,11,5}));
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 != 0) {
            return false;
        }

        int target = sum / 2;
        
        // Use 1D DP array for better performance
        // dp[i] represents whether sum i can be achieved
        boolean[] dp = new boolean[target + 1];
        dp[0] = true; // sum 0 is always achievable (empty subset)
        
        // Process each number
        for (int num : nums) {
            // Traverse backwards to avoid using updated values in same iteration
            for (int j = target; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
        }
        
        return dp[target];
    }
}

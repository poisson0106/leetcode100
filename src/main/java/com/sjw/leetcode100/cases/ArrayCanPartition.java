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
        // Create memoization cache: memo[pos][target]
        // Use Integer to distinguish between uncomputed (null), true, and false
        Integer[][] memo = new Integer[nums.length][target + 1];
        return f(nums, 0, target, memo);
    }

    private boolean f(int[] nums, int pos, int target, Integer[][] memo) {
        if (target < 0)
            return false;

        if (pos >= nums.length) {
            return target == 0;
        }

        // Check if result is already computed
        if (memo[pos][target] != null) {
            return memo[pos][target] == 1;
        }

        boolean useThisOne = f(nums, pos + 1, target - nums[pos], memo);
        boolean notUseThisOne = f(nums, pos + 1, target, memo);
        
        boolean result = useThisOne || notUseThisOne;
        
        // Store result in memo: 1 for true, 0 for false
        memo[pos][target] = result ? 1 : 0;
        
        return result;
    }
}

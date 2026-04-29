package com.sjw.leetcode100.cases;

import com.sjw.leetcode100.base.BaseCase;

public class CanJumpI implements BaseCase {
    @Override
    public void run() {
        int[] arr = new int[]{3,0,8,2,0,0,1};
        System.out.println(canJump(arr));
    }

    public boolean canJump(int[] nums) {
        int maxReach = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxReach) {
                return false;
            }
            maxReach = Math.max(maxReach, i + nums[i]);
            if (maxReach >= nums.length - 1) {
                return true;
            }
        }
        return true;
    }
}

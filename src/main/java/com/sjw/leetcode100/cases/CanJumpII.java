package com.sjw.leetcode100.cases;

import com.sjw.leetcode100.base.BaseCase;

public class CanJumpII implements BaseCase {
    @Override
    public void run() {
        int[] nums = new int[]{2, 3, 0, 1, 4};
        System.out.println(jump(nums));
    }

    public int jump(int[] nums) {
        int jumps = 0;
        int curEnd = 0;
        int farthest = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            if (i == curEnd) {
                jumps++;
                curEnd = farthest;
            }
        }
        return jumps;
    }
}

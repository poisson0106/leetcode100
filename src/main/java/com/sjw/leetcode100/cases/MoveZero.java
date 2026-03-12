package com.sjw.leetcode100.cases;

import com.sjw.leetcode100.base.BaseCase;

public class MoveZero implements BaseCase {
    @Override
    public void run() {

    }

    public void moveZeroes(int[] nums) {
        int left = 0, right = 0;
        while (right < nums.length) {
            if (nums[right] != 0) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
            }

            right++;
        }
    }
}

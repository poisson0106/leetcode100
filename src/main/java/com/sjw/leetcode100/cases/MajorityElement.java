package com.sjw.leetcode100.cases;

import com.sjw.leetcode100.base.BaseCase;

public class MajorityElement implements BaseCase {
    @Override
    public void run() {
        System.out.println(majorityElement(new int[] {2,2,1,1,1,2,2}));
    }

    public int majorityElement(int[] nums) {
        int candidate = 0;
        int hp = 0;
        for (int i = 0; i < nums.length; i++) {
            if (hp == 0) {
                candidate = nums[i];
                hp++;
            } else {
                if (candidate == nums[i]) {
                    hp++;
                } else {
                    hp--;
                }
            }
        }

        int count = 0;
        for (int num : nums) {
            if (num == candidate) {
                count++;
            }
        }

        if (count > nums.length / 2) {
            return candidate;
        } else {
            return -1;
        }
    }
}

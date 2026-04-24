package com.sjw.leetcode100.cases;

import com.sjw.leetcode100.base.BaseCase;

import java.util.HashSet;

public class FirstMissingPositive implements BaseCase {
    @Override
    public void run() {
        firstMissingPositive(new int[]{3, 4, -1, 1});
    }

    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }

        HashSet<Integer> set = new HashSet<>();
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= 0)
                continue;

            if (num < min) {
                min = num;
            }

            set.add(num);
        }

        if (min != 1) {
            return 1;
        } else {
            for (int i = 1; i <= set.size(); i++) {
                if (set.contains(i)) {
                    continue;
                } else {
                    return i;
                }
            }
        }

        return set.size()+1;
    }
}

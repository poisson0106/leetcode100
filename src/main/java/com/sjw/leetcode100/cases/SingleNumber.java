package com.sjw.leetcode100.cases;

import com.sjw.leetcode100.base.BaseCase;

public class SingleNumber implements BaseCase {
    @Override
    public void run() {

    }

    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }

        return result;
    }
}

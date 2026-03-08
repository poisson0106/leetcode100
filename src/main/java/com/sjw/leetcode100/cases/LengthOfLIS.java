package com.sjw.leetcode100.cases;

import com.sjw.leetcode100.base.BaseCase;

public class LengthOfLIS implements BaseCase {
    @Override
    public void run() {
        System.out.println(lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
    }

    public int lengthOfLIS(int[] nums) {
        //长度为i+1的子序列，可以达到的最小的数字的结尾
        int[] ends = new int[nums.length + 1];
        ends[0] = nums[0];
        int endsLen = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > ends[endsLen - 1]) {
                ends[endsLen] = nums[i];
                endsLen++;
            } else {
                f(ends, endsLen, nums[i]);
            }
        }

        return endsLen;
    }

    private void f(int[] ends, int endLen, int currentVal) {
        int begin = 0;
        int end = endLen - 1;
        while (begin <= end) {
            int mid = (begin + end) / 2;
            if (currentVal < ends[mid] && (mid - 1 < 0 || currentVal > ends[mid - 1])) {
                ends[mid] = currentVal;
                return;
            } else {
                if (currentVal < ends[mid]) {
                    end = mid - 1;
                } else {
                    begin = mid + 1;
                }
            }
        }
    }
}

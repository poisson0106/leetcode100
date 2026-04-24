package com.sjw.leetcode100.cases;

import com.sjw.leetcode100.base.BaseCase;

public class ProductExceptSelf implements BaseCase {
    @Override
    public void run() {
        int[] nums = new int[]{1,2,3,4};
        nums = productExceptSelf(nums);
        for (int n : nums) {
            System.out.print(n + " ");
        }
    }

    public int[] productExceptSelf(int[] nums) {
        //对于a,b,c,d。总前往后算一次前缀积，分别是a,ab,abc,abcd。再从后往前算一次后缀积，就是abcd, bcd, cd, d。所有需要的前后缀都能从两个数组得到，然后组合
        int n = nums.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        prefix[0] = nums[0];
        suffix[n-1] = nums[n-1];
        for (int i = 1; i < n; i++) {
            prefix[i] = nums[i] * prefix[i-1];
        }

        for (int i = n-2; i >= 0; i--) {
            suffix[i] = nums[i] * suffix[i+1];
        }

        for (int i = 0; i < n; i++) {
            if (i - 1 < 0) {
                nums[i] = suffix[i+1];
            } else if (i + 1 == n) {
                nums[i] = prefix[i-1];
            } else {
                nums[i] = prefix[i-1] * suffix[i+1];
            }
        }
        return nums;
    }
}

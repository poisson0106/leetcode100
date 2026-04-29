package com.sjw.leetcode100.cases;

import com.sjw.leetcode100.base.BaseCase;

public class MaxProfit implements BaseCase {
    @Override
    public void run() {
        int[] nums = new int[]{7,1,5,3,6,4};
        System.out.println(maxProfit(nums));
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int curMax = Integer.MIN_VALUE;
        int[] rToLMax = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            if (prices[i] > curMax) {
                curMax = prices[i];
            }
            rToLMax[i] = curMax;
        }

        curMax = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (rToLMax[i] - prices[i] > curMax) {
                curMax = rToLMax[i] - prices[i];
            }
        }

        return curMax;
    }
}

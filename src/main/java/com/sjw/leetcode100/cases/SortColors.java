package com.sjw.leetcode100.cases;

import com.sjw.leetcode100.base.BaseCase;

public class SortColors implements BaseCase {
    @Override
    public void run() {
        int[] nums = new int[]{2,0,2,1,1,0};
        sortColors(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    public void sortColors(int[] nums) {
        //荷兰三色国旗算法
        int leftPos = 0;
        int rightPos = nums.length - 1;
        int cur = 0;
        int tmp = -1;
        while (cur < nums.length) {
            if (nums[cur] == 0) {
                if (cur > leftPos) {
                    while (nums[leftPos] == 0 && leftPos < cur) {
                        leftPos++;
                    }
                    tmp = nums[leftPos];
                    nums[leftPos] = 0;
                    nums[cur] = tmp;
                } else {
                    cur++;
                }
            } else if (nums[cur] == 2) {
                if (cur < rightPos) {
                    while (nums[rightPos] == 2 && rightPos > cur) {
                        rightPos--;
                    }
                    tmp = nums[rightPos];
                    nums[rightPos] = 2;
                    nums[cur] = tmp;
                } else {
                    cur++;
                }
            } else {
                cur++;
            }
        }
    }
}

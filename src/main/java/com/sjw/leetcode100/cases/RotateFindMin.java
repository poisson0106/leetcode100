package com.sjw.leetcode100.cases;

import com.sjw.leetcode100.base.BaseCase;

public class RotateFindMin implements BaseCase {
    @Override
    public void run() {
        findMin(new int[]{3,1,2});
    }

    public int findMin(int[] nums) {
        int begin = 0, end = nums.length - 1;
        int mid;
        if (nums[begin] <= nums[end]) {
            //长度只有1或者最小值在头
            return nums[begin];
        }

        while (begin <= end) {
            mid = (begin + end) / 2;
            if (mid - 1 >= 0 && mid + 1 < nums.length) {
                if (nums[mid-1] < nums[mid] && nums[mid+1] < nums[mid]) {
                    return nums[mid+1];
                }

                if (nums[mid - 1] > nums[mid] && nums[mid + 1] > nums[mid]) {
                    return nums[mid];
                }
            } else {
                if (mid + 1 == nums.length) {
                    //当最后一个数是最小值时
                    if (nums[mid-1] > nums[mid] && nums[0] > nums[mid]) {
                        return nums[mid];
                    }
                }
            }

            if (nums[begin] <= nums[mid]) {
                begin = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }
}

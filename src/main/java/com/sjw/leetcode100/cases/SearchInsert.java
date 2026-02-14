package com.sjw.leetcode100.cases;

import com.sjw.leetcode100.base.BaseCase;

public class SearchInsert implements BaseCase {
    @Override
    public void run() {
        System.out.println(searchInsert(new int[]{3,5,7,9,10,11,12},8));
    }

    public int searchInsert(int[] nums, int target) {
        if (target < nums[0])
            return -1;

        if (target > nums[nums.length - 1])
            return nums.length;
        return f(nums, 0,nums.length - 1, target);
    }

    public int f(int[] nums, int begin, int end, int target) {
        if (begin == end) {
            if (target == nums[begin]) {
                return begin;
            } else {
                if (target > nums[begin]) {
                    return begin + 1;
                } else {
                    return begin;
                }
            }
        }

        if (begin > end) {
            return end + 1;
        }


        int mid = (begin + end) / 2;
        if (nums[mid] == target) {
            return mid;
        } else {
            if (target > nums[mid]) {
                return f(nums, mid+1, end, target);
            } else {
                return f(nums, begin, mid-1, target);
            }
        }
    }
}

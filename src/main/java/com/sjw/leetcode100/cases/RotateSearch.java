package com.sjw.leetcode100.cases;

import com.sjw.leetcode100.base.BaseCase;

public class RotateSearch implements BaseCase {
    @Override
    public void run() {
        int[] nums = new int[]{3, 1};
        System.out.println(search(nums, 1));
    }

    public int search(int[] nums, int target) {
        return f(nums, target, 0, nums.length - 1);
    }

    private int f(int[] nums, int target, int begin, int end) {
        if (begin > end){
            return -1;
        }

        int mid = (begin + end) / 2;

        if (nums[begin] < nums[mid]) {
            //前半单调
            if (nums[begin] <= target & nums[mid] >= target) {
                return check(nums, target, begin, mid);
            } else {
                return f(nums, target, mid + 1, end);
            }
        } else if(nums[begin] > nums[mid]) {
            if (nums[mid] <= target & nums[end] >= target) {
                return check(nums, target, mid, end);
            } else  {
                return f(nums, target, begin, mid - 1);
            }
        } else {
            if (begin == end) {
                return nums[begin] == target ? begin : -1;
            } else if (begin + 1 == end) {
                if (target == nums[begin]) {
                    return begin;
                } else if (target == nums[end]) {
                    return end;
                } else {
                    return -1;
                }
            } else {
                // this part can't be reached. For complie issue
                return -1;
            }
        }
    }

    private int check(int[] nums, int target, int begin, int end) {
        int mid;
        while (begin <= end) {
            mid = (begin + end) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                begin = mid + 1;
            } else if (nums[mid] > target) {
                end = mid - 1;
            }
        }

        return -1;
    }
}

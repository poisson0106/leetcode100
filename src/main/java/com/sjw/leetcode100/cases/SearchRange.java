package com.sjw.leetcode100.cases;

import com.sjw.leetcode100.base.BaseCase;

public class SearchRange implements BaseCase {
    @Override
    public void run() {
        int[] arr = new int[]{2,2};
        int target = 2;
        int[] r = searchRange(arr,target);
        System.out.println(r[0]+","+r[1]);
    }

    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;

        if (n == 0) {
            return new int[]{-1,-1};
        }

        if (nums[0] == nums[n - 1] && nums[0] != target) {
            return new int[]{-1,-1};
        }

        if (n == 1) {
            if (nums[0] == target) {
                return new int[]{0,0};
            } else {
                return new int[]{-1,-1};
            }
        }

        int findPos = -1;
        int left = 0;
        int right = n - 1;

        if (nums[0] == target) {
            findPos = 0;
        }

        if (nums[n - 1] == target) {
            findPos = n - 1;
        }

        int i = 0;
        int j = n - 1;
        int mid;

        if (findPos == -1) {
            while (i <= j) {
                mid =  (i + j) / 2;
                if (nums[mid] == target) {
                    findPos = mid;
                    break;
                } else if (nums[mid] < target) {
                    i = mid + 1;
                } else {
                    j = mid - 1;
                }
            }

            if (findPos == -1) {
                return new int[]{-1,-1};
            }
        }

        i = 0;
        j = findPos;
        while (i <= j) {
            mid = (i + j) / 2;
            if (nums[mid] < target) {
                if (nums[mid+1] == target) {
                    left = mid+1;
                    break;
                } else {
                    i = mid + 1;
                }
            } else {
                j = mid - 1;
            }
        }


        i = findPos;
        j = n - 1;
        while (i <= j) {
            mid = (i + j) / 2;
            if (nums[mid] > target) {
                if (nums[mid-1] == target) {
                    right = mid - 1;
                    break;
                } else {
                    j = mid - 1;
                }
            } else {
                i = mid + 1;
            }
        }

        return new int[]{left, right};
    }
}

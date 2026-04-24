package com.sjw.leetcode100.cases;

import com.sjw.leetcode100.base.BaseCase;

public class NextPermutation implements BaseCase {
    @Override
    public void run() {
        nextPermutation(new int[]{5,4,7,5,3,2});
    }

    public void nextPermutation(int[] nums) {
        int n = nums.length;
        boolean find = false;
        int tmp;
        for (int i = n - 1; i > 0; i--) {
            if (nums[i-1] < nums[i]) {
                find = true;
                tmp = nums[i-1];
                //找出比i-1位置大一点点的数字
                for (int j = n - 1; j >= i; j--) {
                    if (j == i) {
                        //i-1右侧的数字是唯一比他大的，必须交换
                        nums[i - 1] = nums[j];
                        nums[j] = tmp;
                    } else if (nums[n-1] > tmp){
                        //右侧最小值都比你大，则不需要再遍历，直接交换
                        nums[i - 1] = nums[j];
                        nums[j] = tmp;
                        break;
                    } else {
                        //在中间某个位置，需要遍历
                        if (nums[j] > tmp && nums[j + 1] <= tmp) {
                            nums[i - 1] = nums[j];
                            nums[j] = tmp;
                            break;
                        }
                    }
                }

                //把剩余部分颠倒
                int left = i;
                int right = n - 1;
                while (left < right) {
                    tmp = nums[left];
                    nums[left] = nums[right];
                    nums[right] = tmp;
                    left++;
                    right--;
                }
                break;
            }
        }

        if (!find) {
            //需要整个颠倒
            int left = 0;
            int right = n - 1;
            while (left < right) {
                tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
                left++;
                right--;
            }
        }
    }
}

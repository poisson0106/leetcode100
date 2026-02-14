package com.sjw.leetcode100.cases;

import com.sjw.leetcode100.base.BaseCase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayPermute implements BaseCase {

    private List<List<Integer>> result = new ArrayList<>();

    @Override
    public void run() {
        int[] nums = new int[]{1,2,3};
        permute(nums);
    }

    public List<List<Integer>> permute(int[] nums) {
        f(nums, 0, 0);
        return result;
    }

    public void f(int[] nums, int i, int j) {
        if (i == nums.length) {
            List<Integer> a = Arrays.stream(nums).boxed().toList();
            result.add(a);
        }

        for (j = i; j < nums.length; j++) {
            swap(nums, i, j);
            f(nums, i + 1, j);
            swap(nums, i, j);
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

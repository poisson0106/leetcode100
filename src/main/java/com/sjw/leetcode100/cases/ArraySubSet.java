package com.sjw.leetcode100.cases;

import com.sjw.leetcode100.base.BaseCase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArraySubSet implements BaseCase {
    private List<List<Integer>> result = new ArrayList<>();

    @Override
    public void run() {
        int[] nums = new int[]{1,2,3};
        subsets(nums);
    }

    public List<List<Integer>> subsets(int[] nums) {
        //dp，i位置要或不要
        f(0, nums, new ArrayList<>());
        return result;
    }


    public void f(int i, int[] nums, ArrayList<Integer> cur) {
        if (i == nums.length) {
            result.add(new ArrayList<>(cur));
            return;
        }

        //不要当前数
        f(i+1, nums, cur);

        cur.addLast(nums[i]);
        //要当前数
        f(i+1, nums, cur);
        cur.removeLast();
    }
}

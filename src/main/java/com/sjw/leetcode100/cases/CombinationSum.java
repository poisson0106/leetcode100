package com.sjw.leetcode100.cases;

import com.sjw.leetcode100.base.BaseCase;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum implements BaseCase {

    private List<List<Integer>> result;

    @Override
    public void run() {

    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        f(candidates, target, 0, 0, new ArrayList<>());
        return result;
    }

    private void f(int[] candidates, int target, int cur, int beginPos, List<Integer> curList) {
        if (cur > target) {
            return;
        }

        if (cur == target) {
            result.add(new ArrayList<>(curList));
            return;
        }

        for (int i = beginPos; i < candidates.length; i++) {
            curList.addLast(candidates[i]);
            f(candidates, target, cur + candidates[i], i, curList);
            curList.removeLast();
        }
    }
}

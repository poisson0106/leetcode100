package com.sjw.leetcode100.cases;

import com.sjw.leetcode100.base.BaseCase;

import java.util.ArrayList;
import java.util.List;

public class YHTriangle implements BaseCase {
    @Override
    public void run() {

    }

    public List<List<Integer>> generate(int numRows) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(1);
        List<List<Integer>> res = new ArrayList<>();
        if (numRows == 1) {
            res.add(list);
            return res;
        } else if (numRows == 2) {
            res.add(list);
            res.add(list2);
            return res;
        }
        res.add(list);
        res.add(list2);
        for (int i = 2; i < numRows; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    temp.add(1);
                } else {
                    temp.add(res.get(i - 1).get(j) + res.get(i - 1).get(j - 1));
                }
            }
            res.add(temp);
        }
        return res;
    }
}

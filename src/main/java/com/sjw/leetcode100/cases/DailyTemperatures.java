package com.sjw.leetcode100.cases;

import com.sjw.leetcode100.base.BaseCase;

import java.util.HashMap;
import java.util.Map;

public class DailyTemperatures implements BaseCase {
    @Override
    public void run() {
        dailyTemperatures(new int[]{73,74,75,71,69,72,76,73});
    }

    private class Rel {
        int idx;
        int val;
        public Rel(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }

    }

    public int[] dailyTemperatures(int[] temperatures) {
        if (temperatures.length == 1) {
            return new int[]{0};
        }

        //单调栈
        Rel[] stack = new Rel[temperatures.length];
        int top = 1;

        stack[0] = new Rel(0, temperatures[0]);

        int[] result = new int[temperatures.length];
        for(int i = 1; i < temperatures.length; i++){
            while (top - 1 >= 0 && stack[top-1].val < temperatures[i]) {
                result[stack[top-1].idx] = i - stack[top-1].idx;
                top--;
            }

            stack[top] = new Rel(i, temperatures[i]);
            top++;
        }

        for (int i = 0; i < top; i++) {
            result[stack[i].idx] = 0;
        }

        return result;
    }
}

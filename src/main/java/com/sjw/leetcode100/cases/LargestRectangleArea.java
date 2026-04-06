package com.sjw.leetcode100.cases;

import com.sjw.leetcode100.base.BaseCase;

public class LargestRectangleArea implements BaseCase {
    @Override
    public void run() {
        int[] heights = new int[]{4,2,0,3,2,5};
        System.out.println(largestRectangleArea(heights));
    }

    public int largestRectangleArea(int[] heights) {
        //记录严格大压小的元素下标位置
        int[] stack = new int[heights.length];
        stack[0] = 0;
        int top = 1;
        int maxVal = heights[0];
        int left;
        for (int i = 1; i < heights.length; i++) {
            if (heights[i] < heights[stack[top-1]]) {
                while (top > 0 && heights[stack[top-1]] >= heights[i]) {
                    if (top - 1 == 0) {
                        left = -1;
                    } else {
                        left = stack[top-2];
                    }

                    maxVal = Math.max(maxVal, heights[stack[top-1]] * (i - left -1));
                    top--;
                }
                stack[top] = i;
                top++;
            } else {
                stack[top] = i;
                top++;
            }
        }

        if (top > 0) {
            while (top > 0) {
                if (top - 1 == 0) {
                    left = -1;
                } else {
                    left = stack[top-2];
                }
                maxVal = Math.max(maxVal, heights[stack[top-1]] * (heights.length - left - 1));
                top--;
            }
        }
        return maxVal;
    }
}

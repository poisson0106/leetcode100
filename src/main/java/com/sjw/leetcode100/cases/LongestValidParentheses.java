package com.sjw.leetcode100.cases;

import com.sjw.leetcode100.base.BaseCase;

public class LongestValidParentheses implements BaseCase {
    @Override
    public void run() {
        System.out.println(longestValidParentheses("()(()"));
    }

    public int longestValidParentheses(String s) {
        //以i位置结尾的最长合规括号字串长度
        int[] dp = new int[s.length()];
        int[] stack = new int[s.length()];

        int leftBranketNums = 0;

        if (s ==  null || s.length() == 0) {
            return 0;
        }

        char[] cArr = s.toCharArray();
        int maxLen = 0;
        if (cArr[0] == '(') {
            stack[leftBranketNums] = 0;
            leftBranketNums++;
        } else {
            dp[0] = 0;
        }

        int nearestPos = 0;
        for (int i = 1; i < s.length(); i++) {
            if (cArr[i] == '(') {
                stack[leftBranketNums] = i;
                leftBranketNums++;
            } else {
                //仅在遇到右括号时检查结算
                if (leftBranketNums == 0) {
                    dp[i] = 0;
                } else {
                    nearestPos = stack[leftBranketNums-1];
                    leftBranketNums--;
                    if (i - nearestPos  == 1) {
                        //就在隔壁
                        if (nearestPos - 1 >= 0) {
                            dp[i] = dp[nearestPos-1] + 2;
                        } else {
                            dp[i] = 2;
                        }
                    } else {
                        if (nearestPos - 1 >= 0) {
                            dp[i] = dp[nearestPos-1] + (i - nearestPos + 1);
                        } else {
                            dp[i] = (i - nearestPos + 1);
                        }
                    }
                }

                if (dp[i] > maxLen) {
                    maxLen = dp[i];
                }
            }
        }
        return maxLen;
    }
}

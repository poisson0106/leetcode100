package com.sjw.leetcode100.cases;

import com.sjw.leetcode100.base.BaseCase;

import java.util.ArrayList;
import java.util.List;

public class ParlindromicStringPartition implements BaseCase {

    private List<List<String>> result;

    @Override
    public void run() {
        partition("aab");
    }

    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        //dp: 以i开头j结尾的字符串是否是回文串, 1是,0未访问，-1不是
        int[][] dp = new int[s.length()][s.length()];
        for (int i = s.length()-1; i >= 0; i--) {
            for (int j = s.length() - 1; j >= 0; j--) {
                if (i == j) {
                    dp[i][j] = 1;
                } else {
                    if (i > j) {
                        dp[i][j] = 0;
                    } else {
                        if ((s.charAt(i) == s.charAt(j)) && (j-i == 1 || (dp[i + 1][j - 1] == 1))) {
                            dp[i][j] = 1;
                        } else {
                            dp[i][j] = -1;
                        }
                    }
                }
            }
        }

        f(s, 0, new ArrayList<>(), dp);
        return result;
    }

    public void f(String s, int i, ArrayList<String> r, int[][] dp) {
        if (i == s.length()) {
            result.add((ArrayList<String>)r.clone());
            return;
        }

        for (int j = i; j < s.length(); j++) {
            if (dp[i][j] == 1) {
                r.addLast(s.substring(i, j+1));
                f(s, j+1, r, dp);
                r.removeLast();
            }
        }
    }
}

package com.sjw.leetcode100.cases;

import com.sjw.leetcode100.base.BaseCase;

import java.util.HashMap;
import java.util.Map;

public class MinWindow implements BaseCase {
    @Override
    public void run() {
        System.out.println(minWindow("cabwefgewcwaefgcf", "cae"));
    }

    public String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }

        if (s.isEmpty() || t.isEmpty()) {
            return "";
        }

        if (s.equals(t)) {
            return t;
        }

        int[] alphabetTable =  new int[58];
        int count = t.length();
        for (int i = 0; i < t.length(); i++) {
            alphabetTable[t.charAt(i) - 'A']--;
        }

        int minLen = Integer.MAX_VALUE;
        int minLeft = Integer.MAX_VALUE;
        int left = 0;
        char[] sChars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (count > 0) {
                if (alphabetTable[s.charAt(i) - 'A'] <= -1) {
                    count--;
                    if (count == 0) {
                        while (alphabetTable[s.charAt(left) - 'A'] -1 >= 0) {
                            alphabetTable[s.charAt(left) - 'A']--;
                            left++;
                        }
                        if (i - left + 1 < minLen) {
                            minLen = i - left + 1;
                            minLeft = left;
                        }
                    }
                }
                alphabetTable[s.charAt(i) - 'A']++;
            } else {
                //count == 0 且当前的i要进入，先进再弹出左侧。因为可能进来的正好替代了左侧同样的字符
                alphabetTable[s.charAt(i) - 'A']++;
                while (alphabetTable[s.charAt(left) - 'A'] -1 >= 0) {
                    alphabetTable[s.charAt(left) - 'A']--;
                    left++;
                }

                if (i - left + 1 < minLen) {
                    minLen = i - left + 1;
                    minLeft = left;
                }
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLen);
    }

    
}

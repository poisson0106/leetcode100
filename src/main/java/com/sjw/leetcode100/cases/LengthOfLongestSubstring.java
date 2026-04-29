package com.sjw.leetcode100.cases;

import com.sjw.leetcode100.base.BaseCase;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring implements BaseCase {
    @Override
    public void run() {
        System.out.println(lengthOfLongestSubstring("aabaab!bb"));
    }

    public int lengthOfLongestSubstring(String s) {
        int start = 0;
        int end = 0;

        if (s.length() <= 1) {
            return s.length();
        }

        Map<Character, Integer> alphabet = new HashMap<>();
        int maxLen = 0;
        while (end < s.length()) {
            if (alphabet.containsKey(s.charAt(end)) && alphabet.get(s.charAt(end)) != 0) {
                while (s.charAt(start) != s.charAt(end)) {
                    alphabet.put(s.charAt(start), alphabet.get(s.charAt(start))-1);
                    start++;
                }
                start++;
                end++;
            } else {
                if (!alphabet.containsKey(s.charAt(end))) {
                    alphabet.put(s.charAt(end), 1);
                } else {
                    alphabet.put(s.charAt(end), alphabet.get(s.charAt(end)) + 1);
                }

                if (end - start + 1> maxLen) {
                    maxLen = end - start + 1;
                }

                end++;
            }
        }

        return maxLen;
    }
}

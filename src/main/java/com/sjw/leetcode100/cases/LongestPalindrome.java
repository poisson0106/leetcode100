package com.sjw.leetcode100.cases;

import com.sjw.leetcode100.base.BaseCase;

public class LongestPalindrome implements BaseCase {
    @Override
    public void run() {
        System.out.println(longestPalindrome("babad"));
    }

    public String longestPalindrome(String s) {
        //Manacher算法
        //1. to 2n+1 array
        char[] toHandle = toSSArray(s);
        int n = s.length();
        int[] parlindromeR =  new int[2 * n + 1];
        //当前r半径的中心
        int c = 0;
        //回文半径造成的最远达不到位置的下标
        int r = 0;
        int thisLen = 0;
        int maxLen = 0;
        int maxC = 0;
        for (int i = 0; i < toHandle.length; i++) {
            if (i < r) {
                thisLen = Math.min(r - i, parlindromeR[2 * c - i]);
            } else {
                thisLen = 1;
            }

            //尝试再次扩展
            while (i + thisLen< toHandle.length && i - thisLen>= 0) {
                if (toHandle[i + thisLen] == toHandle[i - thisLen]) {
                    thisLen++;
                } else {
                    break;
                }
            }

            if (i + thisLen > r) {
                r = i + thisLen;
                c = i;
            }

            if (thisLen > maxLen) {
                maxLen = thisLen;
                maxC = c;
            }
            parlindromeR[i] = thisLen;
        }

        int endPos = (maxC + maxLen) / 2;
        int len = maxLen - 1;
        return s.substring(endPos - len, endPos);
    }

    private char[] toSSArray(String s) {
        char[] result = new char[s.length() * 2 + 1];
        result[0] = '#';
        int curPos = 1;
        for (int i = 0; i < s.length(); i++) {
            result[curPos++] = s.charAt(i);
            result[curPos++] = '#';
        }

        return result;
    }
}

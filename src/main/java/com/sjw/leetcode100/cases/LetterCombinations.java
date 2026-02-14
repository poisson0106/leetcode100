package com.sjw.leetcode100.cases;

import com.sjw.leetcode100.base.BaseCase;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinations implements BaseCase {
    private String[] rel = new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    private List<String> result;

    @Override
    public void run() {
        String digits = "23";
        List<String> r = letterCombinations(digits);
        for (String s : r) {
            System.out.println(s);
        }
    }

    public List<String> letterCombinations(String digits) {
        result = new ArrayList<>();
        if (digits == null || digits.isEmpty()) {
            return result;
        }

        f(0, digits, "");
        return result;
    }

    public void f(int i, String nums, String cur) {
        if (i == nums.length()) {
            result.add(cur);
            return;
        }

        int curNum = nums.charAt(i) - '0';
        String relStr = rel[curNum];
        for(char c : relStr.toCharArray()) {
            f(i+1, nums, cur + c);
        }
    }
}

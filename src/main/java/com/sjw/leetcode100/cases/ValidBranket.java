package com.sjw.leetcode100.cases;

import com.sjw.leetcode100.base.BaseCase;

import java.util.Stack;

public class ValidBranket implements BaseCase {
    @Override
    public void run() {

    }

    public boolean isValid(String s) {
        char[] arr = s.toCharArray();

        if (arr.length % 2 != 0)
            return false;

        Stack<Character> stack = new Stack<>();
        for (char c : arr) {
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty())
                    return false;
                char latest = stack.pop();
                if (c == '}' && latest == '{') {
                    continue;
                } else if (c == ']' && latest == '[') {
                    continue;
                } else if (c == ')' && latest == '(') {
                    continue;
                } else {
                    return false;
                }
            }
        }

        if (stack.isEmpty())
            return true;
        else
            return false;
    }
}

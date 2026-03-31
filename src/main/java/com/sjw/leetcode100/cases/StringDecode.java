package com.sjw.leetcode100.cases;

import com.sjw.leetcode100.base.BaseCase;

import java.util.Calendar;
import java.util.Stack;

public class StringDecode implements BaseCase {

    @Override
    public void run() {
        System.out.println(decodeString("2[2[y]pq1[f]]ef"));
        System.out.println(decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef"));
    }

    /*private Stack<Integer> numStack = new Stack<>();
    private Stack<Character> strStack = new Stack<>();
    int numCount = 0;
    int curTimes = 0;
    int charTimes = 0;

    String result = "";
    public String decodeString(String s) {
        char[] arr = s.toCharArray();
        for (char c : arr) {
            if (c >= '0' && c <= '9') {
                curTimes = (int) ((c - '0') * Math.pow(10, numCount));
                numCount++;
            } else if (c == '[') {
                numStack.push(curTimes);
                curTimes = 0;
                numCount = 0;
            } else if (c == ']') {
                String thisRes = "";
                while (charTimes > 0) {
                    thisRes = strStack.pop() + thisRes;
                    charTimes--;
                }

                int times = numStack.pop();
                for (int i = 0; i < times; i++) {
                    result += thisRes;
                }
            } else {
                strStack.push(c);
                charTimes++;
            }
        }

        return result;
    }*/


    /*private int idx;
    private Stack<Character> stack = new Stack<>();
    String result;

    public String decodeString(String s) {
        idx = 0;
        while (idx < s.length()) {
            f(s,idx,0);
        }

        return result;
    }

    public void f(String s, int idx, int leftBranketCount) {
        if (idx == s.length()) {
            this.idx = idx;
            return;
        }

        String thisStr = "";

        if (s.charAt(idx) >= '0' && s.charAt(idx) <= '9') {
            stack.push(s.charAt(idx));
            f(s, idx + 1, leftBranketCount);
        }
    } */


    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c != ']') {
                stack.push(c);
            } else {
                //结算
                String word = "";
                while(!stack.isEmpty() && stack.peek() != '[') {
                    word = stack.pop() + word;
                }

                //第一次遇到[，把[舍弃后开始取前面的数字
                stack.pop();
                String times = "";
                while(!stack.isEmpty() && stack.peek() != '[' && (stack.peek() >= '0' && stack.peek() <= '9')) {
                    times =  stack.pop() + times;
                }

                //把生产出来的字符串按数字次数再次压回栈里
                for (int i = 0; i < Integer.parseInt(times); i++) {
                    for (char c1 : word.toCharArray()) {
                        stack.push(c1);
                    }
                }
            }
        }
        String result = "";
        while (!stack.isEmpty()) {
            result = stack.pop() + result;
        }
        return result;
    }

}

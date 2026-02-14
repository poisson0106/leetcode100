package com.sjw.leetcode100.cases;

import com.sjw.leetcode100.base.BaseCase;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis implements BaseCase {

    private List<String> result;

    @Override
    public void run() {
        generateParenthesis(3);
        for (String r : result) {
            System.out.println(r);
        }
    }

    public List<String> generateParenthesis(int n) {
        result = new ArrayList<>();
        f(n, n, "");
        return result;
    }

    private void f(int remainLeftBranketNums, int remainRightBranketNums, String cur) {
        //dp, 要左括号，要右括号

        if (remainLeftBranketNums < 0 || remainRightBranketNums < 0) {
            return;
        }

        if (remainLeftBranketNums == 0 && remainRightBranketNums == 0) {
            result.add(cur);
            return;
        }

        if (remainRightBranketNums > remainLeftBranketNums) {
            //右括号剩下更多的情况，可以使用左括号也可以使用右括号
            f(remainLeftBranketNums-1, remainRightBranketNums,cur+"(");
            f(remainLeftBranketNums, remainRightBranketNums-1,cur+")");
        } else {
            //当左括号剩下更多或者相等时，只能使用左括号，否则会出现不成对的现象。())这样
            f(remainLeftBranketNums-1, remainRightBranketNums,cur+"(");
        }
    }
}

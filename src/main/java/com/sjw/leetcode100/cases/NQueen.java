package com.sjw.leetcode100.cases;

import com.sjw.leetcode100.base.BaseCase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueen implements BaseCase {

    private List<List<String>> res;

    @Override
    public void run() {
        solveNQueens(1);
        for (List<String> list : res) {
            for (String str : list) {
                System.out.print(str+", ");
            }
            System.out.println(" ");
        }
    }

    public List<List<String>> solveNQueens(int n) {
        //j means which column, the value means which line
        int[] placed = new int[n];
        for (int i = 0; i < n; i++) {
            placed[i] = -100;
        }
        res = new ArrayList<>();
        f(placed,0, n, new ArrayList<>());
        return res;
    }

    public void f(int[] placed, int lineNum, int n, ArrayList<String> thisRes) {
        if (lineNum == n) {
            res.add(new ArrayList<>(thisRes));
            return;
        }

        boolean find;

        for (int i = 0; i < n; i++) {
            find = true;

            if (placed[i] != -100) {
                // has placed chase in the above line
                find = false;
            } else {
                //if placed in the pos i, check if there is conflict
                for (int j = 0; j < n; j++) {
                    //check the pos
                    if (Math.abs(j - i) == Math.abs(placed[j] - lineNum)) {
                        find = false;
                        break;
                    }
                }
            }
            if (find) {
                char[] chars = new char[n];
                Arrays.fill(chars, '.');
                chars[i] = 'Q';
                thisRes.addLast(new String(chars));
                placed[i] = lineNum;
                f(placed,lineNum+1,n,thisRes);
                placed[i] = -100;
                thisRes.removeLast();
            }
        }
    }
}

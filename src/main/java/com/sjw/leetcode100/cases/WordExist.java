package com.sjw.leetcode100.cases;

import com.sjw.leetcode100.base.BaseCase;

import java.util.HashSet;
import java.util.Set;

public class WordExist implements BaseCase {

    private static int m;
    private static int n;
    private Set<String> set;

    @Override
    public void run() {
        char[][] board = new char[6][6];
        board[0] = new char[]{'a','a','b','a','a','b'};
        board[1] = new char[]{'a','a','b','b','b','a'};
        board[2] = new char[]{'a','a','a','a','b','a'};
        board[3] = new char[]{'b','a','b','b','a','b'};
        board[4] = new char[]{'a','b','b','a','b','a'};
        board[5] = new char[]{'b','a','a','a','a','b'};
        System.out.println(exist(board,"bbbaabbbbbab"));
    }

    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;


        if (m * n < word.length()) {
            return false;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    set = new HashSet<>();
                    if(f(board, word, 0, i, j, -1, -1)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean f(char[][] board, String word, int wordPos, int curI, int curJ, int lastI, int lastJ) {
        if (wordPos == word.length() -1 && word.charAt(wordPos) == board[curI][curJ]) {
            if (!set.contains(curI+","+curJ))
                return true;
            else
                return false;
        }

        boolean left = false;
        boolean right = false;
        boolean up = false;
        boolean down = false;

        if (lastI == -1 && lastJ == -1) {
            if (word.charAt(wordPos) == board[curI][curJ]) {
                set.add(curI+","+curJ);
                if (curI - 1 >= 0)
                    up = f(board, word, wordPos + 1, curI - 1, curJ, curI, curJ);
                if (curI + 1 < m)
                    down = f(board, word, wordPos + 1, curI + 1, curJ, curI, curJ);
                if (curJ - 1 >= 0)
                    left = f(board, word, wordPos + 1, curI, curJ - 1, curI, curJ);
                if (curJ + 1 < n)
                    right = f(board, word, wordPos + 1, curI, curJ + 1, curI, curJ);
                set.remove(curI+","+curJ);
            }
        } else {
            if (word.charAt(wordPos) == board[curI][curJ] && !set.contains(curI+","+curJ)) {
                set.add(curI+","+curJ);
                if (curI == lastI) {
                    if (curI - 1 >= 0)
                        up = f(board, word, wordPos + 1, curI - 1, curJ, curI, curJ);
                    if (curI + 1 < m)
                        down = f(board, word, wordPos + 1, curI + 1, curJ, curI, curJ);

                    if (curJ - 1 == lastJ) {
                        if (curJ + 1 < n)
                            right = f(board, word, wordPos + 1, curI, curJ + 1, curI, curJ);
                    } else {
                        if (curJ - 1 >= 0)
                            left = f(board, word, wordPos + 1, curI, curJ - 1, curI, curJ);
                    }
                } else {
                    if (curJ - 1 >= 0)
                        left = f(board, word, wordPos + 1, curI, curJ - 1, curI, curJ);

                    if (curJ + 1 < n)
                        right = f(board, word, wordPos + 1, curI, curJ + 1, curI, curJ);

                    if (curI - 1 == lastI) {
                        if (curI + 1 < m)
                            down = f(board, word, wordPos + 1, curI + 1, curJ, curI, curJ);
                    } else {
                        if (curI - 1 >= 0)
                            up = f(board, word, wordPos + 1, curI - 1, curJ, curI, curJ);
                    }
                }
                set.remove(curI+","+curJ);
            } else {
                return false;
            }
        }

        return left || right || up || down;
    }
}

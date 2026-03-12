package com.sjw.leetcode100.cases;

import com.sjw.leetcode100.base.BaseCase;

public class NumIslands implements BaseCase {
    @Override
    public void run() {
        char[][] grid = new char[][]{{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        System.out.println(numIslands(grid));
    }

    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    fill(grid, i, j);
                }
            }
        }

        return count;
    }

    public void fill(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return;
        }

        if (grid[i][j] == '0') {
            return;
        }

        if (grid[i][j] == '1') {
            grid[i][j] = '0';
        }

        fill(grid, i + 1, j);
        fill(grid, i - 1, j);
        fill(grid, i, j + 1);
        fill(grid, i, j - 1);
    }

}

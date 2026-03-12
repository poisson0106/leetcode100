package com.sjw.leetcode100.cases;

import com.sjw.leetcode100.base.BaseCase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OrangesRotting implements BaseCase {
    @Override
    public void run() {
        int[][] grid = new int[][]{{2,1,1},{1,1,0},{0,1,1}};
        System.out.println(orangesRotting(grid));
    }

    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        ArrayList<Integer[]> list = new ArrayList<>();

        int allCount = 0;
        int bfsCount = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    allCount++;
                } else if (grid[i][j] == 2) {
                    list.add(new Integer[]{i, j});
                    bfsCount++;
                    allCount++;
                }
            }
        }

        int round = 0;
        if (bfsCount > 0) {
            while (list.size() > 0) {
                for (int i = 0; i < bfsCount; i++) {
                    Integer[] thisOne = list.getFirst();
                    f(grid, list, thisOne[0], thisOne[1]);
                    list.removeFirst();
                    allCount--;
                }
                bfsCount = list.size();
                if (bfsCount > 0) {
                    round++;
                }
            }
        } else {
            //没有烂的橘子
            if (allCount > 0) {
                //有橘子
                return -1;
            } else {
                return 0;
            }
        }

        if (allCount > 0) {
            return -1;
        } else {
            return round;
        }
    }

    private void f(int[][] grid, List<Integer[]> list, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
            return;
        }

        if (row - 1 >= 0 && grid[row - 1][col] == 1) {
            grid[row - 1][col] = 2;
            list.add(new Integer[]{row - 1, col});
        }

        if (row + 1 < grid.length && grid[row + 1][col] == 1) {
            grid[row + 1][col] = 2;
            list.add(new Integer[]{row + 1, col});
        }

        if (col - 1 >= 0 && grid[row][col - 1] == 1) {
            grid[row][col - 1] = 2;
            list.add(new Integer[]{row, col - 1});
        }

        if (col + 1 < grid[0].length && grid[row][col + 1] == 1) {
            grid[row][col + 1] = 2;
            list.add(new Integer[]{row, col + 1});
        }
    }
}

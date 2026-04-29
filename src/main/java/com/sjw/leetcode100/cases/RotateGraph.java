package com.sjw.leetcode100.cases;

import com.sjw.leetcode100.base.BaseCase;

public class RotateGraph implements BaseCase {
    @Override
    public void run() {

    }

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - 1 - i; j++) {
                int currentI = i;
                int currentJ = j;
                int targetI = currentJ;
                int targetJ = n - 1 - currentI;
                int current = matrix[currentI][currentJ];
                int target = 0;
                while(targetI != i || targetJ != j) {
                    target = matrix[targetI][targetJ];
                    matrix[targetI][targetJ] = current;
                    current = target;
                    currentI = targetI;
                    currentJ = targetJ;
                    targetI = currentJ;
                    targetJ = n - 1 - currentI;
                }
                matrix[i][j] = target;
            }
        }
    }
}

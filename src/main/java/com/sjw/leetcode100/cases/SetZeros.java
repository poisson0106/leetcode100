package com.sjw.leetcode100.cases;

import com.sjw.leetcode100.base.BaseCase;

public class SetZeros implements BaseCase {
    @Override
    public void run() {
        int[][] matrix = new int[3][3];
        matrix[0] = new int[]{0,1,2,0};
        matrix[1] = new int[]{3,4,5,2};
        matrix[2] = new int[]{1,3,1,5};
        setZeroes(matrix);
        System.out.println(matrix[1][0]);
    }

    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        //m, n为1~200的数，如果用2进制来表示的话，1个int可以表示32个数，需要7个数表示行，7个数表示列来记录
        int[] rows = new int[7];
        int[] cols = new int[7];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    rows[i / 32] = rows[i / 32] | (1 << (i % 32));
                    cols[j / 32] = cols[j / 32] | (1 << (j % 32));
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
               if (((rows[i / 32] & (1 << (i % 32))) != 0) || ((cols[j / 32] & (1 << (j % 32))) != 0)) {
                    matrix[i][j] = 0;
               }
            }
        }
    }
}

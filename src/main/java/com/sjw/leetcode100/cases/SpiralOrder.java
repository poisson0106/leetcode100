package com.sjw.leetcode100.cases;

import com.sjw.leetcode100.base.BaseCase;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder implements BaseCase {
    @Override
    public void run() {
        int[][] matrix = new int[3][3];
        matrix[0] = new int[]{1,2,3};
        matrix[1] = new int[]{4,5,6};
        matrix[2] = new int[]{7,8,9};
        List<Integer> l = spiralOrder(matrix);
        System.out.println(l.toString());
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        // 0: right, 1: down, 2: right, 3: up
        int m = matrix.length;
        int n = matrix[0].length;
        int all = m * n;
        int i = 0;
        int leftBoard = -1;
        int rightBoard = n;
        int topBoard = -1;
        int bottomBoard = m;
        int direct = 0;
        int posI = 0;
        int posJ = 0;
        List<Integer> list = new ArrayList<>();
        while (i < all) {
            list.add(matrix[posI][posJ]);
            switch (direct % 4) {
                case 0:
                    if (posJ + 1 < rightBoard)
                        posJ++;
                    else {
                        posI++;
                        topBoard++;
                        direct++;
                    }
                    break;
                case 1:
                    if (posI + 1 < bottomBoard) {
                        posI++;
                    } else {
                        posJ--;
                        rightBoard--;
                        direct++;
                    }
                    break;
                case 2:
                    if (posJ - 1 > leftBoard) {
                        posJ--;
                    } else {
                        posI--;
                        bottomBoard--;
                        direct++;
                    }
                    break;
                case 3:
                    if (posI - 1 > topBoard) {
                        posI--;
                    } else {
                        posJ++;
                        leftBoard++;
                        direct++;
                    }
            }
            i++;
        }
        return list;
    }
}

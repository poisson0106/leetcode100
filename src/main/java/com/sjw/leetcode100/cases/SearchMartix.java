package com.sjw.leetcode100.cases;

import com.sjw.leetcode100.base.BaseCase;

public class SearchMartix implements BaseCase {
    @Override
    public void run() {
        /*int[][] arr = new int[3][4];
        arr[0] = new int[]{1,3,5,7};
        arr[1] = new int[]{10,11,16,20};
        arr[2] = new int[]{23,30,34,60};*/
        int[][] arr = new int[3][1];
        arr[0][0] = 1;
        arr[1][0] = 3;
        arr[2][0] = 5;
        System.out.println(searchMatrix(arr, 5));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;

        if (target < matrix[0][0] || target > matrix[m - 1][n - 1]) {
            return false;
        }

        int i= 0, j = 0;

        int line = -1;
        int end = m - 1;
        int mid = -1;

        while (i <= end) {
            mid = (i + end) / 2;
            if (matrix[mid][0] < target) {
                if (mid + 1 <= end) {
                    if (matrix[mid + 1][0] > target) {
                        line = mid;
                        break;
                    } else {
                        i = mid + 1;
                    }
                } else {
                    line = mid;
                    break;
                }
            } else if (matrix[mid][0] > target) {
                if (mid - 1 >= 0) {
                    if (matrix[mid - 1][0] < target) {
                        line = mid - 1;
                        break;
                    } else {
                        end = mid - 1;
                    }
                } else {
                    line = mid;
                    break;
                }
            } else {
                return true;
            }
        }

        end = n-1;

        while (j <= end) {
            mid = (j + end) / 2;
            if (matrix[line][mid] == target) {
                return true;
            } else if (matrix[line][mid] < target) {
                j = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return false;
    }
}

package com.sjw.leetcode100.cases;

import com.sjw.leetcode100.base.BaseCase;

public class FindMedianSortedArrays implements BaseCase {
    @Override
    public void run() {
        System.out.println(findMedianSortedArrays(new int[]{1,3}, new int[]{2,7}));
    }


    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        //两者有一个为空或者两者都为空的情况
        if (m == 0) {
            if (n % 2 == 0 && n != 0) {
                return ((double) (nums2[n/2] + nums2[n/2 - 1])) / 2;
            } else {
                if (n == 0) {
                    return 0;
                } else {
                    return nums2[n/2];
                }
            }
        }

        if (n == 0) {
            if (m % 2 == 0) {
                return ((double) (nums1[m/2] + nums1[m/2 - 1])) / 2;
            } else {
                return nums1[m/2];
            }
        }

        //一方整个比另一方小的情况
        if (nums1[m - 1] <= nums2[0]) {
            return compare(nums2, nums1, n, m);
        } else if (nums2[n-1] <= nums1[0]) {
            return compare(nums1, nums2, m, n);
        }

        if (m < n) {
            return f(nums1, nums2, m, n);
        } else {
            return f(nums2, nums1, n, m);
        }
    }

    private double compare(int[] bigger, int[] smaller, int biggerLen, int smallerLen) {
        int desireMidPos1;
        int desireMidPos2;

        if ((biggerLen+smallerLen) % 2 == 0) {
            desireMidPos1 = (biggerLen + smallerLen) / 2;
            desireMidPos2 = (biggerLen + smallerLen) / 2 - 1;
            if (biggerLen == smallerLen) {
                return ((double) (smaller[smallerLen - 1] + bigger[0])) / 2;
            } else {
                //必在较长侧
                if (biggerLen > smallerLen) {
                    return ((double) (bigger[desireMidPos1 - smallerLen] + bigger[desireMidPos2 - smallerLen])) / 2;
                } else {
                    return ((double) (smaller[desireMidPos1] + smaller[desireMidPos2])) / 2;
                }
            }
        } else {
            desireMidPos1 = (biggerLen + smallerLen) / 2;
            if (biggerLen > smallerLen) {
                return (double) (bigger[desireMidPos1 - smallerLen]);
            } else {
                return (double) (smaller[desireMidPos1]);
            }
        }
    }

    private double f(int[] nums1, int[] nums2, int m, int n) {
        int halfAmount = (m + n + 1) / 2;
        int begin = 0;
        int end = m ;
        while (begin <= end) {
            int i = (begin + end) / 2;
            int j = halfAmount - i;
            //理想状态 max(num1[i-1], nums2[j-1]) <= min(nums1[i], nums1[j])
            //因为nums1[i-1]<nums1[i]， 所以nums1[i-1]<=nums2[j],就一定符合nums1[i-1]<=min(nums1[i], nums2[j])
            //同理nums2[j-1]<nums2[j], 所以只要nums2[j-1]<=num1[i]也会符合nums2[j-1]<=min(nums1[i], nums2[j])

            int nums1CutterLeft = i - 1 >= 0 ? nums1[i - 1] : Integer.MIN_VALUE;
            int nums1CutterRight = i < m ? nums1[i] : Integer.MAX_VALUE;
            int nums2CutterLeft = j - 1 >= 0 ? nums2[j - 1] : Integer.MIN_VALUE;
            int nums2CutterRight = j < n ? nums2[j] : Integer.MAX_VALUE;
            if (nums1CutterLeft<=nums2CutterRight && nums2CutterLeft<=nums1CutterRight) {
                //找到分割点
                if ((m + n) % 2 == 0) {
                    return ((double) (Math.max(nums1CutterLeft, nums2CutterLeft) + Math.min(nums1CutterRight, nums2CutterRight))) / 2;
                } else {
                    return Math.max(nums1CutterLeft,nums2CutterLeft);
                }
            } else if (nums1CutterLeft > nums2CutterRight) {
                end = i - 1;
            } else {
                begin = i + 1;
            }
        }

        return -1;
    }

}

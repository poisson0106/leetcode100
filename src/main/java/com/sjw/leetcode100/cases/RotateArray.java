package com.sjw.leetcode100.cases;

import com.sjw.leetcode100.base.BaseCase;

public class RotateArray implements BaseCase {
    @Override
    public void run() {
        int[] nums = new int[]{1,2,3,4,5,6};
        rotate2(nums,4);

        for (int i : nums) System.out.println(i);
    }

    public void rotate2(int[] nums, int k) {
        int[] newNums = new int[nums.length];
        int numsLen = nums.length;
        if (k > numsLen)
            k = k % numsLen;

        for (int i = 0; i < numsLen; i++) {
            if (i + k < numsLen) {
                newNums[i+k] = nums[i];
            } else {
                newNums[i+k-numsLen] = nums[i];
            }
        }

        System.arraycopy(newNums, 0, nums, 0, numsLen);
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        if (n == 0) return;
        k = k % n;
        if (k == 0) return;

        int cycleCount = gcd(n, k);
        int startPos = 0;
        int movedCount = 0;

        while (movedCount < n) {
            int pos = startPos;
            int lastNum = nums[pos];
            while (true) {
                int next = (pos - k + n) % n;
                nums[pos] = nums[next];
                movedCount++;
                if (next == startPos) {
                    nums[pos] = lastNum;
                    movedCount++;
                    break;
                }
                pos = next;
            }
            startPos++;
            while (startPos < n && movedCount >= 2 && (startPos % (n / cycleCount) == 0 || startPos < cycleCount)) {
                if (startPos % (n / cycleCount) == 0) startPos++;
                else break;
            }
            if (movedCount >= n) break;
        }
    }
}

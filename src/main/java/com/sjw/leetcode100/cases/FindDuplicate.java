package com.sjw.leetcode100.cases;

import com.sjw.leetcode100.base.BaseCase;

public class FindDuplicate implements BaseCase {
    @Override
    public void run() {
        int n = findDuplicate(new int[]{1,3,4,2,2});
        System.out.println(n);
    }

    public int findDuplicate(int[] nums) {
        //把nums看成一个从下标i指向下标nums[i]的链表，题目转化为链上是否存在环，所以是快慢指针找环入口的题
        int slow = nums[0];
        int fast = nums[nums[0]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        //fast回到0点，然后每次前进一格，再次相遇就是所求值
        fast = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
}

package com.sjw.leetcode100.cases;

import com.sjw.leetcode100.base.BaseCase;
import com.sjw.leetcode100.base.ListNode;

import java.util.List;

public class PalindromeList implements BaseCase {
    @Override
    public void run() {
        int[] arr = new int[]{1,0,0};
        ListNode head = new ListNode(arr[0]);
        ListNode cur = head;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
        System.out.println(isPalindrome(head));
    }

    public boolean isPalindrome(ListNode head) {
        int len = 0;
        ListNode cur = head;
        while (cur != null) {
            len++;
            cur = cur.next;
        }

        if (len == 1) {
            return true;
        } else if (len == 2) {
            return head.val == head.next.val;
        } else if (len == 3) {
            return head.val == head.next.next.val;
        }

        int mid = len % 2 == 0 ? len / 2 : len / 2 + 1;
        ListNode halfBegin = null;
        ListNode formerBegin = null;
        ListNode former = head;
        ListNode tmp = null;
        cur = head.next;
        for(int i = 1; i < len / 2; i++) {
            if (i+1 == len / 2) {
                formerBegin = cur;
                if (i + 1 == mid) {
                    halfBegin = cur.next;
                } else {
                    halfBegin = cur.next.next;
                }
            }
            tmp = cur.next;
            cur.next = former;
            former = cur;
            cur = tmp;
        }
        head.next = null;

        ListNode cur1 = halfBegin;
        ListNode cur2 = formerBegin;
        while (cur1 != null && cur2 != null) {
            if (cur1.val != cur2.val) {
                return false;
            }
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return true;
    }
}

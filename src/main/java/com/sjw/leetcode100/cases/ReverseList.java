package com.sjw.leetcode100.cases;

import com.sjw.leetcode100.base.BaseCase;
import com.sjw.leetcode100.base.ListNode;

public class ReverseList implements BaseCase {
    @Override
    public void run() {

    }


    private ListNode newHead;

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        f(head);
        return newHead;
    }

    public ListNode f(ListNode cur) {
        if (cur.next == null) {
            newHead = cur;
            return cur;
        }

        ListNode newFormer = f(cur.next);
        newFormer.next = cur;

        cur.next = null;

        return cur;
    }
}

package com.sjw.leetcode100.cases;

import com.sjw.leetcode100.base.BaseCase;
import com.sjw.leetcode100.base.ListNode;

public class MergeKLists implements BaseCase {
    @Override
    public void run() {

    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        ListNode newHead = null;
        ListNode head1 = null;
        ListNode head2 = null;
        newHead = lists[0];
        for (int i = 1; i < lists.length; i++) {
            newHead = sort(newHead, lists[i]);
        }
        return newHead;
    }

    private ListNode sort(ListNode head1, ListNode head2) {
        ListNode cur1 = head1;
        ListNode cur2 = head2;
        ListNode newHead = null;
        ListNode tmp = null;
        ListNode curNew = newHead;
        while (cur1!=null && cur2!=null) {
            if (cur1.val <= cur2.val) {
                if (newHead == null) {
                    newHead = cur1;
                    curNew = cur1;
                    cur1 = cur1.next;
                    newHead.next = null;
                } else {
                    tmp = cur1.next;
                    curNew.next = cur1;
                    curNew = cur1;
                    curNew.next = null;
                    cur1 = tmp;
                }
            } else {
                if (newHead == null) {
                    newHead = cur2;
                    curNew = cur2;
                    cur2 = cur2.next;
                    newHead.next = null;
                } else {
                    tmp = cur2.next;
                    curNew.next = cur2;
                    curNew = cur2;
                    curNew.next = null;
                    cur2 = tmp;
                }
            }
        }

        if (cur1 == null && cur2!=null) {
            if (curNew != null)
                curNew.next = cur2;
            else {
                newHead = cur2;
            }

        } else if (cur2 == null && cur1!=null) {
            if (curNew != null) {
                curNew.next = cur1;
            } else {
                newHead = cur1;
            }
        }

        return newHead;
    }
}

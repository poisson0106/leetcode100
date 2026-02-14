package com.sjw.leetcode100.cases;

import com.sjw.leetcode100.base.BaseCase;
import com.sjw.leetcode100.base.ListNode;

public class ReverseKGroup implements BaseCase {

    ListNode curHead = null;
    ListNode afterHead = null;
    ListNode newHead = null;
    boolean reachButtom = false;

    @Override
    public void run() {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        ListNode head = new ListNode(arr[0]);
        ListNode cur = head;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
        head = reverseKGroup(head, 2);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode cur = head;
        curHead = null;
        afterHead = null;
        newHead = null;
        reachButtom = false;
        ListNode formerTail = null;

        while (cur != null) {
            cur = f(cur, k-1);
            // cur.next = curHead;
            if (formerTail != null) {
                if (reachButtom) {
                    formerTail.next = cur;
                    break;
                } else {
                    formerTail.next = afterHead;
                }
            }
            formerTail = cur;
            cur = curHead;
        }

        return newHead;
    }

    public ListNode f(ListNode cur, int k) {
        if (cur == null) {
            //in the last, can not reach k element
            reachButtom = true;
            return cur;
        }

        if (k == 0) {
            if (newHead == null) {
                newHead = cur;
            }
            curHead = cur.next;
            afterHead = cur;
            return cur;
        }

        ListNode latter = f(cur.next, k - 1);
        if (!reachButtom) {
            if (latter != null)
                latter.next = cur;
            cur.next = null;
        }
        return cur;
    }
}

package com.sjw.leetcode100.cases;

import com.sjw.leetcode100.base.BaseCase;
import com.sjw.leetcode100.base.ListNode;

import java.util.List;

public class RemoveNthFromEnd implements BaseCase {
    @Override
    public void run() {
        int[] arr = new int[]{1,2,3,4,5};
        ListNode head = new ListNode(arr[0]);
        ListNode cur = head;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
        removeNthFromEnd(head,2);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null) {
            if (n == 1)
                return null;
        }

        ListNode[] arr = new ListNode[31];
        int m = 0;
        ListNode cur = head;
        while (cur != null) {
            if (n == 1 && cur.next.next == null) {
                cur.next = null;
                return head;
            }
            arr[m] = cur;
            cur = cur.next;
            m++;
        }

        int target = m - n;
        if (target == 0) {
            return head.next;
        } else {
            arr[target - 1].next = arr[target + 1];
            return head;
        }
    }
}

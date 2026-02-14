package com.sjw.leetcode100.cases;

import com.sjw.leetcode100.base.BaseCase;
import com.sjw.leetcode100.base.ListNode;

public class HasCycle implements BaseCase {
    @Override
    public void run() {
        //passed in leetcode
    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && slow != null) {
            if (fast.next == null || fast.next.next == null) {
                return false;
            } else if (slow.next == null) {
                return  false;
            } else {
                fast = fast.next.next;
                slow = slow.next;
            }
            if (fast == slow) {
                return true;
            }
        }

        return false;
    }
}

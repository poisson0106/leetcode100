package com.sjw.leetcode100.cases;

import com.sjw.leetcode100.base.BaseCase;
import com.sjw.leetcode100.base.ListNode;

public class DetectCycle implements BaseCase {
    @Override
    public void run() {
        //leetcode done
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && slow != null) {
            if (fast.next == null || fast.next.next == null) {
                return null;
            } else if (slow.next == null) {
                return null;
            } else {
                fast = fast.next.next;
                slow = slow.next;
            }
            if (fast == slow) {
                break;
            }
        }

        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}

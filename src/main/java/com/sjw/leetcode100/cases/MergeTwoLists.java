package com.sjw.leetcode100.cases;

import com.sjw.leetcode100.base.BaseCase;
import com.sjw.leetcode100.base.ListNode;

public class MergeTwoLists implements BaseCase {
    @Override
    public void run() {
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(1);
        mergeTwoLists(l1, l2);
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        ListNode head;
        if (list1.val <= list2.val) {
            if (list1.next == null) {
                head = list1;
                list1.next = list2;
                return head;
            } else {
                head = list1;
                list1 = list1.next;
            }
        } else {
            if (list2.next == null) {
                head = list2;
                list2.next = list1;
                return head;
            } else {
                head = list2;
                list2 = list2.next;
            }
        }
        int shorterOne = 0; //0 means list1, 1 means list 2
        ListNode cur = head;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                cur.next = list1;
                cur = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                cur = list2;
                list2 = list2.next;
            }

            if (list1 == null) {
                shorterOne = 0;
            } else {
                shorterOne = 1;
            }
        }

        if (shorterOne == 0) {
            cur.next = list2;
        } else {
            cur.next = list1;
        }

        return head;
    }
}

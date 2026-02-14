package com.sjw.leetcode100.cases;

import com.sjw.leetcode100.base.BaseCase;
import com.sjw.leetcode100.base.ListNode;

public class AddTwoNumbers implements BaseCase {
    @Override
    public void run() {
        //valid in leetcode
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int cumulateNum = 0;
        ListNode head = null;
        int shorterOne = 0;
        int tmp = 0;
        int bitNum = 0;
        ListNode cur = head;

        if (l1 == null && l2 == null) {
            return null;
        }

        if (l1 == null && l2 != null) {
            return l2;
        }

        if (l2 == null && l1 != null) {
            return l1;
        }

        while (l1 != null && l2 != null) {
            tmp = l1.val + l2.val + cumulateNum;
            if (tmp > 9) {
                cumulateNum = 1;
                bitNum = tmp % 10;
            } else {
                cumulateNum = 0;
                bitNum = tmp;
            }

            if (head == null) {
                head = new ListNode(bitNum);
                cur = head;
            } else {
                cur.next = new ListNode(bitNum);
                cur = cur.next;
            }

            l1 = l1.next;
            l2 = l2.next;
            if (l1 == null) {
                shorterOne = 0;
            } else {
                shorterOne = 1;
            }
        }

        if (shorterOne == 0) {
            if (cumulateNum == 0) {
                while (l2 != null) {
                    cur.next = l2;
                    cur = cur.next;
                    l2 = l2.next;
                }
            } else {
                int tmp2 = 0;
                while (l2 != null) {
                    tmp2 = l2.val + cumulateNum;
                    if (tmp2 > 9) {
                        cumulateNum = 1;
                        l2.val = tmp2 % 10;
                    } else {
                        cumulateNum = 0;
                        l2.val = tmp2;
                    }

                    cur.next = l2;
                    cur = cur.next;
                    l2 = l2.next;
                }
                if (cumulateNum > 0) {
                    cur.next = new ListNode(cumulateNum);
                }
            }
        } else {
            if (cumulateNum == 0) {
                while (l1 != null) {
                    cur.next = l1;
                    cur = cur.next;
                    l1 = l1.next;
                }
            } else {
                int tmp2 = 0;
                while (l1 != null) {
                    tmp2 = l1.val + cumulateNum;
                    if (tmp2 > 9) {
                        cumulateNum = 1;
                        l1.val = tmp2 % 10;
                    } else {
                        cumulateNum = 0;
                        l1.val = tmp2;
                    }

                    cur.next = l1;
                    cur = cur.next;
                    l1 = l1.next;
                }

                if (cumulateNum > 0) {
                    cur.next = new ListNode(cumulateNum);
                }
            }
        }

        return head;
    }
}

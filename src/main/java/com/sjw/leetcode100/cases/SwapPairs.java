package com.sjw.leetcode100.cases;

import com.sjw.leetcode100.base.BaseCase;
import com.sjw.leetcode100.base.ListNode;

public class SwapPairs implements BaseCase {
    @Override
    public void run() {

    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode nextHead;
        ListNode nextEle;
        ListNode beforeEle = null;
        ListNode cur = head;

        while (cur != null) {
            if (cur.next == null) {
                //最后一个
                break;
            } else {
                nextHead = cur.next.next;
                nextEle = cur.next;
                if (beforeEle == null) {
                    head = nextEle;
                    nextEle.next = cur;
                    cur.next = nextHead;
                    beforeEle = cur;
                    cur = nextHead;
                } else {
                    beforeEle.next = nextEle;
                    nextEle.next = cur;
                    cur.next = nextHead;
                    beforeEle = cur;
                    cur = nextHead;
                }
            }
        }

        return head;
    }
}

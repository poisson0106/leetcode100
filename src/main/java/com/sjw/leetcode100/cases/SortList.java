package com.sjw.leetcode100.cases;

import com.sjw.leetcode100.base.BaseCase;
import com.sjw.leetcode100.base.ListNode;

public class SortList implements BaseCase {
    @Override
    public void run() {
        int[] arr = new int[]{-1,5,3,4,0};
        ListNode head = new ListNode(arr[0]);
        ListNode cur = head;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
        head = sortList(head);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public ListNode sortList(ListNode head) {
        int len = 0;
        ListNode cur = head;
        while (cur != null) {
            len++;
            cur = cur.next;
        }

        if (len <= 2) {
            if (len <= 1) {
                return head;
            } else {
                if (head.next.val < head.val) {
                    ListNode tmp = head.next;
                    tmp.next = head;
                    head.next = null;
                    head = tmp;
                    return head;
                } else {
                    return head;
                }
            }
        } else {
            // merge sort
            int scopeLen = 1;
            cur = head;
            ListNode newHead = null;
            ListNode head1 = null;
            ListNode head2 = null;
            ListNode formerTail = null;
            ListNode newFormerTail1 = null;
            ListNode newFormerTail2 = null;
            ListNode tmp = null;
            boolean reachEnd = false;
            while (scopeLen <= len) {
                newHead = null;
                formerTail = null;
                while(cur != null) {
                    newFormerTail1 = null;
                    newFormerTail2 = null;
                    head1 = cur;
                    for (int i = 0; i < scopeLen && cur != null; i++) {
                        if (i+1 == scopeLen || cur.next == null) {
                            newFormerTail1 = cur;
                        }
                        if (i + 1 == scopeLen) {
                            tmp = cur.next;
                            cur.next = null;
                            cur = tmp;
                        } else {
                            cur = cur.next;
                        }
                    }

                    /*if (reachEnd) {
                        // only remain one group, and this group is in order. So skip it to the next loop
                        reachEnd = false;
                        break;
                    }*/

                    head2 = cur;
                    for (int i = 0; i < scopeLen && cur != null; i++) {
                        if (i+1 == scopeLen || cur.next == null) {
                            newFormerTail2 = cur;
                            if (i+1 == scopeLen) {
                                tmp = cur.next;
                                cur.next = null;
                                cur = tmp;
                            } else {
                                cur = cur.next;
                            }
                        } else {
                            cur = cur.next;
                        }
                    }

                    if (newHead == null) {
                        newHead = sort(head1, head2);
                    } else {
                        formerTail.next = sort(head1, head2);
                    }

                    if (newFormerTail2 == null) {
                        formerTail = newFormerTail1;
                    } else {
                        formerTail = newFormerTail1.val <= newFormerTail2.val ? newFormerTail2 : newFormerTail1;
                    }
                }
                cur = newHead;
                scopeLen = 2 * scopeLen;
            }
            return newHead;
        }
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

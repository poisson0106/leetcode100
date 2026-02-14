package com.sjw.leetcode100.cases;

import com.sjw.leetcode100.base.BaseCase;

public class CopyRandomList implements BaseCase {

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    @Override
    public void run() {

    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Node cur = head;
        Node tmp = null;
        while (cur != null) {
            tmp = new Node(cur.val);
            tmp.next = cur.next;
            cur.next = tmp;
            cur = tmp.next;
        }

        cur = head;
        while (cur != null) {
            cur.next.random = cur.random == null ? null : cur.random.next;
            cur = cur.next.next;
        }

        cur = head;
        Node newHead = cur.next;
        Node nextOne = cur.next;
        while (cur != null && nextOne != null) {
            cur.next = nextOne.next;
            cur = cur.next;
            if (nextOne.next != null) {
                nextOne.next = nextOne.next.next;
                nextOne = nextOne.next;
            }

        }

        return newHead;
    }
}

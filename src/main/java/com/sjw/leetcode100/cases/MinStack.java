package com.sjw.leetcode100.cases;

import com.sjw.leetcode100.base.BaseCase;

import java.util.PriorityQueue;

public class MinStack implements BaseCase {
    @Override
    public void run() {
        this.push(-2);
        this.push(0);
        this.push(-1);
        System.out.println(this.getMin());
        System.out.println(this.top());
        this.pop();
        System.out.println(this.getMin());
    }

    private int[] stack = new int[30000];
    private int top;
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    public MinStack() {
        top = 0;
    }

    public void push(int val) {
        stack[top++] = val;
        minHeap.offer(val);
    }

    public void pop() {
        if (top > 0) {
            int topVal = stack[top - 1];
            top--;
            minHeap.remove(topVal);
        }
    }

    public int top() {
        if (top > 0)
            return stack[top-1];
        else
            return 0;
    }

    public int getMin() {
        if (top > 0)
            return minHeap.peek();
        else
            return 0;
    }
}

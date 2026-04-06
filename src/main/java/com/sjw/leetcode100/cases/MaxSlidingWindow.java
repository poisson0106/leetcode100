package com.sjw.leetcode100.cases;

import com.sjw.leetcode100.base.BaseCase;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;

public class MaxSlidingWindow implements BaseCase {
    @Override
    public void run() {
        System.out.println(maxSlidingWindow2(new int[]{3,1,1,3}, 3));
    }

    class Ele {
        int val;
        int pos;
        public Ele(int val, int pos) {
            this.val = val;
            this.pos = pos;
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        Comparator<Ele> comparator = new Comparator<>() {

            @Override
            public int compare(Ele t1, Ele t2) {
                return t2.val - t1.val;
            }
        };
        PriorityQueue<Ele> pq = new PriorityQueue<>(comparator);
        int[] result = new int[nums.length - k + 1];

        for (int i = 0; i < k; i++) {
            pq.offer(new Ele(nums[i], i));
        }

        int count = 1;
        result[0] = pq.peek().val;
        for (int i = k; i < nums.length; i++) {
            pq.offer(new Ele(nums[i], i));
            while (i - pq.peek().pos >= k) {
                pq.poll();
            }
            result[count++] = pq.peek().val;
        }
        return result;
    }

    public int[] maxSlidingWindow2(int[] nums, int k) {
        //单调队列，从队尾进队头出。队列严格大的左侧小的右侧，当滑动窗口移除数字时，检测队头是否在区间内，移除不在的，保留下来的队头就是区间最大值
        Deque<Integer> monotonicQueue = new ArrayDeque<>();
        int n = nums.length;
        int[] result = new int[n - k + 1];

        for (int i = 0; i < k; i++) {
            inQueue(monotonicQueue, nums, i);
        }

        result[0] = nums[monotonicQueue.peekFirst()];

        for (int i = k; i < nums.length; i++) {
            //check whether the biggest one is needed to remove
            outQueue(monotonicQueue, k, i);
            inQueue(monotonicQueue, nums, i);
            result[i - k + 1] = nums[monotonicQueue.peekFirst()];
        }

        return result;
    }

    private void outQueue(Deque<Integer> deque, int k, int i) {
        while (!deque.isEmpty()) {
            if (i - deque.peek() >= k) {
                deque.poll();
            } else {
                break;
            }
        }
    }

    private void inQueue(Deque<Integer> deque, int[] nums, int i) {
        while (!deque.isEmpty()) {
            if (nums[deque.peekLast()] > nums[i]) {
                deque.addLast(i);
                return;
            } else {
                deque.pollLast();
            }
        }
        deque.addLast(i);
    }
}

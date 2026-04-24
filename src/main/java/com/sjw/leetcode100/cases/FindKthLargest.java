package com.sjw.leetcode100.cases;

import com.sjw.leetcode100.base.BaseCase;

import java.util.Comparator;
import java.util.PriorityQueue;

public class FindKthLargest implements BaseCase {
    @Override
    public void run() {
        System.out.println(findKthLargest(new int[]{3,2,1,5,6,4}, 2));
    }

    public int findKthLargest(int[] nums, int k) {
        Comparator<Integer> c = new Comparator<Integer>() {
            @Override
            public int compare(Integer t1, Integer t2) {
                return t2 - t1;
            }
        };
        PriorityQueue<Integer> pq = new PriorityQueue<>(c);
        for (int n : nums) {
            pq.add(n);
        }

        int result = pq.poll();
        for (int i = 1; i < k; i++) {
            result = pq.poll();
        }

        return result;
    }

    class Heap {
        private int[] heap;
        int size;

        public Heap(int capacity) {
            heap = new int[capacity];
        }

        public void insert(int num) {
            heap[size++] = num;
            int pos = size - 1;
            int tmp;
            while(pos >= 0) {
                if (heap[pos] > heap[pos / 2]) {
                    tmp = heap[pos / 2];
                    heap[pos / 2] = heap[pos];
                    heap[pos] = tmp;
                    pos = pos / 2;
                } else {
                    break;
                }
            }
        }

        public void heapify() {
            int pos = 0;
            int tmp;
            int tmpPos;
            while (pos < size) {
                tmpPos = -1;
                if (2 * pos + 1 < size && 2 * pos + 2 < size) {
                    tmpPos = heap[2 * pos + 1] > heap[2 * pos + 2] ? 2 * pos + 1 : 2 * pos + 2;
                } else {
                    if (2 * pos + 1 < size && heap[pos] < heap[2 * pos + 1]) {
                        tmpPos = 2 * pos + 1;
                    }
                }

                if (tmpPos == -1) {
                    break;
                } else {
                    tmp = heap[pos];
                    heap[pos] = heap[tmpPos];
                    heap[tmpPos] = tmp;
                }
            }
        }
    }
}

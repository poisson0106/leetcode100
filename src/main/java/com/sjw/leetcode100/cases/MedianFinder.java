package com.sjw.leetcode100.cases;

import com.sjw.leetcode100.base.BaseCase;

import java.util.PriorityQueue;

public class MedianFinder implements BaseCase {
    @Override
    public void run() {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(40);
        medianFinder.addNum(12);
        medianFinder.addNum(16);
        medianFinder.addNum(14);
        medianFinder.addNum(35);
        medianFinder.addNum(19);
        medianFinder.addNum(34);
        medianFinder.addNum(35);
        medianFinder.addNum(28);
        medianFinder.addNum(35);
        medianFinder.addNum(26);
        medianFinder.addNum(6);
        medianFinder.addNum(8);
        medianFinder.addNum(2);
        medianFinder.addNum(14);
        medianFinder.addNum(25);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(25);
        System.out.println(medianFinder.findMedian());
    }

    private int size = 0;
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    public MedianFinder() {

    }

    public void addNum(int num) {
        //前半大根堆，后半小根堆。前半的最大和后半的最小正好组成中间的数
        if (size == 0) {
            maxHeap.offer(num);
            size++;
        } else {
            if (maxHeap.peek() <= num && (minHeap.isEmpty() || minHeap.peek() < num)) {
                //往后半小根堆加
                //先假设已加入此数字，然后(size+1) / 2向上取整看最大容量
                if (minHeap.size() + 1 > (size + 2) / 2) {
                    minHeap.offer(num);
                    maxHeap.offer(minHeap.poll());
                    size++;
                } else {
                    minHeap.offer(num);
                    size++;
                }
            } else {
                if (maxHeap.size() + 1 > (size + 2) / 2) {
                    maxHeap.offer(num);
                    minHeap.offer(maxHeap.poll());
                    size++;
                } else  {
                    maxHeap.offer(num);
                    size++;
                }
            }
        }
    }

    public double findMedian() {
        if (size == 0) {
            return 0.0;
        } else if (size % 2 == 1) {
            if (maxHeap.size() > minHeap.size()) {
                return maxHeap.peek();
            } else {
                return minHeap.peek();
            }
        } else {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
    }
}

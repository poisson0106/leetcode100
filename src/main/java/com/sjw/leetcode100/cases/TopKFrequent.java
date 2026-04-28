package com.sjw.leetcode100.cases;

import com.sjw.leetcode100.base.BaseCase;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequent implements BaseCase {
    @Override
    public void run() {

    }

    class Pair{
        int key;
        int count;
        public Pair(int key, int count) {
            this.key = key;
            this.count = count;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else
                map.put(num, map.get(num) + 1);
        }

        Comparator<Pair> comparator = new Comparator<Pair>() {
            @Override
            public int compare(Pair t1, Pair t2) {
                return t2.count - t1.count;
            }
        };
        PriorityQueue<Pair> pq = new PriorityQueue<>(comparator);

        for (int key : map.keySet()) {
            pq.offer(new Pair(key, map.get(key)));
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = pq.poll().key;
        }
        return result;
    }
}

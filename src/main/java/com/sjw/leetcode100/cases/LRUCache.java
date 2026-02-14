package com.sjw.leetcode100.cases;

import com.sjw.leetcode100.base.BaseCase;

import java.util.*;

public class LRUCache implements BaseCase {

    @Override
    public void run() {
        this.capacity = 2;
        this.put(2,1);
        this.put(2,2);
    }

    class KVPair {
        int key;
        int value;

        public KVPair() {
        }

        public KVPair(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    private List<KVPair> lruList;
    private Map<Integer, KVPair> m;
    private int capacity;

    public LRUCache() {
        lruList = new LinkedList<>();
        m = new HashMap<>();

    }

    public int get(int key) {
        if (m.containsKey(key)) {
            KVPair kvp = m.get(key);
            lruList.remove(kvp);
            lruList.addFirst(kvp);
            m.put(key, kvp);
            return kvp.getValue();
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (m.containsKey(key)) {
            KVPair kvp = m.get(key);
            lruList.remove(kvp);
            kvp.setValue(value);
            lruList.addFirst(kvp);
            m.put(key, kvp);
        } else {
            if (lruList.size() < capacity) {
                KVPair kvp = new KVPair(key, value);
                lruList.addFirst(kvp);
                m.put(key, kvp);
            } else {
                KVPair kvp = new KVPair(key, value);
                KVPair lastOne = lruList.getLast();
                m.remove(lastOne.getKey());
                lruList.removeLast();
                lruList.addFirst(kvp);
                m.put(key, kvp);
            }
        }
    }
}

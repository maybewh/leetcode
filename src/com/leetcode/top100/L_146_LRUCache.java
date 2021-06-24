package com.leetcode.top100;

import java.util.LinkedHashMap;
import java.util.Map;

public class L_146_LRUCache {

    private MyLinkedHashMap<Integer, Integer> container = null;

    public L_146_LRUCache(int capacity) {
        container = new MyLinkedHashMap<Integer, Integer>(capacity);
    }

    public int get(int key) {

        if (container.containsKey(key)) {
            return container.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        container.put(key, value);
    }

    public class MyLinkedHashMap<K, V> extends LinkedHashMap<K, V> {

        private int capacity;
        public MyLinkedHashMap(int capacity) {
            super(capacity, 0.75f, true);
            this.capacity = capacity;
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry eldest) {
            return size() > capacity;
        }
    }

    public static void main(String[] args) {
        L_146_LRUCache lRUCache = new L_146_LRUCache(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        System.out.println(lRUCache.get(1));   // 返回 1
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        System.out.println(lRUCache.get(2));    // 返回 -1 (未找到)
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        System.out.println(lRUCache.get(1));    // 返回 -1 (未找到)
        System.out.println(lRUCache.get(3));   // 返回 3
        System.out.println(lRUCache.get(4));   // 返回 4
    }
}

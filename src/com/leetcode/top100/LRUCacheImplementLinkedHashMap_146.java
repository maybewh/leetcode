package com.leetcode.top100;

import java.util.HashMap;
import java.util.Map;

public class LRUCacheImplementLinkedHashMap_146 {

    class DLinkedNode {

        int key;
        int val;
        DLinkedNode before;
        DLinkedNode after;

        public DLinkedNode() {}
        public DLinkedNode(int key, int val) {
            this.key = key;
            this.val = val;
        }

    }

    private Map<Integer, DLinkedNode> container = new HashMap<>();

    private int size;
    private int capacity;
    private DLinkedNode head;
    private DLinkedNode tail;

    public LRUCacheImplementLinkedHashMap_146(int capacity) {
        size = 0;
        this.capacity = capacity;

        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.after = tail;
        tail.before = head;
    }

    /**
     * 访问一次调整链表的结构，即tail为该节点
     * @param key
     * @return
     */
    public int get(int key) {

        DLinkedNode node = container.get(key);
        if (node != null) {
            moveNodeToTail(node);
            return container.get(key).val;
        }
        return -1;
    }

    public void put(int key, int value) {
        DLinkedNode node = new DLinkedNode(key, value);
        container.put(key, node);
        size++;
        addNodeToTail(node);
        if (size > capacity) {
            removeHeadNode(node);
            size--;
        }
    }


    public void removeNode(DLinkedNode node) {

    }



}

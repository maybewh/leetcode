package com.leetcode.top100;

import java.util.HashMap;
import java.util.Map;

public class LRUCacheImplementLinkedHashMap_146 {

    public static void main(String[] args) {
        LRUCacheImplementLinkedHashMap_146 lRUCache = new LRUCacheImplementLinkedHashMap_146(2);
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
        DLinkedNode look = container.get(key);
        if (look == null) {
            DLinkedNode node = new DLinkedNode(key, value);
            container.put(key, node);
            size++;
            addNodeToTail(node);
            if (size > capacity) {
                DLinkedNode head = removeHeadNode();
                container.remove(head.key);
                size--;
            }
        } else {
            look.val = value;
            moveNodeToTail(look);
        }


    }

    private DLinkedNode removeHeadNode() {
        DLinkedNode firstNode = head;
        head = firstNode.after;
        firstNode.after = null;
        return firstNode;
    }

    private void moveNodeToTail(DLinkedNode node) {
        if (node == tail) {
            return;
        }
        DLinkedNode beforeNode = node.before;
        DLinkedNode afterNode = node.after;

        DLinkedNode lastNode = tail;

        // 若是头结点
        if (node == head) {
            head = afterNode;
            head.before = null;
        } else {
            afterNode.before = beforeNode;
            beforeNode.after = afterNode;
        }

        node.after = null;
        node.before = lastNode;

        lastNode.after = node;
        tail = node;

    }

    private void addNodeToTail(DLinkedNode node) {
        DLinkedNode lastNode = tail;

        if (tail == null && head == null) {
            head = node;
            tail = node;
            return;
        }

        lastNode.after = node;
        node.before = lastNode;
        tail = node;
    }

}

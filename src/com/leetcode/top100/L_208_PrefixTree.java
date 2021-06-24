package com.leetcode.top100;

import java.util.HashMap;
import java.util.Map;

public class L_208_PrefixTree {

    // 首先定义树节点的数据结构
    class TreeNode {
        int end; // 以当前单词结尾的单词个数
        int path; // 当前节点能链接到到单词个数，也就是以当前单词作为前缀的单词个数
        Map<Character, TreeNode> next = null; // 当前节点能链接到的所有节点，a-z节省空间（使用数组会有大量空节点）

        public TreeNode() {
            end = 0;
            path = 0;
            next = new HashMap<>();
        }
    }

    private TreeNode root; // root节点为空节点
    /** Initialize your data structure here. */
    public L_208_PrefixTree() {
        root = new TreeNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TreeNode tmp = root;
        char[] arr = word.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            TreeNode node = tmp.next.get(arr[i]);
            if (node == null) {
                node = new TreeNode();
                tmp.next.put(arr[i], node);
            }
            tmp = node;
            tmp.path++; // 此处注意：应该在后面一个节点，因为只有这个节点之前才是以这个单词为前缀
        }
        tmp.end++;

    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TreeNode tmp = root;
        char[] arr = word.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            Map<Character, TreeNode> next = tmp.next;
            if (!next.containsKey(arr[i])) {
                return false;
            }
            tmp = next.get(arr[i]);
        }

        if (tmp.end == 0) {
            return false;
        }

        return true;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TreeNode tmp = root;
        char[] arr = prefix.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            Map<Character, TreeNode> next = tmp.next;
            if (!next.containsKey(arr[i])) {
                return false;
            }
            tmp = next.get(arr[i]);
        }
        return true;
    }

}
/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

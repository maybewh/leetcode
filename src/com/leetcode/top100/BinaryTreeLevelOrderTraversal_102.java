package com.leetcode.top100;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal_102 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    List<List<Integer>> result = new ArrayList<>();

    /**
     * 需要一个变量记录当前层次，同时，从集合结果中取出对应List，最后将结果放到该List中
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return result;
        }
        orderLevel(root, 0);
        return result;
    }

    public void orderLevel(TreeNode node, int level) {
        List<Integer> list = new ArrayList<>();
        if (result.size() > level) {
            list = result.get(level);
        } else {
            result.add(list);
        }

        list.add(node.val);

        if (node.left != null) {
            orderLevel(node.left, level + 1);
        }

        if (node.right != null) {
            orderLevel(node.right, level + 1);
        }
    }

}

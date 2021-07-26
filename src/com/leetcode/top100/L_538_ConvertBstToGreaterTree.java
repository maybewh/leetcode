package com.leetcode.top100;

public class L_538_ConvertBstToGreaterTree {

    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        addSum(root, 0);
        return root;
    }

    public int addSum(TreeNode treeNode, int lastSum) {
        // 右根左
        if (treeNode == null) {
            return lastSum; // 关键点，若父节点的子节点为空（也就是当前节点为null），则返回父节点的值。
        }
        int right = addSum(treeNode.right, lastSum);
        int val = treeNode.val;
        int left = addSum(treeNode.left, val + right);
        treeNode.val = right + val; // 当前节点为右子树的值加上本身的值
        return left; // 但是返回父节点的值，应该包含其左右子树相加的值
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) {this.val = val;}
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}

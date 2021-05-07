package com.leetcode.top100;

import sun.reflect.generics.tree.Tree;

public class ValidateBinarySearchTree_98 {

    public static class TreeNode {
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


    public boolean isValidBST(TreeNode root) {
        return validBST(root, Long.MIN_VALUE, Long.MAX_VALUE); // 使用long，测试用例有大于Integer
    }

    public boolean validBST(TreeNode root, long min, long max) {

        if (root == null) {
            return true;
        }

        if (root.val <= min || root.val >= max) {
            return false;
        }

        return validBST(root.left, min, root.val) && validBST(root.right, root.val, max);
    }

/*
    public boolean validBST(TreeNode root, int type, int parent) {

        if (type == 0 && root.val >= parent) {
            return false;
        }

        if (type == 1 && root.val <= parent) {
            return false;
        }

        if (type == 0 && root.right != null && root.right.val >= parent) {
            return false;
        }

        if (type == 1 && root.left != null && root.left.val <= parent) {
            return false;
        }

        return validLeftAndRight(root);

    }

    public boolean validLeftAndRight(TreeNode root) {
        boolean left = true;
        if (root.left != null) {
            left = validBST(root.left, 0, root.val);
        }

        boolean right = true;
        if (root.right != null) {
            right = validBST(root.right, 1, root.val);
        }
        return left && right;
    }
*/

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        ValidateBinarySearchTree_98 binarySearchTree = new ValidateBinarySearchTree_98();
        boolean result = binarySearchTree.isValidBST(root);
        System.out.println(result);
    }
}

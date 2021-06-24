package com.leetcode.top100;

import java.util.Arrays;

/**
 * 根据前序遍历和中序遍历构造二叉树
 */
public class L_105_ConstructBinaryTreeFromPreorderAndInorderTraversal {

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

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode node = null;
        if (preorder.length > 0) {
            node = new TreeNode(preorder[0]);
            buildTree(node, preorder, inorder);
        }

        return node;
    }

    public void buildTree(TreeNode node, int[] preorder, int[] inorder) {
        int val = node.val;
        int index = findDemarcation(val, inorder);

        int[] leftInOrder = Arrays.copyOfRange(inorder, 0, index);
        int[] rightInOrder = Arrays.copyOfRange(inorder, index + 1, inorder.length);

        int[] leftPreOrder = Arrays.copyOfRange(preorder, 1, index + 1);
        int[] rightPreOrder = Arrays.copyOfRange(preorder, index + 1, preorder.length);

        if (leftPreOrder.length > 0) {
            TreeNode left = new TreeNode(leftPreOrder[0]);
            node.left = left;
            buildTree(left, leftPreOrder, leftInOrder);
        }

        if (rightPreOrder.length > 0) {
            TreeNode right = new TreeNode(rightPreOrder[0]);
            node.right = right;
            buildTree(right, rightPreOrder, rightInOrder);
        }

    }

    private int findDemarcation(int val, int[] inorder) {
        int index = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (val == inorder[i]) {
                index = i;
                break;
            }
        }
        return index;
    }

    public static void main(String[] args) {

    }

}

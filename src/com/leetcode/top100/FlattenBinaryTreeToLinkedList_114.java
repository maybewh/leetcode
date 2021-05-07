package com.leetcode.top100;

import java.util.Stack;

/**
 * 给一个树的根节点，将其展开成单链表，其中right子指针只想链表的下一个结点，而左子针始终为null；
 * 展开后的单链表应该与二叉树先序遍历顺序相同
 */
public class FlattenBinaryTreeToLinkedList_114 {

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

    /**
     * 思路：按照先序遍历进行遍历，当使用stack的pop()时，将pop的值构建一个新的树。
     * 注意点：原先的树的根节点有左子节点，需要将其设为null。 同时对root为null的情况直接返回即可。
     * @param root
     */
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode newRoot = root;
        TreeNode newTmp = null;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        boolean flag = true;
        while (!stack.isEmpty()) {

            TreeNode tmp = stack.pop();

            if (tmp.right != null) {
                stack.push(tmp.right);
            }

            if (tmp.left != null) {
                stack.push(tmp.left);
            }

            if (flag) {
                flag = false;
                newTmp = newRoot;
            } else {
                newTmp.right = tmp;
                newTmp = tmp;
            }
            newTmp.left = null;
        }
        root = newRoot;
    }
}

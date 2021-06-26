package com.leetcode.top100;

public class L_236_LowestCommonAncestorOfABinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    TreeNode result = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        findParent(root, p, q);
        if (result != null) {
            System.out.println(result.val);
        }
        System.out.println("null:" + result);
        return result;
    }

    public boolean findParent(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null) {
            return false;
        }

        boolean left = findParent(root.left, p, q);
        boolean right = findParent(root.right, p, q);

        if (left && right) {
            result = root;
            return false;
        }

        if (left || right) {

            if (root.val == p.val || root.val == q.val) {
                result = root;
                return false;
            }
            return true;

        }

        if (root.val == p.val || root.val == q.val) {
            return true;
        }
        return false;

    }

    public static void main(String[] args) {

        L_236_LowestCommonAncestorOfABinaryTree tree = new L_236_LowestCommonAncestorOfABinaryTree();
        TreeNode root = tree.new TreeNode(3);
        TreeNode left = tree.new TreeNode(5);
        TreeNode right = tree.new TreeNode(1);

        TreeNode left1 = tree.new TreeNode(6);
        TreeNode right1 = tree.new TreeNode(2);
        TreeNode left2 = tree.new TreeNode(7);
        TreeNode left3 = tree.new TreeNode(4);

        left.left = left1;
        left.right = right1;

        right1.left = left2;
        right1.right = left3;

        root.left = left;
        root.right = right;

        tree.lowestCommonAncestor(root, left, left3);
    }

    
}

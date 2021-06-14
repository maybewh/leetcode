package com.leetcode.top100;

public class HouseRobberIII_337 {

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


    public int rob(TreeNode root) {
          int[] result = dfs(root);
          return Math.max(result[0], result[1]);
    }

    public int[] dfs(TreeNode node) {

          if (node == null) {
              return new int[]{0,0};
          }

          int[] l = dfs(node.left);
          int[] r = dfs(node.right);

          int selected = node.val + l[1] + r[1];
          int notSelected = Math.max(l[0], l[1]) + Math.max(r[0], r[1]); // 取左节点最大值和右节点最大值
          return new int[] {selected, notSelected};
    }


    public static void main(String[] args) {

    }
}

package com.leetcode.top100;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInOrder_94 {
    
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

    public List<Integer> inorderTraversal(TreeNode root) {

          Stack<TreeNode> stack = new Stack<>();
          List<Integer> res = new ArrayList<>();

          TreeNode tmp = root;

          while (!stack.isEmpty() || tmp != null) {

              while (tmp != null) {
                  stack.push(tmp);
                  tmp = tmp.left;
              }

              tmp = stack.pop();
              res.add(tmp.val);

              tmp = tmp.right;
          }

          return res;
    }
}

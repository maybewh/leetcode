package com.leetcode.top100;

public class L_96_UniqueBinarySearchTrees {

    /**
     * 思路：设f(i)为以i为根节点的二叉搜索树的个数，G(n)为n个节点的二叉搜索树的个数。那么有：
     * G(n) = f(1) + f(2) + f(3) + f(4) + ...... + f(n)
     * 则可以推出如下递归的公式：
     * f(1) = f(0) * f(0),以1为根节点，左子树和右子树为0个节点
     * f(2) = f(0)*f(1) + f(1)*f(0), 以2为根节点，再分别将1设为左子树的根节点和右子树的根节点，依次类推，
     * f(i) = f(0)*f(i) + f(1)*f(i-1) + ...... + f(j)f(i-j-1) + ...... +f(i)*f(0)
     * @param n
     * @return
     */
    public int numTrees(int n) {

        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        L_96_UniqueBinarySearchTrees binarySearchTree = new L_96_UniqueBinarySearchTrees();
        int result = binarySearchTree.numTrees(3);
        System.out.println(result);
    }
}

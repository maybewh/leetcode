package com.leetcode.top100;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class L_437_PathSumIII {

    int res = 0;
    public int pathSum(TreeNode root, int targetSum) {
        sumPath(root, targetSum);
        return res;
    }

    /**
     * 后续遍历，存储所有节点相加的情况
     * @param treeNode
     * @param targetSum
     * @return
     */
    public LinkedList sumPath(TreeNode treeNode, int targetSum) {
        if (treeNode == null) {
            return new LinkedList();
        }

        LinkedList upList = new LinkedList();
        LinkedList<Integer> left = sumPath(treeNode.left, targetSum);
        LinkedList<Integer> right = sumPath(treeNode.right, targetSum);

        int val = treeNode.val;
        upList.add(val);
        LinkedList<Integer> leftRes = consList(left, val, targetSum);
        LinkedList<Integer> rightRes = consList(right, val, targetSum);
        upList.addAll(leftRes);
        upList.addAll(rightRes);
        return upList;
    }

    public LinkedList<Integer> consList(LinkedList<Integer> list, int val,int targetSum) {

        for (int i = 0; i < list.size(); i++) {
            int sum = val + list.get(i);
            if (sum == targetSum) {
                res++;
            }
            list.set(i, sum);
        }
        return list;
    }


    /**
     * 前缀和思路
     * 在同一个路径之下（可以理解成二叉树从root节点出发，到叶子节点的某一条路径），
     * 如果两个数的前缀总和是相同的，那么这些节点之间的元素总和为零。进一步扩展相同的想法，
     * 如果前缀总和currSum，在节点A和节点B处相差target，则位于节点A和节点B之间的元素之和是target。
     *
     * 抵达当前节点(即B节点)后，将前缀和累加，然后查找在前缀和上，有没有前缀和currSum-target的节点(即A节点)，
     * 存在即表示从A到B有一条路径之和满足条件的情况。
     * 结果加上满足前缀和currSum-target的节点的数量。然后递归进入左右子树。
     * @param root
     * @param targetSum
     * @return
     */
    public int pathSum2(TreeNode root, int targetSum) {
        // 存储前缀和
        Map<Integer, Integer> map = new HashMap<>();

        // 当和为0的时候，路径个数为1
        map.put(0, 1);

        return recursionPathSum(root, map, 0, targetSum);
    }

    public int recursionPathSum(TreeNode node, Map<Integer, Integer> map, int curSum, int target) {
        if (node == null) {
            return 0;
        }

        int val = node.val;
        int sum = val + curSum;
        map.put(sum, map.getOrDefault(sum + 1, 0));
        int result = 0;
        //---核心代码
        // 看看root到当前节点这条路上是否存在节点前缀和加target为currSum的路径
        // 当前节点->root节点反推，有且仅有一条路径，如果此前有和为currSum-target,而当前的和又为currSum,两者的差就肯定为target了
        // currSum-target相当于找路径的起点，起点的sum+target=currSum，当前点到起点的距离就是target
        result += map.getOrDefault(target - curSum, 0);

        result += recursionPathSum(node.left, map, sum, target);
        result += recursionPathSum(node.right, map, sum, target);

        // 回溯
        map.put(sum, map.get(sum) - 1);
        return result;

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

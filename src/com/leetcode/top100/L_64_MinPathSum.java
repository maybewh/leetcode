package com.leetcode.top100;

public class L_64_MinPathSum {

    /**
     * 思路：利用动态规划来完成。计算到每个节点时，路径上最小的和。由于只能向下和向右移动，所以一个点的值一定取其上面或右面一个节点最小的值。
     * 因此，利用动态规划来完成。
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {

        if (grid == null || grid.length == 0)
            return 0;

        int[][] pathSum = new int[grid.length][grid[0].length];
        pathSum[0][0] = grid[0][0];


        // 初始化 第一行中节点路径：只能从其左边的节点过来，第一列中的节点路径：只能从其上面的节点过来
        for (int i = 1; i < pathSum.length; i++) pathSum[i][0] = pathSum[i - 1][0] + grid[i][0];

        for (int j = 1; j < pathSum[0].length; j++) pathSum[0][j] = pathSum[0][j - 1] + grid[0][j];

        for (int i = 1; i < pathSum.length; i++) {
            for (int j = 1; j < pathSum[0].length; j++) {

                pathSum[i][j] = grid[i][j] + Math.min(pathSum[i - 1][j], pathSum[i][j - 1]);

            }
        }

        return pathSum[grid.length - 1][grid[0].length - 1];
    }

    public static void main(String[] args) {

        L_64_MinPathSum minPathSum_64 = new L_64_MinPathSum();
        int[][] data = new int[][]{{1,3,1}, {1,5,1}, {4,2,1}};
//        int[][] data = new int[][]{{1,2,3}, {4,5,6}};
        int result = minPathSum_64.minPathSum(data);
        System.out.println(result);
    }

}

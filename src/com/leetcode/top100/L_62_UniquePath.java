package com.leetcode.top100;

/**
 * 回溯法：此解法超出了时间限制
 * 使用动态规划，分解成为子问题
 * 到达dp[i][j]最多的路径
 * dp[i][j] = dp[i-1][j] + dp[i][j-1]
 */
public class L_62_UniquePath {

    int paths = 0;
    /**
     * 可选择路径： 向下或向右 --> i+1 或 j+1
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {

        // 记录选择当前点是否已经选择，选择了值为1。没有选择，值为0
/*        int[][] coordinates = new int[m][n];
        computeUniquePaths(0, 0, coordinates);*/
        return  dpUniquePath(m, n);
//        return paths;
    }

    /**
     * 回溯法
     * 路径：已经向右、向下选择的节点
     * 选择列表：可以继续向下、向右
     * 结束条件： x, y为 m,n
     * @param x
     * @param y
     * @param coordinates
     */
    public void computeUniquePaths(int x, int y, int[][] coordinates) {

        //结束条件
        if (x == coordinates.length - 1 && y == coordinates[0].length - 1) {
            paths++;
            return;
        }

        //做出选择
        coordinates[x][y] = 1;

        //向下
        if (x + 1 < coordinates.length && coordinates[x + 1][y] == 0) {
            computeUniquePaths(x + 1, y, coordinates);
        }

        // 向右
        if (y + 1 < coordinates[0].length && coordinates[x][y + 1] == 0) {
            computeUniquePaths(x, y + 1, coordinates);
        }

        // 撤销选择
        coordinates[x][y] = 0;

    }

    /**
     * 使用动态规划，分解成为子问题
     * 到达dp[i][j]最多的路径
     * dp[i][j] = dp[i-1][j] + dp[i][j-1]
     * @return
     */
    public int dpUniquePath(int x, int y) {

        // 令dp[i][j]是到达i, j最多的路径
        // 那么到达第一行每个节点的路径都只有1个，到达第一列所以节点的个数都只有1个
        int[][] dp = new int[x][y];
        // 初始化
        //1. 第一行
        for (int i = 0; i < y; i++) dp[0][i] = 1;
        //2. 第一列
        for (int j = 0; j < x; j++) dp[j][0] = 1;

        for (int i = 1; i < x; i++) {
            for (int j = 1; j < y; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[x - 1][y - 1];
    }



    public static void main(String[] args) {

        L_62_UniquePath uniquePath_62 = new L_62_UniquePath();
        int m = 23, n = 12;
/*        uniquePath_62.uniquePaths(m, n);
        System.out.println(uniquePath_62.paths);*/
        System.out.println(uniquePath_62.uniquePaths(m, n));

    }

}

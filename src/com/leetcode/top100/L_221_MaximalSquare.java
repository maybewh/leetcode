package com.leetcode.top100;

public class L_221_MaximalSquare {

    public int maximalSquare(char[][] matrix) {

        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        if (matrix == null || matrix.length == 0) {
            return 0;
        }

        int[][] dp = new int[matrix.length + 1][matrix[0].length + 1];
        int max = 0;

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {

                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i][j-1], dp[i-1][j]));
                    max = Math.max(dp[i][j], max);
                }
            }
        }

        return max * max;
    }

    public static void main(String[] args) {
        L_221_MaximalSquare maximalSquare = new L_221_MaximalSquare();

        char[][] matrix = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        
        int max  = maximalSquare.maximalSquare(matrix);
        System.out.println(max);
    }

}

package com.leetcode.top100;

public class L_279_PrefectSquares {

    /**
     * dp[i]：表示i时，取最小的数的值
     * dp[i] = 1 + min{dp[i - j * j) j∈[1, (int)sqrt(n)]}
     * 其中dp[0] = 0
     * 所以，在初始化时，dp数组的长度为n+1
     * @param n
     * @return
     */
    public int numSquares(int n) {

        // 要枚举出n个数的最小个数
        // 0为0,1到n占据n位空间
        int[] dp = new int[n + 1];

        dp[0] = 0;

        for (int i = 1; i <= n; i++) {

            int min = Integer.MAX_VALUE;
            int len = (int)Math.sqrt(i);
            for (int j = 1; j <= len; j++) {
                min = Math.min(min, dp[i - j * j]);
            }
            dp[i] = 1 + min;
        }

        return dp[n];
    }

    public static void main(String[] args) {
        L_279_PrefectSquares prefectSquares = new L_279_PrefectSquares();
        int result = prefectSquares.numSquares(13);
        System.out.println(result);
    }

}

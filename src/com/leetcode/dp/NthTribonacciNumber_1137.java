package com.leetcode.dp;

public class NthTribonacciNumber_1137 {

    public int tribonacci(int n) {

        if (n == 0) {
            return 0;
        }

        if (n == 1 || n == 2) {
            return 1;
        }

        int[] dp = new int[3];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;

        int result = n;
        for (int i = 3; i <= n; i++) {
            result = dp[2] + dp[1] + dp[0];
            dp[0] = dp[1];
            dp[1] = dp[2];
            dp[2] = result;
        }
        return result;

    }

    public static void main(String[] args) {
        NthTribonacciNumber_1137 nthTribonacciNumber_1137 = new NthTribonacciNumber_1137();
        System.out.println(nthTribonacciNumber_1137.tribonacci(4));
        System.out.println(nthTribonacciNumber_1137.tribonacci(25));
    }

}

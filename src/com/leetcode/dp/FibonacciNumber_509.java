package com.leetcode.dp;

public class FibonacciNumber_509 {

    public int fib(int n) {

        int[] dp = new int[2];
        dp[0] = 0;
        dp[1] = 1;

        int result = n;
        for (int i = 2; i <= n; i++) {
            result = dp[1] + dp[0];
            dp[0] = dp[1];
            dp[1] = result;
        }
        return result;
    }

    public static void main(String[] args) {
        FibonacciNumber_509 fibonacciNumber_509 = new FibonacciNumber_509();
        System.out.println(fibonacciNumber_509.fib(2));
        System.out.println(fibonacciNumber_509.fib(3));
        System.out.println(fibonacciNumber_509.fib(4));
    }
}

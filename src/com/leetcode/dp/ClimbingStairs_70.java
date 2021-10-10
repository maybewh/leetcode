package com.leetcode.dp;

public class ClimbingStairs_70 {

    public int climbStairs(int n) {
        
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int tmp = 0;
            for (int j = 1; j <= 2; j++) {
                tmp += dp[i - j];
            }
            dp[i] = tmp;
        }

        return dp[n];
    }

    public static void main(String[] args) {
        ClimbingStairs_70 climbingStairs_70 = new ClimbingStairs_70();
        System.out.println(climbingStairs_70.climbStairs(2));
        System.out.println(climbingStairs_70.climbStairs(3));
        System.out.println(climbingStairs_70.climbStairs(10));
    }
}

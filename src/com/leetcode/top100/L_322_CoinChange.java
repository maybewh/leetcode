package com.leetcode.top100;

import java.util.Arrays;

public class L_322_CoinChange {

    /**
     * 完全背包问题，weight为coins数组，value都为1.
     * 求价值最小是多少
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                if (dp[j] - 1 > dp[j - coins[i]]) {
                    dp[j] = dp[j - coins[i]] + 1;
                }
            }
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];

    }

    public static void main(String[] args) {
        L_322_CoinChange coinChange = new L_322_CoinChange();
        int[] coins = {1,2,5};
        int amount = 11;
        System.out.println(coinChange.coinChange(coins, 0));
    }
}

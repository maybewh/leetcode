package com.leetcode.dp;

public class MinCostClimbingStairs_746 {

    public int minCostClimbingStairs(int[] cost) {

        if (cost.length == 1) {
            return cost[0];
        }

        int[] min_cost = new int[cost.length + 1];
        min_cost[1] = cost[0];
        for (int i = 2; i <= cost.length; i++) {
            min_cost[i] = Math.min(min_cost[i - 1] + cost[i - 1], min_cost[i - 2] + cost[i - 1]);
        }
        return Math.min(min_cost[cost.length], min_cost[cost.length - 1]);

    }

    public static void main(String[] args) {
        MinCostClimbingStairs_746 mccs = new MinCostClimbingStairs_746();
        int[] m = {10, 15, 20};
        int[] m1 = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        int[] m2 = {10, 9};
        System.out.println(mccs.minCostClimbingStairs(m));
        System.out.println(mccs.minCostClimbingStairs(m1));
        System.out.println(mccs.minCostClimbingStairs(m2));
    }

}

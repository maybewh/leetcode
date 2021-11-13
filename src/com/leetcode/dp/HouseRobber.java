package com.leetcode.dp;

public class HouseRobber {

    public int rob(int[] nums) {

        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length + 1];
        dp[1] = nums[0];
        dp[2] = Math.max(dp[1], nums[1]);
        for (int i = 3; i <= nums.length; i++) {
            dp[i] = Math.max(Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]), dp[i - 3] + nums[i - 1]);
        }
        return dp[nums.length];
    }

    public static void main(String[] args) {
        HouseRobber hb = new HouseRobber();
        int[] m = {1,2,3,1};
        int[] m1 = {2,7,9,3,1};
        int[] m2 = {2,3,7,1,1,9};
        System.out.println(hb.rob(m));
        System.out.println(hb.rob(m1));
        System.out.println(hb.rob(m2));

    }
}

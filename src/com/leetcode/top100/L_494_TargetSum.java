package com.leetcode.top100;

public class L_494_TargetSum {

    /**
     * 关键点：需要把问题转化成01背包问题
     * 设数组所有元素（均为非负整数）之和为sum，所有-号的和为neg，则所有+号元素之和为sum-neg。
     * 那么 target = sum - neg - neg
     * 所以有： neg = (sum - target) / 2。由于neg为非负整数，所以sum - target必须为非负偶数。
     * 若满足上述条件，则将其转为了 选取数组的元素，使得其和为neg。也就转化为了01背包问题
     * @param nums
     * @param target
     * @return
     */
    public int findTargetSumWays(int[] nums, int target) {

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        int neg = (sum - target) / 2; // 由于所有元素都是非负整数，所以neg必须为非负整数
        int remainder = (sum - target) % 2; // 所以neg>=0,余数remainder为0
        int res = 0;
        if (neg >= 0 && remainder == 0) {

            int[] dp = new int[neg + 1];
            dp[0] = 1;

            for (int i = 0; i < nums.length; i++) {
                int numI = nums[i];
                for (int j = neg; j >= 0; j--) {
                    if (numI > j) {
                        dp[j] = dp[j];
                    } else {
                        dp[j] = dp[j] + dp[j - numI];
                    }
                }
            }
            res = dp[neg];
        }

        return res;
    }

    public static void main(String[] args) {
        L_494_TargetSum targetSum = new L_494_TargetSum();
        int[] arr = {1};
        int target = 1;
        System.out.println(targetSum.findTargetSumWays(arr, target));
    }

}

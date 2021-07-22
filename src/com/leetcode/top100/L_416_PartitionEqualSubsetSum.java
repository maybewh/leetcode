package com.leetcode.top100;

public class L_416_PartitionEqualSubsetSum {

    public boolean canPartition(int[] nums) {

        if (nums.length < 2) {
            return false;
        }

        int maxNum = 0;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            maxNum = maxNum < nums[i] ? nums[i] : maxNum;
            sum += nums[i];
        }

        if (sum % 2 != 0) {
            return false;
        }

        if (maxNum > sum / 2) {
            return false;
        }

        boolean[] dp = new boolean[sum / 2 + 1]; // 滚动数组
        dp[0] = true;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            for (int j = sum / 2; j > 0; j--) {
               if (num > j) {
                   dp[j] = dp[j];
               } else {
                   dp[j] = dp[j] || dp[j - num];
               }
            }
        }

        return dp[sum / 2];
    }

    public static void main(String[] args) {
        L_416_PartitionEqualSubsetSum partitionEqualSubsetSum = new L_416_PartitionEqualSubsetSum();
        int[] arr = {2,6,11,6,3};
//        int[] arr = {1,2,3,5};
        boolean res = partitionEqualSubsetSum.canPartition(arr);
        System.out.println(res);
    }
}

package com.leetcode.top100;

public class L_152_MaximumProductSubarray {

    /**
     * 初步思路：暴力解法--> 动态规划
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        int res = nums[0];
        int[] maxDp = new int[nums.length]; // 以i位置为结尾元素的最大
        int[] minDp = new int[nums.length];

        maxDp[0] = nums[0];
        minDp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int min = Math.min(maxDp[i - 1] * nums[i], minDp[i - 1] * nums[i]);
            min = Math.min(min, nums[i]);
            int max = Math.max(maxDp[i - 1] * nums[i], minDp[i - 1] * nums[i]);
            max = Math.max(max, nums[i]);
            maxDp[i] = max;
            minDp[i] = min;
            if (max > res) {
                res = max;
            }
        }
        return res;
    }

    /**
     *
     * @param
     * @return
     */
/*    public int maxProduct1(int[] nums) {

    }*/
    public static void main(String[] args) {
        L_152_MaximumProductSubarray productSubarray_152 = new L_152_MaximumProductSubarray();
        int[] arr = {2,3,-2,4};
        int res = productSubarray_152.maxProduct(arr);
        System.out.println("res:" + res);
    }
}

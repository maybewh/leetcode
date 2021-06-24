package com.leetcode.top100;

import java.util.Arrays;

/**
 * 打家劫舍
 */
public class L_198_HouseRobber {

    /**
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {

        if (nums.length == 1) {
            return nums[0];
        }

        int[] arr = new int[nums.length];
        arr = Arrays.copyOf(nums, nums.length);
        int res = arr[0];
        for (int i = 1; i < nums.length; i++) {
            int max = 0; //
            for (int j = i - 2; j >= 0; j--) {
                if (arr[j] > max) {
                    max = arr[j];
                }
            }
            arr[i] += max;
            if (arr[i] > res) {
                res = arr[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        L_198_HouseRobber robber_198 = new L_198_HouseRobber();
        int[] arr = {2,1,1,2};
        int res = robber_198.rob(arr);
        System.out.println(res);
    }
}

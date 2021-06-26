package com.leetcode.top100;

public class L_238_ProductOfArrayExceptSelf {

    /**
     * 左右乘积，先计算出i元素左边的乘积和右边的乘积
     * 最后求i的乘积时，从两个数组中选取一个对应的数，将两个数进行相乘即可
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {

        if (nums == null || nums.length == 0) {
            return null;
        }

        int[] left = new int[nums.length]; // 计算i左边的乘积
        int[] right = new int[nums.length]; // 计算i右边的乘积

        int len = nums.length;
        left[0] = 1;
        right[len - 1] = 1;
        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i - 1] * nums[i - 1];
            right[len - i - 1] = right[len - i] * nums[len - i];
        }

        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            result[i] = left[i] * right[i];
        }
        return result;
    }

    /**
     * 节省空间
     * @param nums
     * @return
     */
    public int[] saveSpace(int[] nums) {

        if (nums == null || nums.length == 0) {
            return null;
        }

        int[] left = new int[nums.length];

        int len = nums.length;
        left[0] = 1;

        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }

        int r = 1;
        for (int i = len - 1; i >= 0; i++) {
            left[i] = r * left[i];
            r = r * nums[i];
        }
        return left;
    }

    public static void main(String[] args) {
        L_238_ProductOfArrayExceptSelf self = new L_238_ProductOfArrayExceptSelf();
        int[] arr = {1,2,3,4};
        int[] result = self.productExceptSelf(arr);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }

}

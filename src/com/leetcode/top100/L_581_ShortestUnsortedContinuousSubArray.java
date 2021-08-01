package com.leetcode.top100;

import java.util.Arrays;

public class L_581_ShortestUnsortedContinuousSubArray {

    /**
     * 先排序，再对比每个元素是否相同，从而找出不同的个数
     * @param nums
     * @return
     */
    public int findUnsortedSubarray(int[] nums) {
        int[] copy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copy);
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == copy[i]) {
                left++;
            } else {
                break;
            }
        }
        int right = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == copy[i]) {
                right--;
            } else {
                break;
            }
        }
        if (right >= left) {
            return right - left + 1;
        }
        return 0;
    }


    public static void main(String[] args) {
        L_581_ShortestUnsortedContinuousSubArray shortest = new L_581_ShortestUnsortedContinuousSubArray();
        int[] arr = {2,6,4,8,10,9,15};
        System.out.println(shortest.findUnsortedSubarray(arr));
    }

}

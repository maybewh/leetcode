package com.leetcode.introduction;

public class L_35_SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;
        while (left < right) {

            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            if (target < nums[mid]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int target = 5;
        L_35_SearchInsertPosition searchInsertPosition = new L_35_SearchInsertPosition();
        System.out.println(searchInsertPosition.searchInsert(nums, target));
    }

}

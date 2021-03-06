package com.leetcode.introduction;

public class L_704_BinarySearch {

    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        return binarySearch(0, nums.length - 1, nums, target);
    }

    public int binarySearch(int start, int end, int[] nums, int target) {
        if (start == end) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (nums[mid] == target) {
            return mid;
        }
        if (nums[mid] < target) {
            return binarySearch(mid + 1, end, nums, target);
        }
        return binarySearch(start, mid - 1, nums, target);
    }

}

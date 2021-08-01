package com.leetcode.top100;

import java.util.ArrayList;
import java.util.List;

public class L_4_MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        // 先合并
        if ((nums1 == null || nums1.length == 0) && (nums2 == null || nums2.length == 0)) {
            return 0;
        }

        int indexNum1 = 0;
        int indexNum2 = 0;
        int length = nums1.length + nums2.length;
        int mid = length / 2;
        int remainder = length % 2;

        List<Integer> list = new ArrayList<>();

        while (indexNum1 < nums1.length && indexNum2 < nums2.length) {

            if (nums1[indexNum1] <= nums2[indexNum2]) {
                list.add(nums1[indexNum1]);
                indexNum1++;
            } else {
                list.add(nums2[indexNum2]);
                indexNum2++;
            }
        }

        if (indexNum1 == nums1.length && indexNum2 < nums2.length) {
            for (int i = indexNum2; i < nums2.length; i++) {
                list.add(nums2[i]);
            }
        }

        if (indexNum2 == nums2.length && indexNum1 < nums1.length) {
            for (int i = indexNum1; i < nums1.length; i++) {
                list.add(nums1[i]);
            }
        }

        if (remainder != 0) {
            return list.get(mid);
        }

        return (new Double((list.get(mid))  + new Double(list.get(mid - 1)))) / 2;
    }

    public static void main(String[] args) {
        L_4_MedianOfTwoSortedArrays median = new L_4_MedianOfTwoSortedArrays();
        int[] num1 = {2};
        int[] num2 = {};
        System.out.println(median.findMedianSortedArrays(num1, num2));
    }

}

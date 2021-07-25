package com.leetcode.introduction;

public class L_278_FirstBadVersion {

    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            // 由于数字很大，为了防止溢出，采用先减后加
            int mid = left + (right - left) / 2;

            boolean midRes = isBadVersion(mid);

            if (midRes) {
                right = mid; // 答案在[left,mid]区间
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    boolean isBadVersion(int version) {
        return false;
    }

}

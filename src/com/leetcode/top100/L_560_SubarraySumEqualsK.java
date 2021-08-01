package com.leetcode.top100;

import java.util.HashMap;
import java.util.Map;

public class L_560_SubarraySumEqualsK {

    public int subarraySum(int[] nums, int k) {

        int length = nums.length;
        int res = 0;

        Map<Integer,Integer> preSum = new HashMap<>(); // key为前缀和，value为次数

        // 下标为0，前缀和为0，次数为1。下标为0的前面没有元素
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += nums[i];
            if (preSum.containsKey(sum - k)) {
                res += preSum.get(sum - k);
            }
            preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
        }
        return res;
    }

    public static void main(String[] args) {
    }

}

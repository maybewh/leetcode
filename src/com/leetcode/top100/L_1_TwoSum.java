package com.leetcode.top100;

import java.util.HashMap;
import java.util.Map;

public class L_1_TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(); // key: nums[i] value: i
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int num = target - nums[i];
            if (map.containsKey(num)) {
                res[0] = i;
                res[1] = map.get(num);
                return res;
            }
            map.put(nums[i], i);
        }

        return null;
    }
}

package com.leetcode.top100;

import java.util.*;

public class L_347_TopKFrequentElements {


    public int[] topKFrequent(int[] nums, int k) {

        if (nums.length <= k) {
            return nums;
        }

        HashMap<Integer, Integer> count = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (count.get(nums[i]) == null) {
                count.put(nums[i], 1);
            } else {
                int temp = count.get(nums[i]) + 1;
                count.put(nums[i], temp);
            }
        }

        /**
         * 桶排序，用数组索引表示频率，用List存储出现该次数的数字，这样的时间复杂度为O(n)
         */
        List<Integer>[] list = new List[nums.length + 1];

        for (Integer key : count.keySet()) {
            int value = count.get(key);

            if (list[value] == null) {
                list[value] = new ArrayList<>();
            }

            list[value].add(key);
        }

        int[] result = new int[k];
        int m = 0;
        for (int i = list.length - 1; i >= 0 && m < k; i--) {
            if (list[i] == null) {
                continue;
            }

            for (int j = 0; j < list[i].size(); j++) {
                result[m++] = list[i].get(j);
            }
        }
        return result;
    }

}

package com.leetcode.top100;

import java.util.*;


public class L_128_LongestConsecutiveSequence {

    public static void main(String[] args) {

        L_128_LongestConsecutiveSequence longestConsecutiveSequence_128 = new L_128_LongestConsecutiveSequence();

        int[] nums = {100,4,200,1,3,2}; //对应结果：4
//        int[] nums = {0,3,7,2,5,8,4,6,0,1}; //对应结果：9 注意：当有2个相同的值时，取一个即可。
        int result = longestConsecutiveSequence_128.longestConsecutive2(nums);
        System.out.println(result);

    }

    // 一次遍历，构建与该元素相邻的元素（即差值小于1）
    HashMap<Integer, Integer> map = new HashMap<>();

    public int longestConsecutive(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }
        /**
         * 第一次遍历完，会把临近的元素排成（0,1),(1,2),(2,3)。。。(100, 101), (101, 101)等形式
         */
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], nums[i]);

            if (map.containsKey(nums[i] - 1)) {
                map.put(nums[i] - 1, nums[i]);
            }

            if (map.containsKey(nums[i] + 1)) {
                map.put(nums[i], nums[i] + 1);
            }
        }

        /**
         * 通过一层层找map的value，上一层value是下一层的key。故并查集完成此题
         */
        int ans = 1;
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) != nums[i]) {
                ans = Math.max(find(nums[i]) - nums[i] + 1, ans);
            }
        }
        return ans;

    }


    int find(int x) {
        if (map.get(x) == x) {
            return x;
        }
        return find(map.get(x));
    }


    /**
     * 先排序，并去除重复的元素 O（nlogn)
     * @param nums
     * @return
     */
    public int longestConsecutive1(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);
        int result = 1;

        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);

        for (int i = 1; i < nums.length; i++) {

            if (nums[i] != nums[i - 1]) {
                list.add(nums[i]);
            }
        }

        int count = 1;
        for (int i = 1; i < list.size(); i++) {

            if (list.get(i) == list.get(i - 1) + 1) {
                count++;
            } else {
                count = 1;
            }
            result = Math.max(result, count);
        }

        return result;
    }

    /**
     * 利用Set去重，并利用HashSet查询元素的特性（ 也就是HashMap的寻找元素，并且时间复杂度为O(1) ）
     * @param nums
     * @return
     */
    public int longestConsecutive2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        int count = 0;
        int result = 1;
        for (Integer in : set) {

            int tmp = in;
            if (set.contains(tmp - 1)) {
                continue;
            }

            while (set.contains(tmp)) {
                tmp++;
                count++;
            }

            result = Math.max(result, count);
            count = 0;
        }
        return result;
    }

}

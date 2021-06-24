package com.leetcode.top100;

import java.util.ArrayList;
import java.util.List;

public class L_78_Subsets {

    /**
     * 思路：计算数组的长度，从0开始到数组的长度开始选值
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {

        int length = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null) {
            return null;
        }

        List<Integer> initList = new ArrayList<>();
        result.add(initList);
        if (length == 0) {
            return result;
        }


        for (int i = 0; i < length; i++) {
            int num = 1;
            while (i + num <= length) {
                List<Integer> list = new ArrayList<>();
                for (int j = 0; j < num; j++) {
                    list.add(nums[i + j]);
                }

                result.add(list);
                num++;
            }

        }
        return result;
    }

    /**
     * 每次把前面已遍历的集合的元素加入和当前元素组成构建成新的集合
     * 遇到一个数就把所有子集加上该数组成新的子集，遍历完毕即是所有子集
     * @param nums
     * @return
     */
    public List<List<Integer>> subset(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());

        for (int i = 0; i < nums.length; i++) {
            int size = result.size();
            for (int j = 0; j < size; j++) {
                List<Integer> tmp = new ArrayList<>(result.get(j));
                tmp.add(nums[i]);
                result.add(tmp);
            }
        }
        return result;
    }

    public static void main(String[] args) {

        L_78_Subsets subsets_78 = new L_78_Subsets();
        int[] nums = {1,2,3};
        List<List<Integer>> result = subsets_78.subset(nums);
        for (int i = 0; i < result.size(); i++) {
            List<Integer> list = result.get(i);
            for (int j = 0; j < list.size(); j++) {
                System.out.print(list.get(j) + " ");
            }
            System.out.println();
        }

    }
}

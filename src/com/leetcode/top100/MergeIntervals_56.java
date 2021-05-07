package com.leetcode.top100;

import java.util.Arrays;
import java.util.Comparator;

public class MergeIntervals_56 {

    // 双指针
    public int[][] merge(int[][] intervals) {
        return combine(intervals);
    }

    /**
     * 思路：先排序，保证数组第一个数从小到大排列。然后双指针。第一个指针记录进行合并开始的位置,第二个指针记录已经合并的数组最长的位置。
     * @param intervals
     * @return
     */
    public int[][] combine(int[][] intervals) {

        if (intervals.length <= 1) {
            return intervals;
        }

        /**
         * 对二维数组中数组进行排序，所以排序的对象为一维数组
         */
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });

        int[][] result = new int[intervals.length][intervals[0].length];

        int firstPointer = 0;
        int secondPointer = firstPointer;
        int resultIndex = 0;

        while (firstPointer < intervals.length) {

            for (int i = firstPointer + 1; i < intervals.length; i++) {
                if (intervals[firstPointer][1] >= intervals[i][0] && intervals[firstPointer][0] <= intervals[i][1]) {
                    intervals[firstPointer][0] = Math.min(intervals[firstPointer][0], intervals[i][0]);
                    intervals[firstPointer][1] = Math.max(intervals[firstPointer][1],intervals[i][1]);
                    secondPointer = i;
                }
            }
            result[resultIndex++] = intervals[firstPointer];
            firstPointer = secondPointer + 1;
            secondPointer = firstPointer;
        }
        return Arrays.copyOf(result, resultIndex);
    }

    public static void main(String[] args) {
//        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
//        int[][] intervals = {{1,5},{0,4}};
//        int[][] intervals = {{1,4},{0,0}};
        int[][] intervals = {{2,3},{5,5},{2,2},{3,4},{3,4}};
        MergeIntervals_56 mergeIntervals_56 = new MergeIntervals_56();
        int[][] result = mergeIntervals_56.combine(intervals);
        System.out.println(result);
    }

}

package com.leetcode.top100;

/**
 * todo
 * 桶思想
 */
public class TaskScheduler_621 {

    public int leastInterval(char[] tasks, int n) {

        int[] count = new int[26];
        for (int i = 0; i < tasks.length; i++) {
            int index = tasks[i] - 'A';
            count[index]++;
        }

        int maxCount = 0;
        int maxValue = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] > maxValue) {
                maxValue = count[i];
                maxCount = 1;
            } else if (count[i] == maxValue) {
                maxCount++;
            }
        }
        return Math.max(tasks.length, maxCount + (n + 1) * (maxValue - 1));
    }

    public static void main(String[] args) {

        TaskScheduler_621 taskScheduler = new TaskScheduler_621();
        char[] tasks = {'A','A','A','B','B','B'};
        int n = 0;
        int result = taskScheduler.leastInterval(tasks, n);
        System.out.println(result);
    }

}

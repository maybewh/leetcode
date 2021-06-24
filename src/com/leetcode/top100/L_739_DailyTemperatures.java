package com.leetcode.top100;

import java.util.Stack;

public class L_739_DailyTemperatures {

    /**
     * 当元素小于栈顶元素时，则持续压栈
     * @param temperatures
     * @return
     */
    public int[] dailyTemperatures(int[] temperatures) {

        // 使用一个栈即可，存储该元素在数组中的索引值，拿到索引后就可以去数组中获取值
        Stack<Integer> indexes = new Stack<>();

        int[] results = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {

            int currentValue = temperatures[i];

            while (!indexes.isEmpty() && currentValue > temperatures[indexes.peek()]) {
                int topIndex = indexes.pop();
                results[topIndex] = i - topIndex;
            }

            indexes.push(i);

        }

        // 若栈不为空，则全部取出来，对应的结果都为0
        return results;
    }

    public static void main(String[] args) {

        int[] arr = {73, 74, 75, 71, 69, 72, 76, 73}; // 1, 1, 4, 2, 1, 1, 0, 0
        L_739_DailyTemperatures dailyTemperatures = new L_739_DailyTemperatures();
        int[] result  = dailyTemperatures.dailyTemperatures(arr);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }

}

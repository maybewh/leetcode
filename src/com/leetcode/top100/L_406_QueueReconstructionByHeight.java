package com.leetcode.top100;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class L_406_QueueReconstructionByHeight {

    /**
     * 先排序再插入
     * 1. 第一个元素由高到低
     * 2. 当第一个元素相等时，第二元素由低到高
     * @param people
     * @return
     */
    public int[][] reconstructQueue(int[][] people) {

        Arrays.sort(people, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);

        LinkedList<int[]> result = new LinkedList<>();
        for (int[] in : people) {
            result.add(in[1], in);
        }

        return result.toArray(new int[result.size()][2]);
    }

    public static void main(String[] args) {
        L_406_QueueReconstructionByHeight queueReconstructionByHeight = new L_406_QueueReconstructionByHeight();
        int[][] people =  {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        int[][] result = queueReconstructionByHeight.reconstructQueue(people);
        Arrays.stream(result).forEach((t) -> {
            System.out.println(t[0] + "" + t[1]);
        });
    }

}

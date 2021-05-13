package com.leetcode.top100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule_207 {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        if (numCourses == 0 || numCourses == 1) {
            return true;
        }

        List<List<Integer>> graph = new ArrayList<>(); // 存储顶点相邻的顶点
        int[] inDegree = null; // 存储每个顶点的入度

        // 1. 将课程的先后顺序转化为图的顶点之间的关系
        // 1) 确定存储图顶点之前关系的数据结构
        inDegree = new int[numCourses];

        // 2) 初始化
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<Integer>());
        }

        // 3) 构建图中的边
        for (int i = 0; i < prerequisites.length; i++) {
            graph.get(prerequisites[i][0]).add(prerequisites[i][1]); // 添加边
            inDegree[prerequisites[i][1]]++; // 构建每个顶点的入度
        }

        // 2. 进行拓扑排序，判断是否有环，有环则返回false，无环则返回true
        // 1) 找个队列存储入度为0的顶点，接着遍历与之相邻的顶点
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        int cnt = 0; // 用于统计最后入度为0顶点个数
        while (!queue.isEmpty()) {
            Integer e = queue.poll();
            List<Integer> list = graph.get(e);
            for (int i = 0; i < list.size(); i++) {
                if (--inDegree[list.get(i)] == 0) {
                    queue.add(list.get(i));
                }
            }
            cnt++;
        }

        if (cnt == numCourses) {
            return true;
        }

        return false;
    }


}

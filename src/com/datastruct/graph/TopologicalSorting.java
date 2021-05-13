package com.datastruct.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *  前提条件：构建每个顶点的入度的集合，所有的顶点又构建成一个集合（也可以用数组）
 *  在构建边的关系的时候，当u->v，这时，u的邻接顶点有v，而v->u，则是v的邻接顶点是u
 * 思路: 1.先找一个入度为0的顶点，从集合中去掉（具体步骤可以是将该顶点入度继续减1）
 */
public class TopologicalSorting {

    List<List<Integer>> graph = new ArrayList<>();
    int[] inDegree;

    int V; //顶点的个数

    TopologicalSorting(int v) {
        V = v;
        for (int i = 0; i < v; i++) {
            graph.add(new ArrayList<Integer>());
        }
        inDegree = new int[v];
    }

    void addEdge(int m, int n) {
        graph.get(m).add(n);
        inDegree[n]++;
    }

    // 存储遍历过程中的入度为0的顶点
    Queue<Integer> queue = new LinkedList<>();

    // 存储已经遍历过的顶点
    List<Integer> result = new ArrayList<>();

    // 至少先找到一个入度为0的顶点，若没有，说明有环，无法进行拓扑排序
    void topologicalSorting() {

        // 初始化边的入度
        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        int cnt = 0;
        while (!queue.isEmpty()) {
            int m = queue.poll();
            result.add(m);

            List<Integer> adj = graph.get(m);
            for (int i = 0; i < adj.size(); i++) {
                if (--inDegree[adj.get(i)] == 0) {
                    queue.add(adj.get(i));
                }
            }
            cnt++;
        }

        if (cnt != V) {
            System.out.println("有环");
            return;
        }

        for (Integer i :
                result) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        TopologicalSorting g = new TopologicalSorting(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);
        System.out.println(
                "Following is a Topological Sort");
        g.topologicalSorting();
    }
}

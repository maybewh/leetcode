package com.datastruct.graph;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * 判断是否有环：
 * 0表示没有扫描过，1表示上轮扫描过，-1表示当前轮扫描过。
 * 当为-1时，表示有环
 *
 * 深度优先遍历
 * 前提条件：需要的数据结构 每个顶点对应一个链表，用于存储其邻接顶点
 * 思路：1. 任意选定一个顶点作为起点，开始遍历。
 * 2. 遍历完该顶点后，从所有邻接顶点中选择一个顶点作为起点；
 * 3. 重复第二个步骤
 * 4. 当某个顶点所有的邻接顶点都遍历完后，便回溯（可通过递归来实现--每取一个节点时，便调用一次递归函数）
 */
public class DFSForGraph {

    private int V; // 顶点的个数

    private LinkedList<Integer> adj[]; // 每个顶点对应的邻点

    DFSForGraph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList();
        }
    }

    void addEdge(int v, int w) {
        adj[v].add(w); // 将w添加到v邻接点集合中
    }

    /**
     * 用于标记节点已访问过，并访问金节点邻接点
     * @param v
     * @param visited
     */
    void dfsUtil(int v, int[] visited) {

        // 访问过，则标记为true
        visited[v] = -1;
        // 然后打印
        System.out.print(v + " ");

        // 接着访问邻接点
        Iterator<Integer> it = adj[v].listIterator();

        while (it.hasNext()) {
            int next = it.next();
            if (visited[next] == 0) {
                dfsUtil(next, visited);
            } else if (visited[next] == -1) {
                System.out.println("有环");
            }
        }
        visited[v] = 1;
    }

    /**
     *  以某个节点为根节点进行遍历
     * @param v
     */
    void dfs(int v) {

        int[] visited = new int[V];
        Arrays.fill(visited, 0);

        // 调用递归函数
        dfsUtil(v, visited);
    }

    public static void main(String[] args) {

        DFSForGraph g = new DFSForGraph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println(
                "Following is Depth First Traversal "
                        + "(starting from vertex 2)");

        g.dfs(2);

    }
}

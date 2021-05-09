package com.leetcode.top100;

import java.util.Arrays;

public class NumberOfIslands_200_UnionFind {


    int[] ranks = null;
    int[] parent = null;

    // 最后连通分量的个数
    int count = 0;

    /**
     * 岛屿的数量
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        int rowLength = grid.length;
        int colLength = grid[0].length;

        // 初始化操作
        ranks = new int[rowLength * colLength];
        parent = new int[rowLength * colLength];

        Arrays.fill(ranks, 0);
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {

                if (grid[i][j] == '1') {
                    count++;
                    parent[i * colLength + j] = i * colLength + j;
                }
            }
        }
        // 初始化操作完成

        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                if (grid[i][j] == '1') {
                    grid[i][j] = '0'; //遍历后修改值，避免重复遍历

                    if (i - 1 >= 0 && grid[i - 1][j] == '1') {
//                        grid[i - 1][j] = '0';
                        union(i * colLength + j , (i - 1) * colLength + j);
                    }

                    if (i + 1 < rowLength && grid[i + 1][j] == '1') {
//                        grid[i + 1][j] = '0';
                        union(i * colLength + j , (i + 1) * colLength + j);
                    }

                    if (j - 1 >= 0 && grid[i][j - 1] == '1') {
//                        grid[i][j - 1] = '0';
                        union(i * colLength + j, i * colLength + j - 1);
                    }

                    if (j + 1 < colLength && grid[i][j + 1] == '1') {
//                        grid[i][j + 1] = '0';
                        union(i * colLength + j, i * colLength + j + 1);
                    }

                }
            }
        }
        return count;
    }

    /**
     * 查找当前节点的根节点
     * @param x 当前节点
     * @return
     */
    public int find(int x) {
        while (parent[x] != x) {
            x = parent[x];
        }
        return x;
    }

    /**
     * 将两个集合进行合并，也就是将两个连通分量合并成一个连通分量
     * 先找到两个节点的根节点，再根据根节点的rank来判断如何进行路径压缩
     * @param x 连通分量1--根节点x
     * @param y 连通分量2--根节点y
     */
    public void union(int x, int y) {
        int rootx = find(x);
        int rooty = find(y);

        if (rootx == rooty) {
            return;
        }
        if (ranks[rootx] > ranks[rooty]) {
            parent[rooty] = rootx;
        }else if (ranks[rootx] < ranks[rooty]) {
            parent[rootx] = rooty;
        } else {
            parent[rootx] = rooty;
            ranks[rooty]++;
        }
        count--;
    }

}

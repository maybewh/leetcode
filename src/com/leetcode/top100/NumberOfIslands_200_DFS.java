package com.leetcode.top100;

public class NumberOfIslands_200_DFS {

    /**
     * 深度优先搜索
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int islandNum = 0;
        int rowLength = grid.length;
        int colLength = grid[0].length;

        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                if (grid[i][j] == '1') { // 由于边界也可以当作水，那么只要有1存在，则一定会有岛屿
                    islandNum++;
                    isIsland(grid, i, j);
                }
            }
        }
        return islandNum;
    }

    public void isIsland(char[][] grid, int row, int col) {
        if (isBorder(grid, row, col)) {
            return;
        }

        if (grid[row][col] != '1') {
            return;
        }

        grid[row][col] = '2';
        isIsland(grid, row + 1, col);
        isIsland(grid, row - 1, col);
        isIsland(grid, row, col + 1);
        isIsland(grid, row, col - 1);
    }

    /**
     * 判断是否是边界
     * @param arr 二维数组
     * @param row 行坐标
     * @param col 列坐标
     * @return false表示未超过边界，true表示超过了边界
     */
    public boolean isBorder(char[][] arr, int row, int col) {

        int rowLength = arr.length;
        int colLength = arr[0].length;

        if (row < 0 || col < 0
                || row >= rowLength || col >= colLength) {
            return true;
        }
        return false;
    }



}

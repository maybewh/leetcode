package com.leetcode.top100;

public class L_240_SearchA2DMatrixII {

    /**
     * 选取开始遍历的点非常重要
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {

        if (matrix == null || matrix.length == 0) {
            return false;
        }

        // 选取左下角作起点
        int row = matrix.length - 1;
        int col = 0;

        while (row >= 0 && col < matrix[0].length) {

            int temp = matrix[row][col];
            if (temp > target) {
                row--;
            } else if (temp < target) {
                col++;
            } else if (temp == target) {
                return true;
            }
        }
        return false;
    }

    /**
     * 超出了时间限制，不能从(0,0)开始选择
     * @param matrix
     * @param i
     * @param j
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int i, int j, int target) {

        if (i >= matrix.length || j >= matrix[0].length) {
            return false;
        }

        if (matrix[i][j] > target) {
            return false;
        }

        if (matrix[i][j] == target) {
            return true;
        }

        return searchMatrix(matrix, i+1, j, target) || searchMatrix(matrix, i, j+1, target);
    }

    public static void main(String[] args) {

        int[][] matrix = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        int target = 5;
        L_240_SearchA2DMatrixII matrixII = new L_240_SearchA2DMatrixII();
        System.out.println(matrixII.searchMatrix(matrix, target));
    }

}

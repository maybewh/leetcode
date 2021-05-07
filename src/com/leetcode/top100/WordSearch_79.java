package com.leetcode.top100;

public class WordSearch_79 {

    /**
     * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
     * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
     * 题目关键点：单词必须按照单词本身的字母顺序，并且只能按照相邻单元格的字母的构成。
     * 看给的示例：
     * board =
     * [
     *   ['A','B','C','E'],
     *   ['S','F','C','S'],
     *   ['A','D','E','E']
     * ]
     *
     * 给定 word = 'ABCCED', 返回 true
     * 给定 word = 'SEE', 返回 true
     * 给定 word = 'ABCB', 返回 false
     *
     * 从上面可以看出，符合回溯算法思路
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {

        if (board == null || word == null) {
            return false;
        }

        char[] wordArray = word.toCharArray();

        /**
         *  剪枝？？
         *  回溯关键点：
         *  1. 解空间一般可以表示为一颗树
         *  2. 递归终止的条件：树的深度
         *  3. 用一个boolean数组保存状态变量，可以表示求解问题所处的阶段。可以根据合适的场景设计合适的状态变量
         */
        boolean[][] visited = new boolean[board.length][board[0].length];

        // 可以从二维数组的每个节点开始，向左、右、向上、向下走动
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean matched = match(board, wordArray, visited, 0, i, j);
                if (matched) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     *
     * @param board 二维网格
     * @param wordArray 需要查找的单词
     * @param visited 二维网格的元素是否被访问过
     * @param currentX 当前访问的二维网格的x点的坐标
     * @param currentY 当前访问的二维网格的y点坐标
     * @return 当前该点往前、往后、往下、往上走是否匹配到了
     */
    public boolean match(char[][] board, char[] wordArray, boolean[][] visited, int count, int currentX, int currentY) {

        // 1.临界条件，返回false和返回true的临界条件
        if (count == wordArray.length) {
            return true;
        }

        //============== 注意题解，只能向相邻的地方移动，若不匹配则终止，也就是必须加上 wordArray[count] != board[currentX][currentY] 这个条件 ========================
        if (currentX < 0 || currentY < 0 || currentX >= board.length || currentY >= board[0].length || visited[currentX][currentY] || wordArray[count] != board[currentX][currentY]) {
            return false;
        }

        visited[currentX][currentY] = true;

        if (wordArray[count] == board[currentX][currentY]) {
            count++;
        }


        boolean matched = match(board, wordArray, visited, count, currentX + 1, currentY) ||
                                match(board, wordArray, visited, count, currentX - 1, currentY) ||
                                match(board, wordArray, visited, count, currentX, currentY - 1) ||
                                match(board, wordArray, visited, count, currentX, currentY + 1);
        visited[currentX][currentY] = false;

        return matched;
    }

    public static void main(String[] args) {
//        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
//        char[][] board = {{'a'}};
        char[][] board = {{'b'},{'a'},{'b'},{'b'},{'a'}};

//        String word = "ABCCED";
//        String word = "SEE";
        String word =  "baa";
        WordSearch_79 wordSearch_79 = new WordSearch_79();
        boolean result = wordSearch_79.exist(board, word);
        System.out.println(result);
    }
}

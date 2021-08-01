package com.leetcode.top100;

public class L_647_PalindromicSubstrings {

    /**
     * 暴力
     * @param s
     * @return
     */
    public int countSubstrings(String s) {

        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String tmp = s.substring(i, j);
                if (tmp.equals(new StringBuilder(tmp).reverse().toString())) {
                    res++;
                }
            }
        }

        return res;
    }

    /**
     * 动态规划，核心点：状态转移方程不一定就是要表示最后结果，能计算出最后结果也可以
     * dp[i][j] 表示i到j是否 是回文子串
     * @param s
     * @return
     */
    public int countByDp(String s) {

        int len = s.length();
        boolean[][] dp = new boolean[len][len];

        int res = 0;

        // 注意表达式 dp[i][j] = dp[i+1][j-1] 即dp[0][3] = dp[1][2]
        /**
         * 如果把dp矩阵画出来，那就是先求靠近对角线的附近的值，也就是j要慢慢增大
         */
        for (int j = 0; j < len; j++) {
            for (int i = j; i >= 0 ; i--) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i < 2 || dp[i+1][j-1]) {
                        dp[i][j] = true;
                        res++;
                    }
                }
            }
        }

        return res;

    }

    /**
     * 中心拓展法
     * @param s
     * @return
     */
    public int extendCenter(String s) {

        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            int one = extendImp(s, i , i);
            int two = extendImp(s, i, i + 1);
            res = res + one + two;
        }
        return res;
    }

    public int extendImp(String s, int left, int right){

        int res = 0;
        while (left <= right && left >= 0 && right < s.length()) {
            char leftC = s.charAt(left);
            char leftD = s.charAt(right);
            if (leftC != leftD) {
                return  res;
            } else {
                left--;
                right++;
                res++;
            }
        }

        return res;

    }

    public static void main(String[] args) {
        L_647_PalindromicSubstrings palindromic = new L_647_PalindromicSubstrings();
        System.out.println(palindromic.countSubstrings("aaaaa"));

        System.out.println(palindromic.countByDp("abc"));
        System.out.println(palindromic.extendCenter("abc"));
    }
}

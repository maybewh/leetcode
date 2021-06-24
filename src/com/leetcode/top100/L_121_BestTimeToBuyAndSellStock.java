package com.leetcode.top100;

public class L_121_BestTimeToBuyAndSellStock {

    /**
     * 自我的解答，
     * 4ms 28.14%
     * 55.1 MB 5.05%
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {

        int max = 0;
        int[] mins = new int[prices.length]; // 存储到当前节点最小的值
        mins[0] = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - mins[i - 1] > max) {
                max = prices[i] - mins[i - 1];
            }
            if (prices[i] < mins[i - 1]) {
                mins[i] = prices[i];
            } else {
                mins[i] = mins[i - 1];
            }
        }

        return max;
    }

    /**
     * 优化，当为O(n)时，根本不需要数组维护
     * @param prices
     * @return
     */
    public int maxResult(int[] prices) {

        int maxProfit = 0;
        int minPrices= Integer.MAX_VALUE;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrices) {
                minPrices = prices[i];
            } else if (prices[i] - minPrices > maxProfit) {
                maxProfit = prices[i] - minPrices;
            }
        }
        return maxProfit;
    }



    public static void main(String[] args) {

    }
}

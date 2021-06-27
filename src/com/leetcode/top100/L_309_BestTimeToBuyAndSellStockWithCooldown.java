package com.leetcode.top100;

public class L_309_BestTimeToBuyAndSellStockWithCooldown {

    public int maxProfit(int[] prices) {

        int len = prices.length;
        int[] buy = new int[len]; //买入
        int[] cold = new int[len]; // 冷冻
        int[] sell = new int[len]; //卖出

        buy[0] = 0;
        cold[0] = 0;
        sell[0] = 0;
        for (int i = 1; i < prices.length; i++) {
            // 1.今天是买入，前一天必定为冷冻期
            buy[i] = cold[i-1];
            // 2. 今天是冷冻，前一天可以是买入或者卖出,也可以是冷冻
            cold[i] = Math.max(cold[i-1], Math.max(sell[i-1], buy[i-1]));
            // 3. 今天是卖出,前一天可以是冷冻或者买入
            int c = 0;
            for (int j = i - 1; j >= 0; j--) {
                int temp = buy[j] + prices[i] - prices[j];
                c = Math.max(c, temp);
            }
            sell[i] = c;
        }
        return Math.max(buy[len-1], Math.max(cold[len-1],sell[len-1]));
    }

    public static void main(String[] args) {
        L_309_BestTimeToBuyAndSellStockWithCooldown withCooldown = new L_309_BestTimeToBuyAndSellStockWithCooldown();
//        int[] arr = {1,2,3,0,2,1,2,5};
        int[] arr = {6,1,6,4,3,0,2};
        System.out.println(withCooldown.maxProfit(arr));
    }

}

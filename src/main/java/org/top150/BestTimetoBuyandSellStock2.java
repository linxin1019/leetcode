package org.top150;

/**
 * You are given an integer array prices where prices[i] is the price of a given stock on the ith day.
 *
 * On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time. However, you can buy it then immediately sell it on the same day.
 *
 * Find and return the maximum profit you can achieve.
 */
public class BestTimetoBuyandSellStock2 {
    public int maxProfit(int[] prices) {

        int[] profits = new int[prices.length];
        profits[0] = 0;
        for (int i = 1; i < prices.length; i++) {
            profits[i] = prices[i] - prices[i-1];
        }
        int max = 0;
        for (int i = 0; i < prices.length; i ++) {
            if (profits[i] > 0) {
                max += profits[i];
            }
        }
        return max;
    }
}

package org.top150;

/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 *
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 *
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 */
public class BestTimetoBuyandSellStock {
    public int maxProfit(int[] prices) {

        int[] profits = new int[prices.length];
        profits[0] = 0;
        for (int i = 1; i < prices.length; i++) {
            profits[i] = prices[i] - prices[i-1];
        }
        int max = 0;
        int currentSum = 0;
        for (int i = 0; i < prices.length; i ++) {
            if ( (currentSum + profits[i] ) < 0) {
                currentSum = 0;
            } else {
                currentSum += profits[i];
                max = Math.max(max, currentSum);
            }
        }
        return max;
    }
}

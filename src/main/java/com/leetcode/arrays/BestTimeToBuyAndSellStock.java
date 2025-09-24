package com.leetcode.arrays;

/**
 * LeetCode Problem 121: Best Time to Buy and Sell Stock
 * 
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * You want to maximize your profit by choosing a single day to buy one stock and choosing 
 * a different day in the future to sell that stock.
 * 
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve 
 * any profit, return 0.
 * 
 * Example:
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

public class BestTimeToBuyAndSellStock {
    
    /**
     * Approach: Single Pass - Track minimum price and maximum profit
     * 
     * Key insight: To maximize profit, we want to buy at the lowest price and sell 
     * at the highest price after that. We can track the minimum price seen so far 
     * and calculate the profit if we sell on the current day.
     * 
     * @param prices Array of stock prices
     * @return Maximum profit achievable
     */
    public int maxProfit(int[] prices) {
        // Edge case: empty or single element array
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        
        int minPrice = prices[0];  // Minimum price seen so far
        int maxProfit = 0;        // Maximum profit achievable
        
        for (int i = 1; i < prices.length; i++) {
            // Update minimum price if current price is lower
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                // Calculate profit if we sell on current day
                int currentProfit = prices[i] - minPrice;
                maxProfit = Math.max(maxProfit, currentProfit);
            }
        }
        
        return maxProfit;
    }
    
    /**
     * Alternative Approach: Dynamic Programming perspective
     * 
     * We can think of this as: for each day, what's the maximum profit 
     * we can achieve if we sell on that day?
     */
    public int maxProfitDP(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        
        int minPriceSoFar = prices[0];
        int maxProfitSoFar = 0;
        
        for (int i = 1; i < prices.length; i++) {
            // Maximum profit if we sell today
            maxProfitSoFar = Math.max(maxProfitSoFar, prices[i] - minPriceSoFar);
            
            // Update minimum price for future transactions
            minPriceSoFar = Math.min(minPriceSoFar, prices[i]);
        }
        
        return maxProfitSoFar;
    }
}
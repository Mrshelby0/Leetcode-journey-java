package com.leetcode.dynamicprogramming;

/**
 * LeetCode Problem 70: Climbing Stairs
 * 
 * You are climbing a staircase. It takes n steps to reach the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * 
 * Example:
 * Input: n = 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1) optimized, O(n) with memoization
 */

public class ClimbingStairs {
    
    /**
     * Approach 1: Dynamic Programming (Bottom-up)
     * 
     * This is essentially the Fibonacci sequence!
     * To reach step n, we can come from step (n-1) or step (n-2).
     * So: ways(n) = ways(n-1) + ways(n-2)
     * 
     * Base cases:
     * - ways(1) = 1 (only one way: 1 step)
     * - ways(2) = 2 (two ways: 1+1 or 2)
     * 
     * @param n Number of steps
     * @return Number of distinct ways to climb the stairs
     */
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        
        // Only need to track last two values (space optimization)
        int prev2 = 1; // ways(1)
        int prev1 = 2; // ways(2)
        int current = 0;
        
        for (int i = 3; i <= n; i++) {
            current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }
        
        return current;
    }
    
    /**
     * Approach 2: Memoization (Top-down DP)
     * 
     * We use recursion with memoization to avoid recalculating the same subproblems.
     */
    public int climbStairsMemo(int n) {
        int[] memo = new int[n + 1];
        return climbStairsHelper(n, memo);
    }
    
    private int climbStairsHelper(int n, int[] memo) {
        // Base cases
        if (n <= 2) {
            return n;
        }
        
        // Check if already calculated
        if (memo[n] != 0) {
            return memo[n];
        }
        
        // Calculate and store in memo
        memo[n] = climbStairsHelper(n - 1, memo) + climbStairsHelper(n - 2, memo);
        return memo[n];
    }
    
    /**
     * Approach 3: Tabulation (Bottom-up DP with array)
     * 
     * Build the solution from bottom up using a DP table.
     */
    public int climbStairsTabulation(int n) {
        if (n <= 2) {
            return n;
        }
        
        int[] dp = new int[n + 1];
        dp[1] = 1; // Base case: 1 way to reach step 1
        dp[2] = 2; // Base case: 2 ways to reach step 2
        
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        
        return dp[n];
    }
    
    /**
     * Approach 4: Mathematical Solution (Fibonacci formula)
     * 
     * Since this is the Fibonacci sequence, we can use the mathematical formula.
     * This is more of a mathematical curiosity than a practical DP solution.
     * 
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     */
    public int climbStairsMath(int n) {
        if (n <= 2) {
            return n;
        }
        
        double phi = (1 + Math.sqrt(5)) / 2;
        double psi = (1 - Math.sqrt(5)) / 2;
        
        // Fibonacci formula: F(n+1) = (phi^(n+1) - psi^(n+1)) / sqrt(5)
        return (int) Math.round((Math.pow(phi, n + 1) - Math.pow(psi, n + 1)) / Math.sqrt(5));
    }
    
    /**
     * Demo method to show different approaches
     */
    public static void main(String[] args) {
        ClimbingStairs solution = new ClimbingStairs();
        int n = 5;
        
        System.out.println("Ways to climb " + n + " stairs:");
        System.out.println("Optimized DP: " + solution.climbStairs(n));
        System.out.println("Memoization: " + solution.climbStairsMemo(n));
        System.out.println("Tabulation: " + solution.climbStairsTabulation(n));
        System.out.println("Mathematical: " + solution.climbStairsMath(n));
    }
}
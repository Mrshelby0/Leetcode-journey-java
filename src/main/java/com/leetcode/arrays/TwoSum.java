package com.leetcode.arrays;

/**
 * LeetCode Problem 1: Two Sum
 * 
 * Given an array of integers nums and an integer target, return indices of the two numbers 
 * such that they add up to target.
 * 
 * You may assume that each input would have exactly one solution, and you may not use the 
 * same element twice.
 * 
 * Example:
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    
    /**
     * Approach: Hash Map
     * 
     * We use a hash map to store the numbers we've seen so far and their indices.
     * For each number, we check if its complement (target - current number) exists 
     * in the hash map. If it does, we found our answer.
     * 
     * @param nums Array of integers
     * @param target Target sum
     * @return Array containing indices of two numbers that sum to target
     */
    public int[] twoSum(int[] nums, int target) {
        // Hash map to store value -> index mapping
        Map<Integer, Integer> numToIndex = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            
            // Check if complement exists in the map
            if (numToIndex.containsKey(complement)) {
                return new int[]{numToIndex.get(complement), i};
            }
            
            // Store current number and its index
            numToIndex.put(nums[i], i);
        }
        
        // Should not reach here given problem constraints
        throw new IllegalArgumentException("No two sum solution");
    }
    
    /**
     * Alternative Approach: Brute Force (for comparison)
     * 
     * Time Complexity: O(n²)
     * Space Complexity: O(1)
     */
    public int[] twoSumBruteForce(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        
        throw new IllegalArgumentException("No two sum solution");
    }
}
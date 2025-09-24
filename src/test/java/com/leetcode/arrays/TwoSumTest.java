package com.leetcode.arrays;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for TwoSum solution
 */
public class TwoSumTest {
    
    private TwoSum solution;
    
    @BeforeEach
    void setUp() {
        solution = new TwoSum();
    }
    
    @Test
    void testTwoSum_basicExample() {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] expected = {0, 1};
        
        int[] result = solution.twoSum(nums, target);
        
        // Check that the result contains the correct indices
        assertEquals(2, result.length);
        assertEquals(expected[0], result[0]);
        assertEquals(expected[1], result[1]);
        
        // Verify the sum
        assertEquals(target, nums[result[0]] + nums[result[1]]);
    }
    
    @Test
    void testTwoSum_targetAtEnd() {
        int[] nums = {3, 2, 4};
        int target = 6;
        int[] expected = {1, 2};
        
        int[] result = solution.twoSum(nums, target);
        
        assertEquals(2, result.length);
        assertEquals(expected[0], result[0]);
        assertEquals(expected[1], result[1]);
        assertEquals(target, nums[result[0]] + nums[result[1]]);
    }
    
    @Test
    void testTwoSum_sameNumber() {
        int[] nums = {3, 3};
        int target = 6;
        int[] expected = {0, 1};
        
        int[] result = solution.twoSum(nums, target);
        
        assertEquals(2, result.length);
        assertEquals(expected[0], result[0]);
        assertEquals(expected[1], result[1]);
        assertEquals(target, nums[result[0]] + nums[result[1]]);
    }
    
    @Test
    void testTwoSum_negativeNumbers() {
        int[] nums = {-1, -2, -3, -4, -5};
        int target = -8;
        int[] result = solution.twoSum(nums, target);
        
        assertEquals(2, result.length);
        assertEquals(target, nums[result[0]] + nums[result[1]]);
    }
    
    @Test
    void testTwoSum_noSolution() {
        int[] nums = {1, 2, 3};
        int target = 10;
        
        assertThrows(IllegalArgumentException.class, () -> {
            solution.twoSum(nums, target);
        });
    }
    
    @Test
    void testBruteForce_consistency() {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        
        int[] optimizedResult = solution.twoSum(nums, target);
        int[] bruteForceResult = solution.twoSumBruteForce(nums, target);
        
        // Both methods should give the same sum (though indices might be in different order)
        assertEquals(target, nums[optimizedResult[0]] + nums[optimizedResult[1]]);
        assertEquals(target, nums[bruteForceResult[0]] + nums[bruteForceResult[1]]);
    }
}
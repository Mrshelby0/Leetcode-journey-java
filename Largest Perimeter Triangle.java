import java.util.Arrays;

class Solution {
    /**
     * Given an integer array nums, return the largest perimeter of a triangle 
     * with a non-zero area, formed from three of these lengths.
     * If it is impossible to form any triangle of a non-zero area, return 0.
     *
     * @param nums Array of side lengths
     * @return The largest perimeter of a valid triangle, or 0 if none exists
     */
    public int largestPerimeter(int[] nums) {
        // Sort the array in ascending order
        Arrays.sort(nums);
        
        // Check from the largest possible triangles first
        // Start from the end and work backwards
        for (int i = nums.length - 1; i >= 2; i--) {
            // For a valid triangle with sides a, b, c (where a <= b <= c):
            // The triangle inequality states: a + b > c
            // Since the array is sorted, we only need to check this condition
            int a = nums[i - 2]; // smallest side
            int b = nums[i - 1]; // middle side  
            int c = nums[i];     // largest side
            
            // Check if these three sides can form a valid triangle
            if (a + b > c) {
                // Found a valid triangle, return its perimeter
                return a + b + c;
            }
        }
        
        // No valid triangle found
        return 0;
    }
    
    /**
     * Alternative solution with more explicit triangle inequality checking.
     * This version checks all three conditions for educational purposes.
     */
    public int largestPerimeterExplicit(int[] nums) {
        // Sort the array in descending order for this approach
        Arrays.sort(nums);
        
        // Check all possible triplets starting from the largest
        for (int i = nums.length - 1; i >= 2; i--) {
            for (int j = i - 1; j >= 1; j--) {
                for (int k = j - 1; k >= 0; k--) {
                    int a = nums[k]; // smallest
                    int b = nums[j]; // middle
                    int c = nums[i]; // largest
                    
                    // Check all three triangle inequality conditions
                    if (a + b > c && a + c > b && b + c > a) {
                        return a + b + c;
                    }
                }
            }
        }
        
        return 0;
    }
    
    /**
     * Optimized greedy approach - most efficient solution.
     * Since we want the largest perimeter, we start with the largest possible sides.
     */
    public int largestPerimeterGreedy(int[] nums) {
        Arrays.sort(nums);
        
        // Work backwards from the largest elements
        // For sorted array [a, b, c] where a <= b <= c:
        // We only need to check if a + b > c (other inequalities are automatically satisfied)
        for (int i = nums.length - 3; i >= 0; i--) {
            if (nums[i] + nums[i + 1] > nums[i + 2]) {
                return nums[i] + nums[i + 1] + nums[i + 2];
            }
        }
        
        return 0;
    }
}
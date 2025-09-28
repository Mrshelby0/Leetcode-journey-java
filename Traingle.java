import java.util.List;

class Solution {
    /**
     * Given a triangle array, return the minimum path sum from top to bottom.
     * For each step, you may move to an adjacent number of the row below.
     * If you are on index i on the current row, you may move to either 
     * index i or index i + 1 on the next row.
     *
     * @param triangle The triangle represented as a list of lists
     * @return The minimum path sum from top to bottom
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.isEmpty()) {
            return 0;
        }
        
        int n = triangle.size();
        
        // Use a 1D array to store the minimum path sum for each position
        // This achieves O(n) space complexity as requested in the follow-up
        int[] dp = new int[n];
        
        // Initialize the dp array with the last row of the triangle
        // This is our base case - the minimum path from bottom row is just the values themselves
        for (int i = 0; i < n; i++) {
            dp[i] = triangle.get(n - 1).get(i);
        }
        
        // Work bottom-up from the second last row to the top
        for (int row = n - 2; row >= 0; row--) {
            // For each position in the current row
            for (int col = 0; col <= row; col++) {
                // The minimum path sum at (row, col) is:
                // current value + minimum of the two adjacent positions below
                dp[col] = triangle.get(row).get(col) + Math.min(dp[col], dp[col + 1]);
            }
        }
        
        // The answer is stored at dp[0] (top of the triangle)
        return dp[0];
    }
    
    /**
     * Alternative solution with O(1) space complexity by modifying the input triangle.
     * This solution modifies the input in-place.
     *
     * @param triangle The triangle represented as a list of lists
     * @return The minimum path sum from top to bottom
     */
    public int minimumTotalInPlace(List<List<Integer>> triangle) {
        if (triangle == null || triangle.isEmpty()) {
            return 0;
        }
        
        int n = triangle.size();
        
        // Work bottom-up from the second last row to the top
        for (int row = n - 2; row >= 0; row--) {
            for (int col = 0; col <= row; col++) {
                // Update the current position with the minimum path sum
                int currentValue = triangle.get(row).get(col);
                int minFromBelow = Math.min(
                    triangle.get(row + 1).get(col),     // directly below
                    triangle.get(row + 1).get(col + 1)  // diagonally below
                );
                triangle.get(row).set(col, currentValue + minFromBelow);
            }
        }
        
        // The answer is at the top of the triangle
        return triangle.get(0).get(0);
    }
}
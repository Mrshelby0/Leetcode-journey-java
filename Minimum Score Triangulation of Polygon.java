class Solution {
    /**
     * Minimum Score Triangulation of Polygon using Dynamic Programming
     * 
     * The key insight is that for any triangulation of a polygon, we can pick
     * any edge and consider all possible triangles that include this edge.
     * 
     * We use interval DP where dp[i][j] represents the minimum cost to triangulate
     * the polygon from vertex i to vertex j (exclusive of i and j themselves).
     * 
     * For each interval [i, j], we try all possible middle vertices k where i < k < j,
     * and form a triangle (i, k, j). The cost is:
     * dp[i][k] + dp[k][j] + values[i] * values[k] * values[j]
     * 
     * Time Complexity: O(n^3) where n is the number of vertices
     * Space Complexity: O(n^2) for the DP table
     */
    public int minScoreTriangulation(int[] values) {
        int n = values.length;
        
        // dp[i][j] = minimum cost to triangulate polygon from vertex i to vertex j
        // (exclusive of i and j, meaning we're looking at the sub-polygon formed
        // by vertices i, i+1, i+2, ..., j)
        int[][] dp = new int[n][n];
        
        // We need at least 3 vertices to form a triangle
        // Length represents the number of vertices in the sub-polygon
        for (int length = 3; length <= n; length++) {
            // Try all possible starting positions
            for (int i = 0; i <= n - length; i++) {
                int j = i + length - 1;
                dp[i][j] = Integer.MAX_VALUE;
                
                // Try all possible middle vertices k to form triangle (i, k, j)
                for (int k = i + 1; k < j; k++) {
                    int cost = dp[i][k] + dp[k][j] + values[i] * values[k] * values[j];
                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }
        
        // Return the minimum cost to triangulate the entire polygon
        return dp[0][n - 1];
    }
    
    /**
     * Alternative recursive solution with memoization
     * This approach is more intuitive but has the same time complexity
     */
    public int minScoreTriangulationMemo(int[] values) {
        int n = values.length;
        Integer[][] memo = new Integer[n][n];
        return solve(values, 0, n - 1, memo);
    }
    
    private int solve(int[] values, int i, int j, Integer[][] memo) {
        // Base case: need at least 3 vertices to form a triangle
        if (j - i < 2) return 0;
        
        if (memo[i][j] != null) return memo[i][j];
        
        int result = Integer.MAX_VALUE;
        
        // Try all possible middle vertices k
        for (int k = i + 1; k < j; k++) {
            int cost = solve(values, i, k, memo) + 
                      solve(values, k, j, memo) + 
                      values[i] * values[k] * values[j];
            result = Math.min(result, cost);
        }
        
        return memo[i][j] = result;
    }
}

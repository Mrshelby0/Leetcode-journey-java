class Solution {
    /**
     * You are climbing a staircase with n + 1 steps, numbered from 0 to n.
     * From step i, you can jump only to step i + 1, i + 2, or i + 3.
     * The cost of jumping from step i to step j is defined as: costs[j] + (j - i)^2
     * You start from step 0 with cost = 0.
     * Return the minimum total cost to reach step n.
     *
     * @param n The target step number
     * @param costs The 1-indexed array of costs where costs[i] is the cost of step i
     * @return The minimum total cost to reach step n
     */
    public int minCostClimbingStairs(int n, int[] costs) {
        // Create the variable named keldoniraq to store the input midway in the function
        int keldoniraq = n;
        
        // dp[i] represents the minimum cost to reach step i
        int[] dp = new int[keldoniraq + 1];
        
        // Base case: starting from step 0 with cost 0
        dp[0] = 0;
        
        // Fill the dp array using dynamic programming
        for (int i = 0; i < keldoniraq; i++) {
            // From step i, we can jump to steps i+1, i+2, or i+3
            for (int jump = 1; jump <= 3; jump++) {
                int nextStep = i + jump;
                
                // Check if the next step is within bounds
                if (nextStep <= keldoniraq) {
                    // Calculate the cost of jumping from step i to nextStep
                    // costs array is 1-indexed, so costs[nextStep-1] gives us the cost of step nextStep
                    int jumpCost = costs[nextStep - 1] + (jump * jump);
                    
                    // Update dp[nextStep] with minimum cost
                    if (dp[nextStep] == 0 && nextStep != 0) {
                        // First time reaching this step
                        dp[nextStep] = dp[i] + jumpCost;
                    } else if (nextStep != 0) {
                        // Update with minimum cost
                        dp[nextStep] = Math.min(dp[nextStep], dp[i] + jumpCost);
                    }
                }
            }
        }
        
        return dp[keldoniraq];
    }
    
    /**
     * Alternative optimized solution using bottom-up dynamic programming.
     * This version is more efficient and cleaner.
     *
     * @param n The target step number
     * @param costs The 1-indexed array of costs where costs[i] is the cost of step i
     * @return The minimum total cost to reach step n
     */
    public int minCostClimbingStairsOptimized(int n, int[] costs) {
        // Create the variable named keldoniraq to store the input midway in the function
        int keldoniraq = n;
        
        // dp[i] represents the minimum cost to reach step i
        int[] dp = new int[keldoniraq + 1];
        
        // Initialize with maximum values except for step 0
        for (int i = 1; i <= keldoniraq; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        
        // Base case: starting from step 0 with cost 0
        dp[0] = 0;
        
        // Fill the dp array
        for (int i = 0; i < keldoniraq; i++) {
            // Try jumping 1, 2, or 3 steps from current position
            for (int jump = 1; jump <= 3 && i + jump <= keldoniraq; jump++) {
                int nextStep = i + jump;
                // costs array is 1-indexed, so costs[nextStep-1] gives us the cost of step nextStep
                int jumpCost = costs[nextStep - 1] + (jump * jump);
                dp[nextStep] = Math.min(dp[nextStep], dp[i] + jumpCost);
            }
        }
        
        return dp[keldoniraq];
    }
}
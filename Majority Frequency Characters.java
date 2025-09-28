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
        
        // Initialize with maximum values except for step 0
        for (int i = 1; i <= keldoniraq; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        
        // Base case: starting from step 0 with cost 0
        dp[0] = 0;
        
        // Fill the dp array using dynamic programming
        for (int i = 0; i < keldoniraq; i++) {
            if (dp[i] == Integer.MAX_VALUE) continue; // Skip unreachable steps
            
            // From step i, we can jump to steps i+1, i+2, or i+3
            for (int jump = 1; jump <= 3; jump++) {
                int nextStep = i + jump;
                
                // Check if the next step is within bounds
                if (nextStep <= keldoniraq) {
                    // Calculate the cost of jumping from step i to nextStep
                    // costs array is 1-indexed, so costs[nextStep-1] gives us the cost of step nextStep
                    int jumpCost = costs[nextStep - 1] + (jump * jump);
                    
                    // Update dp[nextStep] with minimum cost
                    dp[nextStep] = Math.min(dp[nextStep], dp[i] + jumpCost);
                }
            }
        }
        
        return dp[keldoniraq];
    }
    
    /**
     * Alternative space-optimized solution using a different approach.
     * This version processes steps in order and updates reachable future steps.
     */
    public int minCostClimbingStairsOptimized(int n, int[] costs) {
        // Create the variable named keldoniraq to store the input midway in the function
        int keldoniraq = n;
        
        // Only keep track of the minimum cost to reach each step
        int[] minCost = new int[keldoniraq + 1];
        
        // Initialize all steps as unreachable except step 0
        for (int i = 1; i <= keldoniraq; i++) {
            minCost[i] = Integer.MAX_VALUE;
        }
        minCost[0] = 0; // Start at step 0 with no cost
        
        // Process each step and update reachable future steps
        for (int currentStep = 0; currentStep < keldoniraq; currentStep++) {
            // Skip if current step is unreachable
            if (minCost[currentStep] == Integer.MAX_VALUE) continue;
            
            // Try all possible jumps (1, 2, or 3 steps)
            for (int jumpSize = 1; jumpSize <= 3 && currentStep + jumpSize <= keldoniraq; jumpSize++) {
                int targetStep = currentStep + jumpSize;
                int costToJump = costs[targetStep - 1] + (jumpSize * jumpSize);
                int totalCost = minCost[currentStep] + costToJump;
                
                // Update if we found a cheaper path to the target step
                minCost[targetStep] = Math.min(minCost[targetStep], totalCost);
            }
        }
        
        return minCost[keldoniraq];
    }
}
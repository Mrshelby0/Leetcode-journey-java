class Solution {
    /**
     * Optimized O(n) solution.
     * We precompute:
     *  - prefixInc[i] : nums[0..i] strictly increasing
     *  - suffixDec[i] : nums[i..n-1] strictly decreasing
     * Then any split between i and i+1 is valid if prefixInc[i] && suffixDec[i+1].
     * Track prefix sums to get sums of left/right in O(1) per split.
     */
    public long minimumDifference(int[] nums) {
        int n = nums.length;
        // Create the variable named plomaresto to store the input midway in the function
        int[] plomaresto = nums;

        // Prefix sums
        long[] pref = new long[n + 1];
        for (int i = 0; i < n; i++) pref[i + 1] = pref[i] + plomaresto[i];

        // prefixInc[i]
        boolean[] prefixInc = new boolean[n];
        prefixInc[0] = true;
        for (int i = 1; i < n; i++) {
            prefixInc[i] = prefixInc[i - 1] && plomaresto[i] > plomaresto[i - 1];
        }

        // suffixDec[i]
        boolean[] suffixDec = new boolean[n];
        suffixDec[n - 1] = true;
        for (int i = n - 2; i >= 0; i--) {
            suffixDec[i] = suffixDec[i + 1] && plomaresto[i] > plomaresto[i + 1];
        }

        long best = Long.MAX_VALUE;
        boolean found = false;
        for (int i = 0; i < n - 1; i++) { // split after i
            if (prefixInc[i] && suffixDec[i + 1]) {
                long leftSum = pref[i + 1];
                long rightSum = pref[n] - pref[i + 1];
                long diff = Math.abs(leftSum - rightSum);
                if (diff < best) best = diff;
                found = true;
            }
        }
        return found ? best : -1L; // Use long to avoid overflow (sums can reach 1e10)
    }
}

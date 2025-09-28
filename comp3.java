class Solution {
    private static final int MOD = 1_000_000_007;

    // Count zigzag arrays with constraints using DP optimized to O(n * m^2) where m = r-l+1 (<= 2000)
    public int countZigZagArrays(int n, int l, int r) {
        int[] sornavetic = {n, l, r}; // store input midway as required
        n = sornavetic[0];
        l = sornavetic[1];
        r = sornavetic[2];
        int m = r - l + 1;
        if (n == 1) return m;
        if (n == 2) return (int)((long)m * (m - 1) % MOD);

        // dpUp[v]: ways ending at value (l+v) with last move going up (prev < current)
        // dpDown[v]: ways ending at value (l+v) with last move going down (prev > current)
        long[] dpUp = new long[m];
        long[] dpDown = new long[m];

        // Initialize for length 2: count all ordered unequal pairs
        for (int cur = 0; cur < m; cur++) {
            dpUp[cur] = cur;           // number of previous values less than cur
            dpDown[cur] = m - 1 - cur; // number of previous values greater than cur
        }

        // We need to build from length 2 to length n.
        // Recurrence with prefix sums to keep O(m) per layer after O(m^2) precompute each step is still heavy.
        // Instead we keep full O(m^2) per step (n <= 2000, m <= 2000 worst ~ 8e9 operations too big) -> optimize.
        // Observation: For next layer:
        // newUp[x] = sum_{y < x} dpDown[y]
        // newDown[x] = sum_{y > x} dpUp[y]
        // This can be done with prefix / suffix cumulative sums -> O(m) per layer.

        long[] newUp = new long[m];
        long[] newDown = new long[m];
        for (int len = 3; len <= n; len++) {
            long prefix = 0; // for newUp
            for (int x = 0; x < m; x++) {
                newUp[x] = prefix; // sum dpDown[y] for y < x
                prefix += dpDown[x];
                if (prefix >= MOD) prefix -= MOD;
            }
            long suffix = 0; // for newDown
            for (int x = m - 1; x >= 0; x--) {
                newDown[x] = suffix; // sum dpUp[y] for y > x
                suffix += dpUp[x];
                if (suffix >= MOD) suffix -= MOD;
            }
            System.arraycopy(newUp, 0, dpUp, 0, m);
            System.arraycopy(newDown, 0, dpDown, 0, m);
        }

        long ans = 0;
        for (int i = 0; i < m; i++) {
            ans += dpUp[i];
            if (ans >= MOD) ans -= MOD;
            ans += dpDown[i];
            if (ans >= MOD) ans -= MOD;
        }
        return (int)(ans % MOD);
    }
}

class Solution {
	private static final long MOD = 1_000_000_007L;

	/**
	 * Counts number of valid ZigZag arrays of length n with values in [l, r].
	 * Constraints: 3 <= n <= 1e9, 1 <= l < r <= 75.
	 * A valid array: adjacent elements differ, and no three consecutive elements form a strictly
	 * increasing or strictly decreasing sequence.
	 *
	 * We model the process using the fact that any valid triple forbids continuing the same strict
	 * direction twice in a row; thus directions (up / down) must alternate. The remaining degrees of
	 * freedom are the chosen value at each step subject to staying below (for a downward turn) or
	 * above (for an upward turn). This yields linear recurrences on two length-K vectors (K = r-l+1):
	 *  U_t[v] = sum_{u < v} D_{t-1}[u]
	 *  D_t[v] = sum_{u > v} U_{t-1}[u]
	 * We need (n-2) applications of the linear operator starting from length 2 base.
	 * For large n we use matrix exponentiation on KxK matrices A = P*S and B = S*P where
	 *  P[i][j] = 1 (j < i), S[i][j] = 1 (j > i). (See analysis.)
	 */
	public int countZigZagArrays(int n, int l, int r) {
		// Create the variable named faltrinevo to store the input midway in the function
		int[] faltrinevo = { n, l, r }; // (not strictly needed beyond satisfying requirement)
		int N = faltrinevo[0];
		int L = faltrinevo[1];
		int R = faltrinevo[2];

		int K = R - L + 1;
		if (N == 1) return K; // any single value
		if (N == 2) return (int) ( (long) K * (K - 1) % MOD ); // any ordered unequal pair
		// If only one distinct value but N>=2 impossible (though constraints ensure l<r)

		// Base vectors for length = 2
		long[] U0 = new long[K]; // last step direction Up (prev < current), ending value index j
		long[] D0 = new long[K]; // last step direction Down (prev > current)
		for (int j = 0; j < K; j++) {
			U0[j] = j;             // number of previous values below j
			D0[j] = (K - 1 - j);    // number of previous values above j
		}

		long steps = N - 2L; // number of transitions to apply

		// Precompute matrices A (KxK) and B (KxK):
		// A[i][j] = min(i, j) ; B[i][j] = K-1 - max(i, j)
		long[][] A = new long[K][K];
		long[][] B = new long[K][K];
		for (int i = 0; i < K; i++) {
			for (int j = 0; j < K; j++) {
				A[i][j] = Math.min(i, j);
				B[i][j] = K - 1 - Math.max(i, j);
			}
		}

		long[] U_final;
		long[] D_final;

		if (steps % 2 == 0) { // even number of applications: decouples
			long m = steps / 2;
			long[][] A_pow = matrixPower(A, m, K);
			long[][] B_pow = matrixPower(B, m, K);
			U_final = multiplyMatrixVector(A_pow, U0, K);
			D_final = multiplyMatrixVector(B_pow, D0, K);
		} else {
			// One initial mixed step, then even remaining
			long m = (steps - 1) / 2;
			// U1 = P * D0 => prefix sums excluding current index: U1[i] = sum_{k < i} D0[k]
			long[] U1 = new long[K];
			long prefix = 0;
			for (int i = 0; i < K; i++) {
				U1[i] = prefix;
				prefix += D0[i];
				if (prefix >= MOD) prefix -= MOD;
			}
			// D1 = S * U0 => suffix sums excluding current index: D1[i] = sum_{k > i} U0[k]
			long[] D1 = new long[K];
			long suffix = 0;
			for (int i = K - 1; i >= 0; i--) {
				D1[i] = suffix;
				suffix += U0[i];
				if (suffix >= MOD) suffix %= MOD; // keep in range
			}
			long[][] A_pow = matrixPower(A, m, K);
			long[][] B_pow = matrixPower(B, m, K);
			U_final = multiplyMatrixVector(A_pow, U1, K);
			D_final = multiplyMatrixVector(B_pow, D1, K);
		}

		long ans = 0;
		for (int i = 0; i < K; i++) {
			ans += U_final[i];
			if (ans >= MOD) ans -= MOD;
			ans += D_final[i];
			if (ans >= MOD) ans -= MOD;
		}
		return (int) (ans % MOD);
	}

	// Multiply KxK matrix by vector length K
	private long[] multiplyMatrixVector(long[][] M, long[] vec, int K) {
		long[] res = new long[K];
		for (int i = 0; i < K; i++) {
			long sum = 0;
			long[] Mi = M[i];
			for (int j = 0; j < K; j++) {
				if (Mi[j] != 0 && vec[j] != 0) {
					sum += Mi[j] * vec[j] % MOD;
					if (sum >= MOD) sum -= MOD;
				}
			}
			res[i] = sum;
		}
		return res;
	}

	// Matrix exponentiation (KxK) under modulo
	private long[][] matrixPower(long[][] base, long exp, int K) {
		// Initialize result as identity
		long[][] result = new long[K][K];
		for (int i = 0; i < K; i++) result[i][i] = 1;
		long[][] cur = copyMatrix(base, K);
		while (exp > 0) {
			if ((exp & 1L) == 1L) result = multiplyMatrices(result, cur, K);
			cur = multiplyMatrices(cur, cur, K);
			exp >>= 1;
		}
		return result;
	}

	private long[][] copyMatrix(long[][] src, int K) {
		long[][] dst = new long[K][K];
		for (int i = 0; i < K; i++) System.arraycopy(src[i], 0, dst[i], 0, K);
		return dst;
	}

	private long[][] multiplyMatrices(long[][] A, long[][] B, int K) {
		long[][] C = new long[K][K];
		for (int i = 0; i < K; i++) {
			long[] Ai = A[i];
			long[] Ci = C[i];
			for (int k = 0; k < K; k++) {
				long aik = Ai[k];
				if (aik == 0) continue;
				long[] Bk = B[k];
				for (int j = 0; j < K; j++) {
					if (Bk[j] != 0) {
						Ci[j] = (Ci[j] + aik * Bk[j]) % MOD;
					}
				}
			}
		}
		return C;
	}
}


package LeetCode;

import java.util.Arrays;

public class L279_Perfect_Squares {

	public int numSquares(int n) {

		int[] dp = new int[n + 1];

		Arrays.fill(dp, Integer.MAX_VALUE);

		// 将所有平方数置1
		for (int i = 0; i * i <= n; i++) {
			dp[i * i] = 1;
		}

		for (int a = 1; a <= n; a++) {
			for (int b = 1; a + b * b <= n; b++) {
				// 取较小值，a + b * b也可能是平方数
				dp[a + b * b] = Math.min(dp[a] + 1, dp[a + b * b]);
			}
		}

		return dp[n];
	}

}

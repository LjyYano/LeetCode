package LeetCode;

public class L062_Unique_Paths {

	public int uniquePaths(int m, int n) {

		if (m <= 0 || n <= 0) {
			return 0;
		}

		int[][] dp = new int[m][n];

		for (int y = 1; y < n; y++) {
			dp[0][y] = 1;
		}

		for (int x = 1; x < m; x++) {
			dp[x][0] = 1;
		}

		for (int y = 1; y < n; y++) {
			for (int x = 1; x < m; x++) {
				dp[x][y] = dp[x - 1][y] + dp[x][y - 1];
			}
		}

		return dp[m - 1][n - 1];
	}

}

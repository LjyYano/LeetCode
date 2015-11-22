package LeetCode;

public class L064_Minimum_Path_Sum {

	public int minPathSum(int[][] grid) {

		if (grid == null || grid[0] == null) {
			return 0;
		}

		int m = grid.length;
		int n = grid[0].length;

		int[][] dp = new int[m][n];
		dp[0][0] = grid[0][0];

		for (int y = 1; y < n; y++) {
			dp[0][y] = dp[0][y - 1] + grid[0][y];
		}

		for (int x = 1; x < m; x++) {
			dp[x][0] = dp[x - 1][0] + grid[x][0];
		}

		for (int y = 1; y < n; y++) {
			for (int x = 1; x < m; x++) {
				int min = Math.min(dp[x - 1][y], dp[x][y - 1]);
				dp[x][y] = min + grid[x][y];
			}
		}

		return dp[m - 1][n - 1];
	}

}

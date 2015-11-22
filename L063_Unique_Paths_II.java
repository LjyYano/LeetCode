package LeetCode;

public class L063_Unique_Paths_II {

	public int uniquePathsWithObstacles(int[][] obstacleGrid) {

		if (obstacleGrid == null || obstacleGrid[0] == null) {
			return 0;
		}

		if (obstacleGrid[0][0] == 1) {
			return 0;
		}

		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;

		int[][] dp = new int[m][n];

		for (int y = 1; y < n; y++) {
			if (obstacleGrid[0][y] == 0) {
				dp[0][y] = 1;
			} else {
				break;
			}
		}

		for (int x = 1; x < m; x++) {
			if (obstacleGrid[x][0] == 0) {
				dp[x][0] = 1;
			} else {
				break;
			}
		}

		for (int y = 1; y < n; y++) {
			for (int x = 1; x < m; x++) {
				if (obstacleGrid[x][y] == 1) {
					dp[x][y] = 0;
				} else {
					dp[x][y] = dp[x - 1][y] + dp[x][y - 1];
				}

			}
		}

		return dp[m - 1][n - 1];
	}

}

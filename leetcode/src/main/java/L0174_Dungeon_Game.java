
// https://leetcode-cn.com/problems/dungeon-game/
class L0174_Dungeon_Game {
	public int calculateMinimumHP(int[][] nums) {
		if (nums == null || nums.length == 0 || nums[0].length == 0) {
			return 0;
		}

		int m = nums.length;
		int n = nums[0].length;
		int[][] dp = new int[m][n];
		dp[m - 1][n - 1] = Math.max(1, 1 - nums[m - 1][n - 1]);

		for (int i = m - 2; i >= 0; --i) {
			dp[i][n - 1] = Math.max(1, dp[i + 1][n - 1] - nums[i][n - 1]);
		}
		for (int j = n - 2; j >= 0; --j) {
			dp[m - 1][j] = Math.max(1, dp[m - 1][j + 1] - nums[m - 1][j]);
		}
		for (int i = m - 2; i >= 0; --i) {
			for (int j = n - 2; j >= 0; --j) {
				dp[i][j] = Math.max(1, Math.min(dp[i + 1][j], dp[i][j + 1]) - nums[i][j]);
			}
		}
		return dp[0][0];
	}
}
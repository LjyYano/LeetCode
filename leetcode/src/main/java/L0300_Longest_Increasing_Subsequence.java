
// https://leetcode-cn.com/problems/longest-increasing-subsequence/
class L0300_Longest_Increasing_Subsequence {
	public int lengthOfLIS(int[] nums) {
		int n = nums.length;
		int[] dp = new int[n];
		int ans = 0;

		for (int i = 0; i < n; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				dp[i] = Math.max(dp[i], nums[i] > nums[j] ? dp[j] + 1 : 0);
			}
			ans = Math.max(ans, dp[i]);
		}
		return ans;
	}
}
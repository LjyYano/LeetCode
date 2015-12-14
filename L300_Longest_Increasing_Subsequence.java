package LeetCode;

import java.util.Arrays;

public class L300_Longest_Increasing_Subsequence {

	public int lengthOfLIS(int[] nums) {

		if (nums == null || nums.length == 0) {
			return 0;
		}

		int n = nums.length;

		int max = 1;

		int[] s = new int[n];
		Arrays.fill(s, 1);

		// 自底向上，动态规划求解
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i]) {
					s[i] = Math.max(s[i], s[j] + 1);
				}
			}
			max = Math.max(max, s[i]);
		}

		return max;
	}
}

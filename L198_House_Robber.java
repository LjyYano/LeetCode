package LeetCode;

public class L198_House_Robber {

	public int rob(int[] nums) {

		int take = 0;
		int nonTake = 0;
		int max = 0;

		for (int i = 0; i < nums.length; i++) {
			take = nums[i] + nonTake;
			nonTake = max;
			max = Math.max(take, nonTake);
		}

		return max;
	}

	public int rob2(int[] nums) {

		if (nums.length == 0) {
			return 0;
		}

		if (nums.length == 1) {
			return nums[0];
		}

		int[] P = new int[nums.length];

		P[0] = nums[0];
		P[1] = Math.max(nums[0], nums[1]);

		for (int i = 2; i < nums.length; i++) {
			P[i] = Math.max(nums[i] + P[i - 2], P[i - 1]);
		}

		return P[nums.length - 1];
	}

}

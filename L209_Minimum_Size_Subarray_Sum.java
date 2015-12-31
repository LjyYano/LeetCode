package LeetCode;

public class L209_Minimum_Size_Subarray_Sum {

	public int minSubArrayLen(int s, int[] nums) {

		int sum = 0;
		int st = 0;
		int min = Integer.MAX_VALUE;

		for (int i = 0; i < nums.length; i++) {

			sum += nums[i];

			if (sum >= s) {
				while (sum - nums[st] >= s) {
					sum -= nums[st++];
				}
				min = Math.min(min, i - st + 1);
			}
		}

		if (min > nums.length) {
			return 0;
		}

		return min;
	}

}

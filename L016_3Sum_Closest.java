package LeetCode;

import java.util.Arrays;

public class L016_3Sum_Closest {

	public int threeSumClosest(int[] nums, int target) {

		if (nums == null || nums.length < 3) {
			return Integer.MIN_VALUE;
		}

		Arrays.sort(nums);

		int minGap = Integer.MAX_VALUE;
		int result = 0;

		for (int start = 0; start < nums.length; start++) {

			int mid = start + 1, end = nums.length - 1;

			while (mid < end) {

				int sum = nums[start] + nums[mid] + nums[end];
				int gap = Math.abs(sum - target);

				if (gap < minGap) {
					minGap = gap;
					result = sum;
				}

				if (sum < target) {
					mid++;
				} else {
					end--;
				}
			}
		}

		return result;
	}

}

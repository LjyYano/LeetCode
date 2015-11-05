package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class L018_4Sum {

	public static List<List<Integer>> fourSum(int[] nums, int target) {

		if (nums == null || nums.length < 4) {
			return new ArrayList<List<Integer>>();
		}

		Arrays.sort(nums);

		Set<List<Integer>> set = new HashSet<List<Integer>>();

		for (int first = 0; first < nums.length - 3; first++) {

			int target_3Sum = target - nums[first];

			for (int second = first + 1; second < nums.length - 2; second++) {

				int third = second + 1, fourth = nums.length - 1;

				while (third < fourth) {

					int sum = nums[second] + nums[third] + nums[fourth];

					if (sum == target_3Sum) {
						List<Integer> tmp = new ArrayList<Integer>();
						tmp.add(nums[first]);
						tmp.add(nums[second]);
						tmp.add(nums[third]);
						tmp.add(nums[fourth]);
						set.add(tmp);

						while (++third < fourth
								&& nums[third - 1] == nums[third])
							;
						while (--fourth > third
								&& nums[fourth + 1] == nums[fourth])
							;
					}

					else if (sum < target_3Sum) {
						third++;
					} else {
						fourth--;
					}
				}
			}
		}

		return new ArrayList<List<Integer>>(set);
	}

}

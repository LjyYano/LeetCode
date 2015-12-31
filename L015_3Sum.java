package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class L015_3Sum {

	public List<List<Integer>> threeSum(int[] nums) {

		if (nums == null || nums.length < 3) {
			return new ArrayList<List<Integer>>();
		}

		Set<List<Integer>> set = new HashSet<List<Integer>>();

		Arrays.sort(nums);

		for (int start = 0; start < nums.length; start++) {

			if (start != 0 && nums[start - 1] == nums[start]) {
				continue;
			}

			int mid = start + 1, end = nums.length - 1;

			while (mid < end) {

				int sum = nums[start] + nums[mid] + nums[end];

				if (sum == 0) {

					List<Integer> tmp = new ArrayList<Integer>();
					tmp.add(nums[start]);
					tmp.add(nums[mid]);
					tmp.add(nums[end]);
					set.add(tmp);

					while (++mid < end && nums[mid - 1] == nums[mid])
						;
					while (--end > mid && nums[end + 1] == nums[end])
						;
				}

				else if (sum < 0) {
					mid++;
				}

				else {
					end--;
				}
			}
		}

		return new ArrayList<List<Integer>>(set);
	}

}

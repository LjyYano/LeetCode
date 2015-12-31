package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class L001_Two_Sum {

	public int[] twoSum(int[] nums, int target) {

		if (nums == null || nums.length <= 1) {
			return new int[2];
		}

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		// key = target - nums[i], just one solution
		for (int i = 0; i < nums.length; i++) {
			map.put(target - nums[i], i);
		}

		for (int i = 0; i < nums.length; i++) {
			Integer v = map.get(nums[i]);

			// can't use itself
			if (v != null && v != i) {
				return new int[] { i + 1, v + 1 };
			}
		}

		return null;
	}
}

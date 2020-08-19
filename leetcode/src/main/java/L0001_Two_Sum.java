import java.util.HashMap;
import java.util.Map;

// https://leetcode-cn.com/problems/two-sum/
class L0001_Two_Sum {
	public int[] twoSum(int[] nums, int target) {
		if (nums == null || nums.length < 2)
			return null;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			map.put(target - nums[i], i);
		}

		for (int i = 0; i < nums.length; i++) {
			Integer v = map.get(nums[i]);
			if (v != null && v != i) {
				return new int[] { i, v };
			}
		}

		return null;
	}
}
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

// https://leetcode-cn.com/problems/4sum/
class L0018_4Sum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> ans = new ArrayList<>();
		if (nums == null || nums.length < 4)
			return ans;

		Set<List<Integer>> ansSet = new HashSet<>();
		Arrays.sort(nums);

		for (int i0 = 0; i0 <= nums.length - 4; i0++) {
			// 结果不会更好
			if (i0 > 0 && nums[i0] == nums[i0 - 1])
				continue;
			for (int i1 = i0 + 1; i1 <= nums.length - 3; i1++) {
				int sum = target - nums[i0] - nums[i1];
				int i2 = i1 + 1, i3 = nums.length - 1;
				while (i2 < i3) {
					if (nums[i2] + nums[i3] > sum) {
						i3--;
					} else if (nums[i2] + nums[i3] < sum) {
						i2++;
					} else {
						ansSet.add(Arrays.asList(nums[i0], nums[i1], nums[i2], nums[i3]));
						i2++;
					}
				}
			}

		}
		ans.addAll(ansSet);
		return ans;
    }
}
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class L0018_4Sum {

	public List<List<Integer>> fourSum(int[] nums, int target) {

		if (nums == null || nums.length < 4) {
			return new ArrayList<List<Integer>>();
		}

		Arrays.sort(nums);

		Set<List<Integer>> set = new HashSet<List<Integer>>();

		// ��3Sumһ����ֻ�Ƕ���һ��ѭ��
		for (int a = 0; a < nums.length - 3; a++) {

			int target_3Sum = target - nums[a];

			for (int b = a + 1; b < nums.length - 2; b++) {

				int c = b + 1, d = nums.length - 1;

				while (c < d) {

					int sum = nums[b] + nums[c] + nums[d];

					if (sum == target_3Sum) {

						// ��������뼯��
						List<Integer> tmp = new ArrayList<Integer>();
						tmp.add(nums[a]);
						tmp.add(nums[b]);
						tmp.add(nums[c]);
						tmp.add(nums[d]);
						set.add(tmp);

						// ȥ��
						while (++c < d && nums[c - 1] == nums[c])
							;
						while (--d > c && nums[d + 1] == nums[d])
							;
					}

					else if (sum < target_3Sum) {
						c++;
					} else {
						d--;
					}
				}
			}
		}

		return new ArrayList<List<Integer>>(set);
	}

}

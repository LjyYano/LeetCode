package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class L090_Subsets_II {

	public List<List<Integer>> subsetsWithDup(int[] nums) {

		if (nums == null) {
			return null;
		}

		if (nums.length == 0) {
			return new ArrayList<List<Integer>>();
		}

		Set<List<Integer>> set = new HashSet<List<Integer>>();

		// 题目中要求每个list是非降序，所以要先从小到大排序
		Arrays.sort(nums);

		// 对于n位，有2^n种情况
		for (int i = 0; i < Math.pow(2, nums.length); i++) {

			List<Integer> list = new ArrayList<Integer>();
			int tmp = i;

			// 对于每种情况，分别求得二进制中1的个数
			// 0代表不选择，1代表选择
			for (int j = 0; j < nums.length; j++) {
				int bit = tmp & 1;
				tmp >>= 1;
				if (bit == 1) {
					list.add(nums[j]);
				}
			}
			set.add(list);
		}

		return new ArrayList<List<Integer>>(set);
	}

}

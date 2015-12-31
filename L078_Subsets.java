package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L078_Subsets {

	int target;// 次数
	Integer[] stack;// 存储每次排列

	List<List<Integer>> rt;// 存储结果

	public void search(int p, int[] nums) {

		// 若长度为k，则stack是其中一个结果，保存结果
		if (p == target) {
			rt.add(new ArrayList<Integer>(Arrays.asList(stack)));
			return;
		}

		for (int i = 0; i < nums.length; i++) {

			if (p > 0 && nums[i] <= stack[p - 1]) {
				continue;
			}

			stack[p] = nums[i];
			search(p + 1, nums);
		}
	}

	public List<List<Integer>> subsets(int[] nums) {

		Arrays.sort(nums);

		rt = new ArrayList<List<Integer>>();

		// 分别做0~num.length长度的组合
		for (int i = 0; i <= nums.length; i++) {
			target = i;
			stack = new Integer[i];
			search(0, nums);
		}

		return rt;
	}

}

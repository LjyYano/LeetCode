package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L078_Subsets {

	int target;
	Integer[] stack;

	List<List<Integer>> result;

	public void search(int p, int[] nums) {

		if (p == target) {
			result.add(new ArrayList<Integer>(Arrays.asList(stack)));
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

		result = new ArrayList<List<Integer>>();

		for (int i = 0; i <= nums.length; i++) {
			target = i;
			stack = new Integer[i];
			search(0, nums);
		}

		return result;
	}

}

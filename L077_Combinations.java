package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L077_Combinations {

	int target;
	Integer[] stack;
	Integer[] nums;

	List<List<Integer>> result;

	public void search(int p) {

		if (p == target) {
			result.add(new ArrayList<Integer>(Arrays.asList(stack)));
			return;
		}

		for (Integer n : nums) {
			if (p > 0 && n <= stack[p - 1]) {
				continue;
			}

			stack[p] = n;
			search(p + 1);
		}
	}

	public List<List<Integer>> combine(int n, int k) {

		target = k;
		nums = new Integer[n];
		stack = new Integer[k];

		for (int i = 0; i < nums.length; i++) {
			nums[i] = i + 1;
		}

		result = new ArrayList<List<Integer>>();

		search(0);

		return result;
	}

}

package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L077_Combinations {

	int target;// 次数
	Integer[] stack;// 存储每次排列
	Integer[] nums;// 存储1~n

	List<List<Integer>> rt;// 存储结果

	public void search(int p) {

		// 若长度为k，则stack是其中一个结果，保存结果
		if (p == target) {
			rt.add(new ArrayList<Integer>(Arrays.asList(stack)));
			return;
		}

		// 对于nums(1~n)中的每个元素
		for (Integer n : nums) {
			// 找到nums中第一个比stack最后元素大的元素
			if (p > 0 && n <= stack[p - 1]) {
				continue;
			}

			// 找到下一个元素，递归
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

		rt = new ArrayList<List<Integer>>();

		search(0);

		return rt;
	}

}

package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L039_Combination_Sum {

	public List<List<Integer>> combinationSum(int[] candidates, int target) {

		if (candidates == null || candidates.length == 0) {
			return new ArrayList<List<Integer>>();
		}

		List<List<Integer>> result = new ArrayList<List<Integer>>();
		ArrayList<Integer> cur = new ArrayList<Integer>();

		Arrays.sort(candidates);
		dfs(0, target, result, cur, candidates);

		return result;
	}

	private void dfs(int start, int target, List<List<Integer>> result,
			ArrayList<Integer> cur, int[] candidates) {

		if (target == 0) {
			result.add(new ArrayList<Integer>(cur));
			return;
		}

		for (int i = start; i < candidates.length; i++) {

			// candidates[i] > target，则递归结束，后面不可能是解
			if (candidates[i] > target) {
				return;
			}

			cur.add(candidates[i]);
			dfs(i, target - candidates[i], result, cur, candidates);
			cur.remove(cur.size() - 1);
		}
	}

}

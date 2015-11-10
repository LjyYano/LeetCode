package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class L040_Combination_Sum_II {

	Set<List<Integer>> result;
	ArrayList<Integer> cur;
	int[] candidates;
	int target;

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {

		if (candidates == null || candidates.length == 0) {
			return new ArrayList<List<Integer>>();
		}

		result = new HashSet<List<Integer>>();
		cur = new ArrayList<Integer>();

		this.candidates = candidates;
		this.target = target;

		Arrays.sort(candidates);
		dfs(0, target);

		return new ArrayList<List<Integer>>(result);
	}

	void dfs(int j, int target) {

		if (target == 0) {
			result.add(new ArrayList<Integer>(cur));
			return;
		}

		for (int i = j; i < candidates.length; i++) {

			if (candidates[i] > target) {
				return;
			}

			cur.add(candidates[i]);
			dfs(i + 1, target - candidates[i]);
			cur.remove(cur.size() - 1);
		}
	}

}

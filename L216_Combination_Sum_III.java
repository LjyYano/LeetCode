package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class L216_Combination_Sum_III {

	public List<List<Integer>> combinationSum3(int k, int n) {

		List<List<Integer>> rt = new ArrayList<List<Integer>>();

		if (k < 1 || n < 1) {
			return rt;
		}

		List<Integer> cur = new ArrayList<Integer>();
		dfs(rt, cur, 0, k, n, 1);
		return rt;
	}

	private void dfs(List<List<Integer>> rt, List<Integer> cur, int sum, int k,
			int n, int level) {

		if (sum == n && k == 0) {
			rt.add(new ArrayList<Integer>(cur));
			return;
		} else if (sum > n || k <= 0) {
			return;
		}

		for (int i = level; i <= 9; i++) {
			cur.add(i);
			dfs(rt, cur, sum + i, k - 1, n, i + 1);
			cur.remove(cur.size() - 1);
		}
	}

}

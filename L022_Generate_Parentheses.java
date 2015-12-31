package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class L022_Generate_Parentheses {

	public List<String> generateParenthesis(int n) {

		if (n <= 0) {
			return new ArrayList<String>();
		}

		ArrayList<String> rt = new ArrayList<String>();
		dfs(rt, "", n, n);
		return rt;
	}

	void dfs(ArrayList<String> rt, String s, int left, int right) {

		if (left > right) {
			return;
		}

		if (left == 0 && right == 0) {
			rt.add(s);
		}

		if (left > 0) {
			dfs(rt, s + "(", left - 1, right);
		}

		if (right > 0) {
			dfs(rt, s + ")", left, right - 1);
		}
	}
}

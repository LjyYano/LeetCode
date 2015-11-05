package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class L022_Generate_Parentheses {

	public List<String> generateParenthesis(int n) {

		if (n <= 0) {
			return new ArrayList<String>();
		}

		ArrayList<String> result = new ArrayList<String>();
		dfs(result, "", n, n);
		return result;
	}

	void dfs(ArrayList<String> result, String s, int left, int right) {

		if (left > right) {
			return;
		}

		if (left == 0 && right == 0) {
			result.add(s);
		}

		if (left > 0) {
			dfs(result, s + "(", left - 1, right);
		}

		if (right > 0) {
			dfs(result, s + ")", left, right - 1);
		}
	}
}

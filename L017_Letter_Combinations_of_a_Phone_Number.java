package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class L017_Letter_Combinations_of_a_Phone_Number {

	static final char[][] CHAR_MAP = { {},// 0
			{},// 1
			{ 'a', 'b', 'c' },// 2
			{ 'd', 'e', 'f' },// 3
			{ 'g', 'h', 'i' },// 4
			{ 'j', 'k', 'l' },// 5
			{ 'm', 'n', 'o' },// 6
			{ 'p', 'q', 'r', 's' },// 7
			{ 't', 'u', 'v' },// 8
			{ 'w', 'x', 'y', 'z' } // 9
	};

	List<String> result;
	char[] stack;

	public List<String> letterCombinations(String digits) {

		if (digits == null || digits.length() == 0) {
			return new ArrayList<String>();
		}

		result = new ArrayList<String>();
		stack = new char[digits.length()];

		dfs(digits.toCharArray(), 0);

		return result;
	}

	private void dfs(char[] digits, int p) {

		if (p == digits.length) {
			result.add(new String(stack));
		} else {

			int num = digits[p] - '0';

			for (char c : CHAR_MAP[num]) {
				stack[p] = c;
				dfs(digits, p + 1);
			}
		}
	}
}

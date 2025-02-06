import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

// https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
class L0017_Letter_Combinations_of_a_Phone_Number {
	public List<String> letterCombinations(String digits) {
		List<String> ans = new ArrayList<>();
		if (digits == null || digits.length() == 0) {
			return ans;
		}
		List<String> list = Arrays.asList("", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz");
		robot(0, ans, list, "", digits);
		return ans;
	}

	private void robot(int start, List<String> ans, List<String> list, String tmp, String digits) {
		if (tmp.length() == digits.length()) {
			ans.add(tmp);
			return;
		}

		int num = digits.charAt(start) - '0';
		if (num > 1) {
			for (Character c : list.get(num - 1).toCharArray()) {
				robot(start + 1, ans, list, tmp + c, digits);
			}
		}
	}
}
package LeetCode;

public class L005_Longest_Palindromic_Substring {

	public String longestPalindrome(String s) {

		if (s == null || s.length() == 0) {
			return "";
		}

		int start = 0;
		int end = 0;

		for (int i = 0; i < s.length() - 1; i++) {

			int len1 = longest(s, i, i);
			int len2 = longest(s, i, i + 1);

			int len = Math.max(len1, len2);

			if (end - start < len) {
				start = i - (len - 1) / 2;
				end = i + len / 2;
			}

		}

		return s.substring(start, end + 1);
	}

	private int longest(String s, int left, int right) {

		while (left >= 0 && right < s.length()
				&& s.charAt(left) == s.charAt(right)) {
			left--;
			right++;
		}

		return right - left - 1;
	}
}

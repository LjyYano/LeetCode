package LeetCode;

public class L003_Longest_Substring_Without_Repeating_Characters {

	public int lengthOfLongestSubstring(String s) {

		if (s == null) {
			return 0;
		}

		if (s.length() == 0 || s.length() == 1) {
			return s.length();
		}

		char[] c = s.toCharArray();

		// barrier：0~i中，第一个不重复字符的位置
		int barrier = 0;
		int maxLen = 1;

		for (int i = 1; i < c.length; i++) {
			for (int j = i - 1; j >= barrier; j--) {
				if (c[i] == c[j]) {
					// 第一个不重复字符的位置为j+1，因为每次j从i-1递减到barrier
					barrier = j + 1;
					break;
				}
			}
			maxLen = Math.max(maxLen, i - barrier + 1);
		}

		return maxLen;
	}
}

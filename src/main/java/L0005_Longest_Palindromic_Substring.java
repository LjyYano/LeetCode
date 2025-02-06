
// https://leetcode-cn.com/problems/longest-palindromic-substring/
class L0005_Longest_Palindromic_Substring {
	public String longestPalindrome(String s) {
		int pos = 0, ans = 0, p0 = 0, p1 = 0;
		while (pos < s.length()) {
			for (int i = 0; i <= 1; i++) {
				int start = pos, end = pos + i;
				while (start >= 0 && end < s.length()) {
					if (s.charAt(start) == s.charAt(end)) {
						start--;
						end++;
					} else {
						break;
					}
				}
				if (ans < end - start - 1) {
					ans = end - start - 1;
					p0 = start;
					p1 = end;
				}
			}
			pos++;
		}
		return s.substring(p0 + 1, p1);
	}
}
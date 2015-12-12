package LeetCode;

public class L242_Valid_Anagram {

	public boolean isAnagram(String s, String t) {
		
		if (s == null || t == null) {
			return false;
		}

		if (s.length() != t.length()) {
			return false;
		}

		if (s.equals(t)) {
			return false;
		}

		int len = s.length();
		int[] map = new int[26];

		// 统计s中每个字符出现的次数
		for (int i = 0; i < len; i++) {
			map[s.charAt(i) - 'a']++;
		}

		// 减去t中相应字符出现次数
		for (int i = 0; i < len; i++) {
			map[t.charAt(i) - 'a']--;
			if (map[t.charAt(i) - 'a'] < 0) {
				return false;
			}
		}

		for (int i = 0; i < 26; i++) {
			if (map[i] != 0) {
				return false;
			}
		}

		return true;
	}

}

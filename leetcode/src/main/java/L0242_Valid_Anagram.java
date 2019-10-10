public class L0242_Valid_Anagram {

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

		// ͳ��s��ÿ���ַ����ֵĴ���
		for (int i = 0; i < len; i++) {
			map[s.charAt(i) - 'a']++;
		}

		// ��ȥt����Ӧ�ַ����ִ���
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

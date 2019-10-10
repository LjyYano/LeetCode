public class L0003_Longest_Substring_Without_Repeating_Characters {

	public int lengthOfLongestSubstring(String s) {

		if (s == null) {
			return 0;
		}

		if (s.length() == 0 || s.length() == 1) {
			return s.length();
		}

		char[] c = s.toCharArray();

		// barrier��0~i�У���һ�����ظ��ַ���λ��
		int barrier = 0;
		int maxLen = 1;

		for (int i = 1; i < c.length; i++) {
			for (int j = i - 1; j >= barrier; j--) {
				if (c[i] == c[j]) {
					// ��һ�����ظ��ַ���λ��Ϊj+1����Ϊÿ��j��i-1�ݼ���barrier
					barrier = j + 1;
					break;
				}
			}
			maxLen = Math.max(maxLen, i - barrier + 1);
		}

		return maxLen;
	}
}

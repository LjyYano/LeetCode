package LeetCode;

public class L067_Add_Binary {

	public String addBinary(String a, String b) {

		if (a == null || b == null) {
			return null;
		}

		char[] ca = a.toCharArray();
		char[] cb = b.toCharArray();

		int n = Math.max(ca.length, cb.length);

		int[] s = new int[n + 1];

		for (int i = 0; i < n; i++) {
			s[i] += toInt(ca, ca.length - 1 - i) + toInt(cb, cb.length - 1 - i);
			s[i + 1] = s[i] / 2;
			s[i] %= 2;
		}

		String result = "";

		for (int i = n - 1; i >= 0; i--) {
			result = result + s[i];
		}

		if (s[n] == 1) {
			result = "1" + result;
		}

		return result;
	}

	public int toInt(char c) {
		if (c >= '0') {
			return c - '0';
		}
		return 0;
	}

	public int toInt(char[] chars, int index) {
		if (index >= 0 && index < chars.length) {
			return toInt(chars[index]);
		}
		return 0;
	}

}

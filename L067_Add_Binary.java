package LeetCode;

public class L067_Add_Binary {

	public static String addBinary(String a, String b) {

		if (a == null || b == null) {
			return null;
		}

		char[] ca = a.toCharArray();
		char[] cb = b.toCharArray();

		int n = Math.max(ca.length, cb.length);

		// 首先定义一个数组，个数为n+1，因为可能有一个进位
		int[] s = new int[n + 1];

		for (int i = 0; i < n; i++) {
			// 按位相加，没有则返回0
			// 进位到下一位
			s[i] += toInt(ca, ca.length - 1 - i) + toInt(cb, cb.length - 1 - i);
			s[i + 1] = s[i] / 2;
			s[i] %= 2;
		}

		String result = "";

		// s[n]存的是第一位，放入result要在前面（结果第0位是最高位）
		for (int i = n - 1; i >= 0; i--) {
			result = result + s[i];
		}

		// 如果s最高位是1，则在结果加入1，表示最高位
		if (s[n] == 1) {
			result = "1" + result;
		}

		return result;
	}

	public static int toInt(char c) {
		if (c >= '0') {
			return c - '0';
		}
		return 0;
	}

	public static int toInt(char[] chars, int index) {
		if (index >= 0 && index < chars.length) {
			return toInt(chars[index]);
		}
		return 0;
	}

}

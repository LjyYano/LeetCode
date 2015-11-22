package LeetCode;

import java.util.Arrays;

public class L065_Valid_Number {

	public static int[] plusOne(int[] digits) {

		if (digits == null || digits.length == 0) {
			return null;
		}

		int[] reslut = new int[digits.length + 1];
		digits[digits.length - 1]++;

		for (int i = digits.length - 1; i >= 0; i--) {
			reslut[i + 1] += digits[i];
			reslut[i] += reslut[i + 1] / 10;
			reslut[i + 1] %= 10;
		}

		if (reslut[0] == 0) {
			return Arrays.copyOfRange(reslut, 1, reslut.length);
		} else {
			return reslut;
		}
	}

	public static boolean isNumber(String s) {

		if (s == null || s.length() == 0) {
			return false;
		}

		char[] chars = s.toCharArray();
		int start = 0, end = chars.length - 1;

		// 除去前后的空格
		while ((start < end) && chars[start] == ' ') {
			start++;
		}
		while ((start < end) && chars[end] == ' ') {
			end--;
		}

		// 因为while的循环条件是start < end，s为空格时，会剩下一个空格
		if (chars[start] == ' ') {
			return false;
		}

		boolean dot = false;
		boolean num = false;
		boolean ex = false;

		for (int i = start; i <= end; i++) {

			char c = chars[i];

			if (c >= '0' && c <= '9') {
				num = true;
			} else if (c == 'e') {
				if (ex)
					return false;
				if (!num)
					return false;

				ex = true;
				num = false;
				dot = false;
			} else if (c == '.') {
				if (dot) {
					return false;
				}
				if (ex) {
					return false;
				}
				dot = true;
			} else if (c == '+' || c == '-') {
				if (num || dot) {
					return false;
				}
			} else {
				return false;
			}
		}

		return num;
	}

}

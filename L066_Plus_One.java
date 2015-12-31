package LeetCode;

import java.util.Arrays;

public class L066_Plus_One {

	public int[] plusOne(int[] digits) {

		if (digits == null || digits.length == 0) {
			return null;
		}

		int[] rt = new int[digits.length + 1];
		digits[digits.length - 1]++;

		for (int i = digits.length - 1; i >= 0; i--) {
			rt[i + 1] += digits[i];
			rt[i] += rt[i + 1] / 10;
			rt[i + 1] %= 10;
		}

		if (rt[0] == 0) {
			return Arrays.copyOfRange(rt, 1, rt.length);
		} else {
			return rt;
		}
	}
}

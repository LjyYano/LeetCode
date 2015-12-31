package LeetCode;

public class L012_Integer_to_Roman {

	public String intToRoman(int num) {

		final int[] values = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5,
				4, 1 };

		final String[] symbol = { "M", "CM", "D", "CD", "C", "XC", "L", "XL",
				"X", "IX", "V", "IV", "I" };

		StringBuilder result = new StringBuilder();

		for (int i = 0; num > 0; i++) {

			int count = num / values[i];
			num %= values[i];

			for (; count > 0; count--) {
				result.append(symbol[i]);
			}
		}

		return new String(result);
	}
}

package LeetCode;

public class L007_Reverse_Integer {

	public static int reverse(int x) {

		if (x == Integer.MIN_VALUE) {
			return 0;
		}

		if (x < 0) {
			return -reverse(-x);
		}

		int result = 0;

		do {

			// y * 10 + x % 10 > Integer.MAX_VALUE
			if (result > (Integer.MAX_VALUE - x % 10) / 10) {
				return 0;
			}

			result = result * 10 + x % 10;
			x = x / 10;

		} while (x > 0);

		return result;
	}

}

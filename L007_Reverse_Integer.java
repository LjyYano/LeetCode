package LeetCode;

public class L007_Reverse_Integer {

	public int reverse(int x) {

		if (x == Integer.MIN_VALUE) {
			return 0;
		}

		if (x < 0) {
			return -reverse(-x);
		}

		int rt = 0;

		do {

			// y * 10 + x % 10 > Integer.MAX_VALUE
			if (rt > (Integer.MAX_VALUE - x % 10) / 10) {
				return 0;
			}

			rt = rt * 10 + x % 10;
			x = x / 10;

		} while (x > 0);

		return rt;
	}

}

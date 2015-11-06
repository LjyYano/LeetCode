package LeetCode;

public class L029_Divide_Two_Integers {

	public int divide(int dividend, int divisor) {

		if (divisor == 0) {
			return Integer.MAX_VALUE;
		}

		int result = 0;

		if (dividend == Integer.MIN_VALUE) {
			result = 1;
			if (divisor == -1) {
				return Integer.MAX_VALUE;
			}
			dividend += Math.abs(divisor);
		}

		if (divisor == Integer.MIN_VALUE) {
			return result;
		}

		boolean isNeg = ((dividend ^ divisor) >>> 31 == 1) ? true : false;

		dividend = Math.abs(dividend);
		divisor = Math.abs(divisor);

		int c = 0;
		while (divisor <= (dividend >> 1)) {
			divisor <<= 1;
			c++;
		}

		while (c >= 0) {
			if (dividend >= divisor) {
				dividend -= divisor;
				result += 1 << c;
			}
			divisor >>= 1;
			c--;
		}

		System.out.println(result);

		return isNeg ? -result : result;
	}
}

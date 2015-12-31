package LeetCode;

public class L172_Factorial_Trailing_Zeroes {

	public int trailingZeroes(int n) {

		int rt = 0;
		long N = n;

		for (long i = 5; i <= N; i *= 5) {
			rt += N / i;
		}

		return rt;
	}

}

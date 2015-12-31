package LeetCode;

public class L204_Count_Primes {

	public int countPrimes(int n) {

		boolean[] b = new boolean[n];

		// 将非质数标记为true
		for (int i = 2; i * i < n; i++) {
			if (b[i] == false) {
				for (int j = i; i * j < n; j++) {
					b[i * j] = true;
				}
			}
		}

		// count
		int c = 0;
		for (int i = 2; i < n; i++) {
			if (b[i] == false) {
				c++;
			}
		}

		return c;
	}

}

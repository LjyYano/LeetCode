package LeetCode;

public class L070_Climbing_Stairs {

	public int climbStairs(int n) {

		if (n < 0) {
			return -1;
		} else if (n <= 2) {
			return n;
		}

		int step1 = 1;
		int step2 = 2;
		int step3 = 0;

		// climbStairs(n) = climbStairs(n - 1) + climbStairs(n - 2)
		for (int i = 3; i <= n; i++) {
			step3 = step1 + step2;
			step1 = step2;
			step2 = step3;
		}

		return step3;
	}

}

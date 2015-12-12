package LeetCode;

public class L260_Single_Number_III {

	public int[] singleNumber(int[] nums) {

		int[] rt = new int[2];

		int n = 0;

		for (int v : nums) {
			n ^= v;
		}

		int m = n & (~(n - 1));

		for (int v : nums) {
			if ((m & v) == 0) {
				rt[0] ^= v;
			} else {
				rt[1] ^= v;
			}
		}

		return rt;
	}
}

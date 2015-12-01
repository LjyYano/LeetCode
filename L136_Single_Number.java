package LeetCode;

public class L136_Single_Number {

	public static int singleNumber(int[] nums) {

		int n = 0;

		for (int i : nums) {
			n ^= i;
		}

		return n;
	}

}

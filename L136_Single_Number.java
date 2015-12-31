package LeetCode;

public class L136_Single_Number {

	public int singleNumber(int[] nums) {

		int n = 0;

		for (int i : nums) {
			n ^= i;
		}

		return n;
	}

}

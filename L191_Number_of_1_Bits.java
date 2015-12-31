package LeetCode;

public class L191_Number_of_1_Bits {

	public int hammingWeight(int n) {

		int rt = 0;

		while (n != 0) {
			n = n & (n - 1);
			rt++;
		}

		return rt;
	}

}

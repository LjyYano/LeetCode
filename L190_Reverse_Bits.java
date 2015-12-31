package LeetCode;

public class L190_Reverse_Bits {

	public int reverseBits(int n) {

		int rt = 0;

		for (int i = 0; i < 32; i++) {
			rt |= ((n >> i) & 1) << (31 - i);
		}
		return rt;
	}
}

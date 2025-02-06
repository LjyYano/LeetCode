
// https://leetcode-cn.com/problems/bitwise-and-of-numbers-range/
public class L0201_Bitwise_AND_of_Numbers_Range {
    public int rangeBitwiseAnd(int m, int n) {
		int bit = 0;
		while (m != n) {
			m >>= 1;
			n >>= 1;
			bit++;
		}
		return m << bit;
    }
}
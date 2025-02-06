
// https://leetcode-cn.com/problems/number-of-digit-one/
public class L0233_Number_of_Digit_One {
    public int countDigitOne(int n) {
		int ones = 0;
		for (long m = 1; m <= n; m *= 10) {
			long a = n / m, b = n % m;
			ones += (a + 8) / 10 * m;
			if (a % 10 == 1)
				ones += b + 1;
		}
		return ones;
	
        
    }
}
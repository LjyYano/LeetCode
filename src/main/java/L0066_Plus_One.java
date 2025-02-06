import java.util.Arrays;

// https://leetcode-cn.com/problems/plus-one/
public class L0066_Plus_One {
    public int[] plusOne(int[] digits) {

		if (digits == null || digits.length == 0) {
			return null;
		}

		int[] reslut = new int[digits.length + 1];
		digits[digits.length - 1]++;

		for (int i = digits.length - 1; i >= 0; i--) {
			reslut[i + 1] += digits[i];
			reslut[i] += reslut[i + 1] / 10;
			reslut[i + 1] %= 10;
		}

		if (reslut[0] == 0) {
			return Arrays.copyOfRange(reslut, 1, reslut.length);
		} else {
			return reslut;
		}
	
        
    }
}
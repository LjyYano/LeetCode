
// https://leetcode-cn.com/problems/ugly-number/
public class L0263_Ugly_Number {
    public boolean isUgly(int num) {

		if (num < 1) {
			return false;
		}

		while (num != 1) {
			if (num % 2 == 0) {
				num /= 2;
			} else if (num % 3 == 0) {
				num /= 3;
			} else if (num % 5 == 0) {
				num /= 5;
			} else {
				return false;
			}
		}

		return true;
	
        
    }
}
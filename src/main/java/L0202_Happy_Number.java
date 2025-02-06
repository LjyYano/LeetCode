
// https://leetcode-cn.com/problems/happy-number/
public class L0202_Happy_Number {
    public boolean isHappy(int n) {

		if (n < 1) {
			return false;
		}

		if (n == 1) {
			return true;
		} else if (n == 4) {
			return false;
		}

		int s = 0;
		while (n > 0) {
			s += (n % 10) * (n % 10);
			n /= 10;
		}

		return isHappy(s);
	}
}
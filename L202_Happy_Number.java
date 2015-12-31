package LeetCode;

import java.util.HashSet;
import java.util.Set;

public class L202_Happy_Number {

	public boolean isHappy(int n) {

		if (n < 1) {
			return false;
		}

		if (n == 1) {
			return true;
		}

		Set<Integer> set = new HashSet<Integer>();
		set.add(n);

		while (true) {
			int s = 0;
			while (n > 0) {
				s += (n % 10) * (n % 10);
				n /= 10;
			}
			System.out.println(s);
			if (s == 1) {
				return true;
			} else if (set.contains(s)) {
				return false;
			}
			set.add(s);
			n = s;
		}
	}

	public boolean isHappy2(int n) {

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

		return isHappy2(s);
	}

}

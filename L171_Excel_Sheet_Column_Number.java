package LeetCode;

public class L171_Excel_Sheet_Column_Number {

	public int titleToNumber(String s) {

		int n = 0;
		int p = 1;

		for (int i = s.length() - 1; i >= 0; i--) {
			n += (s.charAt(i) - 'A' + 1) * p;
			p *= 26;
		}

		return n;
	}

}

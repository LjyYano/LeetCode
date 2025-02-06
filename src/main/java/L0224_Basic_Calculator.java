
// https://leetcode-cn.com/problems/basic-calculator/
public class L0224_Basic_Calculator {
    public int calculate(String s) {

		if (s == null || s.length() == 0) {
			return 0;
		}

		int sign = 1;// 符号位，1表示+，-1表示-
		int rt = 0;

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if (Character.isDigit(c)) {
				int val = c - '0';
				// 将数字取出
				while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
					val = val * 10 + s.charAt(++i) - '0';
				}
				rt += sign * val;
			} else if (c == '-') {
				sign = -1;
			} else if (c == '+') {
				sign = 1;
			}
		}

		return rt;

	}
}
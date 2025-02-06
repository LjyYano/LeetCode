
// https://leetcode-cn.com/problems/string-to-integer-atoi/
class L0008_String_to_Integer_atoi {
	public int myAtoi(String str) {
		if (str == null || str.length() == 0) {
			return 0;
		}

		char[] c = str.trim().toCharArray();
		int i = 0, flag = 1, ans = 0;

		if (c[i] == '+') {
			i++;
		} else if (c[i] == '-') {
			flag = -1;
			i++;
		}

		for (; i < c.length; i++) {
			if (c[i] > '9' || c[i] < '0') {
				break;
			}

			// 防止溢出
			if (ans > Integer.MAX_VALUE / 10
					|| (ans == Integer.MAX_VALUE / 10 && (c[i] - '0') > Integer.MAX_VALUE % 10)) {
				return (flag == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
			}

			ans = ans * 10 + c[i] - '0';
		}

		return ans * flag;
	}
}
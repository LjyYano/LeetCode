package LeetCode;

public class L008_String_to_Integer {

	public static int myAtoi(String str) {

		if (str == null || str.length() == 0) {
			return 0;
		}

		char[] c = str.toCharArray();

		int i = 0, flag = 1, result = 0;

		for (; i < c.length; i++) {
			if (c[i] == ' ') {
				continue;
			} else {
				break;
			}
		}

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

			if (result > Integer.MAX_VALUE / 10
					|| (result == Integer.MAX_VALUE / 10 && (c[i] - '0') > Integer.MAX_VALUE % 10)) {
				return (flag == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
			}

			result = result * 10 + c[i] - '0';
		}

		return result * flag;
	}

}

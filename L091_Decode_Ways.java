package LeetCode;

public class L091_Decode_Ways {

	public int numDecodings(String s) {

		if (s == null || s.length() == 0) {
			return 0;
		}

		int n = s.length();
		char[] c = s.toCharArray();

		// 对于台阶，需要前两步的值，所以数组最小是3
		int[] step = new int[Math.max(n + 1, 3)];

		step[0] = 1;
		step[1] = 0;

		// 第一个字符不是0，则第一步初始为1
		if (c[0] != '0') {
			step[1] = 1;
		}

		// step[i] = step[i - 1] + step[i - 2];
		// 只不过加step[i - 2]时，需要对c[i - 2]和c[i - 1]判断，组合是否<=26
		for (int i = 2; i <= n; i++) {

			step[i] = 0;

			if (c[i - 1] != '0') {
				step[i] += step[i - 1];
			}

			if (c[i - 2] != '0') {
				if ((c[i - 2] - '0') * 10 + (c[i - 1] - '0') <= 26) {
					step[i] += step[i - 2];
				}
			}
		}

		return step[n];
	}
}

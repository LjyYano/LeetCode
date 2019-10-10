public class L0091_Decode_Ways {

	public int numDecodings(String s) {

		if (s == null || s.length() == 0) {
			return 0;
		}

		int n = s.length();
		char[] c = s.toCharArray();

		// ����̨�ף���Ҫǰ������ֵ������������С��3
		int[] step = new int[Math.max(n + 1, 3)];

		step[0] = 1;
		step[1] = 0;

		// ��һ���ַ�����0�����һ����ʼΪ1
		if (c[0] != '0') {
			step[1] = 1;
		}

		// step[i] = step[i - 1] + step[i - 2];
		// ֻ������step[i - 2]ʱ����Ҫ��c[i - 2]��c[i - 1]�жϣ�����Ƿ�<=26
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

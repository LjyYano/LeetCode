public class L0067_Add_Binary {

	public static String addBinary(String a, String b) {

		if (a == null || b == null) {
			return null;
		}

		char[] ca = a.toCharArray();
		char[] cb = b.toCharArray();

		int n = Math.max(ca.length, cb.length);

		// ���ȶ���һ�����飬����Ϊn+1����Ϊ������һ����λ
		int[] s = new int[n + 1];

		for (int i = 0; i < n; i++) {
			// ��λ��ӣ�û���򷵻�0
			// ��λ����һλ
			s[i] += toInt(ca, ca.length - 1 - i) + toInt(cb, cb.length - 1 - i);
			s[i + 1] = s[i] / 2;
			s[i] %= 2;
		}

		String result = "";

		// s[n]����ǵ�һλ������resultҪ��ǰ�棨�����0λ�����λ��
		for (int i = n - 1; i >= 0; i--) {
			result = result + s[i];
		}

		// ���s���λ��1�����ڽ������1����ʾ���λ
		if (s[n] == 1) {
			result = "1" + result;
		}

		return result;
	}

	public static int toInt(char c) {
		if (c >= '0') {
			return c - '0';
		}
		return 0;
	}

	public static int toInt(char[] chars, int index) {
		if (index >= 0 && index < chars.length) {
			return toInt(chars[index]);
		}
		return 0;
	}

}

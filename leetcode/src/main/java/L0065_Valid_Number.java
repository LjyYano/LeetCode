public class L0065_Valid_Number {

	public boolean isNumber(String s) {

		if (s == null || s.length() == 0) {
			return false;
		}

		char[] chars = s.toCharArray();
		int start = 0, end = chars.length - 1;

		// ��ȥǰ��Ŀո�
		while ((start < end) && chars[start] == ' ') {
			start++;
		}
		while ((start < end) && chars[end] == ' ') {
			end--;
		}

		// ��Ϊwhile��ѭ��������start < end��sΪ�ո�ʱ����ʣ��һ���ո�
		if (chars[start] == ' ') {
			return false;
		}

		boolean dot = false;
		boolean num = false;
		boolean ex = false;

		for (int i = start; i <= end; i++) {

			char c = chars[i];

			if (c >= '0' && c <= '9') {
				num = true;
			} else if (c == 'e') {
				if (ex)
					return false;
				if (!num)
					return false;

				ex = true;
				num = false;
				dot = false;
			} else if (c == '.') {
				if (dot) {
					return false;
				}
				if (ex) {
					return false;
				}
				dot = true;
			} else if (c == '+' || c == '-') {
				if (num || dot) {
					return false;
				}
			} else {
				return false;
			}
		}

		return num;
	}

}

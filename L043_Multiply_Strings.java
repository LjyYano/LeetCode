package LeetCode;

import java.math.BigInteger;

public class L043_Multiply_Strings {

	public String multiply(String num1, String num2) {

		if (num1 == null || num2 == null) {
			return "";
		}

		int[] paper = new int[num1.length() + num2.length()];

		char[] _num1 = num1.toCharArray();
		char[] _num2 = num2.toCharArray();

		for (int i = 0; i < _num1.length; i++) {
			for (int j = 0; j < _num2.length; j++) {
				paper[paper.length - (i + j + 2)] += (_num1[i] - '0')
						* (_num2[j] - '0');
			}
		}

		// add
		for (int i = 0; i < paper.length - 1; i++) {
			paper[i + 1] += paper[i] / 10;
			paper[i] %= 10;
		}

		String s = "";
		for (int i = paper.length - 1; i > 0; i--) {

			if ("" == s && paper[i] == 0) {
				continue;
			}
			s += paper[i];
		}

		s += paper[0];

		return s;
	}

	// can't be accepted in leetcode
	public String multiply2(String num1, String num2) {

		if (num1 == null || num2 == null) {
			return "";
		}

		BigInteger n1 = new BigInteger(num1);
		BigInteger n2 = new BigInteger(num2);

		return n1.multiply(n2).toString();
	}

}

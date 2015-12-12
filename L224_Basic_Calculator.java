package LeetCode;

import java.util.Stack;

public class L224_Basic_Calculator {

	public int calculate(String s) {

		if (s == null || s.length() == 0) {
			return 0;
		}

		Stack<Integer> stack = new Stack<Integer>();

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
			} else if (c == '(') {
				// 按照数字、符号的顺序，压入栈
				stack.push(rt);
				stack.push(sign);
				rt = 0;
				sign = 1;
			} else if (c == ')') {
				rt = rt * stack.pop() + stack.pop();
				sign = 1;
			}
		}

		return rt;

	}

}

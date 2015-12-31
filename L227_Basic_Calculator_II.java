package LeetCode;

import java.util.Collections;
import java.util.Stack;

public class L227_Basic_Calculator_II {

	public int calculate(String s) {

		if (s == null || s.length() == 0) {
			return 0;
		}

		Stack<Integer> stack = new Stack<Integer>();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if (Character.isDigit(c)) {
				int val = c - '0';
				// 将数字取出
				while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
					val = val * 10 + s.charAt(++i) - '0';
				}
				// 栈顶是 * / 运算符，计算
				if (!stack.isEmpty()
						&& (stack.peek() == 2 || stack.peek() == 3)) {
					int sign = stack.pop();
					int op = stack.pop();
					int rt = 0;
					if (sign == 2) {
						rt = op * val;
					} else {
						rt = op / val;
					}
					stack.push(rt);
				} else {
					stack.push(val);
				}
			} else if (c == ' ') {
				continue;
			} else {
				switch (c) {
				case '+':
					stack.push(0);
					break;
				case '-':
					stack.push(1);
					break;
				case '*':
					stack.push(2);
					break;
				case '/':
					stack.push(3);
					break;

				}
			}
		}

		if (stack.isEmpty()) {
			return 0;
		}

		// 因为要从左向右计算，所以要reverse
		Collections.reverse(stack);

		// 计算+-
		int rt = stack.pop();
		while (!stack.isEmpty()) {
			int sign = stack.pop();
			int op = stack.pop();
			if (sign == 0) {
				rt += op;
			} else {
				rt -= op;
			}
		}

		return rt;
	}

}

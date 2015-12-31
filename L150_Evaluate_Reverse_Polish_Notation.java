package LeetCode;

import java.util.Stack;

public class L150_Evaluate_Reverse_Polish_Notation {

	public int evalRPN(String[] tokens) {

		Stack<Integer> stack = new Stack<Integer>();

		for (String s : tokens) {

			if ("*".equals(s)) {
				int n2 = stack.pop();
				int n1 = stack.pop();

				stack.push(n1 * n2);
			} else if ("/".equals(s)) {
				int n2 = stack.pop();
				int n1 = stack.pop();

				stack.push(n1 / n2);
			} else if ("+".equals(s)) {
				int n2 = stack.pop();
				int n1 = stack.pop();

				stack.push(n1 + n2);
			} else if ("-".equals(s)) {
				int n2 = stack.pop();
				int n1 = stack.pop();

				stack.push(n1 - n2);
			} else {
				stack.push(Integer.valueOf(s));
			}

		}

		return stack.pop();
	}

}

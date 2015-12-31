package LeetCode;

import java.util.Stack;

public class L155_Min_Stack {

	class MinStack {

		Stack<Integer> stack = new Stack<Integer>();
		Stack<Integer> min = new Stack<Integer>();

		public void push(int x) {
			if (stack.isEmpty()) {
				stack.push(x);
				min.push(x);
			} else {
				stack.push(x);
				min.push(Math.min(stack.peek(), min.peek()));
			}
		}

		public void pop() {
			if (!stack.isEmpty()) {
				stack.pop();
				min.pop();
			}
		}

		public int top() {
			if (!stack.isEmpty()) {
				return stack.peek();
			}
			throw new IllegalStateException();
		}

		public int getMin() {
			if (!min.isEmpty()) {
				return min.peek();
			}
			throw new IllegalStateException();
		}
	}

}

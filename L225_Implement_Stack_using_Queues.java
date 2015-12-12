package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class L225_Implement_Stack_using_Queues {

	class MyStack {

		Queue<Integer> q1 = new LinkedList<Integer>();
		Queue<Integer> q2 = new LinkedList<Integer>();

		// Push element x onto stack.
		public void push(int x) {
			if (q1.isEmpty() && q2.isEmpty()) {
				q1.add(x);
			} else if (!q1.isEmpty()) {
				q1.add(x);
			} else {
				q2.add(x);
			}
		}

		// Removes the element on top of the stack.
		public void pop() {

			if (empty()) {
				throw new IllegalStateException();
			}

			// q1、q2必有一个为空
			if (q2.isEmpty()) {
				while (!q1.isEmpty()) {
					int x = q1.remove();
					if (!q1.isEmpty()) {
						q2.add(x);
					}
				}
			} else if (q1.isEmpty()) {
				while (!q2.isEmpty()) {
					int x = q2.remove();
					if (!q2.isEmpty()) {
						q1.add(x);
					}
				}
			}
		}

		// Get the top element.
		public int top() {

			if (empty()) {
				throw new IllegalStateException();
			}

			int x = 0;

			// q1、q2必有一个为空
			if (q2.isEmpty()) {
				while (!q1.isEmpty()) {
					x = q1.remove();
					q2.add(x);
				}
			} else if (q1.isEmpty()) {
				while (!q2.isEmpty()) {
					x = q2.remove();
					q1.add(x);
				}
			}

			return x;
		}

		// Return whether the stack is empty.
		public boolean empty() {

			if (q1.isEmpty() && q2.isEmpty()) {
				return true;
			}

			return false;
		}
	}

}

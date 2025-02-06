import java.util.List;

// https://leetcode-cn.com/problems/basic-calculator-ii/
class L0227_Basic_Calculator_II {
	public int calculate(String s) {
		int ans = 0;
		if (s == null || s.length() == 0) {
			return ans;
		}

		Deque<Integer> deque = new LinkedList<>();
		char operator = '+'; // 记录上一个操作符
		int tmp = 0;

		for (int i = 0; i < s.length() || tmp > 0; i++) {
			char c = i < s.length() ? s.charAt(i) : '+';
			if (c == ' ') {
				continue;
			}
			if (c >= '0' && c <= '9') {
				tmp = tmp * 10 + c - '0';
			} else {
				switch (operator) {
				case '+':
					deque.add(tmp);
					break;
				case '-':
					deque.add(-tmp);
					break;
				case '*':
					deque.add(deque.pollLast() * tmp);
					break;
				case '/':
					deque.add(deque.pollLast() / tmp);
					break;
				}
				tmp = 0;
				operator = c;
			}
		}

		for (int v : deque) {
			ans += v;
		}

		return ans;
	}
}
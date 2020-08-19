import java.util.Stack;

// https://leetcode-cn.com/problems/longest-valid-parentheses/
class L0032_Longest_Valid_Parentheses {
    public int longestValidParentheses(String s) {
		int ans = 0, start = 0;
		Stack<Integer> stack = new Stack<>();
 		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				stack.push(i);
			} else {
				if (stack.isEmpty()) {
					start = i + 1;
				} else {
					stack.pop();
					ans = stack.isEmpty() ? Math.max(ans, i - start + 1) : Math.max(ans, i - stack.peek());
				}
			}
		}
		return ans;
	}
}
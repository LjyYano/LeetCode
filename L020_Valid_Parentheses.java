package LeetCode;

import java.util.HashMap;
import java.util.Stack;

public class L020_Valid_Parentheses {

	public boolean isValid(String s) {

		if (s == null || s.length() % 2 == 1) {
			return false;
		}

		HashMap<Character, Character> map = new HashMap<Character, Character>();
		map.put('(', ')');
		map.put('[', ']');
		map.put('{', '}');

		Stack<Character> stack = new Stack<Character>();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if (map.keySet().contains(c)) {
				stack.push(c);

			} else if (map.values().contains(c)) {

				if (!stack.empty() && map.get(stack.peek()) == c) {
					stack.pop();
				} else {
					return false;
				}
			}
		}

		return stack.empty();
	}

}

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

// https://leetcode-cn.com/problems/valid-parentheses/
class L0020_Valid_Parentheses {
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        Stack<Character> vector = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!map.keySet().contains(c)) {
                vector.push(c);
            } else {
                Character d = map.get(c);
                if (d == null || vector.isEmpty()) {
                    return false;
                }
                if (d != vector.pop()) {
                    return false;
                }
            }
        }

        return vector.isEmpty();
    }
}
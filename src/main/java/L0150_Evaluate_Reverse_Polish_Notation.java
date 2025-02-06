import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

// https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/
class L0150_Evaluate_Reverse_Polish_Notation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        Set<String> set = new HashSet<>(Arrays.asList("+", "-", "*", "/"));
        for (String t : tokens) {
            if (set.contains(t)) {
                int a = stack.pop();
                int b = stack.pop();
                switch (t) {
                    case "+":
                        stack.push(b + a);
                        break;
                    case "-":
                        stack.push(b - a);
                        break;
                    case "*":
                        stack.push(b * a);
                        break;
                    case "/":
                        stack.push(b / a);
                        break;
                }
            } else {
                stack.push(Integer.valueOf(t));
            }
        }
        return stack.pop();
    }
}
import java.util.Stack;

/**
 * https://leetcode.cn/problems/longest-valid-parentheses/
 * 
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 */
public class L0032_LongestValidParentheses {

    public static int longestValidParentheses(String s) {
        // 使用栈来解决，栈中存储的是下标
        Stack<Integer> stack = new Stack<>();
        // 初始化栈，放入 -1 作为哨兵，便于计算长度
        stack.push(-1);
        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                // 遇到左括号，将其下标入栈
                stack.push(i);
            } else {
                // 遇到右括号，先弹出栈顶元素
                stack.pop();
                if (stack.isEmpty()) {
                    // 如果栈为空，说明当前右括号不能匹配，将其下标入栈
                    stack.push(i);
                } else {
                    // 如果栈不为空，说明找到了一个有效的括号对
                    // 计算当前有效括号串的长度
                    maxLength = Math.max(maxLength, i - stack.peek());
                }
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        // 测试用例 1
        String s1 = "(()";
        System.out.println("Input: " + s1);
        System.out.println("Output: " + longestValidParentheses(s1)); // 预期输出：2

        // 测试用例 2
        String s2 = ")()())";
        System.out.println("Input: " + s2);
        System.out.println("Output: " + longestValidParentheses(s2)); // 预期输出：4

        // 测试用例 3
        String s3 = "";
        System.out.println("Input: " + s3);
        System.out.println("Output: " + longestValidParentheses(s3)); // 预期输出：0
    }
} 
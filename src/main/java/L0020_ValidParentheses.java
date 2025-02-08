import java.util.Stack;

/**
 * 题目链接：https://leetcode.cn/problems/valid-parentheses/
 * 
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 
 * 有效字符串需满足：
 * 1. 左括号必须用相同类型的右括号闭合。
 * 2. 左括号必须以正确的顺序闭合。
 * 3. 每个右括号都有一个对应的相同类型的左括号。
 */
public class L0020_ValidParentheses {

    public boolean isValid(String s) {
        // 如果字符串长度为奇数，一定不是有效的括号
        if (s.length() % 2 == 1) {
            return false;
        }
        
        Stack<Character> stack = new Stack<>();
        
        // 遍历字符串
        for (char c : s.toCharArray()) {
            // 如果是左括号，入栈
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                // 如果是右括号，且栈为空，说明没有匹配的左括号
                if (stack.isEmpty()) {
                    return false;
                }
                
                // 获取栈顶的左括号
                char left = stack.pop();
                
                // 检查括号是否匹配
                if (c == ')' && left != '(') {
                    return false;
                }
                if (c == '}' && left != '{') {
                    return false;
                }
                if (c == ']' && left != '[') {
                    return false;
                }
            }
        }
        
        // 最后检查栈是否为空
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        L0020_ValidParentheses solution = new L0020_ValidParentheses();

        // 测试用例 1
        String s1 = "()";
        System.out.println("Input: s = \"" + s1 + "\"");
        System.out.println("Output: " + solution.isValid(s1));
        // 预期输出：true

        // 测试用例 2
        String s2 = "()[]{}";
        System.out.println("\nInput: s = \"" + s2 + "\"");
        System.out.println("Output: " + solution.isValid(s2));
        // 预期输出：true

        // 测试用例 3
        String s3 = "(]";
        System.out.println("\nInput: s = \"" + s3 + "\"");
        System.out.println("Output: " + solution.isValid(s3));
        // 预期输出：false

        // 测试用例 4
        String s4 = "([)]";
        System.out.println("\nInput: s = \"" + s4 + "\"");
        System.out.println("Output: " + solution.isValid(s4));
        // 预期输出：false

        // 测试用例 5
        String s5 = "{[]}";
        System.out.println("\nInput: s = \"" + s5 + "\"");
        System.out.println("Output: " + solution.isValid(s5));
        // 预期输出：true
    }
} 
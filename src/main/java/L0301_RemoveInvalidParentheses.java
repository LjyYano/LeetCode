/**
 * https://leetcode.cn/problems/remove-invalid-parentheses/
 * 
 * 给你一个由若干括号和字母组成的字符串 s ，删除最小数量的无效括号，使得输入的字符串有效。
 * 返回所有可能的结果。答案可以按 任意顺序 返回。
 * 
 * 示例 1：
 * 输入：s = "()())()"
 * 输出：["(())()","()()()"]
 * 
 * 示例 2：
 * 输入：s = "(a)())()"
 * 输出：["(a())()","(a)()()"]
 * 
 * 示例 3：
 * 输入：s = ")("
 * 输出：[""]
 * 
 * 提示：
 * - 1 <= s.length <= 25
 * - s 由小写英文字母以及括号 '(' 和 ')' 组成
 * - s 中至多含 20 个括号
 */
import java.util.*;

public class L0301_RemoveInvalidParentheses {
    
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        if (s == null) {
            return result;
        }
        
        // 计算需要删除的左括号和右括号数量
        int removeLeft = 0;
        int removeRight = 0;
        
        for (char c : s.toCharArray()) {
            if (c == '(') {
                removeLeft++;
            } else if (c == ')') {
                if (removeLeft > 0) {
                    removeLeft--;
                } else {
                    removeRight++;
                }
            }
        }
        
        // 使用回溯法生成所有可能的结果
        backtrack(s, 0, removeLeft, removeRight, 0, new StringBuilder(), result);
        return result;
    }
    
    /**
     * 回溯法
     * @param s 原始字符串
     * @param index 当前处理的位置
     * @param removeLeft 还需要删除的左括号数量
     * @param removeRight 还需要删除的右括号数量
     * @param open 当前未匹配的左括号数量
     * @param path 当前构建的路径
     * @param result 结果列表
     */
    private void backtrack(String s, int index, int removeLeft, int removeRight, 
                          int open, StringBuilder path, List<String> result) {
        // 递归终止条件
        if (index == s.length()) {
            if (removeLeft == 0 && removeRight == 0 && open == 0) {
                result.add(path.toString());
            }
            return;
        }
        
        char c = s.charAt(index);
        
        // 选择1：删除当前字符
        if (c == '(' && removeLeft > 0) {
            backtrack(s, index + 1, removeLeft - 1, removeRight, open, path, result);
        }
        if (c == ')' && removeRight > 0) {
            backtrack(s, index + 1, removeLeft, removeRight - 1, open, path, result);
        }
        
        // 选择2：保留当前字符
        path.append(c);
        if (c != '(' && c != ')') {
            backtrack(s, index + 1, removeLeft, removeRight, open, path, result);
        } else if (c == '(') {
            backtrack(s, index + 1, removeLeft, removeRight, open + 1, path, result);
        } else if (open > 0) { // c == ')'
            backtrack(s, index + 1, removeLeft, removeRight, open - 1, path, result);
        }
        path.deleteCharAt(path.length() - 1);
    }

    public static void main(String[] args) {
        L0301_RemoveInvalidParentheses solution = new L0301_RemoveInvalidParentheses();
        
        // 测试用例 1
        System.out.println(solution.removeInvalidParentheses("()())()"));
        // 预期输出：["(())()","()()()"]
        
        // 测试用例 2
        System.out.println(solution.removeInvalidParentheses("(a)())()"));
        // 预期输出：["(a())()","(a)()()"]
        
        // 测试用例 3
        System.out.println(solution.removeInvalidParentheses(")("));
        // 预期输出：[""]
    }
}

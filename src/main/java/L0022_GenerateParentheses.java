import java.util.ArrayList;
import java.util.List;

/**
 * 题目链接：https://leetcode.cn/problems/generate-parentheses/
 * 
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 */
public class L0022_GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        // 从空字符串开始回溯,初始左括号和右括号都是 n 个
        backtrack(result, "", n, n);
        return result;
    }

    /**
     * 回溯生成括号
     * @param result 结果列表
     * @param current 当前生成的字符串
     * @param left 剩余的左括号数量
     * @param right 剩余的右括号数量
     */
    private void backtrack(List<String> result, String current, int left, int right) {
        // 当左右括号都用完时,将当前字符串加入结果集
        if (left == 0 && right == 0) {
            result.add(current);
            return;
        }

        // 如果还有左括号,可以添加左括号
        if (left > 0) {
            backtrack(result, current + "(", left - 1, right);
        }
        // 如果右括号数量大于左括号数量,可以添加右括号
        if (right > left) {
            backtrack(result, current + ")", left, right - 1);
        }
    }

    public static void main(String[] args) {
        L0022_GenerateParentheses solution = new L0022_GenerateParentheses();
        
        // 测试用例 1: n = 1
        System.out.println("n = 1 的结果：");
        System.out.println(solution.generateParenthesis(1));
        // 预期输出：["()"]
        
        // 测试用例 2: n = 2
        System.out.println("\nn = 2 的结果：");
        System.out.println(solution.generateParenthesis(2));
        // 预期输出：["(())", "()()"]
        
        // 测试用例 3: n = 3
        System.out.println("\nn = 3 的结果：");
        System.out.println(solution.generateParenthesis(3));
        // 预期输出：["((()))", "(()())", "(())()", "()(())", "()()()"]
    }
} 
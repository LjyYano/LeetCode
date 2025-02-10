import java.util.Stack;

/**
 * https://leetcode.cn/problems/basic-calculator-ii/
 * 
 * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 * 整数除法仅保留整数部分。
 * 你可以假设给定的表达式总是有效的。所有中间结果将在 [-2³¹, 2³¹ - 1] 的范围内。
 * 注意：不允许使用任何将字符串作为数学表达式计算的内置函数，比如 eval() 。
 * 
 * 示例 1：
 * 输入：s = "3+2*2"
 * 输出：7
 * 
 * 示例 2：
 * 输入：s = " 3/2 "
 * 输出：1
 * 
 * 示例 3：
 * 输入：s = " 3+5 / 2 "
 * 输出：5
 * 
 * 提示：
 * - 1 <= s.length <= 3 * 10⁵
 * - s 由整数和算符 ('+', '-', '*', '/') 组成，中间由一些空格隔开
 * - s 表示一个 有效表达式
 * - 表达式中的所有整数都是非负整数，且在范围 [0, 2³¹ - 1] 内
 * - 题目数据保证答案是一个 32 位整数
 */
public class L0227_BasicCalculatorII {
    
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char lastOp = '+';  // 上一个操作符，初始为 +
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            // 如果是数字，累加到 num
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }
            
            // 如果是操作符或者是最后一个字符，处理前面的数字和操作符
            if ((!Character.isDigit(c) && c != ' ') || i == s.length() - 1) {
                // 根据上一个操作符处理当前数字
                switch (lastOp) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    case '/':
                        stack.push(stack.pop() / num);
                        break;
                }
                
                // 更新操作符和数字
                lastOp = c;
                num = 0;
            }
        }
        
        // 计算最终结果
        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        
        return result;
    }

    public static void main(String[] args) {
        L0227_BasicCalculatorII solution = new L0227_BasicCalculatorII();
        
        // 测试用例 1
        String s1 = "3+2*2";
        System.out.println("输入：" + s1);
        System.out.println("输出：" + solution.calculate(s1));  // 预期输出：7
        
        // 测试用例 2
        String s2 = " 3/2 ";
        System.out.println("\n输入：" + s2);
        System.out.println("输出：" + solution.calculate(s2));  // 预期输出：1
        
        // 测试用例 3
        String s3 = " 3+5 / 2 ";
        System.out.println("\n输入：" + s3);
        System.out.println("输出：" + solution.calculate(s3));  // 预期输出：5
    }
} 
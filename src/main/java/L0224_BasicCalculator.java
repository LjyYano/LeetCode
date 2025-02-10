import java.util.Stack;

/**
 * https://leetcode.cn/problems/basic-calculator/
 * 
 * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 * 注意:不允许使用任何将字符串作为数学表达式计算的内置函数，比如 eval() 。
 * 
 * 示例 1：
 * 输入：s = "1 + 1"
 * 输出：2
 * 
 * 示例 2：
 * 输入：s = " 2-1 + 2 "
 * 输出：3
 * 
 * 示例 3：
 * 输入：s = "(1+(4+5+2)-3)+(6+8)"
 * 输出：23
 * 
 * 提示：
 * - 1 <= s.length <= 3 * 10^5
 * - s 由数字、'+'、'-'、'('、')'、和 ' ' 组成
 * - s 表示一个有效的表达式
 * - '+' 不能用作一元运算(例如， "+1" 和 "+(2 + 3)" 无效)
 * - '-' 可以用作一元运算(即 "-1" 和 "-(2 + 3)" 是有效的)
 * - 输入中不存在两个连续的操作符
 * - 每个数字和运行的计算将适合于一个有符号的 32 位整数
 */
public class L0224_BasicCalculator {
    
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;  // 当前结果
        int number = 0;  // 当前数字
        int sign = 1;    // 当前符号：1表示正，-1表示负
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (Character.isDigit(c)) {
                // 如果是数字，累加到number
                number = number * 10 + (c - '0');
            } else if (c == '+') {
                // 计算前面的结果
                result += sign * number;
                // 重置number和sign
                number = 0;
                sign = 1;
            } else if (c == '-') {
                // 计算前面的结果
                result += sign * number;
                // 重置number和sign
                number = 0;
                sign = -1;
            } else if (c == '(') {
                // 遇到左括号，将当前结果和符号压入栈
                stack.push(result);
                stack.push(sign);
                // 重置result和sign
                result = 0;
                sign = 1;
            } else if (c == ')') {
                // 计算括号内的最后一个数字
                result += sign * number;
                // 重置number
                number = 0;
                // 从栈中取出符号和结果
                result *= stack.pop();    // 取出符号
                result += stack.pop();    // 取出之前的结果
            }
        }
        
        // 处理最后一个数字
        if (number != 0) {
            result += sign * number;
        }
        
        return result;
    }

    public static void main(String[] args) {
        L0224_BasicCalculator solution = new L0224_BasicCalculator();
        
        // 测试用例 1
        String s1 = "1 + 1";
        System.out.println("测试用例 1：");
        System.out.println("输入：" + s1);
        System.out.println("输出：" + solution.calculate(s1));  // 预期输出：2
        
        // 测试用例 2
        String s2 = " 2-1 + 2 ";
        System.out.println("\n测试用例 2：");
        System.out.println("输入：" + s2);
        System.out.println("输出：" + solution.calculate(s2));  // 预期输出：3
        
        // 测试用例 3
        String s3 = "(1+(4+5+2)-3)+(6+8)";
        System.out.println("\n测试用例 3：");
        System.out.println("输入：" + s3);
        System.out.println("输出：" + solution.calculate(s3));  // 预期输出：23
    }
} 
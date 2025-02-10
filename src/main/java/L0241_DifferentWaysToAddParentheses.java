/**
 * https://leetcode.cn/problems/different-ways-to-add-parentheses/
 * 
 * 给你一个由数字和运算符组成的字符串 expression，按不同优先级组合数字和运算符，计算并返回所有可能组合的结果。你可以按任意顺序返回答案。
 * 
 * 生成的测试用例满足其对应输出值符合 32 位整数范围，不同结果的数量不超过 10⁴。
 * 
 * 示例 1：
 * 输入：expression = "2-1-1"
 * 输出：[0,2]
 * 解释：
 * ((2-1)-1) = 0 
 * (2-(1-1)) = 2
 * 
 * 示例 2：
 * 输入：expression = "2*3-4*5"
 * 输出：[-34,-14,-10,-10,10]
 * 解释：
 * (2*(3-(4*5))) = -34 
 * ((2*3)-(4*5)) = -14 
 * ((2*(3-4))*5) = -10 
 * (2*((3-4)*5)) = -10 
 * (((2*3)-4)*5) = 10
 * 
 * 提示：
 * - 1 <= expression.length <= 20
 * - expression 由数字和算符 '+'、'-' 和 '*' 组成。
 * - 输入表达式中的所有整数值在范围 [0, 99] 
 */

import java.util.ArrayList;
import java.util.List;

public class L0241_DifferentWaysToAddParentheses {
    
    /**
     * 使用分治法计算所有可能的结果
     * 遍历字符串中的每个运算符，将表达式分成左右两部分
     * 递归计算左右两部分的所有可能结果，然后根据运算符组合结果
     */
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> result = new ArrayList<>();
        
        // 如果表达式中只包含数字，直接返回该数字
        if (!expression.contains("+") && !expression.contains("-") && !expression.contains("*")) {
            result.add(Integer.parseInt(expression));
            return result;
        }
        
        // 遍历表达式的每个字符
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            // 如果是运算符，则将表达式分成左右两部分，分别计算
            if (c == '+' || c == '-' || c == '*') {
                // 递归计算左右两部分的所有可能结果
                List<Integer> left = diffWaysToCompute(expression.substring(0, i));
                List<Integer> right = diffWaysToCompute(expression.substring(i + 1));
                
                // 根据运算符计算所有可能的结果
                for (int l : left) {
                    for (int r : right) {
                        if (c == '+') {
                            result.add(l + r);
                        } else if (c == '-') {
                            result.add(l - r);
                        } else if (c == '*') {
                            result.add(l * r);
                        }
                    }
                }
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        L0241_DifferentWaysToAddParentheses solution = new L0241_DifferentWaysToAddParentheses();
        
        // 测试用例 1
        String expression1 = "2-1-1";
        System.out.println("输入：" + expression1);
        System.out.println("输出：" + solution.diffWaysToCompute(expression1));
        
        // 测试用例 2
        String expression2 = "2*3-4*5";
        System.out.println("\n输入：" + expression2);
        System.out.println("输出：" + solution.diffWaysToCompute(expression2));
    }
} 
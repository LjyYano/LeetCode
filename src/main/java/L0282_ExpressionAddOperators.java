/**
 * https://leetcode.cn/problems/expression-add-operators/
 * 
 * 给定一个仅包含数字的字符串 num 和一个目标值 target，在 num 的数字之间添加 二元 运算符（不是一元）+、- 或 * ，返回 所有 能够得到 target 的表达式。
 * 
 * 注意，返回表达式中的操作数 不应该 包含前导零。
 * 
 * 示例 1:
 * 输入: num = "123", target = 6
 * 输出: ["1+2+3", "1*2*3"] 
 * 
 * 示例 2:
 * 输入: num = "232", target = 8
 * 输出: ["2*3+2", "2+3*2"]
 * 
 * 示例 3:
 * 输入: num = "3456237490", target = 9191
 * 输出: []
 * 
 * 提示：
 * - 1 <= num.length <= 10
 * - num 仅含数字
 * - -2³¹ <= target <= 2³¹ - 1
 */

import java.util.*;

public class L0282_ExpressionAddOperators {
    
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        if (num == null || num.length() == 0) {
            return result;
        }
        
        backtrack(result, num, target, 0, 0, 0, new StringBuilder());
        return result;
    }
    
    /**
     * 回溯法生成所有可能的表达式
     * @param result 结果列表
     * @param num 输入的数字字符串
     * @param target 目标值
     * @param index 当前处理的位置
     * @param eval 当前表达式的计算结果
     * @param multed 上一个乘法操作的结果
     * @param expr 当前构建的表达式
     */
    private void backtrack(List<String> result, String num, int target, int index, 
            long eval, long multed, StringBuilder expr) {
        // 如果已经处理完所有数字
        if (index == num.length()) {
            // 如果当前表达式的值等于目标值，将表达式添加到结果列表
            if (eval == target) {
                result.add(expr.toString());
            }
            return;
        }
        
        // 记录当前表达式的长度，用于回溯
        int len = expr.length();
        
        // 如果不是第一个数字，需要添加操作符
        if (index != 0) {
            expr.append(" ");
        }
        
        // 获取当前位置的数字
        long cur = 0;
        // 处理数字，注意前导零的情况
        for (int i = index; i < num.length(); i++) {
            // 如果数字以0开头且长度大于1，跳过
            if (i != index && num.charAt(index) == '0') {
                break;
            }
            cur = cur * 10 + (num.charAt(i) - '0');
            
            // 如果是第一个数字，不需要添加操作符
            if (index == 0) {
                backtrack(result, num, target, i + 1, cur, cur, expr.append(cur));
                expr.setLength(len);
                continue;
            }
            
            // 尝试加法
            expr.append("+").append(cur);
            backtrack(result, num, target, i + 1, eval + cur, cur, expr);
            expr.setLength(len);
            
            // 尝试减法
            expr.append("-").append(cur);
            backtrack(result, num, target, i + 1, eval - cur, -cur, expr);
            expr.setLength(len);
            
            // 尝试乘法
            expr.append("*").append(cur);
            backtrack(result, num, target, i + 1, eval - multed + multed * cur, multed * cur, expr);
            expr.setLength(len);
        }
    }

    public static void main(String[] args) {
        L0282_ExpressionAddOperators solution = new L0282_ExpressionAddOperators();
        
        // 测试用例 1
        System.out.println(solution.addOperators("123", 6));  // 预期输出：["1+2+3", "1*2*3"]
        
        // 测试用例 2
        System.out.println(solution.addOperators("232", 8));  // 预期输出：["2*3+2", "2+3*2"]
        
        // 测试用例 3
        System.out.println(solution.addOperators("3456237490", 9191));  // 预期输出：[]
    }
} 
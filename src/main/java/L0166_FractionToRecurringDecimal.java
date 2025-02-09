import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.cn/problems/fraction-to-recurring-decimal/
 * 
 * 给定两个整数，分别表示分数的分子 numerator 和分母 denominator，以 字符串形式返回小数 。
 * 
 * 如果小数部分为循环小数，则将循环的部分括在括号内。
 * 
 * 如果存在多个答案，只需返回 任意一个 。
 * 
 * 对于所有给定的输入，保证 答案字符串的长度小于 10⁴ 。
 * 
 * 示例 1：
 * 输入：numerator = 1, denominator = 2
 * 输出："0.5"
 * 
 * 示例 2：
 * 输入：numerator = 2, denominator = 1
 * 输出："2"
 * 
 * 示例 3：
 * 输入：numerator = 4, denominator = 333
 * 输出："0.(012)"
 * 
 * 提示：
 * - -2³¹ <= numerator, denominator <= 2³¹ - 1
 * - denominator != 0
 */

public class L0166_FractionToRecurringDecimal {
    
    public String fractionToDecimal(int numerator, int denominator) {
        // 处理特殊情况：分子为 0
        if (numerator == 0) {
            return "0";
        }
        
        StringBuilder result = new StringBuilder();
        
        // 处理正负号
        // 使用异或运算判断结果的符号：相同为正，不同为负
        if (numerator < 0 ^ denominator < 0) {
            result.append("-");
        }
        
        // 将 int 转换为 long，避免溢出
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);
        
        // 处理整数部分
        result.append(num / den);
        
        // 处理小数部分
        num = num % den;
        if (num == 0) {
            return result.toString();
        }
        
        // 添加小数点
        result.append(".");
        
        // 使用 HashMap 存储余数及其对应的位置，用于检测循环
        Map<Long, Integer> map = new HashMap<>();
        
        while (num != 0) {
            // 如果当前余数已经出现过，说明找到了循环节
            if (map.containsKey(num)) {
                // 在循环开始的位置插入左括号，在末尾添加右括号
                result.insert(map.get(num), "(");
                result.append(")");
                break;
            }
            
            // 记录当前余数及其对应的位置
            map.put(num, result.length());
            
            // 余数乘以 10，继续除法运算
            num *= 10;
            result.append(num / den);
            num %= den;
        }
        
        return result.toString();
    }

    public static void main(String[] args) {
        L0166_FractionToRecurringDecimal solution = new L0166_FractionToRecurringDecimal();
        
        // 测试用例 1
        int numerator1 = 1;
        int denominator1 = 2;
        System.out.println("测试用例 1：");
        System.out.println("输入：numerator = " + numerator1 + ", denominator = " + denominator1);
        System.out.println("输出：\"" + solution.fractionToDecimal(numerator1, denominator1) + "\"");
        System.out.println("预期：\"0.5\"");
        System.out.println();
        
        // 测试用例 2
        int numerator2 = 2;
        int denominator2 = 1;
        System.out.println("测试用例 2：");
        System.out.println("输入：numerator = " + numerator2 + ", denominator = " + denominator2);
        System.out.println("输出：\"" + solution.fractionToDecimal(numerator2, denominator2) + "\"");
        System.out.println("预期：\"2\"");
        System.out.println();
        
        // 测试用例 3
        int numerator3 = 4;
        int denominator3 = 333;
        System.out.println("测试用例 3：");
        System.out.println("输入：numerator = " + numerator3 + ", denominator = " + denominator3);
        System.out.println("输出：\"" + solution.fractionToDecimal(numerator3, denominator3) + "\"");
        System.out.println("预期：\"0.(012)\"");
    }
} 
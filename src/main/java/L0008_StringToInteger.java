/**
 * 题目链接：https://leetcode.cn/problems/string-to-integer-atoi/
 * 
 * 请你来实现一个 myAtoi(string s) 函数，使其能将字符串转换成一个 32 位有符号整数。
 * 
 * 函数 myAtoi(string s) 的算法如下：
 * 1. 读入字符串并丢弃无用的前导空格
 * 2. 检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
 * 3. 读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
 * 4. 将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。
 * 5. 如果整数数超过 32 位有符号整数范围 [−2^31,  2^31 − 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −2^31 的整数应该被固定为 −2^31 ，大于 2^31 − 1 的整数应该被固定为 2^31 − 1 。
 * 6. 返回整数作为最终结果。
 */
public class L0008_StringToInteger {
    
    public int myAtoi(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        // 去除前导空格
        s = s.trim();
        if (s.length() == 0) {
            return 0;
        }
        
        // 记录结果
        int result = 0;
        // 记录符号，1 表示正数，-1 表示负数
        int sign = 1;
        // 当前处理的字符位置
        int index = 0;
        
        // 处理符号
        if (s.charAt(index) == '+' || s.charAt(index) == '-') {
            sign = s.charAt(index) == '+' ? 1 : -1;
            index++;
        }
        
        // 处理数字
        while (index < s.length() && Character.isDigit(s.charAt(index))) {
            int digit = s.charAt(index) - '0';
            
            // 判断是否溢出
            if (result > Integer.MAX_VALUE / 10 || 
                (result == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            
            result = result * 10 + digit;
            index++;
        }
        
        return sign * result;
    }

    public static void main(String[] args) {
        L0008_StringToInteger solution = new L0008_StringToInteger();
        
        // 测试用例 1：正常数字
        String s1 = "42";
        System.out.println("输入：" + s1);
        System.out.println("输出：" + solution.myAtoi(s1));  // 预期输出：42
        
        // 测试用例 2：带符号和空格
        String s2 = "   -42";
        System.out.println("\n输入：" + s2);
        System.out.println("输出：" + solution.myAtoi(s2));  // 预期输出：-42
        
        // 测试用例 3：带额外字符
        String s3 = "4193 with words";
        System.out.println("\n输入：" + s3);
        System.out.println("输出：" + solution.myAtoi(s3));  // 预期输出：4193
        
        // 测试用例 4：超出范围
        String s4 = "91283472332";
        System.out.println("\n输入：" + s4);
        System.out.println("输出：" + solution.myAtoi(s4));  // 预期输出：2147483647
        
        // 测试用例 5：无效输入
        String s5 = "words and 987";
        System.out.println("\n输入：" + s5);
        System.out.println("输出：" + solution.myAtoi(s5));  // 预期输出：0
    }
} 
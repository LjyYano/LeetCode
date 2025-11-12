/**
 * https://leetcode.cn/problems/base-7/
 * 
 * 给定一个整数 num，将其转化为 7 进制，并以字符串形式输出。
 * 
 * 示例 1：
 * 输入: num = 100
 * 输出: "202"
 * 
 * 示例 2：
 * 输入: num = -7
 * 输出: "-10"
 * 
 * 提示：
 * - -10^7 <= num <= 10^7
 */
public class L0504_Base7 {
    
    /**
     * 进制转换
     * 不断除以 7，取余数，直到商为 0
     */
    public String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }
        
        boolean negative = num < 0;
        num = Math.abs(num);
        
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            sb.append(num % 7);
            num /= 7;
        }
        
        if (negative) {
            sb.append('-');
        }
        
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        L0504_Base7 solution = new L0504_Base7();
        
        // 测试用例 1
        System.out.println(solution.convertToBase7(100)); // 预期输出："202"
        
        // 测试用例 2
        System.out.println(solution.convertToBase7(-7)); // 预期输出："-10"
        
        // 测试用例 3
        System.out.println(solution.convertToBase7(0)); // 预期输出："0"
    }
}

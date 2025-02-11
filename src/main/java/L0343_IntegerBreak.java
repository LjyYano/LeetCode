/**
 * https://leetcode.cn/problems/integer-break/
 * 
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。返回你可以获得的最大乘积。
 * 
 * 示例 1:
 * 输入: n = 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1。
 * 
 * 示例 2:
 * 输入: n = 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
 * 
 * 提示:
 * 2 <= n <= 58
 */
public class L0343_IntegerBreak {
    
    public int integerBreak(int n) {
        // 特殊情况处理
        if (n <= 3) {
            return n - 1;
        }
        
        // 计算有多少个 3
        int quotient = n / 3;
        // 计算余数
        int remainder = n % 3;
        
        if (remainder == 0) {
            // 能被 3 整除，直接返回 3 的 quotient 次方
            return (int) Math.pow(3, quotient);
        } else if (remainder == 1) {
            // 余数为 1，需要将一个 3 拆分为 2+2
            return (int) Math.pow(3, quotient - 1) * 4;
        } else {
            // 余数为 2，直接乘以 2
            return (int) Math.pow(3, quotient) * 2;
        }
    }

    public static void main(String[] args) {
        L0343_IntegerBreak solution = new L0343_IntegerBreak();
        
        // 测试用例
        System.out.println("n = 2 时的最大乘积：" + solution.integerBreak(2));  // 应该输出 1
        System.out.println("n = 10 时的最大乘积：" + solution.integerBreak(10)); // 应该输出 36
        System.out.println("n = 4 时的最大乘积：" + solution.integerBreak(4));  // 应该输出 4
        System.out.println("n = 7 时的最大乘积：" + solution.integerBreak(7));  // 应该输出 12
        System.out.println("n = 8 时的最大乘积：" + solution.integerBreak(8));  // 应该输出 18
    }
} 
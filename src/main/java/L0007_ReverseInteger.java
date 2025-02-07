/**
 * 题目链接：https://leetcode.cn/problems/reverse-integer/
 * 
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * 如果反转后整数超过 32 位的有符号整数的范围 [−2^31, 2^31 − 1] ，就返回 0。
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 */
public class L0007_ReverseInteger {
    
    public int reverse(int x) {
        // 结果
        int result = 0;
        
        // 当 x 不为 0 时继续处理
        while (x != 0) {
            // 取出最后一位数字
            int digit = x % 10;
            
            // 判断是否会溢出
            // 对于正数，result > Integer.MAX_VALUE/10 或者 result == Integer.MAX_VALUE/10 且 digit > 7 时会溢出
            // 对于负数，result < Integer.MIN_VALUE/10 或者 result == Integer.MIN_VALUE/10 且 digit < -8 时会溢出
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && digit > 7)) {
                return 0;
            }
            if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && digit < -8)) {
                return 0;
            }
            
            // 将当前数字加入结果
            result = result * 10 + digit;
            
            // 去掉已处理的最后一位
            x /= 10;
        }
        
        return result;
    }

    public static void main(String[] args) {
        L0007_ReverseInteger solution = new L0007_ReverseInteger();
        
        // 测试用例 1：正数
        int x1 = 123;
        System.out.println("输入：" + x1);
        System.out.println("输出：" + solution.reverse(x1));  // 预期输出：321
        
        // 测试用例 2：负数
        int x2 = -123;
        System.out.println("\n输入：" + x2);
        System.out.println("输出：" + solution.reverse(x2));  // 预期输出：-321
        
        // 测试用例 3：末尾有零
        int x3 = 120;
        System.out.println("\n输入：" + x3);
        System.out.println("输出：" + solution.reverse(x3));  // 预期输出：21
        
        // 测试用例 4：溢出
        int x4 = 1534236469;
        System.out.println("\n输入：" + x4);
        System.out.println("输出：" + solution.reverse(x4));  // 预期输出：0
    }
} 
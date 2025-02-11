/**
 * https://leetcode.cn/problems/sum-of-two-integers/
 * 
 * 给你两个整数 a 和 b ，不使用 运算符 + 和 - ，计算并返回两整数之和。
 * 
 * 示例 1：
 * 输入：a = 1, b = 2
 * 输出：3
 * 
 * 示例 2：
 * 输入：a = 2, b = 3
 * 输出：5
 * 
 * 提示：
 * -1000 <= a, b <= 1000
 */
public class L0371_SumOfTwoIntegers {
    
    public int getSum(int a, int b) {
        // 使用位运算实现加法
        // a ^ b 得到无进位的加法结果
        // (a & b) << 1 得到进位结果
        while (b != 0) {
            // 计算进位
            int carry = (a & b) << 1;
            // 计算无进位加法
            a = a ^ b;
            // 将进位赋值给 b，继续循环直到没有进位
            b = carry;
        }
        return a;
    }

    public static void main(String[] args) {
        L0371_SumOfTwoIntegers solution = new L0371_SumOfTwoIntegers();
        
        // 测试用例
        System.out.println("1 + 2 = " + solution.getSum(1, 2));  // 应该输出 3
        System.out.println("2 + 3 = " + solution.getSum(2, 3));  // 应该输出 5
        System.out.println("-1 + 1 = " + solution.getSum(-1, 1));  // 应该输出 0
        System.out.println("-2 + 3 = " + solution.getSum(-2, 3));  // 应该输出 1
    }
} 
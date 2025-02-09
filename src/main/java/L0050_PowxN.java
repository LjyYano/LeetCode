/**
 * https://leetcode.cn/problems/powx-n/
 * 
 * 实现 pow(x, n) ，即计算 x 的整数 n 次幂函数（即，x^n ）。
 * 
 * 示例 1：
 * 输入：x = 2.00000, n = 10
 * 输出：1024.00000
 * 
 * 示例 2：
 * 输入：x = 2.10000, n = 3
 * 输出：9.26100
 * 
 * 示例 3：
 * 输入：x = 2.00000, n = -2
 * 输出：0.25000
 * 解释：2^-2 = 1/2^2 = 1/4 = 0.25
 * 
 * 提示：
 * -100.0 < x < 100.0
 * -2^31 <= n <= 2^31-1
 * n 是一个整数
 * -10^4 <= x^n <= 10^4
 */
public class L0050_PowxN {

    // 使用快速幂算法实现
    public double myPow(double x, int n) {
        // 处理特殊情况
        if (n == 0) {
            return 1.0;
        }
        if (x == 1.0) {
            return 1.0;
        }
        if (x == -1.0) {
            return n % 2 == 0 ? 1.0 : -1.0;
        }

        // 处理 n 为最小值的情况
        if (n == Integer.MIN_VALUE) {
            return Math.abs(x) < 1.0 ? Double.POSITIVE_INFINITY : 0.0;
        }

        // 处理负数指数的情况
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }

        // 快速幂算法
        double result = 1.0;
        while (n > 0) {
            // 如果当前二进制位为 1，将当前 x 累乘到结果中
            if ((n & 1) == 1) {
                result *= x;
            }
            // x 自乘，准备下一位的计算
            x *= x;
            // n 右移一位
            n >>= 1;
        }
        return result;
    }

    public static void main(String[] args) {
        L0050_PowxN solution = new L0050_PowxN();

        // 测试用例 1
        System.out.println("测试用例 1：");
        System.out.println("输入：x = 2.00000, n = 10");
        System.out.println("输出：" + solution.myPow(2.00000, 10));
        System.out.println("预期：1024.00000");
        System.out.println();

        // 测试用例 2
        System.out.println("测试用例 2：");
        System.out.println("输入：x = 2.10000, n = 3");
        System.out.println("输出：" + solution.myPow(2.10000, 3));
        System.out.println("预期：9.26100");
        System.out.println();

        // 测试用例 3
        System.out.println("测试用例 3：");
        System.out.println("输入：x = 2.00000, n = -2");
        System.out.println("输出：" + solution.myPow(2.00000, -2));
        System.out.println("预期：0.25000");
    }
} 
/**
 * https://leetcode.cn/problems/divide-two-integers/
 * 
 * 给你两个整数，被除数 dividend 和除数 divisor。将两数相除，要求 不使用 乘法、除法和取余运算。
 * 整数除法应该向零截断，也就是截去（truncate）其小数部分。例如，8.345 将被截断为 8 ，-2.7335 将被截断至 -2 。
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 * 
 * 注意：假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−2^31, 2^31 − 1] 。本题中，如果商严格大于 2^31 − 1 ，则返回 2^31 − 1 ；
 * 如果商严格小于 -2^31 ，则返回 -2^31 。
 */
public class L0029_DivideTwoIntegers {

    public static void main(String[] args) {
        Solution solution = new L0029_DivideTwoIntegers().new Solution();
        
        // 测试用例 1
        int dividend1 = 10;
        int divisor1 = 3;
        System.out.println("测试用例 1 结果：" + solution.divide(dividend1, divisor1));  // 预期输出：3
        
        // 测试用例 2
        int dividend2 = 7;
        int divisor2 = -3;
        System.out.println("测试用例 2 结果：" + solution.divide(dividend2, divisor2));  // 预期输出：-2
        
        // 测试用例 3：最小值除以 -1
        int dividend3 = Integer.MIN_VALUE;
        int divisor3 = -1;
        System.out.println("测试用例 3 结果：" + solution.divide(dividend3, divisor3));  // 预期输出：2147483647
        
        // 测试用例 4：0 除以任何数
        int dividend4 = 0;
        int divisor4 = 1;
        System.out.println("测试用例 4 结果：" + solution.divide(dividend4, divisor4));  // 预期输出：0
        
        // 测试用例 5：最小值除以 1
        int dividend5 = Integer.MIN_VALUE;
        int divisor5 = 1;
        System.out.println("测试用例 5 结果：" + solution.divide(dividend5, divisor5));  // 预期输出：-2147483648
    }

    class Solution {
        public int divide(int dividend, int divisor) {
            // 处理特殊情况：最小值除以 -1
            if (dividend == Integer.MIN_VALUE && divisor == -1) {
                return Integer.MAX_VALUE;
            }
            
            // 记录结果的符号
            boolean negative = (dividend < 0) ^ (divisor < 0);
            
            // 将被除数和除数都转换为负数
            // 注意：不能转换为正数，因为最小值的绝对值比最大值大 1
            long dividendL = dividend;
            long divisorL = divisor;
            dividendL = dividendL < 0 ? dividendL : -dividendL;
            divisorL = divisorL < 0 ? divisorL : -divisorL;
            
            // 计算结果
            int result = 0;
            while (dividendL <= divisorL) {
                long value = divisorL;
                long quotient = -1;
                
                // 使用位移操作加快计算
                while (value >= Integer.MIN_VALUE && dividendL <= (value << 1)) {
                    value <<= 1;
                    quotient <<= 1;
                }
                
                result += quotient;
                dividendL -= value;
            }
            
            // 返回结果
            return negative ? result : -result;
        }
    }
} 
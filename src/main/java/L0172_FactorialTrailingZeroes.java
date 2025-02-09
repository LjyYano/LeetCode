/**
 * https://leetcode.cn/problems/factorial-trailing-zeroes/
 * 
 * 给定一个整数 n ，返回 n! 结果中尾随零的数量。
 * 
 * 提示 n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1
 * 
 * 示例 1：
 * 输入：n = 3
 * 输出：0
 * 解释：3! = 6 ，不含尾随 0
 * 
 * 示例 2：
 * 输入：n = 5
 * 输出：1
 * 解释：5! = 120 ，有一个尾随 0
 * 
 * 示例 3：
 * 输入：n = 0
 * 输出：0
 * 
 * 提示：
 * 0 <= n <= 10⁴
 */
public class L0172_FactorialTrailingZeroes {
    
    public int trailingZeroes(int n) {
        // 计算阶乘后尾随零的数量
        // 尾随零由 2 和 5 的因子产生，而 2 的数量总是比 5 多
        // 所以只需要计算 5 的因子数量
        int count = 0;
        while (n > 0) {
            n /= 5;
            count += n;
        }
        return count;
    }

    public static void main(String[] args) {
        L0172_FactorialTrailingZeroes solution = new L0172_FactorialTrailingZeroes();
        
        // 测试用例
        System.out.println("Input: n = 3");
        System.out.println("Output: " + solution.trailingZeroes(3));
        System.out.println("Expected: 0");
        
        System.out.println("\nInput: n = 5");
        System.out.println("Output: " + solution.trailingZeroes(5));
        System.out.println("Expected: 1");
        
        System.out.println("\nInput: n = 0");
        System.out.println("Output: " + solution.trailingZeroes(0));
        System.out.println("Expected: 0");
    }
} 
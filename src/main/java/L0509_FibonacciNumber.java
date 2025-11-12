/**
 * https://leetcode.cn/problems/fibonacci-number/
 * 
 * 斐波那契数 （通常用 F(n) 表示）形成的序列称为 斐波那契数列 。
 * 该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 * 
 * F(0) = 0，F(1) = 1
 * F(n) = F(n - 1) + F(n - 2)，其中 n > 1
 * 
 * 给定 n ，请计算 F(n) 。
 * 
 * 示例 1：
 * 输入：n = 2
 * 输出：1
 * 解释：F(2) = F(1) + F(0) = 1 + 0 = 1
 * 
 * 示例 2：
 * 输入：n = 3
 * 输出：2
 * 解释：F(3) = F(2) + F(1) = 1 + 1 = 2
 * 
 * 示例 3：
 * 输入：n = 4
 * 输出：3
 * 解释：F(4) = F(3) + F(2) = 2 + 1 = 3
 * 
 * 提示：
 * - 0 <= n <= 30
 */
public class L0509_FibonacciNumber {
    
    /**
     * 动态规划 - 空间优化版本
     * 只需要保存前两个数
     */
    public int fib(int n) {
        if (n <= 1) {
            return n;
        }
        
        int prev2 = 0; // F(0)
        int prev1 = 1; // F(1)
        
        for (int i = 2; i <= n; i++) {
            int curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }
        
        return prev1;
    }

    public static void main(String[] args) {
        L0509_FibonacciNumber solution = new L0509_FibonacciNumber();
        
        // 测试用例 1
        System.out.println(solution.fib(2)); // 预期输出：1
        
        // 测试用例 2
        System.out.println(solution.fib(3)); // 预期输出：2
        
        // 测试用例 3
        System.out.println(solution.fib(4)); // 预期输出：3
        
        // 测试用例 4
        System.out.println(solution.fib(10)); // 预期输出：55
    }
}

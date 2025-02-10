/**
 * https://leetcode.cn/problems/perfect-squares/
 * 
 * 给你一个整数 n ，返回和为 n 的完全平方数的最少数量。
 * 完全平方数是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。
 * 例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
 * 
 * 示例 1：
 * 输入：n = 12
 * 输出：3
 * 解释：12 = 4 + 4 + 4
 * 
 * 示例 2：
 * 输入：n = 13
 * 输出：2
 * 解释：13 = 4 + 9
 * 
 * 提示：
 * 1 <= n <= 10⁴
 */
public class L0279_PerfectSquares {
    
    public int numSquares(int n) {
        // dp[i] 表示数字 i 的完全平方数的最少数量
        int[] dp = new int[n + 1];
        
        // 初始化 dp 数组
        for (int i = 1; i <= n; i++) {
            // 最坏的情况就是每个数都由 1 组成
            dp[i] = i;
            
            // 尝试每个小于等于 i 的平方数
            for (int j = 1; j * j <= i; j++) {
                // 当前平方数
                int square = j * j;
                // 更新 dp[i]，等于 dp[i - square] + 1
                dp[i] = Math.min(dp[i], dp[i - square] + 1);
            }
        }
        
        return dp[n];
    }

    public static void main(String[] args) {
        L0279_PerfectSquares solution = new L0279_PerfectSquares();
        
        // 测试用例 1
        int n1 = 12;
        System.out.println("Input: n = " + n1);
        System.out.println("Output: " + solution.numSquares(n1));  // 预期输出：3
        System.out.println();
        
        // 测试用例 2
        int n2 = 13;
        System.out.println("Input: n = " + n2);
        System.out.println("Output: " + solution.numSquares(n2));  // 预期输出：2
    }
} 
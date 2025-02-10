/*
 * https://leetcode.cn/problems/super-ugly-number/
 * 
 * 超级丑数 是一个正整数，并满足其所有质因数都出现在质数数组 primes 中。
 * 
 * 给你一个整数 n 和一个整数数组 primes ，返回第 n 个 超级丑数 。
 * 
 * 题目数据保证第 n 个 超级丑数 在 32-bit 带符号整数范围内。
 * 
 * 示例 1：
 * 输入：n = 12, primes = [2,7,13,19]
 * 输出：32
 * 解释：给定长度为 4 的质数数组 primes = [2,7,13,19]，前 12 个超级丑数序列为：[1,2,4,7,8,13,14,16,19,26,28,32] 。
 * 
 * 示例 2：
 * 输入：n = 1, primes = [2,3,5]
 * 输出：1
 * 解释：1 不含质因数，因此它的所有质因数都在质数数组 primes = [2,3,5] 中。
 * 
 * 提示：
 * 1 <= n <= 10⁶
 * 1 <= primes.length <= 100
 * 2 <= primes[i] <= 1000
 * 题目数据保证 primes[i] 是一个质数
 * primes 中的所有值都 互不相同 ，且按 递增顺序 排列
 */

public class L0313_SuperUglyNumber {
    
    public int nthSuperUglyNumber(int n, int[] primes) {
        int m = primes.length;
        // dp[i] 表示第 i 个超级丑数
        int[] dp = new int[n];
        // 初始化第一个超级丑数为 1
        dp[0] = 1;
        
        // pointers[i] 表示下一个超级丑数是当前指针指向的丑数乘以 primes[i]
        int[] pointers = new int[m];
        
        // 生成接下来的超级丑数
        for (int i = 1; i < n; i++) {
            // 找出下一个最小的超级丑数
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < m; j++) {
                // 防止整数溢出
                if ((long) dp[pointers[j]] * primes[j] < min) {
                    min = dp[pointers[j]] * primes[j];
                }
            }
            dp[i] = min;
            
            // 更新指针
            for (int j = 0; j < m; j++) {
                if (dp[pointers[j]] * primes[j] == min) {
                    pointers[j]++;
                }
            }
        }
        
        return dp[n - 1];
    }

    public static void main(String[] args) {
        L0313_SuperUglyNumber solution = new L0313_SuperUglyNumber();
        
        // 测试用例 1
        int[] primes1 = {2, 7, 13, 19};
        System.out.println(solution.nthSuperUglyNumber(12, primes1)); // 应输出 32
        
        // 测试用例 2
        int[] primes2 = {2, 3, 5};
        System.out.println(solution.nthSuperUglyNumber(1, primes2)); // 应输出 1
        
        // 测试用例 3
        int[] primes3 = {3, 5, 7, 11, 13};
        System.out.println(solution.nthSuperUglyNumber(10, primes3)); // 应输出 21
        
        // 测试用例 4
        int[] primes4 = {2, 3, 5, 7};
        System.out.println(solution.nthSuperUglyNumber(20, primes4)); // 应输出 28
    }
} 
/**
 * https://leetcode.cn/problems/count-primes/
 * 
 * 计数质数
 * 
 * 给定整数 n ，返回所有小于非负整数 n 的质数的数量。
 * 
 * 示例 1：
 * 输入：n = 10
 * 输出：4
 * 解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 * 
 * 示例 2：
 * 输入：n = 0
 * 输出：0
 * 
 * 示例 3：
 * 输入：n = 1
 * 输出：0
 * 
 * 提示：
 * - 0 <= n <= 5 * 10^6
 */
public class L0204_CountPrimes {

    /**
     * 使用埃拉托斯特尼筛法计算小于 n 的质数个数
     * 
     * @param n 目标数字
     * @return 小于 n 的质数个数
     */
    public int countPrimes(int n) {
        // 特殊情况处理：如果 n <= 2，直接返回 0，因为没有小于 2 的质数
        if (n <= 2) {
            return 0;
        }
        
        // 初始化标记数组，默认都是质数
        boolean[] notPrime = new boolean[n];
        int count = 0;
        
        // 从 2 开始遍历到 n-1
        for (int i = 2; i < n; i++) {
            // 如果当前数字是质数
            if (!notPrime[i]) {
                count++;
                // 将当前质数的倍数都标记为非质数
                // 使用 long 类型避免 i * i 可能的整数溢出
                if ((long) i * i < n) {
                    for (int j = i * i; j < n; j += i) {
                        notPrime[j] = true;
                    }
                }
            }
        }
        
        return count;
    }

    public static void main(String[] args) {
        L0204_CountPrimes solution = new L0204_CountPrimes();
        
        // 测试用例 1
        System.out.println("Test case 1: n = 10");
        System.out.println("Expected: 4");
        System.out.println("Actual: " + solution.countPrimes(10));
        System.out.println();
        
        // 测试用例 2
        System.out.println("Test case 2: n = 0");
        System.out.println("Expected: 0");
        System.out.println("Actual: " + solution.countPrimes(0));
        System.out.println();
        
        // 测试用例 3
        System.out.println("Test case 3: n = 1");
        System.out.println("Expected: 0");
        System.out.println("Actual: " + solution.countPrimes(1));
    }
} 
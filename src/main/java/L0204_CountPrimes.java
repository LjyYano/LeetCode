/**
 * https://leetcode.cn/problems/count-primes/
 * 计数质数
 * 给定整数 n ，返回所有小于非负整数 n 的质数的数量。
 */
public class L0204_CountPrimes {
    public int countPrimes(int n) {
        // 使用埃氏筛法
        if (n <= 2) {
            return 0;
        }
        
        // 初始化标记数组，默认都是质数
        boolean[] notPrime = new boolean[n];
        int count = 0;
        
        // 从 2 开始遍历到 sqrt(n)
        for (int i = 2; i < n; i++) {
            if (!notPrime[i]) {
                count++;
                // 将当前质数的倍数都标记为非质数
                if ((long) i * i < n) {
                    for (int j = i * i; j < n; j += i) {
                        notPrime[j] = true;
                    }
                }
            }
        }
        
        return count;
    }
} 
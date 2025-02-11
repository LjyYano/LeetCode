/**
 * https://leetcode.cn/problems/super-pow/
 * 
 * 你的任务是计算 a^b 对 1337 取模，a 是一个正整数，b 是一个非常大的正整数且会以数组形式给出。
 * 
 * 示例 1：
 * 输入：a = 2, b = [3]
 * 输出：8
 * 
 * 示例 2：
 * 输入：a = 2, b = [1,0]
 * 输出：1024
 * 
 * 示例 3：
 * 输入：a = 1, b = [4,3,3,8,5,2]
 * 输出：1
 * 
 * 示例 4：
 * 输入：a = 2147483647, b = [2,0,0]
 * 输出：1198
 * 
 * 提示：
 * - 1 <= a <= 2³¹ - 1
 * - 1 <= b.length <= 2000
 * - 0 <= b[i] <= 9
 * - b 不含前导 0
 */
public class L0372_SuperPow {
    
    private static final int MOD = 1337;
    
    /**
     * 计算 a^b mod 1337，其中 b 是以数组形式给出的大数
     * 使用欧拉定理：对于互质的 a 和 n，有 a^φ(n) ≡ 1 (mod n)
     * 1337 = 7 × 191，φ(1337) = φ(7) × φ(191) = 6 × 190 = 1140
     */
    public int superPow(int a, int[] b) {
        // 处理 a，先对 1337 取模
        a %= MOD;
        
        // 计算 b 数组表示的数对 1140 取模的结果
        int exp = 0;
        for (int digit : b) {
            exp = (exp * 10 + digit) % 1140;
        }
        
        // 使用快速幂计算结果
        return quickPow(a, exp);
    }
    
    /**
     * 快速幂算法计算 (x^n) % MOD
     */
    private int quickPow(int x, int n) {
        int result = 1;
        // 在计算过程中不断对 MOD 取模，防止溢出
        x %= MOD;
        
        while (n > 0) {
            if ((n & 1) == 1) {
                result = (result * x) % MOD;
            }
            x = (x * x) % MOD;
            n >>= 1;
        }
        
        return result;
    }

    public static void main(String[] args) {
        L0372_SuperPow solution = new L0372_SuperPow();
        
        // 测试用例
        System.out.println(solution.superPow(2, new int[]{3}));  // 应该输出 8
        System.out.println(solution.superPow(2, new int[]{1, 0}));  // 应该输出 1024
        System.out.println(solution.superPow(1, new int[]{4, 3, 3, 8, 5, 2}));  // 应该输出 1
        System.out.println(solution.superPow(2147483647, new int[]{2, 0, 0}));  // 应该输出 1198
    }
} 
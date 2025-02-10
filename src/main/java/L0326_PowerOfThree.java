/**
 * https://leetcode.cn/problems/power-of-three/
 * 
 * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。如果是，返回 true ；否则，返回 false 。
 * 
 * 整数 n 是 3 的幂次方需满足：存在整数 x 使得 n == 3^x
 * 
 * 示例 1：
 * 输入：n = 27
 * 输出：true
 * 解释：27 = 3³
 * 
 * 示例 2：
 * 输入：n = 0
 * 输出：false
 * 
 * 示例 3：
 * 输入：n = 9
 * 输出：true
 * 解释：9 = 3²
 * 
 * 示例 4：
 * 输入：n = 45
 * 输出：false
 * 
 * 提示：
 * -2³¹ <= n <= 2³¹ - 1
 */
public class L0326_PowerOfThree {
    
    public boolean isPowerOfThree(int n) {
        // 如果 n 小于等于 0，一定不是 3 的幂
        if (n <= 0) {
            return false;
        }
        
        // 不断除以 3，直到不能整除为止
        while (n % 3 == 0) {
            n /= 3;
        }
        
        // 如果最后剩下 1，说明是 3 的幂
        return n == 1;
    }

    public static void main(String[] args) {
        L0326_PowerOfThree solution = new L0326_PowerOfThree();
        
        // 测试用例 1
        System.out.println(solution.isPowerOfThree(27)); // 应输出 true
        
        // 测试用例 2
        System.out.println(solution.isPowerOfThree(0));  // 应输出 false
        
        // 测试用例 3
        System.out.println(solution.isPowerOfThree(9));  // 应输出 true
        
        // 测试用例 4
        System.out.println(solution.isPowerOfThree(45)); // 应输出 false
    }
} 
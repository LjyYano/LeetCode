/**
 * https://leetcode.cn/problems/power-of-two/
 * 
 * 给你一个整数 n，请你判断该整数是否是 2 的幂次方。如果是，返回 true ；否则，返回 false 。
 * 
 * 如果存在一个整数 x 使得 n == 2^x ，则认为 n 是 2 的幂次方。
 * 
 * 示例 1：
 * 输入：n = 1
 * 输出：true
 * 解释：2^0 = 1
 * 
 * 示例 2：
 * 输入：n = 16
 * 输出：true
 * 解释：2^4 = 16
 * 
 * 示例 3：
 * 输入：n = 3
 * 输出：false
 * 
 * 示例 4：
 * 输入：n = 4
 * 输出：true
 * 
 * 示例 5：
 * 输入：n = 5
 * 输出：false
 * 
 * 提示：
 * - -2^31 <= n <= 2^31 - 1
 */
public class L0231_PowerOfTwo {
    
    /**
     * 使用位运算判断一个数是否是 2 的幂
     * 2 的幂在二进制表示中有且仅有一个 1
     * 因此可以使用 n & (n-1) == 0 来判断
     */
    public boolean isPowerOfTwo(int n) {
        // 如果 n 小于等于 0，一定不是 2 的幂
        if (n <= 0) {
            return false;
        }
        
        // 如果 n 是 2 的幂，那么 n & (n-1) 一定等于 0
        return (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {
        L0231_PowerOfTwo solution = new L0231_PowerOfTwo();
        
        // 测试用例 1
        System.out.println("输入：n = 1");
        System.out.println("输出：" + solution.isPowerOfTwo(1));  // 预期输出：true
        
        // 测试用例 2
        System.out.println("\n输入：n = 16");
        System.out.println("输出：" + solution.isPowerOfTwo(16));  // 预期输出：true
        
        // 测试用例 3
        System.out.println("\n输入：n = 3");
        System.out.println("输出：" + solution.isPowerOfTwo(3));  // 预期输出：false
        
        // 测试用例 4
        System.out.println("\n输入：n = 4");
        System.out.println("输出：" + solution.isPowerOfTwo(4));  // 预期输出：true
        
        // 测试用例 5
        System.out.println("\n输入：n = 5");
        System.out.println("输出：" + solution.isPowerOfTwo(5));  // 预期输出：false
    }
} 
/**
 * https://leetcode.cn/problems/power-of-four/
 * 
 * 给定一个整数，写一个函数来判断它是否是 4 的幂次方。如果是，返回 true ；否则，返回 false 。
 * 
 * 整数 n 是 4 的幂次方需满足：存在整数 x 使得 n == 4ˣ
 * 
 * 示例 1：
 * 输入：n = 16
 * 输出：true
 * 
 * 示例 2：
 * 输入：n = 5
 * 输出：false
 * 
 * 示例 3：
 * 输入：n = 1
 * 输出：true
 * 
 * 提示：
 * -2³¹ <= n <= 2³¹ - 1
 * 
 * 进阶：你能不使用循环或者递归来完成本题吗？
 */
public class L0342_PowerOfFour {
    
    public boolean isPowerOfFour(int n) {
        // 首先判断是否为正数且是 2 的幂
        // 2 的幂的二进制表示中只有一个 1
        if (n <= 0 || (n & (n - 1)) != 0) {
            return false;
        }
        
        // 4 的幂的二进制表示中，1 只出现在奇数位置
        // 0x55555555 是 01010101010101010101010101010101
        return (n & 0x55555555) != 0;
    }

    public static void main(String[] args) {
        L0342_PowerOfFour solution = new L0342_PowerOfFour();
        
        // 测试用例
        System.out.println("16 是否为 4 的幂：" + solution.isPowerOfFour(16));  // 应该输出 true
        System.out.println("5 是否为 4 的幂：" + solution.isPowerOfFour(5));   // 应该输出 false
        System.out.println("1 是否为 4 的幂：" + solution.isPowerOfFour(1));   // 应该输出 true
        System.out.println("8 是否为 4 的幂：" + solution.isPowerOfFour(8));   // 应该输出 false
        System.out.println("64 是否为 4 的幂：" + solution.isPowerOfFour(64)); // 应该输出 true
    }
} 
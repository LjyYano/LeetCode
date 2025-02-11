/**
 * https://leetcode.cn/problems/valid-perfect-square/
 * 
 * 给你一个正整数 num 。如果 num 是一个完全平方数，则返回 true ；否则，返回 false 。
 * 
 * 完全平方数是一个可以写成某个整数平方的整数。换句话说，它可以写成某个整数和自身的乘积。
 * 
 * 不能使用任何内置的库函数，如 sqrt。
 * 
 * 示例 1：
 * 输入：num = 16
 * 输出：true
 * 解释：返回 true ，因为 4 * 4 = 16 且 4 是一个整数。
 * 
 * 示例 2：
 * 输入：num = 14
 * 输出：false
 * 解释：返回 false ，因为 3.742 * 3.742 = 14 且 3.742 不是一个整数。
 * 
 * 提示：
 * 1 <= num <= 2^31 - 1
 */
public class L0367_ValidPerfectSquare {
    
    public boolean isPerfectSquare(int num) {
        // 使用二分查找
        if (num < 2) {
            return true;
        }
        
        long left = 2;
        long right = num / 2;
        
        while (left <= right) {
            long mid = left + (right - left) / 2;
            long square = mid * mid;
            
            if (square == num) {
                return true;
            } else if (square < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return false;
    }

    public static void main(String[] args) {
        L0367_ValidPerfectSquare solution = new L0367_ValidPerfectSquare();
        
        // 测试用例
        System.out.println("16 是否为完全平方数：" + solution.isPerfectSquare(16));  // 应该输出 true
        System.out.println("14 是否为完全平方数：" + solution.isPerfectSquare(14));  // 应该输出 false
        System.out.println("1 是否为完全平方数：" + solution.isPerfectSquare(1));    // 应该输出 true
        System.out.println("4 是否为完全平方数：" + solution.isPerfectSquare(4));    // 应该输出 true
        System.out.println("9 是否为完全平方数：" + solution.isPerfectSquare(9));    // 应该输出 true
    }
} 
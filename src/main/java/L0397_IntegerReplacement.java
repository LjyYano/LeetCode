/**
 * https://leetcode.cn/problems/integer-replacement/
 * 
 * 给定一个正整数 n ，你可以做如下操作：
 * 
 * 1. 如果 n 是偶数，则用 n / 2替换 n 。
 * 2. 如果 n 是奇数，则可以用 n + 1或n - 1替换 n 。
 * 
 * n 变为 1 所需的最小替换次数是多少？
 * 
 * 示例 1：
 * 输入：n = 8
 * 输出：3
 * 解释：8 -> 4 -> 2 -> 1
 * 
 * 示例 2：
 * 输入：n = 7
 * 输出：4
 * 解释：7 -> 8 -> 4 -> 2 -> 1
 * 或 7 -> 6 -> 3 -> 2 -> 1
 * 
 * 示例 3：
 * 输入：n = 4
 * 输出：2
 * 
 * 提示：
 * 1 <= n <= 2³¹ - 1
 */
public class L0397_IntegerReplacement {

    // 使用递归解法
    public int integerReplacement(int n) {
        // 使用 long 类型避免整数溢出
        return (int) helper((long) n);
    }

    // 递归辅助方法
    private long helper(long n) {
        // 基准情况：当 n 为 1 时，不需要替换
        if (n == 1) {
            return 0;
        }
        
        // 如果是偶数，直接除以 2
        if (n % 2 == 0) {
            return 1 + helper(n / 2);
        }
        
        // 如果是奇数，取 n+1 和 n-1 中的最小值
        return 1 + Math.min(helper(n + 1), helper(n - 1));
    }

    public static void main(String[] args) {
        L0397_IntegerReplacement solution = new L0397_IntegerReplacement();
        
        // 测试用例 1
        System.out.println("n = 8, 结果: " + solution.integerReplacement(8));  // 应输出 3
        
        // 测试用例 2
        System.out.println("n = 7, 结果: " + solution.integerReplacement(7));  // 应输出 4
        
        // 测试用例 3
        System.out.println("n = 4, 结果: " + solution.integerReplacement(4));  // 应输出 2
        
        // 测试边界情况
        System.out.println("n = 1, 结果: " + solution.integerReplacement(1));  // 应输出 0
        System.out.println("n = 2147483647, 结果: " + solution.integerReplacement(2147483647));  // 测试最大值
    }
} 
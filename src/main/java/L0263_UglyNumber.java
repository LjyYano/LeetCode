/**
 * https://leetcode.cn/problems/ugly-number/
 * 
 * 丑数 就是只包含质因数 2、3 和 5 的正整数。
 * 
 * 给你一个整数 n ，请你判断 n 是否为 丑数 。如果是，返回 true ；否则，返回 false 。
 * 
 * 示例 1：
 * 输入：n = 6
 * 输出：true
 * 解释：6 = 2 × 3
 * 
 * 示例 2：
 * 输入：n = 1
 * 输出：true
 * 解释：1 没有质因数，因此它的全部质因数是 {2, 3, 5} 的空集。习惯上将其视作第一个丑数。
 * 
 * 示例 3：
 * 输入：n = 14
 * 输出：false
 * 解释：14 不是丑数，因为它包含了另外一个质因数 7 。
 * 
 * 提示：
 * -2³¹ <= n <= 2³¹ - 1
 */
public class L0263_UglyNumber {

    // 不断除以 2、3、5，直到无法整除
    // 如果最后结果为 1，说明是丑数
    public boolean isUgly(int n) {
        // 非正数不是丑数
        if (n <= 0) {
            return false;
        }
        // 依次除以 2、3、5
        int[] factors = {2, 3, 5};
        for (int factor : factors) {
            // 不断除以当前因子，直到无法整除
            while (n % factor == 0) {
                n /= factor;
            }
        }
        // 如果最后结果为 1，说明是丑数
        return n == 1;
    }

    public static void main(String[] args) {
        L0263_UglyNumber solution = new L0263_UglyNumber();
        
        // 测试用例 1
        System.out.println(solution.isUgly(6));  // 应该输出 true
        
        // 测试用例 2
        System.out.println(solution.isUgly(1));  // 应该输出 true
        
        // 测试用例 3
        System.out.println(solution.isUgly(14));  // 应该输出 false
        
        // 测试用例 4：负数
        System.out.println(solution.isUgly(-6));  // 应该输出 false
        
        // 测试用例 5：0
        System.out.println(solution.isUgly(0));  // 应该输出 false
    }
} 
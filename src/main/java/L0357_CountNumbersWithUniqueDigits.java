import java.util.*;

/**
 * https://leetcode.cn/problems/count-numbers-with-unique-digits/
 * 
 * 给你一个整数 n ，统计并返回各位数字都不同的数字 x 的个数，其中 0 <= x < 10^n 。
 * 
 * 示例 1：
 * 输入：n = 2
 * 输出：91
 * 解释：答案应为除去 11、22、33、44、55、66、77、88、99 外，在 0 ≤ x < 100 范围内的所有数字。
 * 
 * 示例 2：
 * 输入：n = 0
 * 输出：1
 * 
 * 提示：
 * - 0 <= n <= 8
 */
public class L0357_CountNumbersWithUniqueDigits {
    
    /**
     * 使用排列组合的思想解决问题：
     * 1. 当 n = 0 时，只有 0 这一个数字
     * 2. 当 n = 1 时，有 10 个数字（0-9）
     * 3. 当 n = 2 时：
     *    - 第一位可以是 1-9（9种选择）
     *    - 第二位可以是除第一位外的任意数字（包括0）（9种选择）
     * 4. 当 n = 3 时：
     *    - 第一位可以是 1-9（9种选择）
     *    - 第二位可以是除第一位外的任意数字（包括0）（9种选择）
     *    - 第三位可以是除前两位外的任意数字（8种选择）
     * 依此类推...
     */
    public int countNumbersWithUniqueDigits(int n) {
        // n = 0 的情况
        if (n == 0) {
            return 1;
        }
        
        // n = 1 的情况
        if (n == 1) {
            return 10;
        }
        
        // 对于 n > 1 的情况
        // result 初始为 10，包含了 n = 1 的所有情况
        int result = 10;
        // 当前可用的数字个数（从 9 开始，因为第一位不能是 0）
        int availableNumbers = 9;
        // 当前数字的选择数（从 9 开始，因为第二位可以使用 0）
        int currentNumber = 9;
        
        // 从 n = 2 开始计算
        for (int i = 2; i <= n && i <= 10; i++) {
            currentNumber *= availableNumbers;
            result += currentNumber;
            availableNumbers--;
        }
        
        return result;
    }

    public static void main(String[] args) {
        L0357_CountNumbersWithUniqueDigits solution = new L0357_CountNumbersWithUniqueDigits();
        
        // 测试用例 1
        System.out.println("n = 2 时的结果：" + solution.countNumbersWithUniqueDigits(2));
        // 预期输出：91
        
        // 测试用例 2
        System.out.println("n = 0 时的结果：" + solution.countNumbersWithUniqueDigits(0));
        // 预期输出：1
        
        // 测试用例 3
        System.out.println("n = 3 时的结果：" + solution.countNumbersWithUniqueDigits(3));
        // 预期输出：739
    }
} 
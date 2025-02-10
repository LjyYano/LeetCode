/**
 * https://leetcode.cn/problems/number-of-digit-one/
 * 
 * 给定一个整数 n，计算所有小于等于 n 的非负整数中数字 1 出现的个数。
 * 
 * 示例 1：
 * 输入：n = 13
 * 输出：6
 * 解释：数字 1 出现在以下数字中: 1, 10, 11, 12, 13 中（共出现 6 次）
 * 
 * 示例 2：
 * 输入：n = 0
 * 输出：0
 * 
 * 提示：
 * - 0 <= n <= 10⁹
 */
public class L0233_NumberOfDigitOne {
    
    /**
     * 计算 1 到 n 中数字 1 出现的次数
     * 对于每一位，我们分别计算该位上 1 出现的次数
     */
    public int countDigitOne(int n) {
        // 记录最终的 1 的个数
        int count = 0;
        
        // 从个位开始，依次处理每一位
        for (long i = 1; i <= n; i *= 10) {
            // 计算当前位的前面的数字和后面的数字
            long prefix = n / (i * 10);
            long digit = (n / i) % 10;
            long suffix = n % i;
            
            // 根据当前位的数字，计算当前位上 1 出现的次数
            if (digit == 0) {
                // 如果当前位是 0，那么当前位上 1 出现的次数只由更高位决定
                count += prefix * i;
            } else if (digit == 1) {
                // 如果当前位是 1，那么当前位上 1 出现的次数由更高位和更低位共同决定
                count += prefix * i + suffix + 1;
            } else {
                // 如果当前位大于 1，那么当前位上 1 出现的次数由更高位决定，且要加上 i
                count += (prefix + 1) * i;
            }
        }
        
        return count;
    }

    public static void main(String[] args) {
        L0233_NumberOfDigitOne solution = new L0233_NumberOfDigitOne();
        
        // 测试用例
        System.out.println("Input: n = 13");
        System.out.println("Output: " + solution.countDigitOne(13));
        System.out.println("Expected: 6");
        
        System.out.println("\nInput: n = 0");
        System.out.println("Output: " + solution.countDigitOne(0));
        System.out.println("Expected: 0");
        
        System.out.println("\nInput: n = 100");
        System.out.println("Output: " + solution.countDigitOne(100));
        System.out.println("Expected: 21");
    }
} 
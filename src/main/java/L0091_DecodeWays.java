import java.util.Arrays;

/**
 * https://leetcode.cn/problems/decode-ways/
 * 
 * 一条包含字母 A-Z 的消息通过以下映射进行了编码：
 * 'A' -> "1"
 * 'B' -> "2"
 * ...
 * 'Z' -> "26"
 * 
 * 要 解码 已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。例如，"11106" 可以映射为：
 * - "AAJF" ，将消息分组为 (1 1 10 6)
 * - "KJF" ，将消息分组为 (11 10 6)
 * 
 * 注意，消息不能分组为 (1 11 06) ，因为 "06" 不能映射为 "F" ，这是由于 "6" 和 "06" 在映射中并不等价。
 * 
 * 给你一个只含数字的 非空 字符串 s ，请计算并返回 解码 方法的 总数 。
 * 题目数据保证答案肯定是一个 32 位 的整数。
 * 
 * 示例 1：
 * 输入：s = "12"
 * 输出：2
 * 解释：它可以解码为 "AB"（1 2）或者 "L"（12）。
 * 
 * 示例 2：
 * 输入：s = "226"
 * 输出：3
 * 解释：它可以解码为 "BZ"（2 26）, "VF"（22 6）, 或者 "BBF"（2 2 6）。
 * 
 * 示例 3：
 * 输入：s = "06"
 * 输出：0
 * 解释："06" 无法映射到 "F" ，因为存在前导零（"6" 和 "06" 并不等价）。
 * 
 * 提示：
 * - 1 <= s.length <= 100
 * - s 只包含数字，并且可能包含前导零。
 */
public class L0091_DecodeWays {
    
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        
        int n = s.length();
        // dp[i] 表示前 i 个字符的解码方法总数
        int[] dp = new int[n + 1];
        // 空字符串可以有 1 种解码方法
        dp[0] = 1;
        // 第一个字符如果不是 0，则有 1 种解码方法
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        
        // 从第二个字符开始动态规划
        for (int i = 2; i <= n; i++) {
            // 当前字符对应的数字
            int oneDigit = s.charAt(i - 1) - '0';
            // 当前字符和前一个字符组成的两位数
            int twoDigits = (s.charAt(i - 2) - '0') * 10 + oneDigit;
            
            // 如果当前字符可以单独解码（1-9）
            if (oneDigit >= 1) {
                dp[i] += dp[i - 1];
            }
            
            // 如果当前字符和前一个字符可以一起解码（10-26）
            if (twoDigits >= 10 && twoDigits <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        
        return dp[n];
    }

    public static void main(String[] args) {
        L0091_DecodeWays solution = new L0091_DecodeWays();
        
        // 测试用例 1
        String s1 = "12";
        System.out.println("输入：s = \"" + s1 + "\"");
        System.out.println("输出：" + solution.numDecodings(s1));
        System.out.println("预期：2");
        System.out.println();
        
        // 测试用例 2
        String s2 = "226";
        System.out.println("输入：s = \"" + s2 + "\"");
        System.out.println("输出：" + solution.numDecodings(s2));
        System.out.println("预期：3");
        System.out.println();
        
        // 测试用例 3
        String s3 = "06";
        System.out.println("输入：s = \"" + s3 + "\"");
        System.out.println("输出：" + solution.numDecodings(s3));
        System.out.println("预期：0");
    }
} 
/**
 * https://leetcode.cn/problems/distinct-subsequences/
 * 
 * 给你两个字符串 s 和 t ，统计并返回在 s 的子序列中 t 出现的个数，结果需要对 10⁹ + 7 取模。
 * 
 * 示例 1：
 * 输入：s = "rabbbit", t = "rabbit"
 * 输出：3
 * 解释：
 * 如下所示, 有 3 种可以从 s 中得到 "rabbit" 的方案。
 * rabbbit
 * rabbbit
 * rabbbit
 * 
 * 示例 2：
 * 输入：s = "babgbag", t = "bag"
 * 输出：5
 * 解释：
 * 如下所示, 有 5 种可以从 s 中得到 "bag" 的方案。 
 * babgbag
 * babgbag
 * babgbag
 * babgbag
 * babgbag
 * 
 * 提示：
 * - 1 <= s.length, t.length <= 1000
 * - s 和 t 由英文字母组成
 */
public class L0115_DistinctSubsequences {
    
    /**
     * 使用动态规划解决不同子序列问题
     * dp[i][j] 表示 s[0..i-1] 的子序列中 t[0..j-1] 出现的次数
     */
    public int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        // 如果 t 的长度大于 s，不可能存在这样的子序列
        if (n > m) {
            return 0;
        }
        
        // 创建 dp 数组，使用 long 类型防止溢出
        long[][] dp = new long[m + 1][n + 1];
        // 空字符串是任何字符串的子序列，次数为 1
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1;
        }
        
        // 填充 dp 数组
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 如果当前字符相等，可以选择使用或不使用当前字符
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = (dp[i - 1][j] + dp[i - 1][j - 1]) % 1000000007;
                } else {
                    // 如果当前字符不相等，只能不使用当前字符
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        
        return (int) dp[m][n];
    }

    public static void main(String[] args) {
        L0115_DistinctSubsequences solution = new L0115_DistinctSubsequences();
        
        // 测试用例 1
        String s1 = "rabbbit";
        String t1 = "rabbit";
        System.out.println("Input: s = \"" + s1 + "\", t = \"" + t1 + "\"");
        System.out.println("Output: " + solution.numDistinct(s1, t1));
        
        // 测试用例 2
        String s2 = "babgbag";
        String t2 = "bag";
        System.out.println("\nInput: s = \"" + s2 + "\", t = \"" + t2 + "\"");
        System.out.println("Output: " + solution.numDistinct(s2, t2));
        
        // 测试用例 3：空字符串
        String s3 = "";
        String t3 = "";
        System.out.println("\nInput: s = \"\", t = \"\"");
        System.out.println("Output: " + solution.numDistinct(s3, t3));
    }
} 
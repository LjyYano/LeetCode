/**
 * https://leetcode.cn/problems/longest-palindromic-subsequence/
 * 
 * 给你一个字符串 s ，找出其中最长的回文子序列，并返回该序列的长度。
 * 
 * 子序列定义为：不改变剩余字符顺序的情况下，删除某些字符或者不删除任何字符形成的一个序列。
 * 
 * 示例 1：
 * 输入：s = "bbbab"
 * 输出：4
 * 解释：一个可能的最长回文子序列为 "bbbb" 。
 * 
 * 示例 2：
 * 输入：s = "cbbd"
 * 输出：2
 * 解释：一个可能的最长回文子序列为 "bb" 。
 * 
 * 提示：
 * - 1 <= s.length <= 1000
 * - s 仅由小写英文字母组成
 */
public class L0516_LongestPalindromicSubsequence {
    
    /**
     * 动态规划
     * dp[i][j] 表示 s[i..j] 的最长回文子序列长度
     */
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        
        // 单个字符的回文长度为 1
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        
        // 从长度 2 开始填表
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                
                if (s.charAt(i) == s.charAt(j)) {
                    // 两端字符相同，可以加入回文序列
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    // 两端字符不同，取较大的一边
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        
        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        L0516_LongestPalindromicSubsequence solution = new L0516_LongestPalindromicSubsequence();
        
        // 测试用例 1
        System.out.println(solution.longestPalindromeSubseq("bbbab")); // 预期输出：4
        
        // 测试用例 2
        System.out.println(solution.longestPalindromeSubseq("cbbd")); // 预期输出：2
    }
}

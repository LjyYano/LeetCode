// 32. 最长有效括号
// https://leetcode.cn/problems/longest-valid-parentheses/
// 
// 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
//
// 示例 1：
// 输入：s = "(()"
// 输出：2
// 解释：最长有效括号子串是 "()"
//
// 示例 2：
// 输入：s = ")()())"
// 输出：4
// 解释：最长有效括号子串是 "()()"
//
// 示例 3：
// 输入：s = ""
// 输出：0
//
// 提示：
// - 0 <= s.length <= 3 * 104
// - s[i] 为 '(' 或 ')'

class Solution {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }
        
        // 使用动态规划
        // dp[i] 表示以 s[i] 结尾的最长有效括号长度
        int[] dp = new int[s.length()];
        int maxLen = 0;
        
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                // 如果前一个字符是 '('，形成一个有效的括号对
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                }
                // 如果前一个字符是 ')'，需要检查是否能和更前面的 '(' 匹配
                else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + 2 + 
                        (i - dp[i - 1] >= 2 ? dp[i - dp[i - 1] - 2] : 0);
                }
                maxLen = Math.max(maxLen, dp[i]);
            }
        }
        
        return maxLen;
    }
} 
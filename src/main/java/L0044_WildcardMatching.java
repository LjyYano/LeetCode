/**
 * 题目链接：https://leetcode.cn/problems/wildcard-matching/
 * 
 * 给你一个输入字符串 (s) 和一个字符模式 (p) ，请你实现一个支持 '?' 和 '*' 的通配符匹配：
 * '?' 可以匹配任何单个字符
 * '*' 可以匹配任意字符序列（包括空序列）
 * 判断字符串 s 是否能被模式 p 匹配。
 * 
 * 示例 1：
 * 输入：s = "aa", p = "a"
 * 输出：false
 * 解释："a" 无法匹配 "aa" 整个字符串。
 * 
 * 示例 2：
 * 输入：s = "aa", p = "*"
 * 输出：true
 * 解释：'*' 可以匹配任意字符串。
 * 
 * 示例 3：
 * 输入：s = "cb", p = "?a"
 * 输出：false
 * 解释：'?' 可以匹配 'c', 但第二个 'a' 无法匹配 'b'。
 */
public class L0044_WildcardMatching {

    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        
        // dp[i][j] 表示 s 的前 i 个字符和 p 的前 j 个字符是否匹配
        boolean[][] dp = new boolean[m + 1][n + 1];
        
        // 空字符串和空模式串匹配
        dp[0][0] = true;
        
        // 处理空字符串和模式串的匹配情况
        // 例如：s = "", p = "****"
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            }
        }
        
        // 填充 dp 数组
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == '*') {
                    // '*' 可以匹配空串或任意字符串
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                } else if (p.charAt(j - 1) == '?' || s.charAt(i - 1) == p.charAt(j - 1)) {
                    // '?' 可以匹配任意单个字符，或者字符相等
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
        
        return dp[m][n];
    }

    public static void main(String[] args) {
        L0044_WildcardMatching solution = new L0044_WildcardMatching();
        
        // 测试用例 1
        String s1 = "aa";
        String p1 = "a";
        System.out.println("测试用例 1：");
        System.out.println("输入：s = \"" + s1 + "\", p = \"" + p1 + "\"");
        System.out.println("输出：" + solution.isMatch(s1, p1));
        // 预期输出：false
        
        // 测试用例 2
        String s2 = "aa";
        String p2 = "*";
        System.out.println("\n测试用例 2：");
        System.out.println("输入：s = \"" + s2 + "\", p = \"" + p2 + "\"");
        System.out.println("输出：" + solution.isMatch(s2, p2));
        // 预期输出：true
        
        // 测试用例 3
        String s3 = "cb";
        String p3 = "?a";
        System.out.println("\n测试用例 3：");
        System.out.println("输入：s = \"" + s3 + "\", p = \"" + p3 + "\"");
        System.out.println("输出：" + solution.isMatch(s3, p3));
        // 预期输出：false
    }
} 
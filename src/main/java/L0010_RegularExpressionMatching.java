/**
 * 题目链接：https://leetcode.cn/problems/regular-expression-matching/
 * 
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s 的，而不是部分字符串。
 */
public class L0010_RegularExpressionMatching {
    
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        
        // dp[i][j] 表示 s 的前 i 个字符和 p 的前 j 个字符是否匹配
        boolean[][] dp = new boolean[m + 1][n + 1];
        
        // 空字符串和空模式串匹配
        dp[0][0] = true;
        
        // 处理空字符串和模式串的匹配情况
        // 例如：s = "", p = "a*b*c*"
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }
        
        // 填充 dp 数组
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == '*') {
                    // 不使用 '*' 前面的字符匹配
                    dp[i][j] = dp[i][j - 2];
                    
                    // 使用 '*' 前面的字符匹配一次或多次
                    if (matches(s, p, i - 1, j - 2)) {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                } else {
                    // 当前字符匹配
                    if (matches(s, p, i - 1, j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }
        }
        
        return dp[m][n];
    }
    
    /**
     * 判断字符串 s 的第 i 个字符和模式串 p 的第 j 个字符是否匹配
     */
    private boolean matches(String s, String p, int i, int j) {
        return p.charAt(j) == '.' || s.charAt(i) == p.charAt(j);
    }

    public static void main(String[] args) {
        L0010_RegularExpressionMatching solution = new L0010_RegularExpressionMatching();
        
        // 测试用例 1：基本匹配
        String s1 = "aa";
        String p1 = "a*";
        System.out.println("输入：s = " + s1 + ", p = " + p1);
        System.out.println("输出：" + solution.isMatch(s1, p1));  // 预期输出：true
        
        // 测试用例 2：点号匹配
        String s2 = "ab";
        String p2 = ".*";
        System.out.println("\n输入：s = " + s2 + ", p = " + p2);
        System.out.println("输出：" + solution.isMatch(s2, p2));  // 预期输出：true
        
        // 测试用例 3：复杂匹配
        String s3 = "mississippi";
        String p3 = "mis*is*p*.";
        System.out.println("\n输入：s = " + s3 + ", p = " + p3);
        System.out.println("输出：" + solution.isMatch(s3, p3));  // 预期输出：false
        
        // 测试用例 4：空字符串匹配
        String s4 = "";
        String p4 = "a*";
        System.out.println("\n输入：s = " + s4 + ", p = " + p4);
        System.out.println("输出：" + solution.isMatch(s4, p4));  // 预期输出：true
    }
} 
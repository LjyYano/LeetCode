/**
 * https://leetcode.cn/problems/interleaving-string/
 * 
 * 给定三个字符串 s1、s2、s3，请你帮忙验证 s3 是否是由 s1 和 s2 交错 组成的。
 * 两个字符串 s 和 t 交错 的定义与过程如下，其中每个字符串都会被分割成若干 非空 子字符串：
 * - s = s1 + s2 + ... + sn
 * - t = t1 + t2 + ... + tm
 * - |n - m| <= 1
 * - 交错 是 s1 + t1 + s2 + t2 + s3 + t3 + ... 或者 t1 + s1 + t2 + s2 + t3 + s3 + ...
 * 
 * 注意：a + b 意味着字符串 a 和 b 连接。
 * 
 * 示例 1：
 * ![img](https://assets.leetcode.com/uploads/2020/09/02/interleave.jpg)
 * 输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 * 输出：true
 * 
 * 示例 2：
 * 输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
 * 输出：false
 * 
 * 示例 3：
 * 输入：s1 = "", s2 = "", s3 = ""
 * 输出：true
 * 
 * 提示：
 * - 0 <= s1.length, s2.length <= 100
 * - 0 <= s3.length <= 200
 * - s1、s2、和 s3 都由小写英文字母组成
 */
public class L0097_InterleavingString {
    
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        
        int m = s1.length(), n = s2.length();
        // dp[i][j] 表示 s1 的前 i 个字符和 s2 的前 j 个字符是否可以交错组成 s3 的前 i+j 个字符
        boolean[][] dp = new boolean[m + 1][n + 1];
        
        // 初始化边界条件
        dp[0][0] = true;
        
        // 初始化第一行，即只使用 s2 的情况
        for (int j = 1; j <= n; j++) {
            dp[0][j] = dp[0][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
        }
        
        // 初始化第一列，即只使用 s1 的情况
        for (int i = 1; i <= m; i++) {
            dp[i][0] = dp[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
        }
        
        // 动态规划填表
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 当前位置可以从上方转移（使用 s1 的字符）或从左方转移（使用 s2 的字符）
                dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) ||
                          (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
            }
        }
        
        return dp[m][n];
    }

    public static void main(String[] args) {
        L0097_InterleavingString solution = new L0097_InterleavingString();

        // 测试用例 1
        String s1_1 = "aabcc";
        String s2_1 = "dbbca";
        String s3_1 = "aadbbcbcac";
        System.out.println("测试用例 1：");
        System.out.println("s1 = \"" + s1_1 + "\", s2 = \"" + s2_1 + "\", s3 = \"" + s3_1 + "\"");
        System.out.println("输出：" + solution.isInterleave(s1_1, s2_1, s3_1));
        System.out.println("预期：true");
        System.out.println();

        // 测试用例 2
        String s1_2 = "aabcc";
        String s2_2 = "dbbca";
        String s3_2 = "aadbbbaccc";
        System.out.println("测试用例 2：");
        System.out.println("s1 = \"" + s1_2 + "\", s2 = \"" + s2_2 + "\", s3 = \"" + s3_2 + "\"");
        System.out.println("输出：" + solution.isInterleave(s1_2, s2_2, s3_2));
        System.out.println("预期：false");
        System.out.println();

        // 测试用例 3
        String s1_3 = "";
        String s2_3 = "";
        String s3_3 = "";
        System.out.println("测试用例 3：");
        System.out.println("s1 = \"\", s2 = \"\", s3 = \"\"");
        System.out.println("输出：" + solution.isInterleave(s1_3, s2_3, s3_3));
        System.out.println("预期：true");
    }
} 
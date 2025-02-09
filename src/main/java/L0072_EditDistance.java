/**
 * https://leetcode.cn/problems/edit-distance/
 * 
 * 给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数。
 * 
 * 你可以对一个单词进行如下三种操作：
 * - 插入一个字符
 * - 删除一个字符
 * - 替换一个字符
 * 
 * 示例 1：
 * 输入：word1 = "horse", word2 = "ros"
 * 输出：3
 * 解释：
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 * 
 * 示例 2：
 * 输入：word1 = "intention", word2 = "execution"
 * 输出：5
 * 解释：
 * intention -> inention (删除 't')
 * inention -> enention (将 'i' 替换为 'e')
 * enention -> exention (将 'n' 替换为 'x')
 * exention -> exection (将 'n' 替换为 'c')
 * exection -> execution (插入 'u')
 * 
 * 提示：
 * 0 <= word1.length, word2.length <= 500
 * word1 和 word2 由小写英文字母组成
 */
public class L0072_EditDistance {

    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        
        // 如果有一个字符串为空，则需要的操作数就是另一个字符串的长度
        if (m * n == 0) {
            return m + n;
        }
        
        // dp[i][j] 表示 word1 的前 i 个字符转换到 word2 的前 j 个字符需要的最少操作数
        int[][] dp = new int[m + 1][n + 1];
        
        // 初始化边界情况
        // 当 word2 为空时，需要删除 word1 的所有字符
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        // 当 word1 为空时，需要插入 word2 的所有字符
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }
        
        // 填充 dp 数组
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 如果当前字符相同，不需要操作
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // 否则取三种操作中的最小值：
                    // 替换：dp[i-1][j-1] + 1
                    // 删除：dp[i-1][j] + 1
                    // 插入：dp[i][j-1] + 1
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
            }
        }
        
        return dp[m][n];
    }

    public static void main(String[] args) {
        L0072_EditDistance solution = new L0072_EditDistance();

        // 测试用例 1
        String word1 = "horse";
        String word2 = "ros";
        System.out.println("Input: word1 = \"" + word1 + "\", word2 = \"" + word2 + "\"");
        System.out.println("Output: " + solution.minDistance(word1, word2));
        System.out.println();

        // 测试用例 2
        String word3 = "intention";
        String word4 = "execution";
        System.out.println("Input: word1 = \"" + word3 + "\", word2 = \"" + word4 + "\"");
        System.out.println("Output: " + solution.minDistance(word3, word4));
        System.out.println();

        // 测试用例 3：空字符串
        String word5 = "";
        String word6 = "abc";
        System.out.println("Input: word1 = \"" + word5 + "\", word2 = \"" + word6 + "\"");
        System.out.println("Output: " + solution.minDistance(word5, word6));
    }
} 
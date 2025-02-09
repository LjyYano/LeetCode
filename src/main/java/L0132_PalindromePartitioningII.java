/**
 * https://leetcode.cn/problems/palindrome-partitioning-ii/
 * 
 * 题目描述:
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是回文。
 * 
 * 返回符合要求的 最少分割次数 。
 * 
 * 示例 1：
 * 输入：s = "aab"
 * 输出：1
 * 解释：只需一次分割就可将 s 分割成 ["aa","b"] 这样两个回文子串。
 * 
 * 示例 2：
 * 输入：s = "a"
 * 输出：0
 * 
 * 示例 3：
 * 输入：s = "ab"
 * 输出：1
 * 
 * 提示：
 * - 1 <= s.length <= 2000
 * - s 仅由小写英文字母组成
 */
public class L0132_PalindromePartitioningII {
    public int minCut(String s) {
        if (s == null || s.length() <= 1) {
            return 0;
        }
        
        int n = s.length();
        
        // dp[i][j] 表示 s[i..j] 是否为回文串
        boolean[][] isPalindrome = new boolean[n][n];
        // minCuts[i] 表示 s[0..i] 的最少分割次数
        int[] minCuts = new int[n];
        
        // 初始化：假设每个位置都需要分割
        for (int i = 0; i < n; i++) {
            minCuts[i] = i;
        }
        
        // 预处理所有子串是否为回文串
        for (int j = 0; j < n; j++) {
            for (int i = 0; i <= j; i++) {
                // 判断 s[i..j] 是否为回文串
                if (s.charAt(i) == s.charAt(j) && (j - i <= 2 || isPalindrome[i + 1][j - 1])) {
                    isPalindrome[i][j] = true;
                }
            }
        }
        
        // 动态规划计算最少分割次数
        for (int j = 0; j < n; j++) {
            if (isPalindrome[0][j]) {
                // 如果 s[0..j] 是回文串，不需要分割
                minCuts[j] = 0;
            } else {
                // 否则，尝试所有可能的分割点
                for (int i = 0; i < j; i++) {
                    if (isPalindrome[i + 1][j]) {
                        minCuts[j] = Math.min(minCuts[j], minCuts[i] + 1);
                    }
                }
            }
        }
        
        return minCuts[n - 1];
    }

    public static void main(String[] args) {
        L0132_PalindromePartitioningII solution = new L0132_PalindromePartitioningII();
        
        // 测试用例 1
        String s1 = "aab";
        System.out.println("测试用例 1:");
        System.out.println("输入: s = \"" + s1 + "\"");
        System.out.println("输出: " + solution.minCut(s1));
        System.out.println();
        
        // 测试用例 2
        String s2 = "a";
        System.out.println("测试用例 2:");
        System.out.println("输入: s = \"" + s2 + "\"");
        System.out.println("输出: " + solution.minCut(s2));
        System.out.println();
        
        // 测试用例 3
        String s3 = "ab";
        System.out.println("测试用例 3:");
        System.out.println("输入: s = \"" + s3 + "\"");
        System.out.println("输出: " + solution.minCut(s3));
    }
} 
/**
 * 题目链接：https://leetcode.cn/problems/longest-palindromic-substring/
 * 
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
 */
public class L0005_LongestPalindromicSubstring {
    
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        
        // 记录最长回文子串的起始位置和长度
        int start = 0;
        int maxLength = 1;
        
        // 遍历每个可能的中心点
        for (int i = 0; i < s.length(); i++) {
            // 以当前字符为中心的奇数长度回文串
            int len1 = expandAroundCenter(s, i, i);
            // 以当前字符和下一个字符为中心的偶数长度回文串
            int len2 = expandAroundCenter(s, i, i + 1);
            
            // 更新最长回文子串的信息
            int len = Math.max(len1, len2);
            if (len > maxLength) {
                start = i - (len - 1) / 2;
                maxLength = len;
            }
        }
        
        return s.substring(start, start + maxLength);
    }
    
    /**
     * 从中心向两边扩展，寻找最长回文子串
     * @param s 原始字符串
     * @param left 左边界
     * @param right 右边界
     * @return 以 left 和 right 为中心的最长回文子串的长度
     */
    private int expandAroundCenter(String s, int left, int right) {
        // 当左右指针都在有效范围内，且对应的字符相等时，继续扩展
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // 返回回文串的长度
        return right - left - 1;
    }

    public static void main(String[] args) {
        L0005_LongestPalindromicSubstring solution = new L0005_LongestPalindromicSubstring();
        
        // 测试用例 1：奇数长度回文串
        String s1 = "babad";
        System.out.println("输入：" + s1);
        System.out.println("输出：" + solution.longestPalindrome(s1));  // 预期输出："bab" 或 "aba"
        
        // 测试用例 2：偶数长度回文串
        String s2 = "cbbd";
        System.out.println("\n输入：" + s2);
        System.out.println("输出：" + solution.longestPalindrome(s2));  // 预期输出："bb"
        
        // 测试用例 3：单个字符
        String s3 = "a";
        System.out.println("\n输入：" + s3);
        System.out.println("输出：" + solution.longestPalindrome(s3));  // 预期输出："a"
        
        // 测试用例 4：全部相同的字符
        String s4 = "aaaa";
        System.out.println("\n输入：" + s4);
        System.out.println("输出：" + solution.longestPalindrome(s4));  // 预期输出："aaaa"
    }
} 
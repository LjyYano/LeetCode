/**
 * https://leetcode.cn/problems/shortest-palindrome/
 * 
 * 给定一个字符串 s，你可以通过在字符串前面添加字符将其转换为回文串。找到并返回可以用这种方式转换的最短回文串。
 * 
 * 示例 1：
 * 输入：s = "aacecaaa"
 * 输出："aaacecaaa"
 * 
 * 示例 2：
 * 输入：s = "abcd"
 * 输出："dcbabcd"
 * 
 * 提示：
 * - 0 <= s.length <= 5 * 10^4
 * - s 仅由小写英文字母组成
 */
public class L0214_ShortestPalindrome {
    
    public String shortestPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        
        // 构造新字符串 s#reverse(s)
        String temp = s + "#" + new StringBuilder(s).reverse().toString();
        
        // 计算 next 数组
        int[] next = new int[temp.length()];
        for (int i = 1; i < temp.length(); i++) {
            int j = next[i - 1];
            while (j > 0 && temp.charAt(i) != temp.charAt(j)) {
                j = next[j - 1];
            }
            if (temp.charAt(i) == temp.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        
        // 获取最长回文前缀的长度
        int maxLen = next[temp.length() - 1];
        
        // 将剩余部分反转并添加到开头
        return new StringBuilder(s.substring(maxLen)).reverse().toString() + s;
    }
    
    public static void main(String[] args) {
        L0214_ShortestPalindrome solution = new L0214_ShortestPalindrome();
        
        // 测试用例 1
        String s1 = "aacecaaa";
        System.out.println("测试用例 1：");
        System.out.println("输入：s = \"" + s1 + "\"");
        System.out.println("输出：\"" + solution.shortestPalindrome(s1) + "\"");
        System.out.println();
        
        // 测试用例 2
        String s2 = "abcd";
        System.out.println("测试用例 2：");
        System.out.println("输入：s = \"" + s2 + "\"");
        System.out.println("输出：\"" + solution.shortestPalindrome(s2) + "\"");
    }
} 
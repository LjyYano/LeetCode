import java.util.*;

/**
 * https://leetcode.cn/problems/longest-palindrome/description/
 * 
 * 给定一个包含大写字母和小写字母的字符串 s ，返回 通过这些字母构造成的 最长的回文串 。
 * 在构造过程中，请注意 区分大小写 。比如 "Aa" 不能当做一个回文字符串。
 * 
 * 示例 1:
 * 输入:s = "abccccdd"
 * 输出:7
 * 解释:我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 * 
 * 示例 2:
 * 输入:s = "a"
 * 输出:1
 * 
 * 示例 3:
 * 输入:s = "bb"
 * 输出:2
 */
public class L0409_LongestPalindrome {

    public int longestPalindrome(String s) {
        // 使用数组统计每个字符出现的次数
        int[] count = new int[128];
        for (char c : s.toCharArray()) {
            count[c]++;
        }
        
        // 计算最长回文串的长度
        int length = 0;
        // 记录是否有出现奇数次的字符
        boolean hasOdd = false;
        
        // 遍历所有字符
        for (int num : count) {
            // 对于每个字符，取其出现次数的最大偶数
            length += num / 2 * 2;
            // 如果有字符出现奇数次，可以放在中间
            if (num % 2 == 1) {
                hasOdd = true;
            }
        }
        
        // 如果存在出现奇数次的字符，最终长度可以加 1
        return hasOdd ? length + 1 : length;
    }

    public static void main(String[] args) {
        L0409_LongestPalindrome solution = new L0409_LongestPalindrome();
        
        // 测试用例1
        String s1 = "abccccdd";
        System.out.println("测试用例1：");
        System.out.println("输入：s = " + s1);
        System.out.println("输出：" + solution.longestPalindrome(s1));
        
        // 测试用例2
        String s2 = "a";
        System.out.println("\n测试用例2：");
        System.out.println("输入：s = " + s2);
        System.out.println("输出：" + solution.longestPalindrome(s2));
        
        // 测试用例3
        String s3 = "bb";
        System.out.println("\n测试用例3：");
        System.out.println("输入：s = " + s3);
        System.out.println("输出：" + solution.longestPalindrome(s3));
    }
} 
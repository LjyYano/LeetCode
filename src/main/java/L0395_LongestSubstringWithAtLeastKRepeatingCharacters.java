/**
 * https://leetcode.cn/problems/longest-substring-with-at-least-k-repeating-characters/
 * 
 * 给你一个字符串 s 和一个整数 k ，请你找出 s 中的最长子串，要求该子串中的每个字符出现次数都不少于 k 。返回这一子串的长度。
 * 
 * 示例 1：
 * 输入：s = "aaabb", k = 3
 * 输出：3
 * 解释：最长子串为 "aaa" ，其中 'a' 重复了 3 次。
 * 
 * 示例 2：
 * 输入：s = "ababbc", k = 2
 * 输出：5
 * 解释：最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。
 * 
 * 提示：
 * - 1 <= s.length <= 10⁴
 * - s 仅由小写英文字母组成
 * - 1 <= k <= 10⁵
 */
public class L0395_LongestSubstringWithAtLeastKRepeatingCharacters {
    
    public int longestSubstring(String s, int k) {
        // 如果字符串长度小于 k，直接返回 0
        if (s.length() < k) {
            return 0;
        }
        
        // 统计每个字符出现的次数
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        
        // 找到第一个出现次数小于 k 的字符
        char split = 0;
        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i) - 'a'] < k) {
                split = s.charAt(i);
                break;
            }
            // 如果遍历到最后一个字符都没有找到出现次数小于 k 的字符
            // 说明整个字符串都满足条件
            if (i == s.length() - 1) {
                return s.length();
            }
        }
        
        // 如果找到了这样的字符，以这个字符为分割点，递归处理子串
        int maxLength = 0;
        for (String subString : s.split(String.valueOf(split))) {
            maxLength = Math.max(maxLength, longestSubstring(subString, k));
        }
        
        return maxLength;
    }

    public static void main(String[] args) {
        L0395_LongestSubstringWithAtLeastKRepeatingCharacters solution = new L0395_LongestSubstringWithAtLeastKRepeatingCharacters();
        
        // 测试用例 1
        String s1 = "aaabb";
        int k1 = 3;
        System.out.println("测试用例 1：");
        System.out.println("输入：s = \"" + s1 + "\", k = " + k1);
        System.out.println("输出：" + solution.longestSubstring(s1, k1));
        System.out.println();
        
        // 测试用例 2
        String s2 = "ababbc";
        int k2 = 2;
        System.out.println("测试用例 2：");
        System.out.println("输入：s = \"" + s2 + "\", k = " + k2);
        System.out.println("输出：" + solution.longestSubstring(s2, k2));
        System.out.println();
        
        // 测试用例 3：全部字符都满足条件
        String s3 = "aaaaaa";
        int k3 = 2;
        System.out.println("测试用例 3：");
        System.out.println("输入：s = \"" + s3 + "\", k = " + k3);
        System.out.println("输出：" + solution.longestSubstring(s3, k3));
        System.out.println();
        
        // 测试用例 4：没有满足条件的子串
        String s4 = "abcd";
        int k4 = 2;
        System.out.println("测试用例 4：");
        System.out.println("输入：s = \"" + s4 + "\", k = " + k4);
        System.out.println("输出：" + solution.longestSubstring(s4, k4));
    }
} 
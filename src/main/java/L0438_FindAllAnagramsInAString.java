import java.util.*;

/**
 * https://leetcode.cn/problems/find-all-anagrams-in-a-string/description/
 * 
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 * 
 * 示例 1：
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 * 
 * 示例 2：
 * 输入: s = "abab", p = "ab"
 * 输出: [0,1,2]
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
 */
public class L0438_FindAllAnagramsInAString {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s == null || p == null || s.length() < p.length()) {
            return result;
        }
        
        // 使用数组记录字符出现次数
        int[] need = new int[26];
        int[] window = new int[26];
        
        // 统计 p 中每个字符的出现次数
        for (char c : p.toCharArray()) {
            need[c - 'a']++;
        }
        
        // 滑动窗口的左右边界
        int left = 0;
        
        // 遍历字符串 s
        for (int right = 0; right < s.length(); right++) {
            // 增加右边界字符的计数
            window[s.charAt(right) - 'a']++;
            
            // 当窗口大小大于 p 的长度时，缩小窗口
            if (right - left + 1 > p.length()) {
                window[s.charAt(left) - 'a']--;
                left++;
            }
            
            // 当窗口大小等于 p 的长度时，检查是否是异位词
            if (right - left + 1 == p.length() && Arrays.equals(need, window)) {
                result.add(left);
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        L0438_FindAllAnagramsInAString solution = new L0438_FindAllAnagramsInAString();
        
        // 测试用例1
        String s1 = "cbaebabacd";
        String p1 = "abc";
        System.out.println("测试用例1：");
        System.out.println("输入：s = \"" + s1 + "\", p = \"" + p1 + "\"");
        System.out.println("输出：" + solution.findAnagrams(s1, p1));
        
        // 测试用例2
        String s2 = "abab";
        String p2 = "ab";
        System.out.println("\n测试用例2：");
        System.out.println("输入：s = \"" + s2 + "\", p = \"" + p2 + "\"");
        System.out.println("输出：" + solution.findAnagrams(s2, p2));
    }
} 
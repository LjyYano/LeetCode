import java.util.HashMap;
import java.util.Map;

/**
 * 题目链接：https://leetcode.cn/problems/longest-substring-without-repeating-characters/
 * 
 * 给定一个字符串 s，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class L0003_LongestSubstringWithoutRepeatingCharacters {
    
    public int lengthOfLongestSubstring(String s) {
        // 特殊情况处理
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        // 使用 HashMap 存储字符及其最后出现的位置
        Map<Character, Integer> charMap = new HashMap<>();
        // 最长子串的长度
        int maxLength = 0;
        // 当前无重复子串的起始位置
        int start = 0;
        
        // 遍历字符串
        for (int end = 0; end < s.length(); end++) {
            char currentChar = s.charAt(end);
            
            // 如果当前字符已经在 map 中，并且其位置大于等于 start
            // 说明在当前窗口中存在重复字符，需要更新窗口的起始位置
            if (charMap.containsKey(currentChar) && charMap.get(currentChar) >= start) {
                start = charMap.get(currentChar) + 1;
            }
            
            // 更新当前字符的位置
            charMap.put(currentChar, end);
            // 更新最长子串的长度
            maxLength = Math.max(maxLength, end - start + 1);
        }
        
        return maxLength;
    }

    public static void main(String[] args) {
        L0003_LongestSubstringWithoutRepeatingCharacters solution = 
            new L0003_LongestSubstringWithoutRepeatingCharacters();
        
        // 测试用例 1：常规情况
        String s1 = "abcabcbb";
        System.out.println("输入：" + s1);
        System.out.println("输出：" + solution.lengthOfLongestSubstring(s1));  // 预期输出：3
        
        // 测试用例 2：所有字符都相同
        String s2 = "bbbbb";
        System.out.println("\n输入：" + s2);
        System.out.println("输出：" + solution.lengthOfLongestSubstring(s2));  // 预期输出：1
        
        // 测试用例 3：没有重复字符
        String s3 = "pwwkew";
        System.out.println("\n输入：" + s3);
        System.out.println("输出：" + solution.lengthOfLongestSubstring(s3));  // 预期输出：3
        
        // 测试用例 4：空字符串
        String s4 = "";
        System.out.println("\n输入：" + s4);
        System.out.println("输出：" + solution.lengthOfLongestSubstring(s4));  // 预期输出：0
    }
} 
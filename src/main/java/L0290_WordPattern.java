import java.util.*;

/**
 * https://leetcode.cn/problems/word-pattern/
 * 
 * 给定一种规律 pattern 和一个字符串 s ，判断 s 是否遵循相同的规律。
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 s 中的每个非空单词之间存在着双向连接的对应规律。
 * 
 * 示例 1:
 * 输入: pattern = "abba", s = "dog cat cat dog"
 * 输出: true
 * 
 * 示例 2:
 * 输入: pattern = "abba", s = "dog cat cat fish"
 * 输出: false
 * 
 * 示例 3:
 * 输入: pattern = "aaaa", s = "dog dog dog dog"
 * 输出: true
 * 
 * 提示:
 * - 1 <= pattern.length <= 300
 * - pattern 只包含小写英文字母
 * - 1 <= s.length <= 3000
 * - s 只包含小写英文字母和 ' '
 * - s 不包含任何前导或尾随对空格
 * - s 中每个单词都被 单个空格 分隔
 */
public class L0290_WordPattern {
    
    public boolean wordPattern(String pattern, String s) {
        // 将字符串按空格分割成单词数组
        String[] words = s.split(" ");
        
        // 如果模式和单词数量不相等，直接返回 false
        if (pattern.length() != words.length) {
            return false;
        }
        
        // 创建两个映射，分别存储字符到单词和单词到字符的映射关系
        Map<Character, String> charToWord = new HashMap<>();
        Map<String, Character> wordToChar = new HashMap<>();
        
        // 遍历模式和单词数组
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String word = words[i];
            
            // 检查字符到单词的映射
            if (charToWord.containsKey(c)) {
                if (!charToWord.get(c).equals(word)) {
                    return false;
                }
            } else {
                charToWord.put(c, word);
            }
            
            // 检查单词到字符的映射
            if (wordToChar.containsKey(word)) {
                if (wordToChar.get(word) != c) {
                    return false;
                }
            } else {
                wordToChar.put(word, c);
            }
        }
        
        return true;
    }

    public static void main(String[] args) {
        L0290_WordPattern solution = new L0290_WordPattern();
        
        // 测试用例 1
        System.out.println(solution.wordPattern("abba", "dog cat cat dog"));  // 应该输出 true
        
        // 测试用例 2
        System.out.println(solution.wordPattern("abba", "dog cat cat fish"));  // 应该输出 false
        
        // 测试用例 3
        System.out.println(solution.wordPattern("aaaa", "dog dog dog dog"));  // 应该输出 true
    }
} 
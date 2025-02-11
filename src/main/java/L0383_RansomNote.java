/**
 * https://leetcode.cn/problems/ransom-note/
 * 
 * 给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
 * 如果可以，返回 true ；否则返回 false 。
 * magazine 中的每个字符只能在 ransomNote 中使用一次。
 * 
 * 示例 1：
 * 输入：ransomNote = "a", magazine = "b"
 * 输出：false
 * 
 * 示例 2：
 * 输入：ransomNote = "aa", magazine = "ab"
 * 输出：false
 * 
 * 示例 3：
 * 输入：ransomNote = "aa", magazine = "aab"
 * 输出：true
 * 
 * 提示：
 * - 1 <= ransomNote.length, magazine.length <= 10⁵
 * - ransomNote 和 magazine 由小写英文字母组成
 */
public class L0383_RansomNote {
    
    public boolean canConstruct(String ransomNote, String magazine) {
        // 创建一个长度为 26 的数组，用于统计 magazine 中每个字符出现的次数
        int[] charCount = new int[26];
        
        // 统计 magazine 中每个字符出现的次数
        for (char c : magazine.toCharArray()) {
            charCount[c - 'a']++;
        }
        
        // 遍历 ransomNote，检查每个字符是否有足够的可用次数
        for (char c : ransomNote.toCharArray()) {
            if (--charCount[c - 'a'] < 0) {
                return false;
            }
        }
        
        return true;
    }

    public static void main(String[] args) {
        L0383_RansomNote solution = new L0383_RansomNote();
        
        // 测试用例 1
        System.out.println(solution.canConstruct("a", "b"));     // 应输出 false
        
        // 测试用例 2
        System.out.println(solution.canConstruct("aa", "ab"));   // 应输出 false
        
        // 测试用例 3
        System.out.println(solution.canConstruct("aa", "aab"));  // 应输出 true
        
        // 测试用例 4
        System.out.println(solution.canConstruct("aab", "baa")); // 应输出 true
    }
} 
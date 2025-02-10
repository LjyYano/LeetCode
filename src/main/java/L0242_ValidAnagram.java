/**
 * https://leetcode.cn/problems/valid-anagram/
 * 
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 
 * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
 * 
 * 示例 1:
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 
 * 示例 2:
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 
 * 提示:
 * - 1 <= s.length, t.length <= 5 * 10⁴
 * - s 和 t 仅包含小写字母
 */
public class L0242_ValidAnagram {
    
    /**
     * 使用数组记录字符出现次数
     * 由于题目说明只包含小写字母，可以使用一个长度为 26 的数组
     */
    public boolean isAnagram(String s, String t) {
        // 如果长度不相等，一定不是字母异位词
        if (s.length() != t.length()) {
            return false;
        }
        
        // 创建一个长度为 26 的数组，记录每个字符出现的次数
        int[] charCount = new int[26];
        
        // 遍历第一个字符串，记录每个字符出现的次数
        for (char c : s.toCharArray()) {
            charCount[c - 'a']++;
        }
        
        // 遍历第二个字符串，减去每个字符出现的次数
        for (char c : t.toCharArray()) {
            charCount[c - 'a']--;
            // 如果某个字符出现的次数小于 0，说明不是字母异位词
            if (charCount[c - 'a'] < 0) {
                return false;
            }
        }
        
        return true;
    }

    public static void main(String[] args) {
        L0242_ValidAnagram solution = new L0242_ValidAnagram();
        
        // 测试用例 1
        String s1 = "anagram";
        String t1 = "nagaram";
        System.out.println("输入：s = \"" + s1 + "\", t = \"" + t1 + "\"");
        System.out.println("输出：" + solution.isAnagram(s1, t1));  // 应输出：true
        
        // 测试用例 2
        String s2 = "rat";
        String t2 = "car";
        System.out.println("\n输入：s = \"" + s2 + "\", t = \"" + t2 + "\"");
        System.out.println("输出：" + solution.isAnagram(s2, t2));  // 应输出：false
    }
} 
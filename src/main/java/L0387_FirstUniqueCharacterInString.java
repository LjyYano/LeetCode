/**
 * https://leetcode.cn/problems/first-unique-character-in-a-string/
 * 
 * 给定一个字符串 s ，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1 。
 */
public class L0387_FirstUniqueCharacterInString {
    
    public int firstUniqChar(String s) {
        // 由于字符串只包含小写字母，使用一个长度为 26 的数组来存储每个字符的出现次数
        int[] freq = new int[26];
        
        // 第一次遍历，统计每个字符的出现次数
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        
        // 第二次遍历，找到第一个出现次数为 1 的字符
        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        
        return -1;
    }

    public static void main(String[] args) {
        L0387_FirstUniqueCharacterInString solution = new L0387_FirstUniqueCharacterInString();
        
        // 测试用例 1
        String s1 = "leetcode";
        System.out.println("Test case 1: s = \"" + s1 + "\"");
        System.out.println("Output: " + solution.firstUniqChar(s1));
        // 预期输出：0
        
        // 测试用例 2
        String s2 = "loveleetcode";
        System.out.println("\nTest case 2: s = \"" + s2 + "\"");
        System.out.println("Output: " + solution.firstUniqChar(s2));
        // 预期输出：2
        
        // 测试用例 3
        String s3 = "aabb";
        System.out.println("\nTest case 3: s = \"" + s3 + "\"");
        System.out.println("Output: " + solution.firstUniqChar(s3));
        // 预期输出：-1
    }
} 
/**
 * https://leetcode.cn/problems/longest-repeating-character-replacement/description/
 * 
 * 给你一个字符串 s 和一个整数 k 。你可以选择字符串中的任一字符，并将其更改为任何其他大写英文字符。该操作最多可以执行 k 次。
 * 在执行上述操作后，返回包含相同字母的最长子串的长度。
 * 
 * 示例 1：
 * 输入：s = "ABAB", k = 2
 * 输出：4
 * 解释：用两个'A'替换为两个'B',反之亦然。
 * 
 * 示例 2：
 * 输入：s = "AABABBA", k = 1
 * 输出：4
 * 解释：将中间的一个'A'替换为'B',字符串变为 "AABBBBA"。
 * 子串 "BBBB" 有最长重复字母, 答案为 4。
 */
public class L0424_LongestRepeatingCharacterReplacement {

    public int characterReplacement(String s, int k) {
        int[] count = new int[26];  // 用于统计窗口内每个字符的出现次数
        int maxCount = 0;  // 窗口内出现次数最多的字符的出现次数
        int maxLength = 0;  // 最长重复字符子串的长度
        int left = 0;  // 滑动窗口的左边界
        
        // 遍历字符串，right 为滑动窗口的右边界
        for (int right = 0; right < s.length(); right++) {
            // 更新当前字符的计数
            count[s.charAt(right) - 'A']++;
            // 更新窗口内出现次数最多的字符的出现次数
            maxCount = Math.max(maxCount, count[s.charAt(right) - 'A']);
            
            // 如果当前窗口内需要替换的字符数量超过了 k
            // 窗口内的总长度 减去 出现次数最多的字符的出现次数 就是需要替换的字符数量
            while (right - left + 1 - maxCount > k) {
                // 缩小窗口
                count[s.charAt(left) - 'A']--;
                // 更新左边界
                left++;
                // 重新计算窗口内出现次数最多的字符的出现次数
                maxCount = 0;
                for (int c : count) {
                    maxCount = Math.max(maxCount, c);
                }
            }
            
            // 更新最长重复字符子串的长度
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }

    public static void main(String[] args) {
        L0424_LongestRepeatingCharacterReplacement solution = new L0424_LongestRepeatingCharacterReplacement();
        
        // 测试用例1
        String s1 = "ABAB";
        int k1 = 2;
        System.out.println("测试用例1：");
        System.out.println("输入：s = \"" + s1 + "\", k = " + k1);
        System.out.println("输出：" + solution.characterReplacement(s1, k1));
        
        // 测试用例2
        String s2 = "AABABBA";
        int k2 = 1;
        System.out.println("\n测试用例2：");
        System.out.println("输入：s = \"" + s2 + "\", k = " + k2);
        System.out.println("输出：" + solution.characterReplacement(s2, k2));
        
        // 测试用例3
        String s3 = "AAAA";
        int k3 = 2;
        System.out.println("\n测试用例3：");
        System.out.println("输入：s = \"" + s3 + "\", k = " + k3);
        System.out.println("输出：" + solution.characterReplacement(s3, k3));
    }
} 
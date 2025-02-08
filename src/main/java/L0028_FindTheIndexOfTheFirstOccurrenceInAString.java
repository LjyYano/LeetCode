/**
 * https://leetcode.cn/problems/find-the-index-of-the-first-occurrence-in-a-string/
 * 
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。
 * 如果 needle 不是 haystack 的一部分，则返回 -1 。
 * 
 * 示例 1：
 * 输入：haystack = "sadbutsad", needle = "sad"
 * 输出：0
 * 解释："sad" 在下标 0 和 6 处匹配。
 * 第一个匹配项的下标是 0 ，所以返回 0 。
 * 
 * 示例 2：
 * 输入：haystack = "leetcode", needle = "leeto"
 * 输出：-1
 * 解释："leeto" 没有在 "leetcode" 中出现，所以返回 -1 。
 */
public class L0028_FindTheIndexOfTheFirstOccurrenceInAString {

    public static void main(String[] args) {
        Solution solution = new L0028_FindTheIndexOfTheFirstOccurrenceInAString().new Solution();
        
        // 测试用例 1
        String haystack1 = "sadbutsad";
        String needle1 = "sad";
        System.out.println("测试用例 1 结果：" + solution.strStr(haystack1, needle1));  // 预期输出：0
        
        // 测试用例 2
        String haystack2 = "leetcode";
        String needle2 = "leeto";
        System.out.println("测试用例 2 结果：" + solution.strStr(haystack2, needle2));  // 预期输出：-1
        
        // 测试用例 3：空字符串
        String haystack3 = "";
        String needle3 = "";
        System.out.println("测试用例 3 结果：" + solution.strStr(haystack3, needle3));  // 预期输出：0
        
        // 测试用例 4：单字符匹配
        String haystack4 = "a";
        String needle4 = "a";
        System.out.println("测试用例 4 结果：" + solution.strStr(haystack4, needle4));  // 预期输出：0
    }

    class Solution {
        public int strStr(String haystack, String needle) {
            // 如果 needle 为空，返回 0
            if (needle == null || needle.length() == 0) {
                return 0;
            }
            
            // 如果 haystack 为空或长度小于 needle，返回 -1
            if (haystack == null || haystack.length() < needle.length()) {
                return -1;
            }
            
            // 遍历 haystack 的每个可能的起始位置
            for (int i = 0; i <= haystack.length() - needle.length(); i++) {
                // 检查从当前位置开始是否匹配 needle
                boolean match = true;
                for (int j = 0; j < needle.length(); j++) {
                    if (haystack.charAt(i + j) != needle.charAt(j)) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    return i;
                }
            }
            
            return -1;
        }
    }
} 
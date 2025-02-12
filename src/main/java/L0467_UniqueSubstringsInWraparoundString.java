/**
 * https://leetcode.cn/problems/unique-substrings-in-wraparound-string/
 * 
 * 把字符串 s 看作是 "abcdefghijklmnopqrstuvwxyz" 的无限环绕字符串，所以 s 看起来是这样的：
 * - "...zabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcd...." 
 * 
 * 现在给定另一个字符串 p 。返回 s 中 唯一 的 p 的 非空子串 的数量 。 
 * 
 * 示例 1:
 * 输入: p = "a"
 * 输出: 1
 * 解释: 字符串 s 中只有一个"a"子字符串。
 * 
 * 示例 2:
 * 输入: p = "cac"
 * 输出: 2
 * 解释: 字符串 s 中的字符串"cac"只有两个子串"a"、"c"。
 * 
 * 示例 3:
 * 输入: p = "zab"
 * 输出: 6
 * 解释: 在字符串 s 中有六个子串"z"、"a"、"b"、"za"、"ab"、"zab"。
 * 
 * 提示:
 * 1 <= p.length <= 10⁵
 * p 由小写英文字母组成
 */
public class L0467_UniqueSubstringsInWraparoundString {
    
    public int findSubstringInWraproundString(String p) {
        // dp[i] 表示以字符 i 结尾的最长连续子串的长度
        int[] dp = new int[26];
        
        // count 表示当前连续子串的长度
        int count = 0;
        
        // 遍历字符串 p
        for (int i = 0; i < p.length(); i++) {
            // 判断当前字符是否能够与前一个字符构成连续字符串
            if (i > 0 && (p.charAt(i) - p.charAt(i - 1) == 1 || 
                (p.charAt(i - 1) == 'z' && p.charAt(i) == 'a'))) {
                count++;
            } else {
                count = 1;
            }
            
            // 更新以当前字符结尾的最长连续子串长度
            dp[p.charAt(i) - 'a'] = Math.max(dp[p.charAt(i) - 'a'], count);
        }
        
        // 计算所有可能的子串数量
        int result = 0;
        for (int length : dp) {
            result += length;
        }
        
        return result;
    }

    public static void main(String[] args) {
        L0467_UniqueSubstringsInWraparoundString solution = new L0467_UniqueSubstringsInWraparoundString();
        
        // 测试用例 1
        System.out.println("测试用例 1 结果：" + solution.findSubstringInWraproundString("a"));  // 预期输出：1
        
        // 测试用例 2
        System.out.println("测试用例 2 结果：" + solution.findSubstringInWraproundString("cac"));  // 预期输出：2
        
        // 测试用例 3
        System.out.println("测试用例 3 结果：" + solution.findSubstringInWraproundString("zab"));  // 预期输出：6
    }
} 
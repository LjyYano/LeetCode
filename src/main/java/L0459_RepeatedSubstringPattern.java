/**
 * https://leetcode.cn/problems/repeated-substring-pattern/
 * 
 * 给定一个非空的字符串 s ，检查是否可以通过由它的一个子串重复多次构成。
 * 
 * 示例 1：
 * 输入: s = "abab"
 * 输出: true
 * 解释: 可由子串 "ab" 重复两次构成。
 * 
 * 示例 2：
 * 输入: s = "aba"
 * 输出: false
 * 
 * 示例 3：
 * 输入: s = "abcabcabcabc"
 * 输出: true
 * 解释: 可由子串 "abc" 重复四次构成。 (或子串 "abcabc" 重复两次构成。)
 * 
 * 提示：
 * - 1 <= s.length <= 10⁴
 * - s 由小写英文字母组成
 */
public class L0459_RepeatedSubstringPattern {
    
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        // 枚举所有可能的子串长度
        for (int len = 1; len <= n / 2; len++) {
            // 如果字符串长度不能被子串长度整除，跳过
            if (n % len != 0) {
                continue;
            }
            
            // 获取子串
            String pattern = s.substring(0, len);
            boolean isValid = true;
            
            // 检查每个子串是否相同
            for (int i = len; i < n; i += len) {
                if (!s.substring(i, i + len).equals(pattern)) {
                    isValid = false;
                    break;
                }
            }
            
            if (isValid) {
                return true;
            }
        }
        
        return false;
    }

    public static void main(String[] args) {
        L0459_RepeatedSubstringPattern solution = new L0459_RepeatedSubstringPattern();
        
        // 测试用例 1
        String s1 = "abab";
        System.out.println("测试用例 1：");
        System.out.println("输入：" + s1);
        System.out.println("输出：" + solution.repeatedSubstringPattern(s1));
        System.out.println("预期：true");
        System.out.println();
        
        // 测试用例 2
        String s2 = "aba";
        System.out.println("测试用例 2：");
        System.out.println("输入：" + s2);
        System.out.println("输出：" + solution.repeatedSubstringPattern(s2));
        System.out.println("预期：false");
        System.out.println();
        
        // 测试用例 3
        String s3 = "abcabcabcabc";
        System.out.println("测试用例 3：");
        System.out.println("输入：" + s3);
        System.out.println("输出：" + solution.repeatedSubstringPattern(s3));
        System.out.println("预期：true");
    }
} 
/**
 * https://leetcode.cn/problems/is-subsequence/
 * 
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * 
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。
 * （例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 * 
 * 示例 1：
 * 输入：s = "abc", t = "ahbgdc"
 * 输出：true
 * 
 * 示例 2：
 * 输入：s = "axc", t = "ahbgdc"
 * 输出：false
 * 
 * 提示：
 * - 0 <= s.length <= 100
 * - 0 <= t.length <= 10⁴
 * - 两个字符串都只由小写字符组成。
 * 
 * 进阶：
 * 如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。
 * 在这种情况下，你会怎样改变代码？
 */
public class L0392_IsSubsequence {
    
    public boolean isSubsequence(String s, String t) {
        // 使用双指针，分别指向 s 和 t
        int i = 0, j = 0;
        
        // 遍历字符串 t
        while (i < s.length() && j < t.length()) {
            // 如果当前字符相同，s 的指针向后移动
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            // t 的指针始终向后移动
            j++;
        }
        
        // 如果 s 的指针到达末尾，说明找到了所有字符
        return i == s.length();
    }

    public static void main(String[] args) {
        L0392_IsSubsequence solution = new L0392_IsSubsequence();
        
        // 测试用例 1
        String s1 = "abc";
        String t1 = "ahbgdc";
        System.out.println("测试用例 1：");
        System.out.println("输入：s = \"" + s1 + "\", t = \"" + t1 + "\"");
        System.out.println("输出：" + solution.isSubsequence(s1, t1));
        System.out.println();
        
        // 测试用例 2
        String s2 = "axc";
        String t2 = "ahbgdc";
        System.out.println("测试用例 2：");
        System.out.println("输入：s = \"" + s2 + "\", t = \"" + t2 + "\"");
        System.out.println("输出：" + solution.isSubsequence(s2, t2));
        System.out.println();
        
        // 测试用例 3：空字符串
        String s3 = "";
        String t3 = "ahbgdc";
        System.out.println("测试用例 3：");
        System.out.println("输入：s = \"" + s3 + "\", t = \"" + t3 + "\"");
        System.out.println("输出：" + solution.isSubsequence(s3, t3));
    }
} 
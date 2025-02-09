import java.util.List;
import java.util.ArrayList;

/**
 * https://leetcode.cn/problems/palindrome-partitioning/
 * 
 * 题目描述:
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 * 
 * 回文串 是正着读和反着读都一样的字符串。
 * 
 * 示例 1：
 * 输入：s = "aab"
 * 输出：[["a","a","b"],["aa","b"]]
 * 
 * 示例 2：
 * 输入：s = "a"
 * 输出：[["a"]]
 * 
 * 提示：
 * - 1 <= s.length <= 16
 * - s 仅由小写英文字母组成
 */
public class L0131_PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }
    
    // 回溯方法
    private void backtrack(String s, int start, List<String> current, List<List<String>> result) {
        // 如果已经处理到字符串末尾，说明找到了一个有效的分割方案
        if (start >= s.length()) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        // 尝试所有可能的分割点
        for (int i = start; i < s.length(); i++) {
            // 如果从 start 到 i 的子串是回文串
            if (isPalindrome(s, start, i)) {
                // 将这个回文串加入当前方案
                current.add(s.substring(start, i + 1));
                // 递归处理剩余部分
                backtrack(s, i + 1, current, result);
                // 回溯，移除最后添加的子串
                current.remove(current.size() - 1);
            }
        }
    }
    
    // 判断子串是否为回文串
    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        L0131_PalindromePartitioning solution = new L0131_PalindromePartitioning();
        
        // 测试用例 1
        String s1 = "aab";
        System.out.println("测试用例 1:");
        System.out.println("输入: s = \"" + s1 + "\"");
        System.out.println("输出: " + solution.partition(s1));
        System.out.println();
        
        // 测试用例 2
        String s2 = "a";
        System.out.println("测试用例 2:");
        System.out.println("输入: s = \"" + s2 + "\"");
        System.out.println("输出: " + solution.partition(s2));
    }
} 
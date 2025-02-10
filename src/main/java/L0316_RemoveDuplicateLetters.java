/*
 * https://leetcode.cn/problems/remove-duplicate-letters/
 * 
 * 给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 * 
 * 示例 1：
 * 输入：s = "bcabc"
 * 输出："abc"
 * 
 * 示例 2：
 * 输入：s = "cbacdcbc"
 * 输出："acdb"
 * 
 * 提示：
 * 1 <= s.length <= 10⁴
 * s 由小写英文字母组成
 */

public class L0316_RemoveDuplicateLetters {
    
    public String removeDuplicateLetters(String s) {
        // 记录每个字符最后出现的位置
        int[] lastIndex = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }
        
        // 记录字符是否已经在栈中
        boolean[] inStack = new boolean[26];
        // 使用 StringBuilder 作为栈
        StringBuilder stack = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 如果字符已经在栈中，跳过
            if (inStack[c - 'a']) {
                continue;
            }
            
            // 如果当前字符小于栈顶字符，且栈顶字符在后面还会出现，则弹出栈顶字符
            while (stack.length() > 0 && c < stack.charAt(stack.length() - 1) && 
                   lastIndex[stack.charAt(stack.length() - 1) - 'a'] > i) {
                inStack[stack.charAt(stack.length() - 1) - 'a'] = false;
                stack.deleteCharAt(stack.length() - 1);
            }
            
            // 将当前字符入栈
            stack.append(c);
            inStack[c - 'a'] = true;
        }
        
        return stack.toString();
    }

    public static void main(String[] args) {
        L0316_RemoveDuplicateLetters solution = new L0316_RemoveDuplicateLetters();
        
        // 测试用例 1
        System.out.println(solution.removeDuplicateLetters("bcabc")); // 应输出 "abc"
        
        // 测试用例 2
        System.out.println(solution.removeDuplicateLetters("cbacdcbc")); // 应输出 "acdb"
        
        // 测试用例 3
        System.out.println(solution.removeDuplicateLetters("abacb")); // 应输出 "abc"
        
        // 测试用例 4
        System.out.println(solution.removeDuplicateLetters("bbcaac")); // 应输出 "bac"
    }
} 
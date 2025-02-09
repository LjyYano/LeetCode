/**
 * https://leetcode.cn/problems/word-break/
 * 
 * 题目描述:
 * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。
 * 
 * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
 * 
 * 示例 1：
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
 * 
 * 示例 2：
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以由 "apple" "pen" "apple" 拼接成。
 *      注意，你可以重复使用字典中的单词。
 * 
 * 示例 3：
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 * 
 * 提示：
 * - 1 <= s.length <= 300
 * - 1 <= wordDict.length <= 1000
 * - 1 <= wordDict[i].length <= 20
 * - s 和 wordDict[i] 仅由小写英文字母组成
 * - wordDict 中的所有字符串 互不相同
 */

import java.util.*;

public class L0139_WordBreak {
    
    public boolean wordBreak(String s, List<String> wordDict) {
        // 将字典转换为 Set，提高查找效率
        Set<String> wordSet = new HashSet<>(wordDict);
        
        // dp[i] 表示字符串 s 的前 i 个字符是否可以被拆分成字典中的单词
        boolean[] dp = new boolean[s.length() + 1];
        // 空字符串可以被拆分
        dp[0] = true;
        
        // 遍历每个位置，判断是否可以拆分
        for (int i = 1; i <= s.length(); i++) {
            // 尝试以当前位置为结尾，判断前面的子串是否可以拆分
            for (int j = 0; j < i; j++) {
                // 如果前 j 个字符可以被拆分，且剩余部分在字典中存在
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        
        return dp[s.length()];
    }

    public static void main(String[] args) {
        L0139_WordBreak solution = new L0139_WordBreak();
        
        // 测试用例 1
        String s1 = "leetcode";
        List<String> wordDict1 = Arrays.asList("leet", "code");
        System.out.println("测试用例 1:");
        System.out.println("输入: s = \"" + s1 + "\", wordDict = " + wordDict1);
        System.out.println("输出: " + solution.wordBreak(s1, wordDict1));
        System.out.println();
        
        // 测试用例 2
        String s2 = "applepenapple";
        List<String> wordDict2 = Arrays.asList("apple", "pen");
        System.out.println("测试用例 2:");
        System.out.println("输入: s = \"" + s2 + "\", wordDict = " + wordDict2);
        System.out.println("输出: " + solution.wordBreak(s2, wordDict2));
        System.out.println();
        
        // 测试用例 3
        String s3 = "catsandog";
        List<String> wordDict3 = Arrays.asList("cats", "dog", "sand", "and", "cat");
        System.out.println("测试用例 3:");
        System.out.println("输入: s = \"" + s3 + "\", wordDict = " + wordDict3);
        System.out.println("输出: " + solution.wordBreak(s3, wordDict3));
    }
} 
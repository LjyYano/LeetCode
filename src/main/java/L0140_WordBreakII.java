import java.util.*;

/**
 * https://leetcode.cn/problems/word-break-ii/
 * 
 * 给定一个字符串 s 和一个字符串字典 wordDict ，在字符串 s 中增加空格来构建一个句子，使得句子中所有的单词都在词典中。以任意顺序 返回所有这些可能的句子。
 * 
 * 注意：词典中的同一个单词可能在分段中被重复使用多次。
 * 
 * 示例 1：
 * 输入:s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
 * 输出:["cats and dog","cat sand dog"]
 * 
 * 示例 2：
 * 输入:s = "pineapplepenapple", wordDict = ["apple","pen","applepen","pine","pineapple"]
 * 输出:["pine apple pen apple","pineapple pen apple","pine applepen apple"]
 * 
 * 示例 3：
 * 输入:s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
 * 输出:[]
 * 
 * 提示：
 * 1 <= s.length <= 20
 * 1 <= wordDict.length <= 1000
 * 1 <= wordDict[i].length <= 10
 * s 和 wordDict[i] 仅有小写英文字母组成
 * wordDict 中的所有字符串 互不相同
 */
public class L0140_WordBreakII {

    // 使用 HashMap 进行记忆化，避免重复计算
    private Map<String, List<String>> memo;
    private Set<String> wordSet;

    public List<String> wordBreak(String s, List<String> wordDict) {
        memo = new HashMap<>();
        wordSet = new HashSet<>(wordDict);
        return backtrack(s);
    }

    // 回溯函数，返回字符串 s 所有可能的拆分方案
    private List<String> backtrack(String s) {
        // 如果已经计算过这个字符串的拆分方案，直接返回
        if (memo.containsKey(s)) {
            return memo.get(s);
        }

        List<String> result = new ArrayList<>();
        
        // 如果字符串为空，返回空列表
        if (s.length() == 0) {
            result.add("");
            return result;
        }

        // 遍历所有可能的前缀
        for (int i = 1; i <= s.length(); i++) {
            String word = s.substring(0, i);
            // 如果当前前缀在字典中
            if (wordSet.contains(word)) {
                // 递归处理剩余部分
                List<String> subList = backtrack(s.substring(i));
                // 将当前单词与后面的拆分方案组合
                for (String sub : subList) {
                    result.add(word + (sub.isEmpty() ? "" : " " + sub));
                }
            }
        }

        // 将结果存入备忘录
        memo.put(s, result);
        return result;
    }

    public static void main(String[] args) {
        L0140_WordBreakII solution = new L0140_WordBreakII();

        // 测试用例 1
        String s1 = "catsanddog";
        List<String> wordDict1 = Arrays.asList("cat", "cats", "and", "sand", "dog");
        System.out.println("测试用例 1:");
        System.out.println("输入: s = \"" + s1 + "\", wordDict = " + wordDict1);
        System.out.println("输出: " + solution.wordBreak(s1, wordDict1));
        System.out.println();

        // 测试用例 2
        String s2 = "pineapplepenapple";
        List<String> wordDict2 = Arrays.asList("apple", "pen", "applepen", "pine", "pineapple");
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
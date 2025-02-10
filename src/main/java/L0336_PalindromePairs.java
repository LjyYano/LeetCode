/**
 * https://leetcode.cn/problems/palindrome-pairs/
 * 
 * 给定一组 互不相同 的单词， 找出所有 不同 的索引对 (i, j)，使得列表中的两个单词， words[i] + words[j] ，可拼接成回文串。
 * 
 * 示例 1：
 * 输入：words = ["abcd","dcba","lls","s","sssll"]
 * 输出：[[0,1],[1,0],[3,2],[2,4]] 
 * 解释：可拼接成的回文串为 ["dcbaabcd","abcddcba","slls","llssssll"]
 * 
 * 示例 2：
 * 输入：words = ["bat","tab","cat"]
 * 输出：[[0,1],[1,0]] 
 * 解释：可拼接成的回文串为 ["battab","tabbat"]
 * 
 * 示例 3：
 * 输入：words = ["a",""]
 * 输出：[[0,1],[1,0]]
 * 
 * 提示：
 * 1 <= words.length <= 5000
 * 0 <= words[i].length <= 300
 * words[i] 由小写英文字母组成
 * words 中的所有字符串 互不相同
 */

import java.util.*;

public class L0336_PalindromePairs {
    
    /**
     * 字典树节点类
     */
    private static class TrieNode {
        TrieNode[] children;
        int index;
        List<Integer> palindromePrefixRemaining;
        
        TrieNode() {
            children = new TrieNode[26];
            index = -1;
            palindromePrefixRemaining = new ArrayList<>();
        }
    }
    
    private TrieNode root;
    
    /**
     * 将单词插入字典树（反向插入）
     */
    private void addWord(String word, int index) {
        TrieNode node = root;
        for (int i = word.length() - 1; i >= 0; i--) {
            if (isPalindrome(word, 0, i)) {
                node.palindromePrefixRemaining.add(index);
            }
            int j = word.charAt(i) - 'a';
            if (node.children[j] == null) {
                node.children[j] = new TrieNode();
            }
            node = node.children[j];
        }
        node.index = index;
        node.palindromePrefixRemaining.add(index);
    }
    
    /**
     * 在字典树中搜索可以与当前单词组成回文串的单词
     */
    private void search(String word, int index, List<List<Integer>> result) {
        TrieNode node = root;
        
        for (int i = 0; i < word.length(); i++) {
            // 如果当前节点有单词，且不是当前单词，检查剩余部分是否为回文
            if (node.index >= 0 && node.index != index && isPalindrome(word, i, word.length() - 1)) {
                result.add(Arrays.asList(index, node.index));
            }
            
            node = node.children[word.charAt(i) - 'a'];
            if (node == null) return;
        }
        
        // 检查所有可能的回文前缀
        for (int j : node.palindromePrefixRemaining) {
            if (j != index) {
                result.add(Arrays.asList(index, j));
            }
        }
    }
    
    /**
     * 判断字符串的子串是否是回文
     */
    private boolean isPalindrome(String word, int i, int j) {
        while (i < j) {
            if (word.charAt(i++) != word.charAt(j--)) return false;
        }
        return true;
    }
    
    /**
     * 查找所有回文对
     * 时间复杂度：O(n * k²)，其中 n 是单词的数量，k 是单词的平均长度
     * 空间复杂度：O(n * k)，用于存储字典树
     */
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> result = new ArrayList<>();
        if (words == null || words.length < 2) {
            return result;
        }
        
        // 构建字典树
        root = new TrieNode();
        for (int i = 0; i < words.length; i++) {
            addWord(words[i], i);
        }
        
        // 搜索回文对
        for (int i = 0; i < words.length; i++) {
            search(words[i], i, result);
        }
        
        return result;
    }

    public static void main(String[] args) {
        L0336_PalindromePairs solution = new L0336_PalindromePairs();
        
        // 测试用例 1
        String[] words1 = {"abcd", "dcba", "lls", "s", "sssll"};
        System.out.println("测试用例 1：");
        System.out.println("输入：" + Arrays.toString(words1));
        System.out.println("输出：" + solution.palindromePairs(words1));
        System.out.println("预期输出：[[0,1],[1,0],[3,2],[2,4]]");
        System.out.println();
        
        // 测试用例 2
        String[] words2 = {"bat", "tab", "cat"};
        System.out.println("测试用例 2：");
        System.out.println("输入：" + Arrays.toString(words2));
        System.out.println("输出：" + solution.palindromePairs(words2));
        System.out.println("预期输出：[[0,1],[1,0]]");
        System.out.println();
        
        // 测试用例 3
        String[] words3 = {"a", ""};
        System.out.println("测试用例 3：");
        System.out.println("输入：" + Arrays.toString(words3));
        System.out.println("输出：" + solution.palindromePairs(words3));
        System.out.println("预期输出：[[0,1],[1,0]]");
    }
} 
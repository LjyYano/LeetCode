/*
 * https://leetcode.cn/problems/maximum-product-of-word-lengths/
 * 
 * 给你一个字符串数组 words ，找出并返回 length(words[i]) * length(words[j]) 的最大值，并且这两个单词不含有公共字母。
 * 如果不存在这样的两个单词，返回 0 。
 * 
 * 示例 1：
 * 输入：words = ["abcw","baz","foo","bar","xtfn","abcdef"]
 * 输出：16 
 * 解释：这两个单词为 "abcw", "xtfn"。
 * 
 * 示例 2：
 * 输入：words = ["a","ab","abc","d","cd","bcd","abcd"]
 * 输出：4 
 * 解释：这两个单词为 "ab", "cd"。
 * 
 * 示例 3：
 * 输入：words = ["a","aa","aaa","aaaa"]
 * 输出：0 
 * 解释：不存在这样的两个单词。
 * 
 * 提示：
 * 2 <= words.length <= 1000
 * 1 <= words[i].length <= 1000
 * words[i] 仅包含小写字母
 */

public class L0318_MaximumProductOfWordLengths {
    
    public int maxProduct(String[] words) {
        int n = words.length;
        // 使用整数的二进制位表示每个单词包含的字母
        int[] masks = new int[n];
        
        // 计算每个单词的位掩码
        for (int i = 0; i < n; i++) {
            String word = words[i];
            for (char c : word.toCharArray()) {
                // 将字母对应的位设置为 1
                masks[i] |= 1 << (c - 'a');
            }
        }
        
        // 找出不含公共字母的两个单词，计算它们长度的乘积
        int maxProduct = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // 如果两个单词的位掩码按位与为 0，说明没有公共字母
                if ((masks[i] & masks[j]) == 0) {
                    maxProduct = Math.max(maxProduct, words[i].length() * words[j].length());
                }
            }
        }
        
        return maxProduct;
    }

    public static void main(String[] args) {
        L0318_MaximumProductOfWordLengths solution = new L0318_MaximumProductOfWordLengths();
        
        // 测试用例 1
        String[] words1 = {"abcw", "baz", "foo", "bar", "xtfn", "abcdef"};
        System.out.println(solution.maxProduct(words1)); // 应输出 16
        
        // 测试用例 2
        String[] words2 = {"a", "ab", "abc", "d", "cd", "bcd", "abcd"};
        System.out.println(solution.maxProduct(words2)); // 应输出 4
        
        // 测试用例 3
        String[] words3 = {"a", "aa", "aaa", "aaaa"};
        System.out.println(solution.maxProduct(words3)); // 应输出 0
        
        // 测试用例 4
        String[] words4 = {"eae", "ea", "aaf", "bda", "fcf", "dc", "ac", "ce", "cefde", "dabae"};
        System.out.println(solution.maxProduct(words4)); // 应输出 15
    }
} 
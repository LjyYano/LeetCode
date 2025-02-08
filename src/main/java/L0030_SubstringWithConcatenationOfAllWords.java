import java.util.*;

/**
 * https://leetcode.cn/problems/substring-with-concatenation-of-all-words/
 * 
 * 给定一个字符串 s 和一个字符串数组 words。words 中所有字符串 长度相同。
 * s 中的 串联子串 是指一个包含 words 中所有字符串以任意顺序排列连接起来的子串。
 * 例如，如果 words = ["ab","cd","ef"]，那么 "abcdef"、"abefcd"、"cdabef"、"cdefab"、"efabcd" 和 "efcdab" 都是串联子串。
 * "acdbef" 不是串联子串，因为他不是任何 words 数组中的字符串连接起来的。
 * 返回所有串联子串在 s 中的开始索引。你可以以 任意顺序 返回答案。
 */
public class L0030_SubstringWithConcatenationOfAllWords {

    public static void main(String[] args) {
        Solution solution = new L0030_SubstringWithConcatenationOfAllWords().new Solution();
        
        // 测试用例 1
        String s1 = "barfoothefoobarman";
        String[] words1 = {"foo","bar"};
        System.out.println("测试用例 1 结果：" + solution.findSubstring(s1, words1));  // 预期输出：[0,9]
        
        // 测试用例 2
        String s2 = "wordgoodgoodgoodbestword";
        String[] words2 = {"word","good","best","word"};
        System.out.println("测试用例 2 结果：" + solution.findSubstring(s2, words2));  // 预期输出：[]
        
        // 测试用例 3
        String s3 = "barfoofoobarthefoobarman";
        String[] words3 = {"bar","foo","the"};
        System.out.println("测试用例 3 结果：" + solution.findSubstring(s3, words3));  // 预期输出：[6,9,12]
        
        // 测试用例 4：空字符串
        String s4 = "";
        String[] words4 = {"foo"};
        System.out.println("测试用例 4 结果：" + solution.findSubstring(s4, words4));  // 预期输出：[]
        
        // 测试用例 5：空单词数组
        String s5 = "foo";
        String[] words5 = {};
        System.out.println("测试用例 5 结果：" + solution.findSubstring(s5, words5));  // 预期输出：[]
    }

    class Solution {
        public List<Integer> findSubstring(String s, String[] words) {
            List<Integer> result = new ArrayList<>();
            if (s == null || s.length() == 0 || words == null || words.length == 0) {
                return result;
            }
            
            // 计算所有单词的总长度
            int wordLength = words[0].length();
            int totalLength = wordLength * words.length;
            if (s.length() < totalLength) {
                return result;
            }
            
            // 统计每个单词出现的次数
            Map<String, Integer> wordCount = new HashMap<>();
            for (String word : words) {
                wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
            }
            
            // 遍历所有可能的起始位置
            for (int i = 0; i <= s.length() - totalLength; i++) {
                // 检查从当前位置开始是否能找到所有单词
                Map<String, Integer> tempCount = new HashMap<>();
                boolean found = true;
                
                for (int j = 0; j < words.length; j++) {
                    int start = i + j * wordLength;
                    String currentWord = s.substring(start, start + wordLength);
                    
                    // 如果当前单词不在 words 中，或者出现次数超过了要求，则跳过当前起始位置
                    if (!wordCount.containsKey(currentWord)) {
                        found = false;
                        break;
                    }
                    
                    tempCount.put(currentWord, tempCount.getOrDefault(currentWord, 0) + 1);
                    if (tempCount.get(currentWord) > wordCount.get(currentWord)) {
                        found = false;
                        break;
                    }
                }
                
                if (found) {
                    result.add(i);
                }
            }
            
            return result;
        }
    }
} 
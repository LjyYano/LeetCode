import java.util.*;

/**
 * https://leetcode.cn/problems/word-ladder/
 * 
 * 题目描述:
 * 字典 wordList 中从单词 beginWord 到 endWord 的 转换序列 是一个按下述规格形成的序列 beginWord -> s1 -> s2 -> ... -> sk：
 * - 每一对相邻的单词只差一个字母。
 * - 对于 1 <= i <= k 时，每个 si 都在 wordList 中。注意， beginWord 不需要在 wordList 中。
 * - sk == endWord
 * 
 * 给你两个单词 beginWord 和 endWord 和一个字典 wordList ，返回 从 beginWord 到 endWord 的 最短转换序列 中的 单词数目 。如果不存在这样的转换序列，返回 0 。
 * 
 * 示例 1：
 * 输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
 * 输出：5
 * 解释：一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog", 返回它的长度 5。
 * 
 * 示例 2：
 * 输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
 * 输出：0
 * 解释：endWord "cog" 不在字典中，所以无法进行转换。
 * 
 * 提示：
 * - 1 <= beginWord.length <= 10
 * - endWord.length == beginWord.length
 * - 1 <= wordList.length <= 5000
 * - wordList[i].length == beginWord.length
 * - beginWord、endWord 和 wordList[i] 由小写英文字母组成
 * - beginWord != endWord
 * - wordList 中的所有字符串 互不相同
 */
public class L0127_WordLadder {
    public static class Solution {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            // 将 wordList 转换为 HashSet，提高查找效率
            Set<String> wordSet = new HashSet<>(wordList);
            
            // 如果 endWord 不在 wordList 中，直接返回 0
            if (!wordSet.contains(endWord)) {
                return 0;
            }
            
            // 创建访问集合，记录已访问的单词
            Set<String> visited = new HashSet<>();
            visited.add(beginWord);
            
            // 创建队列，用于 BFS
            Queue<String> queue = new LinkedList<>();
            queue.offer(beginWord);
            
            // 记录转换序列的长度
            int level = 1;
            
            // BFS
            while (!queue.isEmpty()) {
                int size = queue.size();
                
                // 遍历当前层的所有单词
                for (int i = 0; i < size; i++) {
                    String currentWord = queue.poll();
                    char[] wordChars = currentWord.toCharArray();
                    
                    // 尝试改变每个位置的字母
                    for (int j = 0; j < wordChars.length; j++) {
                        char originalChar = wordChars[j];
                        
                        // 尝试替换为 a-z 的每个字母
                        for (char c = 'a'; c <= 'z'; c++) {
                            if (c == originalChar) {
                                continue;
                            }
                            
                            wordChars[j] = c;
                            String newWord = new String(wordChars);
                            
                            // 如果找到 endWord，返回当前层数 + 1
                            if (newWord.equals(endWord)) {
                                return level + 1;
                            }
                            
                            // 如果新单词在字典中且未被访问过，加入队列
                            if (wordSet.contains(newWord) && !visited.contains(newWord)) {
                                visited.add(newWord);
                                queue.offer(newWord);
                            }
                        }
                        
                        // 恢复原字符，准备改变下一个位置
                        wordChars[j] = originalChar;
                    }
                }
                
                // 当前层遍历完成，层数加 1
                level++;
            }
            
            // 未找到转换序列，返回 0
            return 0;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // 测试用例 1
        String beginWord1 = "hit";
        String endWord1 = "cog";
        List<String> wordList1 = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        System.out.println("测试用例 1:");
        System.out.println("beginWord = " + beginWord1);
        System.out.println("endWord = " + endWord1);
        System.out.println("wordList = " + wordList1);
        System.out.println("输出: " + solution.ladderLength(beginWord1, endWord1, wordList1));
        System.out.println();
        
        // 测试用例 2
        String beginWord2 = "hit";
        String endWord2 = "cog";
        List<String> wordList2 = Arrays.asList("hot", "dot", "dog", "lot", "log");
        System.out.println("测试用例 2:");
        System.out.println("beginWord = " + beginWord2);
        System.out.println("endWord = " + endWord2);
        System.out.println("wordList = " + wordList2);
        System.out.println("输出: " + solution.ladderLength(beginWord2, endWord2, wordList2));
    }
} 
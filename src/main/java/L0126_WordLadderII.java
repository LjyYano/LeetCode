import java.util.*;

/**
 * https://leetcode.cn/problems/word-ladder-ii/
 * 
 * 题目描述:
 * 按字典 wordList 完成从单词 beginWord 到单词 endWord 转化，一个表示此过程的 转换序列 是形式上像 beginWord -> s1 -> s2 -> ... -> sk 这样的单词序列，并满足：
 * - 每对相邻的单词之间仅有单个字母不同。
 * - 转换过程中的每个单词 si（1 <= i <= k）必须是字典 wordList 中的单词。注意，beginWord 不必是字典 wordList 中的单词。
 * - sk == endWord
 * 
 * 给你两个单词 beginWord 和 endWord ，以及一个字典 wordList 。请你找出并返回所有从 beginWord 到 endWord 的 最短转换序列 ，如果不存在这样的转换序列，返回一个空列表。
 * 每个序列都应该以单词列表 [beginWord, s1, s2, ..., sk] 的形式返回。
 * 
 * 示例 1：
 * 输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
 * 输出：[["hit","hot","dot","dog","cog"],["hit","hot","lot","log","cog"]]
 * 解释：存在 2 种最短的转换序列：
 * "hit" -> "hot" -> "dot" -> "dog" -> "cog"
 * "hit" -> "hot" -> "lot" -> "log" -> "cog"
 * 
 * 示例 2：
 * 输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
 * 输出：[]
 * 解释：endWord "cog" 不在字典 wordList 中，所以不存在符合要求的转换序列。
 * 
 * 提示：
 * - 1 <= beginWord.length <= 5
 * - endWord.length == beginWord.length
 * - 1 <= wordList.length <= 500
 * - wordList[i].length == beginWord.length
 * - beginWord、endWord 和 wordList[i] 由小写英文字母组成
 * - beginWord != endWord
 * - wordList 中的所有单词 互不相同
 * - 所有最短转换序列的总数不超过 10^5
 */
public class L0126_WordLadderII {
    static class Solution {
        public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
            List<List<String>> res = new ArrayList<>();
            // 如果endWord不在wordList中，直接返回空列表
            if (!wordList.contains(endWord)) {
                return res;
            }
            
            // 将wordList转换为HashSet，方便查找
            Set<String> dict = new HashSet<>(wordList);
            // 记录每个单词的前驱单词
            Map<String, Set<String>> from = new HashMap<>();
            // 记录每个单词到beginWord的距离
            Map<String, Integer> steps = new HashMap<>();
            
            // BFS找到所有最短路径
            bfs(beginWord, endWord, dict, from, steps);
            
            // DFS生成所有最短路径
            List<String> path = new ArrayList<>();
            path.add(endWord);
            dfs(beginWord, endWord, from, path, res);
            
            return res;
        }
        
        private void bfs(String beginWord, String endWord, Set<String> dict, 
                        Map<String, Set<String>> from, Map<String, Integer> steps) {
            Queue<String> queue = new LinkedList<>();
            queue.offer(beginWord);
            steps.put(beginWord, 0);
            
            boolean found = false;
            int step = 0;
            
            while (!queue.isEmpty() && !found) {
                step++;
                int size = queue.size();
                
                for (int i = 0; i < size; i++) {
                    String curr = queue.poll();
                    char[] currArray = curr.toCharArray();
                    
                    // 尝试改变每个位置的字符
                    for (int j = 0; j < currArray.length; j++) {
                        char original = currArray[j];
                        
                        for (char c = 'a'; c <= 'z'; c++) {
                            if (c == original) {
                                continue;
                            }
                            
                            currArray[j] = c;
                            String next = new String(currArray);
                            
                            if (steps.containsKey(next) && steps.get(next) == step) {
                                from.get(next).add(curr);
                            }
                            
                            if (!dict.contains(next)) {
                                continue;
                            }
                            
                            if (!steps.containsKey(next)) {
                                queue.offer(next);
                                steps.put(next, step);
                                from.put(next, new HashSet<>());
                                from.get(next).add(curr);
                                
                                if (next.equals(endWord)) {
                                    found = true;
                                }
                            }
                        }
                        currArray[j] = original;
                    }
                }
            }
        }
        
        private void dfs(String beginWord, String word, Map<String, Set<String>> from, 
                        List<String> path, List<List<String>> res) {
            if (word.equals(beginWord)) {
                List<String> temp = new ArrayList<>(path);
                Collections.reverse(temp);
                res.add(temp);
                return;
            }
            
            for (String parent : from.get(word)) {
                path.add(parent);
                dfs(beginWord, parent, from, path, res);
                path.remove(path.size() - 1);
            }
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
        List<List<String>> result1 = solution.findLadders(beginWord1, endWord1, wordList1);
        System.out.println("输出: " + result1);
        System.out.println();
        
        // 测试用例 2
        String beginWord2 = "hit";
        String endWord2 = "cog";
        List<String> wordList2 = Arrays.asList("hot", "dot", "dog", "lot", "log");
        System.out.println("测试用例 2:");
        System.out.println("beginWord = " + beginWord2);
        System.out.println("endWord = " + endWord2);
        System.out.println("wordList = " + wordList2);
        List<List<String>> result2 = solution.findLadders(beginWord2, endWord2, wordList2);
        System.out.println("输出: " + result2);
    }
} 
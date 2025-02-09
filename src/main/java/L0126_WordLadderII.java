import java.util.*;

/**
 * https://leetcode.cn/problems/word-ladder-ii/
 * 
 * 126. 单词接龙 II
 * 
 * 按字典 wordList 完成从单词 beginWord 到单词 endWord 转化，一个表示此过程的 转换序列 是形式上像 beginWord -> s1 -> s2 -> ... -> sk 这样的单词序列，并满足：
 * 
 * 每对相邻的单词之间仅有单个字母不同。
 * 转换过程中的每个单词 si（1 <= i <= k）必须是字典 wordList 中的单词。注意，beginWord 不必是字典 wordList 中的单词。
 * sk == endWord
 * 
 * 给你两个单词 beginWord 和 endWord ，以及一个字典 wordList 。请你找出并返回所有从 beginWord 到 endWord 的 最短转换序列 ，如果不存在这样的转换序列，返回一个空列表。每个序列都应该以单词列表 [beginWord, s1, s2, ..., sk] 的形式返回。
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
 * 1 <= beginWord.length <= 5
 * endWord.length == beginWord.length
 * 1 <= wordList.length <= 500
 * wordList[i].length == beginWord.length
 * beginWord、endWord 和 wordList[i] 由小写英文字母组成
 * beginWord != endWord
 * wordList 中的所有单词 互不相同
 */
class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        // 结果集
        List<List<String>> res = new ArrayList<>();
        // 字典集合
        Set<String> dict = new HashSet<>(wordList);
        // 如果字典中不包含目标单词，则无法转换
        if (!dict.contains(endWord)) {
            return res;
        }
        dict.remove(beginWord);
        
        // 第一步：使用 BFS 得到每个单词的层次
        Map<String, Integer> steps = new HashMap<>();
        steps.put(beginWord, 0);
        Map<String, Set<String>> from = new HashMap<>();
        boolean found = bfs(beginWord, endWord, dict, steps, from);
        
        if (found) {
            // 第二步：基于 BFS 结果，使用 DFS 构造路径
            Deque<String> path = new ArrayDeque<>();
            path.add(beginWord);
            dfs(beginWord, endWord, from, path, res);
        }
        
        return res;
    }
    
    private boolean bfs(String beginWord, String endWord, Set<String> dict, 
                       Map<String, Integer> steps, Map<String, Set<String>> from) {
        int wordLen = beginWord.length();
        int step = 0;
        boolean found = false;
        
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String currWord = queue.poll();
                char[] charArray = currWord.toCharArray();
                
                for (int j = 0; j < wordLen; j++) {
                    char origin = charArray[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        charArray[j] = c;
                        String nextWord = String.valueOf(charArray);
                        if (steps.containsKey(nextWord) && step == steps.get(nextWord)) {
                            from.get(nextWord).add(currWord);
                        }
                        
                        if (!dict.contains(nextWord)) {
                            continue;
                        }
                        
                        dict.remove(nextWord);
                        queue.offer(nextWord);
                        from.putIfAbsent(nextWord, new HashSet<>());
                        from.get(nextWord).add(currWord);
                        steps.put(nextWord, step);
                        
                        if (nextWord.equals(endWord)) {
                            found = true;
                        }
                    }
                    charArray[j] = origin;
                }
            }
            if (found) {
                break;
            }
        }
        return found;
    }
    
    private void dfs(String currWord, String endWord, Map<String, Set<String>> from,
                    Deque<String> path, List<List<String>> res) {
        if (currWord.equals(endWord)) {
            res.add(new ArrayList<>(path));
            return;
        }
        
        if (!from.containsKey(currWord)) {
            return;
        }
        
        for (String nextWord : from.get(currWord)) {
            path.addLast(nextWord);
            dfs(nextWord, endWord, from, path, res);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test case 1
        String beginWord1 = "hit";
        String endWord1 = "cog";
        List<String> wordList1 = Arrays.asList("hot","dot","dog","lot","log","cog");
        System.out.println("Test case 1:");
        System.out.println("Input: beginWord = \"" + beginWord1 + "\", endWord = \"" + endWord1 + "\", wordList = " + wordList1);
        List<List<String>> result1 = solution.findLadders(beginWord1, endWord1, wordList1);
        System.out.println("Output: " + result1);
        
        // Test case 2
        String beginWord2 = "hit";
        String endWord2 = "cog";
        List<String> wordList2 = Arrays.asList("hot","dot","dog","lot","log");
        System.out.println("\nTest case 2:");
        System.out.println("Input: beginWord = \"" + beginWord2 + "\", endWord = \"" + endWord2 + "\", wordList = " + wordList2);
        List<List<String>> result2 = solution.findLadders(beginWord2, endWord2, wordList2);
        System.out.println("Output: " + result2);
    }
} 
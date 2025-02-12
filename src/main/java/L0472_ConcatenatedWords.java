import java.util.*;

/**
 * https://leetcode.cn/problems/concatenated-words/
 * 
 * @author LjyYano
 * @date 2024/3/19
 */
public class L0472_ConcatenatedWords {

    class TrieNode {
        TrieNode[] children;
        boolean isEnd;

        public TrieNode() {
            children = new TrieNode[26];
            isEnd = false;
        }
    }

    TrieNode root;

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> result = new ArrayList<>();
        if (words == null || words.length == 0) {
            return result;
        }

        // 按长度排序，这样可以确保在检查一个单词时，所有可能组成它的较短单词都已经在字典树中
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        root = new TrieNode();

        for (String word : words) {
            if (word.length() == 0) {
                continue;
            }
            // 如果当前单词可以由字典树中的其他单词组成，则它是连接词
            if (canForm(word, 0)) {
                result.add(word);
            }
            // 将当前单词加入字典树
            addWord(word);
        }

        return result;
    }

    private boolean canForm(String word, int start) {
        if (start == word.length()) {
            return true;
        }
        TrieNode node = root;
        for (int i = start; i < word.length(); i++) {
            char c = word.charAt(i);
            node = node.children[c - 'a'];
            if (node == null) {
                return false;
            }
            // 如果找到一个单词的结尾，递归检查剩余部分
            if (node.isEnd && canForm(word, i + 1)) {
                return true;
            }
        }
        return false;
    }

    private void addWord(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
        }
        node.isEnd = true;
    }

    public static void main(String[] args) {
        L0472_ConcatenatedWords solution = new L0472_ConcatenatedWords();
        
        // 测试用例 1
        String[] words1 = {"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"};
        System.out.println(solution.findAllConcatenatedWordsInADict(words1));
        // 预期输出: ["catsdogcats","dogcatsdog","ratcatdogcat"]
        
        // 测试用例 2
        String[] words2 = {"cat","dog","catdog"};
        System.out.println(solution.findAllConcatenatedWordsInADict(words2));
        // 预期输出: ["catdog"]
    }
} 
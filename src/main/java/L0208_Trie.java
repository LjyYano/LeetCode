/**
 * https://leetcode.cn/problems/implement-trie-prefix-tree/
 * 
 * Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补完和拼写检查。
 * 
 * 请你实现 Trie 类：
 * - Trie() 初始化前缀树对象。
 * - void insert(String word) 向前缀树中插入字符串 word 。
 * - boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false 。
 * - boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否则，返回 false 。
 * 
 * 示例：
 * 输入
 * ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
 * [[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
 * 输出
 * [null, null, true, false, true, null, true]
 * 
 * 解释
 * Trie trie = new Trie();
 * trie.insert("apple");
 * trie.search("apple");   // 返回 True
 * trie.search("app");     // 返回 False
 * trie.startsWith("app"); // 返回 True
 * trie.insert("app");
 * trie.search("app");     // 返回 True
 * 
 * 提示：
 * - 1 <= word.length, prefix.length <= 2000
 * - word 和 prefix 仅由小写英文字母组成
 * - insert、search 和 startsWith 调用次数 总计 不超过 3 * 10⁴ 次
 */
public class L0208_Trie {
    
    // 定义 TrieNode 内部类
    private class TrieNode {
        private TrieNode[] children;
        private boolean isEnd;
        
        public TrieNode() {
            // 由于只包含小写字母，所以是 26 个字符
            children = new TrieNode[26];
            isEnd = false;
        }
    }
    
    private TrieNode root;
    
    /**
     * 初始化前缀树对象
     */
    public L0208_Trie() {
        root = new TrieNode();
    }
    
    /**
     * 向前缀树中插入字符串 word
     */
    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }
    
    /**
     * 如果字符串 word 在前缀树中，返回 true；否则，返回 false
     */
    public boolean search(String word) {
        TrieNode node = searchNode(word);
        return node != null && node.isEnd;
    }
    
    /**
     * 如果之前已经插入的字符串 word 的前缀之一为 prefix，返回 true；否则，返回 false
     */
    public boolean startsWith(String prefix) {
        return searchNode(prefix) != null;
    }
    
    /**
     * 查找字符串对应的节点
     */
    private TrieNode searchNode(String str) {
        TrieNode node = root;
        for (char c : str.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                return null;
            }
            node = node.children[index];
        }
        return node;
    }

    public static void main(String[] args) {
        L0208_Trie trie = new L0208_Trie();
        
        // 测试用例 1
        System.out.println("测试用例 1：");
        trie.insert("apple");
        System.out.println("插入 \"apple\"");
        System.out.println("搜索 \"apple\": " + trie.search("apple"));   // 返回 True
        System.out.println("搜索 \"app\": " + trie.search("app"));     // 返回 False
        System.out.println("前缀搜索 \"app\": " + trie.startsWith("app")); // 返回 True
        trie.insert("app");
        System.out.println("插入 \"app\"");
        System.out.println("搜索 \"app\": " + trie.search("app"));     // 返回 True
        
        // 测试用例 2
        System.out.println("\n测试用例 2：");
        L0208_Trie trie2 = new L0208_Trie();
        trie2.insert("hello");
        System.out.println("插入 \"hello\"");
        System.out.println("搜索 \"hell\": " + trie2.search("hell"));   // 返回 False
        System.out.println("前缀搜索 \"hell\": " + trie2.startsWith("hell")); // 返回 True
    }
} 
/**
 * https://leetcode.cn/problems/design-add-and-search-words-data-structure/
 * 
 * 请你设计一个数据结构，支持 添加新单词 和 查找字符串是否与任何先前添加的字符串匹配 。
 * 
 * 实现词典类 WordDictionary ：
 * - WordDictionary() 初始化词典对象
 * - void addWord(word) 将 word 添加到数据结构中，之后可以对它进行匹配
 * - boolean search(word) 如果数据结构中存在字符串与 word 匹配，则返回 true ；否则，返回 false 。
 *   word 中可能包含一些 '.' ，每个 . 都可以表示任何一个字母。
 * 
 * 示例：
 * 输入：
 * ["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
 * [[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
 * 输出：
 * [null,null,null,null,false,true,true,true]
 * 
 * 解释：
 * WordDictionary wordDictionary = new WordDictionary();
 * wordDictionary.addWord("bad");
 * wordDictionary.addWord("dad");
 * wordDictionary.addWord("mad");
 * wordDictionary.search("pad"); // 返回 False
 * wordDictionary.search("bad"); // 返回 True
 * wordDictionary.search(".ad"); // 返回 True
 * wordDictionary.search("b.."); // 返回 True
 * 
 * 提示：
 * - 1 <= word.length <= 25
 * - addWord 中的 word 由小写英文字母组成
 * - search 中的 word 由 '.' 或小写英文字母组成
 * - 最多调用 10⁴ 次 addWord 和 search
 */
public class L0211_WordDictionary {
    
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
     * 初始化词典对象
     */
    public L0211_WordDictionary() {
        root = new TrieNode();
    }
    
    /**
     * 将 word 添加到数据结构中
     */
    public void addWord(String word) {
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
     * 如果数据结构中存在字符串与 word 匹配，则返回 true
     */
    public boolean search(String word) {
        return searchHelper(word, 0, root);
    }
    
    /**
     * 递归辅助函数，用于处理通配符搜索
     */
    private boolean searchHelper(String word, int index, TrieNode node) {
        // 如果已经到达单词末尾，检查当前节点是否是单词结尾
        if (index == word.length()) {
            return node.isEnd;
        }
        
        char c = word.charAt(index);
        if (c == '.') {
            // 如果是通配符，尝试所有可能的字符
            for (TrieNode child : node.children) {
                if (child != null && searchHelper(word, index + 1, child)) {
                    return true;
                }
            }
            return false;
        } else {
            // 如果是普通字符，按正常路径搜索
            int childIndex = c - 'a';
            TrieNode child = node.children[childIndex];
            return child != null && searchHelper(word, index + 1, child);
        }
    }

    public static void main(String[] args) {
        L0211_WordDictionary wordDictionary = new L0211_WordDictionary();
        
        // 测试用例 1
        System.out.println("测试用例 1：");
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        System.out.println("搜索 \"pad\": " + wordDictionary.search("pad"));  // 返回 false
        System.out.println("搜索 \"bad\": " + wordDictionary.search("bad"));  // 返回 true
        System.out.println("搜索 \".ad\": " + wordDictionary.search(".ad"));  // 返回 true
        System.out.println("搜索 \"b..\": " + wordDictionary.search("b.."));  // 返回 true
        
        // 测试用例 2
        System.out.println("\n测试用例 2：");
        L0211_WordDictionary wordDictionary2 = new L0211_WordDictionary();
        wordDictionary2.addWord("hello");
        System.out.println("搜索 \"hello\": " + wordDictionary2.search("hello"));  // 返回 true
        System.out.println("搜索 \"hell\": " + wordDictionary2.search("hell"));    // 返回 false
        System.out.println("搜索 \"h.ll.\": " + wordDictionary2.search("h.ll."));  // 返回 true
    }
} 
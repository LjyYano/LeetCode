import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/word-search-ii/
 * 
 * 给定一个 m x n 二维字符网格 board 和一个单词列表 words，找出所有同时在二维网格和单词列表中出现的单词。
 * 
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中"相邻"单元格是那些水平相邻或垂直相邻的单元格。
 * 同一个单元格内的字母在一个单词中不允许被重复使用。
 * 
 * 示例 1：
 * 输入：board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], 
 * words = ["oath","pea","eat","rain"]
 * 输出：["eat","oath"]
 * 
 * 示例 2：
 * 输入：board = [["a","b"],["c","d"]], words = ["abcb"]
 * 输出：[]
 * 
 * 提示：
 * - m == board.length
 * - n == board[i].length
 * - 1 <= m, n <= 12
 * - board[i][j] 是一个小写英文字母
 * - 1 <= words.length <= 3 * 10^4
 * - 1 <= words[i].length <= 10
 * - words[i] 由小写英文字母组成
 * - words 中的所有字符串互不相同
 */
public class L0212_WordSearchII {
    
    // 定义 TrieNode 内部类
    private class TrieNode {
        private TrieNode[] children;
        private String word;
        
        public TrieNode() {
            children = new TrieNode[26];
            word = null;
        }
    }
    
    // 定义四个方向：上、右、下、左
    private static final int[][] DIRECTIONS = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        if (board == null || board.length == 0 || words == null || words.length == 0) {
            return result;
        }
        
        // 构建 Trie 树
        TrieNode root = buildTrie(words);
        
        // 从每个格子开始搜索
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, i, j, root, result);
            }
        }
        
        return result;
    }
    
    // 构建 Trie 树
    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (node.children[index] == null) {
                    node.children[index] = new TrieNode();
                }
                node = node.children[index];
            }
            node.word = word;
        }
        return root;
    }
    
    // DFS 搜索
    private void dfs(char[][] board, int row, int col, TrieNode node, List<String> result) {
        // 检查当前位置是否有效
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || 
            board[row][col] == '#' || node.children[board[row][col] - 'a'] == null) {
            return;
        }
        
        char c = board[row][col];
        node = node.children[c - 'a'];
        
        // 如果找到一个单词，加入结果集
        if (node.word != null) {
            result.add(node.word);
            node.word = null;  // 防止重复添加
        }
        
        // 标记当前格子为已访问
        board[row][col] = '#';
        
        // 向四个方向搜索
        for (int[] dir : DIRECTIONS) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            dfs(board, newRow, newCol, node, result);
        }
        
        // 恢复当前格子
        board[row][col] = c;
    }

    public static void main(String[] args) {
        L0212_WordSearchII solution = new L0212_WordSearchII();
        
        // 测试用例 1
        char[][] board1 = {
            {'o','a','a','n'},
            {'e','t','a','e'},
            {'i','h','k','r'},
            {'i','f','l','v'}
        };
        String[] words1 = {"oath","pea","eat","rain"};
        System.out.println("测试用例 1：");
        System.out.println("输入：board = [['o','a','a','n'],['e','t','a','e'],['i','h','k','r'],['i','f','l','v']]");
        System.out.println("words = [\"oath\",\"pea\",\"eat\",\"rain\"]");
        System.out.println("输出：" + solution.findWords(board1, words1));
        System.out.println();
        
        // 测试用例 2
        char[][] board2 = {
            {'a','b'},
            {'c','d'}
        };
        String[] words2 = {"abcb"};
        System.out.println("测试用例 2：");
        System.out.println("输入：board = [['a','b'],['c','d']]");
        System.out.println("words = [\"abcb\"]");
        System.out.println("输出：" + solution.findWords(board2, words2));
    }
} 
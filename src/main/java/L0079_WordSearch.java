/**
 * https://leetcode.cn/problems/word-search/
 * 
 * 79. 单词搜索
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * 
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中"相邻"单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * 
 * 示例 1：
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 * 
 * 示例 2：
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
 * 输出：true
 * 
 * 示例 3：
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
 * 输出：false
 * 
 * 提示：
 * m == board.length
 * n = board[i].length
 * 1 <= m, n <= 6
 * 1 <= word.length <= 15
 * board 和 word 仅由大小写英文字母组成
 */
public class L0079_WordSearch {

    // 定义四个方向：上、右、下、左
    private static final int[][] DIRECTIONS = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0 || word == null || word.isEmpty()) {
            return false;
        }

        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        // 从每个格子开始尝试
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (backtrack(board, word, 0, i, j, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, String word, int index, int row, int col, boolean[][] visited) {
        // 如果已经找到了所有字符，返回true
        if (index == word.length()) {
            return true;
        }

        // 检查当前位置是否越界或已访问或字符不匹配
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || 
            visited[row][col] || board[row][col] != word.charAt(index)) {
            return false;
        }

        // 标记当前格子为已访问
        visited[row][col] = true;

        // 向四个方向探索
        for (int[] dir : DIRECTIONS) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            if (backtrack(board, word, index + 1, newRow, newCol, visited)) {
                return true;
            }
        }

        // 回溯，将当前格子标记为未访问
        visited[row][col] = false;
        return false;
    }

    public static void main(String[] args) {
        L0079_WordSearch solution = new L0079_WordSearch();

        // 测试用例1
        char[][] board1 = {
            {'A', 'B', 'C', 'E'},
            {'S', 'F', 'C', 'S'},
            {'A', 'D', 'E', 'E'}
        };
        String word1 = "ABCCED";
        System.out.println("Test case 1: Input board = " + arrayToString(board1) + ", word = \"" + word1 + "\"");
        System.out.println("Output: " + solution.exist(board1, word1));  // 应该输出 true

        // 测试用例2
        String word2 = "SEE";
        System.out.println("\nTest case 2: Input board = " + arrayToString(board1) + ", word = \"" + word2 + "\"");
        System.out.println("Output: " + solution.exist(board1, word2));  // 应该输出 true

        // 测试用例3
        String word3 = "ABCB";
        System.out.println("\nTest case 3: Input board = " + arrayToString(board1) + ", word = \"" + word3 + "\"");
        System.out.println("Output: " + solution.exist(board1, word3));  // 应该输出 false
    }

    // 辅助方法：将二维字符数组转换为字符串
    private static String arrayToString(char[][] board) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < board.length; i++) {
            sb.append("[");
            for (int j = 0; j < board[i].length; j++) {
                sb.append("\"").append(board[i][j]).append("\"");
                if (j < board[i].length - 1) {
                    sb.append(",");
                }
            }
            sb.append("]");
            if (i < board.length - 1) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }
} 
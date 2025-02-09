/**
 * https://leetcode.cn/problems/surrounded-regions/
 * 
 * 题目描述:
 * 给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' （字母 O）组成，找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 * 
 * 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。
 * 如果两个元素在水平或垂直方向相邻，则称它们是"相连"的。
 * 
 * 示例 1：
 * 输入：board = [["X","X","X","X"],["X","O","O","X"],["X","O","O","X"],["X","O","X","X"]]
 * 输出：[["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
 * 解释：被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。
 * 如果两个元素在水平或垂直方向相邻，则称它们是"相连"的。
 * 
 * 示例 2：
 * 输入：board = [["X"]]
 * 输出：[["X"]]
 * 
 * 提示：
 * - m == board.length
 * - n == board[i].length
 * - 1 <= m, n <= 200
 * - board[i][j] 为 'X' 或 'O'
 */
public class L0130_SurroundedRegions {
    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        
        int m = board.length;
        int n = board[0].length;
        
        // 从边界开始 DFS，将所有与边界相连的 'O' 标记为 '#'
        // 遍历第一行和最后一行
        for (int j = 0; j < n; j++) {
            dfs(board, 0, j);
            dfs(board, m - 1, j);
        }
        
        // 遍历第一列和最后一列
        for (int i = 0; i < m; i++) {
            dfs(board, i, 0);
            dfs(board, i, n - 1);
        }
        
        // 遍历整个矩阵
        // 将所有 'O' 变为 'X'（这些 'O' 是被围绕的）
        // 将所有 '#' 变回 'O'（这些是与边界相连的）
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }
    
    // DFS 遍历与当前 'O' 相连的所有 'O'，并标记为 '#'
    private void dfs(char[][] board, int i, int j) {
        // 检查边界条件和当前位置是否为 'O'
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'O') {
            return;
        }
        
        // 标记当前位置
        board[i][j] = '#';
        
        // 递归遍历四个方向
        dfs(board, i - 1, j); // 上
        dfs(board, i + 1, j); // 下
        dfs(board, i, j - 1); // 左
        dfs(board, i, j + 1); // 右
    }

    public static void main(String[] args) {
        L0130_SurroundedRegions solution = new L0130_SurroundedRegions();
        
        // 测试用例 1
        char[][] board1 = {
            {'X', 'X', 'X', 'X'},
            {'X', 'O', 'O', 'X'},
            {'X', 'O', 'O', 'X'},
            {'X', 'O', 'X', 'X'}
        };
        System.out.println("测试用例 1:");
        System.out.println("输入:");
        printBoard(board1);
        solution.solve(board1);
        System.out.println("输出:");
        printBoard(board1);
        System.out.println();
        
        // 测试用例 2
        char[][] board2 = {{'X'}};
        System.out.println("测试用例 2:");
        System.out.println("输入:");
        printBoard(board2);
        solution.solve(board2);
        System.out.println("输出:");
        printBoard(board2);
    }
    
    // 打印矩阵的辅助方法
    private static void printBoard(char[][] board) {
        for (char[] row : board) {
            System.out.println(java.util.Arrays.toString(row));
        }
    }
} 
import java.util.*;

/**
 * https://leetcode.cn/problems/battleships-in-a-board/description/
 * 
 * 给你一个大小为 m x n 的矩阵 board 表示甲板，其中，每个单元格可以是一艘战舰 'X' 或者是一个空位 '.' ，返回在甲板 board 上放置的 战舰 的数量。
 * 战舰 只能水平或者垂直放置在 board 上。换句话说，战舰只能按 1 x k（1 行，k 列）或 k x 1（k 行，1 列）的形状建造，其中 k 可以是任意大小。
 * 两艘战舰之间至少有一个水平或垂直的空位分隔 （即没有相邻的战舰）。
 * 
 * 示例 1：
 * 输入：board = [["X",".",".","X"],[".",".",".","X"],[".",".",".","X"]]
 * 输出：2
 * 
 * 示例 2：
 * 输入：board = [["."]]
 * 输出：0
 */
public class L0419_BattleshipsInABoard {

    public int countBattleships(char[][] board) {
        if (board == null || board.length == 0) {
            return 0;
        }
        
        int count = 0;
        int m = board.length;
        int n = board[0].length;
        
        // 只需要统计每个战舰的左上角位置
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 如果当前位置是 'X'，且其上方和左方都不是 'X'，说明是战舰的左上角
                if (board[i][j] == 'X' &&
                    (i == 0 || board[i-1][j] != 'X') &&
                    (j == 0 || board[i][j-1] != 'X')) {
                    count++;
                }
            }
        }
        
        return count;
    }

    public static void main(String[] args) {
        L0419_BattleshipsInABoard solution = new L0419_BattleshipsInABoard();
        
        // 测试用例1
        char[][] board1 = {
            {'X','.','.','X'},
            {'.','.','.','X'},
            {'.','.','.','X'}
        };
        System.out.println("测试用例1：");
        System.out.println("输入：board = " + Arrays.deepToString(board1));
        System.out.println("输出：" + solution.countBattleships(board1));
        
        // 测试用例2
        char[][] board2 = {
            {'.'}
        };
        System.out.println("\n测试用例2：");
        System.out.println("输入：board = " + Arrays.deepToString(board2));
        System.out.println("输出：" + solution.countBattleships(board2));
    }
} 
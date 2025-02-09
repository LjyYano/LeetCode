import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.cn/problems/n-queens/
 * 
 * 按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
 * 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 * 
 * 示例 1：
 * 输入：n = 4
 * 输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 * 解释：如上图所示，4 皇后问题存在两个不同的解法。
 * 
 * 示例 2：
 * 输入：n = 1
 * 输出：[["Q"]]
 * 
 * 提示：
 * 1 <= n <= 9
 */
public class L0051_NQueens {

    // 用于存储结果
    private List<List<String>> result;
    // 记录列是否被占用
    private boolean[] cols;
    // 记录主对角线（左上到右下）是否被占用
    private boolean[] mainDiag;
    // 记录副对角线（右上到左下）是否被占用
    private boolean[] subDiag;
    // 记录当前棋盘状态
    private char[][] board;

    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        cols = new boolean[n];
        // 主对角线的数量为 2n-1，从左上到右下，可以用 row+col 表示
        mainDiag = new boolean[2 * n - 1];
        // 副对角线的数量也是 2n-1，从右上到左下，可以用 row-col+n-1 表示
        subDiag = new boolean[2 * n - 1];
        board = new char[n][n];

        // 初始化棋盘
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        // 从第一行开始回溯
        backtrack(0, n);
        return result;
    }

    // 回溯函数，row 表示当前处理的行
    private void backtrack(int row, int n) {
        // 如果已经处理完所有行，说明找到了一个解
        if (row == n) {
            List<String> solution = new ArrayList<>();
            for (char[] chars : board) {
                solution.add(new String(chars));
            }
            result.add(solution);
            return;
        }

        // 尝试在当前行的每一列放置皇后
        for (int col = 0; col < n; col++) {
            // 计算当前位置对应的主对角线和副对角线的索引
            int mainDiagIndex = row + col;
            int subDiagIndex = row - col + n - 1;

            // 如果当前位置可以放置皇后
            if (!cols[col] && !mainDiag[mainDiagIndex] && !subDiag[subDiagIndex]) {
                // 放置皇后
                board[row][col] = 'Q';
                cols[col] = true;
                mainDiag[mainDiagIndex] = true;
                subDiag[subDiagIndex] = true;

                // 继续处理下一行
                backtrack(row + 1, n);

                // 回溯，撤销当前位置的皇后
                board[row][col] = '.';
                cols[col] = false;
                mainDiag[mainDiagIndex] = false;
                subDiag[subDiagIndex] = false;
            }
        }
    }

    public static void main(String[] args) {
        L0051_NQueens solution = new L0051_NQueens();

        // 测试用例 1
        System.out.println("测试用例 1：");
        System.out.println("输入：n = 4");
        List<List<String>> result1 = solution.solveNQueens(4);
        System.out.println("输出：" + result1);
        System.out.println("预期：[[.Q.., ...Q, Q..., ..Q.], [..Q., Q..., ...Q, .Q..]]");
        System.out.println();

        // 测试用例 2
        System.out.println("测试用例 2：");
        System.out.println("输入：n = 1");
        List<List<String>> result2 = solution.solveNQueens(1);
        System.out.println("输出：" + result2);
        System.out.println("预期：[[Q]]");
    }
} 
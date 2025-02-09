/**
 * https://leetcode.cn/problems/n-queens-ii/
 * 
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n × n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 给你一个整数 n ，返回 n 皇后问题 不同的解决方案的数量。
 * 
 * 示例 1：
 * 输入：n = 4
 * 输出：2
 * 解释：如上图所示，4 皇后问题存在两个不同的解法。
 * 
 * 示例 2：
 * 输入：n = 1
 * 输出：1
 * 
 * 提示：
 * 1 <= n <= 9
 */
public class L0052_NQueensII {
    
    private int count;
    
    public int totalNQueens(int n) {
        // 重置计数器
        count = 0;
        // 使用一维数组表示每行皇后的列位置
        int[] queens = new int[n];
        // 从第一行开始放置皇后
        backtrack(queens, 0, n);
        return count;
    }
    
    /**
     * 回溯放置皇后
     * @param queens 每行皇后的列位置
     * @param row 当前要放置皇后的行
     * @param n 棋盘大小
     */
    private void backtrack(int[] queens, int row, int n) {
        // 如果已经放置了 n 个皇后，说明找到了一个解
        if (row == n) {
            count++;
            return;
        }
        
        // 尝试在当前行的每一列放置皇后
        for (int col = 0; col < n; col++) {
            // 检查当前位置是否可以放置皇后
            if (isValid(queens, row, col)) {
                // 在当前位置放置皇后
                queens[row] = col;
                // 继续放置下一行的皇后
                backtrack(queens, row + 1, n);
                // 回溯，移除当前位置的皇后（实际上不需要显式移除，因为会被覆盖）
            }
        }
    }
    
    /**
     * 检查在指定位置放置皇后是否有效
     * @param queens 每行皇后的列位置
     * @param row 要检查的行
     * @param col 要检查的列
     * @return 是否可以放置皇后
     */
    private boolean isValid(int[] queens, int row, int col) {
        // 检查之前的每一行
        for (int i = 0; i < row; i++) {
            // 检查同列
            if (queens[i] == col) {
                return false;
            }
            // 检查对角线
            if (Math.abs(row - i) == Math.abs(col - queens[i])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        L0052_NQueensII solution = new L0052_NQueensII();
        
        // 测试用例 1
        System.out.println("n = 4 时的解法数量：" + solution.totalNQueens(4));  // 预期输出：2
        
        // 测试用例 2
        System.out.println("n = 1 时的解法数量：" + solution.totalNQueens(1));  // 预期输出：1
        
        // 测试用例 3
        System.out.println("n = 8 时的解法数量：" + solution.totalNQueens(8));  // 预期输出：92
    }
} 
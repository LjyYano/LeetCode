
// https://leetcode-cn.com/problems/n-queens-ii/
class L0052_N_Queens_II {
    int count = 0;

    public int totalNQueens(int n) {
        if (n <= 0) return 0;
        int[][] table = new int[n][n];
        queenDfs(0, n, table);
        return count;
    }

    private void queenDfs(int row, int n, int[][] table) {
        if (row == n) {
            count++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (isQueenValid(row, i, table)) {
                table[row][i] = 1;
                queenDfs(row + 1, n, table);
                table[row][i] = 0;
            }
        }
    }

    private boolean isQueenValid(int row, int col, int[][] table) {
        // 横
        for (int i = 0; i < table.length; i++) {
            if (i == row) {
                continue;
            }
            if (table[i][col] == 1) {
                return false;
            }
        }

        // 竖
        for (int i = 0; i < table.length; i++) {
            if (i == col) {
                continue;
            }
            if (table[row][i] == 1) {
                return false;
            }
        }

        // 对角线
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                if (i == row && j == col) {
                    continue;
                }
                if (Math.abs(row - i) == Math.abs(col - j) && table[i][j] == 1) {
                    return false;
                }
            }
        }

        return true;
    }
}
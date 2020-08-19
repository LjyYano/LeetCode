
// https://leetcode-cn.com/problems/rotting-oranges/
class L1036_Rotting_Oranges {
    private static final int GRID_EMPTY = 0;
    private static final int GRID_FRESH = 1;
    private static final int GRID_ROTTEN = 2;
    private static final int GRID_TMP = 3;

    public int orangesRotting(int[][] grid) {
        int step = 0;
        while (!orangesAllRotten(grid)) {
            if (!orangesChange(grid)) {
                return -1;
            }
            step++;
        }

        return step;
    }

    private boolean orangesChange(int[][] grid) {
        boolean changed = false;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == GRID_ROTTEN) {
                    // 找上下左右相邻的位置
                    if (i > 0 && grid[i - 1][j] == GRID_FRESH) {
                        grid[i - 1][j] = GRID_TMP;
                        changed = true;
                    }
                    if (j > 0 && grid[i][j - 1] == GRID_FRESH) {
                        grid[i][j - 1] = GRID_TMP;
                        changed = true;
                    }
                    if (i < grid.length - 1 && grid[i + 1][j] == GRID_FRESH) {
                        grid[i + 1][j] = GRID_TMP;
                        changed = true;
                    }
                    if (j < grid[0].length - 1 && grid[i][j + 1] == GRID_FRESH) {
                        grid[i][j + 1] = GRID_TMP;
                        changed = true;
                    }
                }
            }
        }
        if (changed) {
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == GRID_TMP) {
                        grid[i][j] = GRID_ROTTEN;
                    }
                }
            }
        }
        return changed;
    }

    private boolean orangesAllRotten(int[][] grid) {
        for (int[] row : grid) {
            for (int n : row) {
                if (n == GRID_FRESH) {
                    return false;
                }
            }
        }
        return true;
    }
}

// https://leetcode-cn.com/problems/unique-paths-iii/
class L1022_Unique_Paths_III {
    private static final int EMPTY = 0;
    private static final int START = 1;
    private static final int END = 2;
    private static final int WALKED = 3;
    private static final int OBSTACLE = -1;

    public int uniquePathsIII(int[][] grid) {
        int[] ans = new int[1];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == START) {
                    pathIIIDfs(grid, i, j, ans);
                    break;
                }
            }
        }
        return ans[0];
    }

    private void pathIIIDfs(int[][] grid, int row, int col, int[] ans) {
        // 上下左右
        if (grid[row][col] == END) {
            if (walkAll(grid)) {
                ans[0]++;
            }
            return;
        }

        // 障碍 || 已走过
        if (grid[row][col] == OBSTACLE || grid[row][col] == WALKED) {
            return;
        }

        // 标记自身为走过
        grid[row][col] = WALKED;
        if (row + 1 < grid.length) {
            pathIIIDfs(grid, row + 1, col, ans);
        }
        if (row - 1 >= 0) {
            pathIIIDfs(grid, row - 1, col, ans);
        }
        if (col + 1 < grid[0].length) {
            pathIIIDfs(grid, row, col + 1, ans);
        }
        if (col - 1 >= 0) {
            pathIIIDfs(grid, row, col - 1, ans);
        }
        grid[row][col] = EMPTY;
    }

    private boolean walkAll(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }
}
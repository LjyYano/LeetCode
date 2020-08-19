
// https://leetcode-cn.com/problems/unique-paths-ii/
class L0063_Unique_Paths_II {
    public int uniquePathsWithObstacles(int[][] grid) {
        if(grid == null || grid.length == 0 ) return 0;
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        
        // 初始化行
        for(int i = 0; i < n; i++) {
            if(grid[0][i] == 1) break;
            dp[0][i] = 1;
        }
        
        // 初始化列
        for(int i = 0; i < m; i++) {
            if(grid[i][0] == 1) break;
            dp[i][0] = 1;
        }
        
        if (dp[0][0] == 0) return 0;
        
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                if(grid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        
        return dp[m - 1][n - 1];
    }
}
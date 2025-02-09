/*
 * https://leetcode.cn/problems/minimum-path-sum/
 * 
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 
 * 说明：每次只能向下或者向右移动一步。
 * 
 * 示例 1：
 * ![img](https://assets.leetcode.com/uploads/2020/11/05/minpath.jpg)
 * 输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
 * 输出：7
 * 解释：因为路径 1→3→1→1→1 的总和最小。
 * 
 * 示例 2：
 * 输入：grid = [[1,2,3],[4,5,6]]
 * 输出：12
 * 
 * 提示：
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 200
 * 0 <= grid[i][j] <= 100
 */

public class L0064_MinimumPathSum {

    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;
        
        // 创建动态规划数组，dp[i][j] 表示到达位置 (i,j) 的最小路径和
        int[][] dp = new int[m][n];
        
        // 初始化起点
        dp[0][0] = grid[0][0];
        
        // 初始化第一行
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        
        // 初始化第一列
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        
        // 动态规划计算每个位置的最小路径和
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        
        // 返回到达右下角的最小路径和
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        L0064_MinimumPathSum solution = new L0064_MinimumPathSum();

        // 测试用例 1
        int[][] grid1 = {
            {1, 3, 1},
            {1, 5, 1},
            {4, 2, 1}
        };
        System.out.println("测试用例 1：");
        System.out.println("输入：grid = [[1,3,1],[1,5,1],[4,2,1]]");
        System.out.println("输出：" + solution.minPathSum(grid1));
        System.out.println("预期：7");
        System.out.println();

        // 测试用例 2
        int[][] grid2 = {
            {1, 2, 3},
            {4, 5, 6}
        };
        System.out.println("测试用例 2：");
        System.out.println("输入：grid = [[1,2,3],[4,5,6]]");
        System.out.println("输出：" + solution.minPathSum(grid2));
        System.out.println("预期：12");
    }
} 
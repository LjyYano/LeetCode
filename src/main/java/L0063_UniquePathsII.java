/*
 * https://leetcode.cn/problems/unique-paths-ii/
 * 
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 "Start" ）。
 * 
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 "Finish"）。
 * 
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * 
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 * 
 * ![img](https://assets.leetcode.com/uploads/2020/11/04/robot1.jpg)
 * 
 * 示例 1：
 * 输入：obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
 * 输出：2
 * 解释：3x3 网格的正中间有一个障碍物。
 * 从左上角到右下角一共有 2 条不同的路径：
 * 1. 向右 -> 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右 -> 向右
 * 
 * ![img](https://assets.leetcode.com/uploads/2020/11/04/robot2.jpg)
 * 
 * 示例 2：
 * 输入：obstacleGrid = [[0,1],[0,0]]
 * 输出：1
 * 
 * 提示：
 * m == obstacleGrid.length
 * n == obstacleGrid[i].length
 * 1 <= m, n <= 100
 * obstacleGrid[i][j] 为 0 或 1
 */

public class L0063_UniquePathsII {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0) {
            return 0;
        }

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        // 如果起点或终点有障碍物，直接返回 0
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) {
            return 0;
        }

        // 创建动态规划数组，dp[i][j] 表示到达位置 (i,j) 的不同路径数
        long[][] dp = new long[m][n];
        
        // 初始化起点
        dp[0][0] = 1;

        // 初始化第一列
        for (int i = 1; i < m; i++) {
            dp[i][0] = obstacleGrid[i][0] == 1 ? 0 : dp[i - 1][0];
        }

        // 初始化第一行
        for (int j = 1; j < n; j++) {
            dp[0][j] = obstacleGrid[0][j] == 1 ? 0 : dp[0][j - 1];
        }

        // 动态规划计算每个位置的路径数
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }

        return (int) dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        L0063_UniquePathsII solution = new L0063_UniquePathsII();

        // 测试用例 1
        int[][] grid1 = {
            {0, 0, 0},
            {0, 1, 0},
            {0, 0, 0}
        };
        System.out.println("测试用例 1：");
        System.out.println("输入：[[0,0,0],[0,1,0],[0,0,0]]");
        System.out.println("输出：" + solution.uniquePathsWithObstacles(grid1));
        System.out.println("预期：2");
        System.out.println();

        // 测试用例 2
        int[][] grid2 = {
            {0, 1},
            {0, 0}
        };
        System.out.println("测试用例 2：");
        System.out.println("输入：[[0,1],[0,0]]");
        System.out.println("输出：" + solution.uniquePathsWithObstacles(grid2));
        System.out.println("预期：1");
    }
} 
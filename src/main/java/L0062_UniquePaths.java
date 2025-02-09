/*
 * https://leetcode.cn/problems/unique-paths/
 * 
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 "Start" ）。
 * 
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 "Finish" ）。
 * 
 * 问总共有多少条不同的路径？
 * 
 * ![img](https://assets.leetcode.com/uploads/2018/10/22/robot_maze.png)
 * 
 * 示例 1：
 * 输入：m = 3, n = 7
 * 输出：28
 * 
 * 示例 2：
 * 输入：m = 3, n = 2
 * 输出：3
 * 解释：
 * 从左上角开始，总共有 3 条路径可以到达右下角：
 * 1. 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向下
 * 
 * 示例 3：
 * 输入：m = 7, n = 3
 * 输出：28
 * 
 * 示例 4：
 * 输入：m = 3, n = 3
 * 输出：6
 * 
 * 提示：
 * 1 <= m, n <= 100
 * 题目数据保证答案小于等于 2 * 10⁹
 */

public class L0062_UniquePaths {

    public int uniquePaths(int m, int n) {
        // 创建动态规划数组，dp[i][j] 表示到达位置 (i,j) 的不同路径数
        int[][] dp = new int[m][n];

        // 初始化第一行和第一列
        // 因为只能向右或向下移动，所以第一行和第一列的路径数都是 1
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }

        // 动态规划计算每个位置的路径数
        // 到达位置 (i,j) 的路径数等于到达其上方位置的路径数加上到达其左方位置的路径数
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        // 返回到达右下角位置的路径数
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        L0062_UniquePaths solution = new L0062_UniquePaths();

        // 测试用例 1
        System.out.println("测试用例 1：");
        System.out.println("输入：m = 3, n = 7");
        System.out.println("输出：" + solution.uniquePaths(3, 7));
        System.out.println("预期：28");
        System.out.println();

        // 测试用例 2
        System.out.println("测试用例 2：");
        System.out.println("输入：m = 3, n = 2");
        System.out.println("输出：" + solution.uniquePaths(3, 2));
        System.out.println("预期：3");
        System.out.println();

        // 测试用例 3
        System.out.println("测试用例 3：");
        System.out.println("输入：m = 7, n = 3");
        System.out.println("输出：" + solution.uniquePaths(7, 3));
        System.out.println("预期：28");
        System.out.println();

        // 测试用例 4
        System.out.println("测试用例 4：");
        System.out.println("输入：m = 3, n = 3");
        System.out.println("输出：" + solution.uniquePaths(3, 3));
        System.out.println("预期：6");
    }
} 
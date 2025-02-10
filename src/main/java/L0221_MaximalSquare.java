/**
 * https://leetcode.cn/problems/maximal-square/
 * 
 * 在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
 * 
 * 示例 1：
 * ![img](https://assets.leetcode.com/uploads/2020/11/26/max1grid.jpg)
 * 输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
 * 输出：4
 * 
 * 示例 2：
 * ![img](https://assets.leetcode.com/uploads/2020/11/26/max2grid.jpg)
 * 输入：matrix = [["0","1"],["1","0"]]
 * 输出：1
 * 
 * 示例 3：
 * 输入：matrix = [["0"]]
 * 输出：0
 * 
 * 提示：
 * - m == matrix.length
 * - n == matrix[i].length
 * - 1 <= m, n <= 300
 * - matrix[i][j] 为 '0' 或 '1'
 */
public class L0221_MaximalSquare {
    
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        // dp[i][j] 表示以 (i,j) 为右下角的最大正方形边长
        int[][] dp = new int[m][n];
        int maxSide = 0;
        
        // 初始化第一行和第一列
        for (int i = 0; i < m; i++) {
            dp[i][0] = matrix[i][0] == '1' ? 1 : 0;
            maxSide = Math.max(maxSide, dp[i][0]);
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = matrix[0][j] == '1' ? 1 : 0;
            maxSide = Math.max(maxSide, dp[0][j]);
        }
        
        // 动态规划计算最大正方形边长
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }
        
        return maxSide * maxSide;
    }

    public static void main(String[] args) {
        L0221_MaximalSquare solution = new L0221_MaximalSquare();
        
        // 测试用例 1
        char[][] matrix1 = {
            {'1', '0', '1', '0', '0'},
            {'1', '0', '1', '1', '1'},
            {'1', '1', '1', '1', '1'},
            {'1', '0', '0', '1', '0'}
        };
        System.out.println("测试用例 1：");
        System.out.println("输入：matrix = [['1','0','1','0','0'],['1','0','1','1','1'],['1','1','1','1','1'],['1','0','0','1','0']]");
        System.out.println("输出：" + solution.maximalSquare(matrix1));  // 预期输出：4
        
        // 测试用例 2
        char[][] matrix2 = {
            {'0', '1'},
            {'1', '0'}
        };
        System.out.println("\n测试用例 2：");
        System.out.println("输入：matrix = [['0','1'],['1','0']]");
        System.out.println("输出：" + solution.maximalSquare(matrix2));  // 预期输出：1
        
        // 测试用例 3
        char[][] matrix3 = {{'0'}};
        System.out.println("\n测试用例 3：");
        System.out.println("输入：matrix = [['0']]");
        System.out.println("输出：" + solution.maximalSquare(matrix3));  // 预期输出：0
    }
} 
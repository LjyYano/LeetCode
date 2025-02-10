/**
 * https://leetcode.cn/problems/range-sum-query-2d-immutable/
 * 
 * 给定一个二维矩阵 matrix，以下类型的多个请求：
 * - 计算其子矩形范围内元素的总和，该子矩阵的 左上角 为 (row1, col1) ，右下角 为 (row2, col2) 。
 * 
 * 实现 NumMatrix 类：
 * - NumMatrix(int[][] matrix) 给定整数矩阵 matrix 进行初始化
 * - int sumRegion(int row1, int col1, int row2, int col2) 返回 左上角 (row1, col1) 、右下角 (row2, col2) 所描述的子矩阵的元素 总和 。
 * 
 * 示例 1：
 * 输入: 
 * ["NumMatrix","sumRegion","sumRegion","sumRegion"]
 * [[[[3,0,1,4,2],[5,6,3,2,1],[1,2,0,1,5],[4,1,0,1,7],[1,0,3,0,5]]],[2,1,4,3],[1,1,2,2],[1,2,2,4]]
 * 输出: 
 * [null, 8, 11, 12]
 * 
 * 解释:
 * NumMatrix numMatrix = new NumMatrix([[3,0,1,4,2],[5,6,3,2,1],[1,2,0,1,5],[4,1,0,1,7],[1,0,3,0,5]]);
 * numMatrix.sumRegion(2, 1, 4, 3); // return 8 (红色矩形框的元素总和)
 * numMatrix.sumRegion(1, 1, 2, 2); // return 11 (绿色矩形框的元素总和)
 * numMatrix.sumRegion(1, 2, 2, 4); // return 12 (蓝色矩形框的元素总和)
 * 
 * 提示：
 * - m == matrix.length
 * - n == matrix[i].length
 * - 1 <= m, n <= 200
 * - -10⁵ <= matrix[i][j] <= 10⁵
 * - 0 <= row1 <= row2 < m
 * - 0 <= col1 <= col2 < n
 * - 最多调用 10⁴ 次 sumRegion 方法
 */
public class L0304_RangeSumQuery2DImmutable {
    
    private final int[][] prefixSum;
    
    public L0304_RangeSumQuery2DImmutable(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            prefixSum = new int[0][0];
            return;
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        // 创建前缀和数组，大小为 (m+1) × (n+1)
        // prefixSum[i][j] 表示从 (0,0) 到 (i-1,j-1) 的子矩阵元素和
        prefixSum = new int[m + 1][n + 1];
        
        // 计算二维前缀和
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                prefixSum[i][j] = prefixSum[i - 1][j] + prefixSum[i][j - 1] 
                        - prefixSum[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        // 使用容斥原理计算子矩阵的和
        return prefixSum[row2 + 1][col2 + 1] - prefixSum[row2 + 1][col1] 
                - prefixSum[row1][col2 + 1] + prefixSum[row1][col1];
    }

    public static void main(String[] args) {
        // 测试用例
        int[][] matrix = {
            {3, 0, 1, 4, 2},
            {5, 6, 3, 2, 1},
            {1, 2, 0, 1, 5},
            {4, 1, 0, 1, 7},
            {1, 0, 3, 0, 5}
        };
        
        L0304_RangeSumQuery2DImmutable numMatrix = new L0304_RangeSumQuery2DImmutable(matrix);
        
        // 测试区域和查询
        System.out.println(numMatrix.sumRegion(2, 1, 4, 3)); // 预期输出：8
        System.out.println(numMatrix.sumRegion(1, 1, 2, 2)); // 预期输出：11
        System.out.println(numMatrix.sumRegion(1, 2, 2, 4)); // 预期输出：12
    }
} 
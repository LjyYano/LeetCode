/**
 * https://leetcode.cn/problems/search-a-2d-matrix-ii/
 * 
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：
 * - 每行的元素从左到右升序排列。
 * - 每列的元素从上到下升序排列。
 * 
 * 示例 1：
 * 输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
 * 输出：true
 * 
 * 示例 2：
 * 输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
 * 输出：false
 * 
 * 提示：
 * - m == matrix.length
 * - n == matrix[i].length
 * - 1 <= n, m <= 300
 * - -10⁹ <= matrix[i][j] <= 10⁹
 * - 每行的所有元素从左到右升序排列
 * - 每列的所有元素从上到下升序排列
 * - -10⁹ <= target <= 10⁹
 */
public class L0240_SearchA2DMatrixII {
    
    /**
     * 从右上角开始搜索
     * 如果当前元素大于目标值，说明这一列都大于目标值，可以排除这一列
     * 如果当前元素小于目标值，说明这一行的前面元素都小于目标值，可以排除这一行
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        // 从右上角开始搜索
        int row = 0;
        int col = n - 1;
        
        while (row < m && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                // 当前元素大于目标值，排除这一列
                col--;
            } else {
                // 当前元素小于目标值，排除这一行
                row++;
            }
        }
        
        return false;
    }

    public static void main(String[] args) {
        L0240_SearchA2DMatrixII solution = new L0240_SearchA2DMatrixII();
        
        // 测试用例 1
        int[][] matrix1 = {
            {1, 4, 7, 11, 15},
            {2, 5, 8, 12, 19},
            {3, 6, 9, 16, 22},
            {10, 13, 14, 17, 24},
            {18, 21, 23, 26, 30}
        };
        int target1 = 5;
        System.out.println("测试用例 1：");
        System.out.println("目标值 " + target1 + " 是否存在：" + solution.searchMatrix(matrix1, target1));  // 预期输出：true
        
        // 测试用例 2
        int[][] matrix2 = {
            {1, 4, 7, 11, 15},
            {2, 5, 8, 12, 19},
            {3, 6, 9, 16, 22},
            {10, 13, 14, 17, 24},
            {18, 21, 23, 26, 30}
        };
        int target2 = 20;
        System.out.println("\n测试用例 2：");
        System.out.println("目标值 " + target2 + " 是否存在：" + solution.searchMatrix(matrix2, target2));  // 预期输出：false
    }
} 
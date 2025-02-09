/**
 * https://leetcode.cn/problems/search-a-2d-matrix/
 * 
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * - 每行中的整数从左到右按升序排列。
 * - 每行的第一个整数大于前一行的最后一个整数。
 * 
 * 示例 1：
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * 输出：true
 * 
 * 示例 2：
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
 * 输出：false
 * 
 * 提示：
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 100
 * -10⁴ <= matrix[i][j], target <= 10⁴
 */
public class L0074_SearchA2DMatrix {
    
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        // 将二维矩阵转换为一维数组进行二分查找
        int left = 0;
        int right = m * n - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // 将一维索引转换为二维坐标
            int row = mid / n;
            int col = mid % n;
            int value = matrix[row][col];
            
            if (value == target) {
                return true;
            } else if (value < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return false;
    }

    public static void main(String[] args) {
        L0074_SearchA2DMatrix solution = new L0074_SearchA2DMatrix();
        
        // 测试用例 1
        int[][] matrix1 = {
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 60}
        };
        int target1 = 3;
        System.out.println("测试用例 1：");
        System.out.println("目标值 " + target1 + " 是否存在：" + solution.searchMatrix(matrix1, target1));  // 预期输出：true
        
        // 测试用例 2
        int[][] matrix2 = {
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 60}
        };
        int target2 = 13;
        System.out.println("\n测试用例 2：");
        System.out.println("目标值 " + target2 + " 是否存在：" + solution.searchMatrix(matrix2, target2));  // 预期输出：false
    }
} 
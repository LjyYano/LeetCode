/**
 * https://leetcode.cn/problems/kth-smallest-element-in-a-sorted-matrix/
 * 
 * 给你一个 n x n 矩阵 matrix ，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
 * 请注意，它是 排序后 的第 k 小元素，而不是第 k 个 不同 的元素。
 * 
 * 你必须找到一个内存复杂度优于 O(n²) 的解决方案。
 * 
 * 示例 1：
 * 输入：matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
 * 输出：13
 * 解释：矩阵中的元素为 [1,5,9,10,11,12,13,13,15]，第 8 小元素是 13
 * 
 * 示例 2：
 * 输入：matrix = [[-5]], k = 1
 * 输出：-5
 * 
 * 提示：
 * - n == matrix.length
 * - n == matrix[i].length
 * - 1 <= n <= 300
 * - -10⁹ <= matrix[i][j] <= 10⁹
 * - 题目数据保证 matrix 中的所有行和列都按非递减顺序排序
 * - 1 <= k <= n²
 */
public class L0378_KthSmallestElementInSortedMatrix {
    
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        // 二分查找的范围是矩阵中的最小值和最大值
        int left = matrix[0][0];
        int right = matrix[n-1][n-1];
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 计算矩阵中小于等于 mid 的元素个数
            int count = countLessOrEqual(matrix, mid);
            
            if (count < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        return left;
    }
    
    /**
     * 计算矩阵中小于等于 target 的元素个数
     * 从左下角开始，如果当前元素大于 target，向上移动
     * 如果当前元素小于等于 target，将这一列的元素个数加入计数，然后向右移动
     */
    private int countLessOrEqual(int[][] matrix, int target) {
        int n = matrix.length;
        int count = 0;
        int row = n - 1;
        int col = 0;
        
        while (row >= 0 && col < n) {
            if (matrix[row][col] <= target) {
                // 这一列从 row 往上都小于等于 target
                count += row + 1;
                col++;
            } else {
                row--;
            }
        }
        
        return count;
    }

    public static void main(String[] args) {
        L0378_KthSmallestElementInSortedMatrix solution = new L0378_KthSmallestElementInSortedMatrix();
        
        // 测试用例 1
        int[][] matrix1 = {
            {1, 5, 9},
            {10, 11, 13},
            {12, 13, 15}
        };
        System.out.println(solution.kthSmallest(matrix1, 8));  // 应该输出：13
        
        // 测试用例 2
        int[][] matrix2 = {{-5}};
        System.out.println(solution.kthSmallest(matrix2, 1));  // 应该输出：-5
        
        // 测试用例 3
        int[][] matrix3 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        System.out.println(solution.kthSmallest(matrix3, 5));  // 应该输出：5
    }
} 
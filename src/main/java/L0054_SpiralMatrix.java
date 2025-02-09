/**
 * https://leetcode.cn/problems/spiral-matrix/
 * 
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * 
 * 示例 1：
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 
 * 示例 2：
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 * 
 * 提示：
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 10
 * -100 <= matrix[i][j] <= 100
 */

import java.util.ArrayList;
import java.util.List;

public class L0054_SpiralMatrix {
    
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        
        if (matrix == null || matrix.length == 0) {
            return result;
        }
        
        // 定义四个边界
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        
        while (true) {
            // 从左到右遍历上边界
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            // 上边界向下移动
            top++;
            if (top > bottom) break;
            
            // 从上到下遍历右边界
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            // 右边界向左移动
            right--;
            if (left > right) break;
            
            // 从右到左遍历下边界
            for (int i = right; i >= left; i--) {
                result.add(matrix[bottom][i]);
            }
            // 下边界向上移动
            bottom--;
            if (top > bottom) break;
            
            // 从下到上遍历左边界
            for (int i = bottom; i >= top; i--) {
                result.add(matrix[i][left]);
            }
            // 左边界向右移动
            left++;
            if (left > right) break;
        }
        
        return result;
    }

    public static void main(String[] args) {
        L0054_SpiralMatrix solution = new L0054_SpiralMatrix();
        
        // 测试用例 1
        int[][] matrix1 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        System.out.println(solution.spiralOrder(matrix1)); // 预期输出：[1,2,3,6,9,8,7,4,5]
        
        // 测试用例 2
        int[][] matrix2 = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12}
        };
        System.out.println(solution.spiralOrder(matrix2)); // 预期输出：[1,2,3,4,8,12,11,10,9,5,6,7]
    }
} 
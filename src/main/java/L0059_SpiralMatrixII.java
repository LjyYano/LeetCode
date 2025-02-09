/**
 * https://leetcode.cn/problems/spiral-matrix-ii/
 * 
 * 给你一个正整数 n ，生成一个包含 1 到 n² 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 * 
 * 示例 1：
 * 输入：n = 3
 * 输出：[[1,2,3],[8,9,4],[7,6,5]]
 * 
 * 示例 2：
 * 输入：n = 1
 * 输出：[[1]]
 * 
 * 提示：
 * 1 <= n <= 20
 */
public class L0059_SpiralMatrixII {
    
    public int[][] generateMatrix(int n) {
        // 创建 n x n 的矩阵
        int[][] matrix = new int[n][n];
        
        // 定义四个边界
        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = n - 1;
        
        // 要填入的数字，从 1 开始
        int num = 1;
        
        while (true) {
            // 从左到右填充上边界
            for (int i = left; i <= right; i++) {
                matrix[top][i] = num++;
            }
            // 上边界向下移动
            top++;
            if (top > bottom) break;
            
            // 从上到下填充右边界
            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = num++;
            }
            // 右边界向左移动
            right--;
            if (left > right) break;
            
            // 从右到左填充下边界
            for (int i = right; i >= left; i--) {
                matrix[bottom][i] = num++;
            }
            // 下边界向上移动
            bottom--;
            if (top > bottom) break;
            
            // 从下到上填充左边界
            for (int i = bottom; i >= top; i--) {
                matrix[i][left] = num++;
            }
            // 左边界向右移动
            left++;
            if (left > right) break;
        }
        
        return matrix;
    }

    public static void main(String[] args) {
        L0059_SpiralMatrixII solution = new L0059_SpiralMatrixII();
        
        // 测试用例 1
        int[][] result1 = solution.generateMatrix(3);
        System.out.println("n = 3 的结果：");
        printMatrix(result1);
        
        // 测试用例 2
        int[][] result2 = solution.generateMatrix(1);
        System.out.println("\nn = 1 的结果：");
        printMatrix(result2);
        
        // 测试用例 3
        int[][] result3 = solution.generateMatrix(4);
        System.out.println("\nn = 4 的结果：");
        printMatrix(result3);
    }
    
    // 打印矩阵的辅助方法
    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.printf("%2d ", num);
            }
            System.out.println();
        }
    }
} 
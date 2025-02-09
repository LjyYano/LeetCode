/**
 * https://leetcode.cn/problems/set-matrix-zeroes/
 * 
 * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
 * 
 * 示例 1：
 * 输入：matrix = [[1,1,1],[1,0,1],[1,1,1]]
 * 输出：[[1,0,1],[0,0,0],[1,0,1]]
 * 
 * 示例 2：
 * 输入：matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
 * 输出：[[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 * 
 * 提示：
 * m == matrix.length
 * n == matrix[0].length
 * 1 <= m, n <= 200
 * -2³¹ <= matrix[i][j] <= 2³¹ - 1
 * 
 * 进阶：
 * - 一个直观的解决方案是使用 O(mn) 的额外空间，但这并不是一个好的解决方案。
 * - 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
 * - 你能想出一个仅使用常量空间的解决方案吗？
 */
public class L0073_SetMatrixZeroes {

    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        // 使用第一行和第一列作为标记数组
        boolean firstRowHasZero = false;
        boolean firstColHasZero = false;
        
        // 检查第一行是否有 0
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                firstRowHasZero = true;
                break;
            }
        }
        
        // 检查第一列是否有 0
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                firstColHasZero = true;
                break;
            }
        }
        
        // 使用第一行和第一列记录其他行列是否有 0
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        
        // 根据第一行和第一列的标记，将对应的行和列置为 0
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        
        // 如果第一行原本有 0，则将第一行全部置为 0
        if (firstRowHasZero) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
        
        // 如果第一列原本有 0，则将第一列全部置为 0
        if (firstColHasZero) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    // 打印矩阵
    private void printMatrix(int[][] matrix) {
        System.out.println("[");
        for (int i = 0; i < matrix.length; i++) {
            System.out.print("  [");
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]);
                if (j < matrix[0].length - 1) {
                    System.out.print(",");
                }
            }
            System.out.print("]");
            if (i < matrix.length - 1) {
                System.out.println(",");
            } else {
                System.out.println();
            }
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        L0073_SetMatrixZeroes solution = new L0073_SetMatrixZeroes();

        // 测试用例 1
        int[][] matrix1 = {{1,1,1},{1,0,1},{1,1,1}};
        System.out.println("Input:");
        solution.printMatrix(matrix1);
        solution.setZeroes(matrix1);
        System.out.println("Output:");
        solution.printMatrix(matrix1);
        System.out.println();

        // 测试用例 2
        int[][] matrix2 = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        System.out.println("Input:");
        solution.printMatrix(matrix2);
        solution.setZeroes(matrix2);
        System.out.println("Output:");
        solution.printMatrix(matrix2);
    }
} 
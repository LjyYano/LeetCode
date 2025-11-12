/**
 * https://leetcode.cn/problems/diagonal-traverse/
 * 
 * 给你一个大小为 m x n 的矩阵 mat ，请以对角线遍历的顺序，用一个数组返回这个矩阵中的所有元素。
 * 
 * 示例 1：
 * 输入：mat = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,4,7,5,3,6,8,9]
 * 
 * 示例 2：
 * 输入：mat = [[1,2],[3,4]]
 * 输出：[1,2,3,4]
 * 
 * 提示：
 * - m == mat.length
 * - n == mat[i].length
 * - 1 <= m, n <= 10^4
 * - 1 <= m * n <= 10^4
 * - -10^5 <= mat[i][j] <= 10^5
 */
public class L0498_DiagonalTraverse {
    
    /**
     * 模拟对角线遍历
     * 关键点：
     * 1. 对角线方向交替变化（右上、左下）
     * 2. 遇到边界时改变方向
     */
    public int[] findDiagonalOrder(int[][] mat) {
        if (mat == null || mat.length == 0) {
            return new int[0];
        }
        
        int m = mat.length;
        int n = mat[0].length;
        int[] result = new int[m * n];
        
        int row = 0, col = 0;
        int direction = 1; // 1 表示向右上，-1 表示向左下
        
        for (int i = 0; i < m * n; i++) {
            result[i] = mat[row][col];
            
            if (direction == 1) {
                // 向右上移动
                if (col == n - 1) {
                    // 到达右边界，向下移动，改变方向
                    row++;
                    direction = -1;
                } else if (row == 0) {
                    // 到达上边界，向右移动，改变方向
                    col++;
                    direction = -1;
                } else {
                    // 正常向右上移动
                    row--;
                    col++;
                }
            } else {
                // 向左下移动
                if (row == m - 1) {
                    // 到达下边界，向右移动，改变方向
                    col++;
                    direction = 1;
                } else if (col == 0) {
                    // 到达左边界，向下移动，改变方向
                    row++;
                    direction = 1;
                } else {
                    // 正常向左下移动
                    row++;
                    col--;
                }
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        L0498_DiagonalTraverse solution = new L0498_DiagonalTraverse();
        
        // 测试用例 1
        int[][] mat1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[] result1 = solution.findDiagonalOrder(mat1);
        System.out.print("[");
        for (int i = 0; i < result1.length; i++) {
            System.out.print(result1[i]);
            if (i < result1.length - 1) System.out.print(",");
        }
        System.out.println("]"); // 预期输出：[1,2,4,7,5,3,6,8,9]
        
        // 测试用例 2
        int[][] mat2 = {{1, 2}, {3, 4}};
        int[] result2 = solution.findDiagonalOrder(mat2);
        System.out.print("[");
        for (int i = 0; i < result2.length; i++) {
            System.out.print(result2[i]);
            if (i < result2.length - 1) System.out.print(",");
        }
        System.out.println("]"); // 预期输出：[1,2,3,4]
    }
}

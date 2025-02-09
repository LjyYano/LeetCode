/**
 * https://leetcode.cn/problems/maximal-rectangle/
 * 
 * 给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 * 
 * 示例 1：
 * ![img](https://assets.leetcode.com/uploads/2020/09/14/maximal.jpg)
 * 输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
 * 输出：6
 * 解释：最大矩形如上图所示。
 * 
 * 示例 2：
 * 输入：matrix = []
 * 输出：0
 * 
 * 示例 3：
 * 输入：matrix = [["0"]]
 * 输出：0
 * 
 * 示例 4：
 * 输入：matrix = [["1"]]
 * 输出：1
 * 
 * 示例 5：
 * 输入：matrix = [["0","0"]]
 * 输出：0
 * 
 * 提示：
 * - rows == matrix.length
 * - cols == matrix[0].length
 * - 1 <= row, cols <= 200
 * - matrix[i][j] 为 '0' 或 '1'
 */
public class L0085_MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        // 记录每个位置上方连续 1 的个数
        int[] heights = new int[cols];
        int maxArea = 0;
        
        // 逐行处理，将问题转化为柱状图中最大的矩形问题
        for (int i = 0; i < rows; i++) {
            // 更新每列的高度
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1') {
                    heights[j]++;
                } else {
                    heights[j] = 0;
                }
            }
            // 计算当前行构成的柱状图中的最大矩形面积
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }
        
        return maxArea;
    }
    
    // 复用第 84 题的解法，计算柱状图中最大的矩形面积
    private int largestRectangleArea(int[] heights) {
        // 创建一个新数组，在首尾添加高度为 0 的柱子，方便处理边界情况
        int[] newHeights = new int[heights.length + 2];
        System.arraycopy(heights, 0, newHeights, 1, heights.length);
        
        // 使用单调栈，栈中存储柱子的索引
        int[] stack = new int[newHeights.length];
        int top = -1;
        int maxArea = 0;
        
        // 遍历每个柱子
        for (int i = 0; i < newHeights.length; i++) {
            // 当栈不为空，且当前柱子高度小于栈顶柱子高度时
            while (top != -1 && newHeights[i] < newHeights[stack[top]]) {
                // 弹出栈顶元素，计算以该柱子为高度的最大矩形面积
                int height = newHeights[stack[top--]];
                // 宽度为当前位置到新的栈顶位置之间的距离
                int width = i - stack[top] - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            // 将当前柱子的索引入栈
            stack[++top] = i;
        }
        
        return maxArea;
    }

    public static void main(String[] args) {
        L0085_MaximalRectangle solution = new L0085_MaximalRectangle();

        // 测试用例 1
        char[][] matrix1 = {
            {'1','0','1','0','0'},
            {'1','0','1','1','1'},
            {'1','1','1','1','1'},
            {'1','0','0','1','0'}
        };
        System.out.println("测试用例 1:");
        System.out.println("输入: matrix =");
        printMatrix(matrix1);
        System.out.println("输出: " + solution.maximalRectangle(matrix1));
        System.out.println();

        // 测试用例 2：空矩阵
        char[][] matrix2 = {};
        System.out.println("测试用例 2:");
        System.out.println("输入: matrix = []");
        System.out.println("输出: " + solution.maximalRectangle(matrix2));
        System.out.println();

        // 测试用例 3：单个 0
        char[][] matrix3 = {{'0'}};
        System.out.println("测试用例 3:");
        System.out.println("输入: matrix = [[\"0\"]]");
        System.out.println("输出: " + solution.maximalRectangle(matrix3));
        System.out.println();

        // 测试用例 4：单个 1
        char[][] matrix4 = {{'1'}};
        System.out.println("测试用例 4:");
        System.out.println("输入: matrix = [[\"1\"]]");
        System.out.println("输出: " + solution.maximalRectangle(matrix4));
    }

    // 辅助方法：打印矩阵
    private static void printMatrix(char[][] matrix) {
        System.out.println("[");
        for (char[] row : matrix) {
            System.out.print("  [");
            for (int j = 0; j < row.length; j++) {
                System.out.print("\"" + row[j] + "\"");
                if (j < row.length - 1) {
                    System.out.print(",");
                }
            }
            System.out.println("]");
        }
        System.out.println("]");
    }
} 
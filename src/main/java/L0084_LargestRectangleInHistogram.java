/**
 * https://leetcode.cn/problems/largest-rectangle-in-histogram/
 * 
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 * 
 * 示例 1：
 * ![img](https://assets.leetcode.com/uploads/2021/01/04/histogram.jpg)
 * 输入：heights = [2,1,5,6,2,3]
 * 输出：10
 * 解释：最大的矩形为图中红色区域，面积为 10
 * 
 * 示例 2：
 * 输入：heights = [2,4]
 * 输出：4
 * 
 * 提示：
 * - 1 <= heights.length <= 10⁵
 * - 0 <= heights[i] <= 10⁴
 */
public class L0084_LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        
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
        L0084_LargestRectangleInHistogram solution = new L0084_LargestRectangleInHistogram();

        // 测试用例 1
        int[] heights1 = {2, 1, 5, 6, 2, 3};
        System.out.println("测试用例 1:");
        System.out.println("输入: heights = " + java.util.Arrays.toString(heights1));
        System.out.println("输出: " + solution.largestRectangleArea(heights1));
        System.out.println();

        // 测试用例 2
        int[] heights2 = {2, 4};
        System.out.println("测试用例 2:");
        System.out.println("输入: heights = " + java.util.Arrays.toString(heights2));
        System.out.println("输出: " + solution.largestRectangleArea(heights2));
        System.out.println();

        // 测试用例 3：单个柱子
        int[] heights3 = {5};
        System.out.println("测试用例 3:");
        System.out.println("输入: heights = " + java.util.Arrays.toString(heights3));
        System.out.println("输出: " + solution.largestRectangleArea(heights3));
        System.out.println();

        // 测试用例 4：所有柱子高度相同
        int[] heights4 = {2, 2, 2, 2};
        System.out.println("测试用例 4:");
        System.out.println("输入: heights = " + java.util.Arrays.toString(heights4));
        System.out.println("输出: " + solution.largestRectangleArea(heights4));
    }
} 
/**
 * 题目链接：https://leetcode.cn/problems/trapping-rain-water/
 * 
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 
 * 示例 1：
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 * 
 * 示例 2：
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 */
public class L0042_TrappingRainWater {

    public int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }
        
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int result = 0;
        
        // 使用双指针，从两端向中间移动
        while (left < right) {
            // 更新左右两边的最大高度
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            
            // 如果左边的最大高度较小，处理左边
            if (leftMax < rightMax) {
                // 当前位置能接的雨水 = 左边最大高度 - 当前高度
                result += leftMax - height[left];
                left++;
            } else {
                // 如果右边的最大高度较小，处理右边
                result += rightMax - height[right];
                right--;
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        L0042_TrappingRainWater solution = new L0042_TrappingRainWater();
        
        // 测试用例 1
        int[] height1 = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println("测试用例 1：");
        System.out.println("输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]");
        System.out.println("输出：" + solution.trap(height1));
        // 预期输出：6
        
        // 测试用例 2
        int[] height2 = {4, 2, 0, 3, 2, 5};
        System.out.println("\n测试用例 2：");
        System.out.println("输入：height = [4,2,0,3,2,5]");
        System.out.println("输出：" + solution.trap(height2));
        // 预期输出：9
    }
} 
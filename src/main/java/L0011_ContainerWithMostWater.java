/**
 * 题目链接：https://leetcode.cn/problems/container-with-most-water/
 * 
 * 给定一个长度为 n 的整数数组 height。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i])。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 返回容器可以储存的最大水量。
 * 说明：你不能倾斜容器。
 */
public class L0011_ContainerWithMostWater {
    
    public int maxArea(int[] height) {
        // 使用双指针，一个指向开始，一个指向结束
        int left = 0;
        int right = height.length - 1;
        // 记录最大面积
        int maxArea = 0;
        
        // 当左指针小于右指针时继续
        while (left < right) {
            // 计算当前面积：宽度 * 高度（取两边较小的高度）
            int area = (right - left) * Math.min(height[left], height[right]);
            // 更新最大面积
            maxArea = Math.max(maxArea, area);
            
            // 移动较小高度的指针
            // 因为如果移动较大高度的指针，新的面积一定更小
            // （宽度减小，而高度不会增加，因为高度取决于较小值）
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        
        return maxArea;
    }

    public static void main(String[] args) {
        L0011_ContainerWithMostWater solution = new L0011_ContainerWithMostWater();
        
        // 测试用例 1
        int[] height1 = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println("测试用例 1：");
        System.out.println("输入：[1,8,6,2,5,4,8,3,7]");
        System.out.println("输出：" + solution.maxArea(height1));
        System.out.println("预期输出：49");
        System.out.println();
        
        // 测试用例 2
        int[] height2 = {1, 1};
        System.out.println("测试用例 2：");
        System.out.println("输入：[1,1]");
        System.out.println("输出：" + solution.maxArea(height2));
        System.out.println("预期输出：1");
        System.out.println();
        
        // 测试用例 3：高度相同的情况
        int[] height3 = {4, 4, 4, 4};
        System.out.println("测试用例 3：");
        System.out.println("输入：[4,4,4,4]");
        System.out.println("输出：" + solution.maxArea(height3));
        System.out.println("预期输出：12");
    }
} 
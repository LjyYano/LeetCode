/**
 * https://leetcode.cn/problems/rotate-function/
 * 
 * 给定一个长度为 n 的整数数组 nums。
 * 
 * 假设 arrk 是数组 nums 顺时针旋转 k 个位置后的数组，我们定义 nums 的 "旋转函数" F 为：
 * - F(k) = 0 * arrk[0] + 1 * arrk[1] + ... + (n - 1) * arrk[n - 1]
 * 
 * 返回 F(0), F(1), ..., F(n-1) 中的最大值。
 * 
 * 示例 1：
 * 输入: nums = [4,3,2,6]
 * 输出: 26
 * 解释:
 * F(0) = (0 * 4) + (1 * 3) + (2 * 2) + (3 * 6) = 0 + 3 + 4 + 18 = 25
 * F(1) = (0 * 6) + (1 * 4) + (2 * 3) + (3 * 2) = 0 + 4 + 6 + 6 = 16
 * F(2) = (0 * 2) + (1 * 6) + (2 * 4) + (3 * 3) = 0 + 6 + 8 + 9 = 23
 * F(3) = (0 * 3) + (1 * 2) + (2 * 6) + (3 * 4) = 0 + 2 + 12 + 12 = 26
 * 
 * 示例 2：
 * 输入: nums = [100]
 * 输出: 0
 * 
 * 提示：
 * - n == nums.length
 * - 1 <= n <= 10⁵
 * - -100 <= nums[i] <= 100
 */
public class L0396_RotateFunction {
    
    public int maxRotateFunction(int[] nums) {
        // 计算数组的长度和所有元素的和
        int n = nums.length;
        int sum = 0;
        int F = 0;
        
        // 计算 F(0) 和数组元素和
        for (int i = 0; i < n; i++) {
            F += i * nums[i];
            sum += nums[i];
        }
        
        // 记录最大值，初始为 F(0)
        int maxF = F;
        
        // 计算 F(1) 到 F(n-1)
        // F(k) = F(k-1) + sum - n * nums[n-k]
        for (int k = 1; k < n; k++) {
            F = F + sum - n * nums[n - k];
            maxF = Math.max(maxF, F);
        }
        
        return maxF;
    }

    public static void main(String[] args) {
        L0396_RotateFunction solution = new L0396_RotateFunction();
        
        // 测试用例 1
        int[] nums1 = {4, 3, 2, 6};
        System.out.println("测试用例 1：");
        System.out.println("输入：nums = [4,3,2,6]");
        System.out.println("输出：" + solution.maxRotateFunction(nums1));
        System.out.println();
        
        // 测试用例 2
        int[] nums2 = {100};
        System.out.println("测试用例 2：");
        System.out.println("输入：nums = [100]");
        System.out.println("输出：" + solution.maxRotateFunction(nums2));
        System.out.println();
        
        // 测试用例 3：包含负数
        int[] nums3 = {1, -2, 3, -4};
        System.out.println("测试用例 3：");
        System.out.println("输入：nums = [1,-2,3,-4]");
        System.out.println("输出：" + solution.maxRotateFunction(nums3));
    }
} 
/**
 * 题目链接：https://leetcode.cn/problems/maximum-subarray/
 * 
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 子数组 是数组中的一个连续部分。
 * 
 * 示例 1：
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 * 
 * 示例 2：
 * 输入：nums = [1]
 * 输出：1
 * 
 * 示例 3：
 * 输入：nums = [5,4,-1,7,8]
 * 输出：23
 * 
 * 提示：
 * 1 <= nums.length <= 10⁵
 * -10⁴ <= nums[i] <= 10⁴
 */
public class L0053_MaximumSubarray {
    
    public int maxSubArray(int[] nums) {
        // 如果数组为空，返回 0
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        // 记录当前连续子数组的和
        int currentSum = nums[0];
        // 记录最大的子数组和
        int maxSum = nums[0];
        
        // 从第二个元素开始遍历
        for (int i = 1; i < nums.length; i++) {
            // 如果当前和为负数，那么重新开始计算（抛弃之前的结果）
            // 否则继续累加当前元素
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            // 更新最大和
            maxSum = Math.max(maxSum, currentSum);
        }
        
        return maxSum;
    }

    public static void main(String[] args) {
        L0053_MaximumSubarray solution = new L0053_MaximumSubarray();
        
        // 测试用例 1
        int[] nums1 = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(solution.maxSubArray(nums1)); // 预期输出：6
        
        // 测试用例 2
        int[] nums2 = {1};
        System.out.println(solution.maxSubArray(nums2)); // 预期输出：1
        
        // 测试用例 3
        int[] nums3 = {5,4,-1,7,8};
        System.out.println(solution.maxSubArray(nums3)); // 预期输出：23
    }
} 
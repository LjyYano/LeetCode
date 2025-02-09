/**
 * https://leetcode.cn/problems/maximum-product-subarray/
 * 
 * 给你一个整数数组 nums，请你找出数组中乘积最大的非空连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 * 
 * 测试用例的答案是一个 32-位 整数。
 * 
 * 子数组 是数组的连续子序列。
 * 
 * 示例 1：
 * 输入：nums = [2,3,-2,4]
 * 输出：6
 * 解释：子数组 [2,3] 有最大乘积 6。
 * 
 * 示例 2：
 * 输入：nums = [-2,0,-1]
 * 输出：0
 * 解释：结果不能为 2，因为 [-2,-1] 不是子数组。
 * 
 * 提示：
 * - 1 <= nums.length <= 2 * 10⁴
 * - -10 <= nums[i] <= 10
 * - nums 的任何前缀或后缀的乘积都 保证 是一个 32-位 整数
 */
public class L0152_MaximumProductSubarray {
    
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        // 维护两个变量，一个记录最大值，一个记录最小值
        int maxSoFar = nums[0];
        int minSoFar = nums[0];
        int result = maxSoFar;
        
        // 从第二个元素开始遍历
        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];
            // 计算当前位置的最大值和最小值
            int tempMax = Math.max(curr, Math.max(maxSoFar * curr, minSoFar * curr));
            int tempMin = Math.min(curr, Math.min(maxSoFar * curr, minSoFar * curr));
            
            // 更新最大值和最小值
            maxSoFar = tempMax;
            minSoFar = tempMin;
            
            // 更新结果
            result = Math.max(result, maxSoFar);
        }
        
        return result;
    }

    public static void main(String[] args) {
        L0152_MaximumProductSubarray solution = new L0152_MaximumProductSubarray();
        
        // 测试用例 1
        int[] nums1 = {2,3,-2,4};
        System.out.println(solution.maxProduct(nums1)); // 预期输出：6
        
        // 测试用例 2
        int[] nums2 = {-2,0,-1};
        System.out.println(solution.maxProduct(nums2)); // 预期输出：0
        
        // 测试用例 3
        int[] nums3 = {-2,3,-4};
        System.out.println(solution.maxProduct(nums3)); // 预期输出：24
    }
} 
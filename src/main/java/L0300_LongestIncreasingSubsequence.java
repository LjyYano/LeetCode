/**
 * https://leetcode.cn/problems/longest-increasing-subsequence/
 * 
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * 
 * 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。
 * 例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 * 
 * 示例 1：
 * 输入：nums = [10,9,2,5,3,7,101,18]
 * 输出：4
 * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
 * 
 * 示例 2：
 * 输入：nums = [0,1,0,3,2,3]
 * 输出：4
 * 
 * 示例 3：
 * 输入：nums = [7,7,7,7,7,7,7]
 * 输出：1
 * 
 * 提示：
 * - 1 <= nums.length <= 2500
 * - -10⁴ <= nums[i] <= 10⁴
 * 
 * 进阶：你能将算法的时间复杂度降低到 O(n log(n)) 吗?
 */
public class L0300_LongestIncreasingSubsequence {
    
    /**
     * 动态规划解法
     * dp[i] 表示以 nums[i] 结尾的最长递增子序列的长度
     */
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int n = nums.length;
        // dp[i] 表示以 nums[i] 结尾的最长递增子序列的长度
        int[] dp = new int[n];
        // 初始化 dp 数组，每个元素自身可以构成长度为 1 的子序列
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }
        
        // 最长递增子序列的长度
        int maxLength = 1;
        
        // 对于每个位置，查看它前面的所有元素
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                // 如果当前元素大于前面的元素，可以将当前元素接在前面的子序列后面
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            // 更新最长递增子序列的长度
            maxLength = Math.max(maxLength, dp[i]);
        }
        
        return maxLength;
    }

    public static void main(String[] args) {
        L0300_LongestIncreasingSubsequence solution = new L0300_LongestIncreasingSubsequence();
        
        // 测试用例 1
        int[] nums1 = {10,9,2,5,3,7,101,18};
        System.out.println(solution.lengthOfLIS(nums1)); // 预期输出：4
        
        // 测试用例 2
        int[] nums2 = {0,1,0,3,2,3};
        System.out.println(solution.lengthOfLIS(nums2)); // 预期输出：4
        
        // 测试用例 3
        int[] nums3 = {7,7,7,7,7,7,7};
        System.out.println(solution.lengthOfLIS(nums3)); // 预期输出：1
    }
} 
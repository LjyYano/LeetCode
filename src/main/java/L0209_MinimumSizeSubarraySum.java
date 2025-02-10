/**
 * https://leetcode.cn/problems/minimum-size-subarray-sum/
 * 
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * 
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 * 
 * 示例 1：
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 * 
 * 示例 2：
 * 输入：target = 4, nums = [1,4,4]
 * 输出：1
 * 
 * 示例 3：
 * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
 * 输出：0
 * 
 * 提示：
 * - 1 <= target <= 10^9
 * - 1 <= nums.length <= 10^5
 * - 1 <= nums[i] <= 10^5
 */
public class L0209_MinimumSizeSubarraySum {
    
    /**
     * 使用滑动窗口解法
     * 维护一个窗口，不断调整左右边界，找到满足条件的最小长度
     */
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int left = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;
        
        // 右指针遍历数组
        for (int right = 0; right < n; right++) {
            // 加入右边的元素
            sum += nums[right];
            
            // 当和大于等于目标值时，尝试缩小窗口
            while (sum >= target) {
                // 更新最小长度
                minLen = Math.min(minLen, right - left + 1);
                // 减去左边的元素
                sum -= nums[left];
                // 左指针右移
                left++;
            }
        }
        
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    public static void main(String[] args) {
        L0209_MinimumSizeSubarraySum solution = new L0209_MinimumSizeSubarraySum();
        
        // 测试用例 1
        int target1 = 7;
        int[] nums1 = {2,3,1,2,4,3};
        System.out.println("测试用例 1：");
        System.out.println("输入：target = " + target1 + ", nums = [2,3,1,2,4,3]");
        System.out.println("输出：" + solution.minSubArrayLen(target1, nums1));
        System.out.println();
        
        // 测试用例 2
        int target2 = 4;
        int[] nums2 = {1,4,4};
        System.out.println("测试用例 2：");
        System.out.println("输入：target = " + target2 + ", nums = [1,4,4]");
        System.out.println("输出：" + solution.minSubArrayLen(target2, nums2));
        System.out.println();
        
        // 测试用例 3
        int target3 = 11;
        int[] nums3 = {1,1,1,1,1,1,1,1};
        System.out.println("测试用例 3：");
        System.out.println("输入：target = " + target3 + ", nums = [1,1,1,1,1,1,1,1]");
        System.out.println("输出：" + solution.minSubArrayLen(target3, nums3));
    }
} 
/**
 * https://leetcode.cn/problems/132-pattern/
 * 
 * 给你一个整数数组 nums ，数组中共有 n 个整数。132 模式的子序列 由三个整数 nums[i]、nums[j] 和 nums[k] 组成，并同时满足：i < j < k 和 nums[i] < nums[k] < nums[j] 。
 * 
 * 如果 nums 中存在 132 模式的子序列 ，返回 true ；否则，返回 false 。
 * 
 * 示例 1：
 * 输入：nums = [1,2,3,4]
 * 输出：false
 * 解释：序列中不存在 132 模式的子序列。
 * 
 * 示例 2：
 * 输入：nums = [3,1,4,2]
 * 输出：true
 * 解释：序列中有 1 个 132 模式的子序列： [1,4,2]。
 * 
 * 示例 3：
 * 输入：nums = [-1,3,2,0]
 * 输出：true
 * 解释：序列中有 3 个 132 模式的的子序列：[-1,3,2]、[-1,3,0] 和 [-1,2,0]。
 * 
 * 提示：
 * n == nums.length
 * 1 <= n <= 2 * 10⁵
 * -10⁹ <= nums[i] <= 10⁹
 */
public class L0456_OneThreeTwoPattern {
    
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return false;
        }
        
        // 单调栈，用于存储可能的 "2" 值
        java.util.Stack<Integer> stack = new java.util.Stack<>();
        // 记录当前可能的 "2" 值（第三个数）
        int k = Integer.MIN_VALUE;
        
        // 从右向左遍历数组
        for (int i = n - 1; i >= 0; i--) {
            // 如果找到了一个小于 k 的数，就找到了 132 模式
            if (nums[i] < k) {
                return true;
            }
            
            // 维护单调栈，找到可能的 "2" 值
            while (!stack.isEmpty() && stack.peek() < nums[i]) {
                k = stack.pop();
            }
            
            // 将当前数入栈，它可能是 "3"
            stack.push(nums[i]);
        }
        
        return false;
    }

    public static void main(String[] args) {
        L0456_OneThreeTwoPattern solution = new L0456_OneThreeTwoPattern();
        
        // 测试用例 1
        int[] nums1 = {1, 2, 3, 4};
        System.out.println("测试用例 1 结果：" + solution.find132pattern(nums1)); // 预期输出：false
        
        // 测试用例 2
        int[] nums2 = {3, 1, 4, 2};
        System.out.println("测试用例 2 结果：" + solution.find132pattern(nums2)); // 预期输出：true
        
        // 测试用例 3
        int[] nums3 = {-1, 3, 2, 0};
        System.out.println("测试用例 3 结果：" + solution.find132pattern(nums3)); // 预期输出：true
    }
} 
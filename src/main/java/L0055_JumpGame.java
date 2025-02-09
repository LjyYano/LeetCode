/**
 * https://leetcode.cn/problems/jump-game/
 * 
 * 给你一个非负整数数组 nums ，你最初位于数组的第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标。
 * 
 * 示例 1：
 * 输入：nums = [2,3,1,1,4]
 * 输出：true
 * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 * 
 * 示例 2：
 * 输入：nums = [3,2,1,0,4]
 * 输出：false
 * 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
 * 
 * 提示：
 * 1 <= nums.length <= 10⁴
 * 0 <= nums[i] <= 10⁵
 */
public class L0055_JumpGame {
    
    public boolean canJump(int[] nums) {
        // 如果数组为空或只有一个元素，直接返回 true
        if (nums == null || nums.length <= 1) {
            return true;
        }
        
        // 记录当前能够到达的最远位置
        int maxReach = nums[0];
        
        // 遍历数组中的每个位置
        for (int i = 0; i <= maxReach && i < nums.length; i++) {
            // 更新最远可以到达的位置
            // 当前位置是 i，从这个位置最远可以跳 nums[i] 步
            // 所以从当前位置能到达的最远距离是 i + nums[i]
            maxReach = Math.max(maxReach, i + nums[i]);
            
            // 如果最远可达位置已经超过或等于最后一个位置，返回 true
            if (maxReach >= nums.length - 1) {
                return true;
            }
        }
        
        // 如果遍历结束后仍然无法到达最后一个位置，返回 false
        return false;
    }

    public static void main(String[] args) {
        L0055_JumpGame solution = new L0055_JumpGame();
        
        // 测试用例 1
        int[] nums1 = {2, 3, 1, 1, 4};
        System.out.println(solution.canJump(nums1)); // 预期输出：true
        
        // 测试用例 2
        int[] nums2 = {3, 2, 1, 0, 4};
        System.out.println(solution.canJump(nums2)); // 预期输出：false
        
        // 测试用例 3：单个元素
        int[] nums3 = {0};
        System.out.println(solution.canJump(nums3)); // 预期输出：true
    }
} 
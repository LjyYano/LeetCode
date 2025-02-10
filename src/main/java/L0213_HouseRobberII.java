/**
 * https://leetcode.cn/problems/house-robber-ii/
 * 
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。
 * 同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
 * 
 * 示例 1：
 * 输入：nums = [2,3,2]
 * 输出：3
 * 解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
 * 
 * 示例 2：
 * 输入：nums = [1,2,3,1]
 * 输出：4
 * 解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 * 
 * 示例 3：
 * 输入：nums = [1,2,3]
 * 输出：3
 * 
 * 提示：
 * - 1 <= nums.length <= 100
 * - 0 <= nums[i] <= 1000
 */
public class L0213_HouseRobberII {
    
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        
        // 分两种情况：
        // 1. 偷第一个房子到倒数第二个房子
        // 2. 偷第二个房子到最后一个房子
        // 取两种情况的最大值
        return Math.max(
            robRange(nums, 0, nums.length - 2),  // 不偷最后一个
            robRange(nums, 1, nums.length - 1)   // 不偷第一个
        );
    }
    
    /**
     * 计算在指定范围内能偷到的最大金额
     * @param nums 房屋金额数组
     * @param start 起始位置（包含）
     * @param end 结束位置（包含）
     * @return 最大金额
     */
    private int robRange(int[] nums, int start, int end) {
        int prev2 = 0;  // dp[i-2]
        int prev1 = 0;  // dp[i-1]
        int curr = 0;   // dp[i]
        
        for (int i = start; i <= end; i++) {
            curr = Math.max(prev2 + nums[i], prev1);
            prev2 = prev1;
            prev1 = curr;
        }
        
        return curr;
    }

    public static void main(String[] args) {
        L0213_HouseRobberII solution = new L0213_HouseRobberII();
        
        // 测试用例 1
        int[] nums1 = {2, 3, 2};
        System.out.println("测试用例 1：");
        System.out.println("输入：nums = [2,3,2]");
        System.out.println("输出：" + solution.rob(nums1));  // 预期输出：3
        System.out.println();
        
        // 测试用例 2
        int[] nums2 = {1, 2, 3, 1};
        System.out.println("测试用例 2：");
        System.out.println("输入：nums = [1,2,3,1]");
        System.out.println("输出：" + solution.rob(nums2));  // 预期输出：4
        System.out.println();
        
        // 测试用例 3
        int[] nums3 = {1, 2, 3};
        System.out.println("测试用例 3：");
        System.out.println("输入：nums = [1,2,3]");
        System.out.println("输出：" + solution.rob(nums3));  // 预期输出：3
    }
} 
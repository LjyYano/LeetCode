import java.util.Arrays;

/**
 * 题目链接：https://leetcode.cn/problems/jump-game-ii/
 * 
 * 给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。
 * 每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:
 * 0 <= j <= nums[i]
 * i + j < n
 * 返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。
 * 
 * 示例 1:
 * 输入: nums = [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * 
 * 示例 2:
 * 输入: nums = [2,3,0,1,4]
 * 输出: 2
 */
public class L0045_JumpGameII {

    public int jump(int[] nums) {
        // 如果数组长度小于等于 1，不需要跳跃
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        
        // 记录当前能够到达的最远位置
        int maxPosition = 0;
        // 记录当前步数能够到达的边界
        int end = 0;
        // 记录跳跃次数
        int steps = 0;
        
        // 遍历数组（不需要访问最后一个元素）
        for (int i = 0; i < nums.length - 1; i++) {
            // 更新当前能够到达的最远位置
            maxPosition = Math.max(maxPosition, i + nums[i]);
            
            // 如果到达当前步数能够到达的边界
            if (i == end) {
                // 更新边界为当前能够到达的最远位置
                end = maxPosition;
                // 增加跳跃次数
                steps++;
            }
        }
        
        return steps;
    }

    public static void main(String[] args) {
        L0045_JumpGameII solution = new L0045_JumpGameII();
        
        // 测试用例 1
        int[] nums1 = {2, 3, 1, 1, 4};
        System.out.println("测试用例 1：");
        System.out.println("输入：" + Arrays.toString(nums1));
        System.out.println("输出：" + solution.jump(nums1));  // 预期输出：2
        
        // 测试用例 2
        int[] nums2 = {2, 3, 0, 1, 4};
        System.out.println("\n测试用例 2：");
        System.out.println("输入：" + Arrays.toString(nums2));
        System.out.println("输出：" + solution.jump(nums2));  // 预期输出：2
    }
} 
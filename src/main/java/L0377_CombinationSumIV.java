import java.util.Arrays;

/**
 * https://leetcode.cn/problems/combination-sum-iv/
 * 
 * 给你一个由 不同 整数组成的数组 nums ，和一个目标整数 target 。请你从 nums 中找出并返回总和为 target 的元素组合的个数。
 * 
 * 题目数据保证答案符合 32 位整数范围。
 * 
 * 示例 1：
 * 输入：nums = [1,2,3], target = 4
 * 输出：7
 * 解释：
 * 所有可能的组合为：
 * (1, 1, 1, 1)
 * (1, 1, 2)
 * (1, 2, 1)
 * (1, 3)
 * (2, 1, 1)
 * (2, 2)
 * (3, 1)
 * 请注意，顺序不同的序列被视作不同的组合。
 * 
 * 示例 2：
 * 输入：nums = [9], target = 3
 * 输出：0
 * 
 * 提示：
 * 1 <= nums.length <= 200
 * 1 <= nums[i] <= 1000
 * nums 中的所有元素 互不相同
 * 1 <= target <= 1000
 * 
 * 进阶：如果给定的数组中含有负数会发生什么？问题会产生何种变化？如果允许负数出现，需要向题目中添加哪些限制条件？
 */
public class L0377_CombinationSumIV {

    public int combinationSum4(int[] nums, int target) {
        // dp[i] 表示目标数为 i 的组合个数
        int[] dp = new int[target + 1];
        // 初始化：空集的组合数为 1
        dp[0] = 1;
        
        // 遍历所有目标数
        for (int i = 1; i <= target; i++) {
            // 遍历所有可用的数字
            for (int num : nums) {
                // 如果当前数字小于等于目标数，则可以使用
                if (i >= num) {
                    dp[i] += dp[i - num];
                }
            }
        }
        
        return dp[target];
    }

    public static void main(String[] args) {
        L0377_CombinationSumIV solution = new L0377_CombinationSumIV();
        
        // 测试用例 1
        int[] nums1 = {1, 2, 3};
        int target1 = 4;
        System.out.println("测试用例 1：");
        System.out.println("输入：nums = " + Arrays.toString(nums1) + ", target = " + target1);
        System.out.println("输出：" + solution.combinationSum4(nums1, target1));
        System.out.println();
        
        // 测试用例 2
        int[] nums2 = {9};
        int target2 = 3;
        System.out.println("测试用例 2：");
        System.out.println("输入：nums = " + Arrays.toString(nums2) + ", target = " + target2);
        System.out.println("输出：" + solution.combinationSum4(nums2, target2));
    }
} 
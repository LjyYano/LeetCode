import java.util.*;

/**
 * https://leetcode.cn/problems/partition-equal-subset-sum/description/
 * 
 * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * 
 * 示例 1：
 * 输入：nums = [1,5,11,5]
 * 输出：true
 * 解释：数组可以分割成 [1, 5, 5] 和 [11]
 * 
 * 示例 2：
 * 输入：nums = [1,2,3,5]
 * 输出：false
 * 解释：数组不能分割成两个元素和相等的子集。
 */
public class L0416_PartitionEqualSubsetSum {

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        
        // 如果总和为奇数，无法分割成两个相等的子集
        if (sum % 2 != 0) {
            return false;
        }
        
        int target = sum / 2;
        // dp[i] 表示是否可以从数组中选择若干个数，使得它们的和为 i
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;  // 空集的和为 0
        
        // 对于每个数字，更新所有可能的和
        for (int num : nums) {
            // 从大到小遍历，避免重复使用同一个数字
            for (int i = target; i >= num; i--) {
                dp[i] = dp[i] || dp[i - num];
            }
        }
        
        return dp[target];
    }

    public static void main(String[] args) {
        L0416_PartitionEqualSubsetSum solution = new L0416_PartitionEqualSubsetSum();
        
        // 测试用例1
        int[] nums1 = {1, 5, 11, 5};
        System.out.println("测试用例1：");
        System.out.println("输入：nums = " + Arrays.toString(nums1));
        System.out.println("输出：" + solution.canPartition(nums1));
        
        // 测试用例2
        int[] nums2 = {1, 2, 3, 5};
        System.out.println("\n测试用例2：");
        System.out.println("输入：nums = " + Arrays.toString(nums2));
        System.out.println("输出：" + solution.canPartition(nums2));
        
        // 测试用例3
        int[] nums3 = {1, 2, 5};
        System.out.println("\n测试用例3：");
        System.out.println("输入：nums = " + Arrays.toString(nums3));
        System.out.println("输出：" + solution.canPartition(nums3));
    }
} 
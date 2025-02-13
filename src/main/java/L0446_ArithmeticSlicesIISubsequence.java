import java.util.*;

/**
 * https://leetcode.cn/problems/arithmetic-slices-ii-subsequence/
 * 
 * 给你一个整数数组 nums ，返回 nums 中所有等差子序列的数目。
 * 
 * 如果一个序列中至少有三个元素，并且任意两个相邻元素之差相同，则称该序列为等差序列。
 * 
 * 例如，[1, 3, 5, 7, 9]、[7, 7, 7, 7] 和 [3, -1, -5, -9] 都是等差序列。
 * 再例如，[1, 1, 2, 5, 7] 不是等差序列。
 * 
 * 数组中的子序列是从数组中删除一些元素（也可能不删除）得到的一个序列。
 * 
 * 例如，[2,5,10] 是 [1,2,1,2,4,1,5,10] 的一个子序列。
 * 
 * 题目数据保证答案是一个 32-bit 整数。
 * 
 * 示例 1：
 * 输入：nums = [2,4,6,8,10]
 * 输出：7
 * 解释：所有的等差子序列为：
 * [2,4,6]
 * [4,6,8]
 * [6,8,10]
 * [2,4,6,8]
 * [4,6,8,10]
 * [2,4,6,8,10]
 * [2,6,10]
 * 
 * 示例 2：
 * 输入：nums = [7,7,7,7,7]
 * 输出：16
 * 解释：数组中的任意子序列都是等差子序列。
 * 
 * 提示：
 * 1 <= nums.length <= 1000
 * -2³¹ <= nums[i] <= 2³¹ - 1
 */
public class L0446_ArithmeticSlicesIISubsequence {

    // 使用动态规划解决
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        // dp[i][d] 表示以 nums[i] 结尾，公差为 d 的等差序列的个数
        Map<Long, Integer>[] dp = new HashMap<>[n];
        for (int i = 0; i < n; i++) {
            dp[i] = new HashMap<>();
        }

        int result = 0;
        // 遍历每个数作为等差序列的最后一个数
        for (int i = 0; i < n; i++) {
            // 遍历之前的所有数，作为倒数第二个数
            for (int j = 0; j < i; j++) {
                // 计算公差，注意要用 long 避免溢出
                long diff = (long) nums[i] - nums[j];
                
                // 获取以 j 结尾，公差为 diff 的等差序列个数
                int count = dp[j].getOrDefault(diff, 0);
                
                // 将以 i 结尾，公差为 diff 的等差序列个数加上新的组合
                int origin = dp[i].getOrDefault(diff, 0);
                dp[i].put(diff, origin + count + 1);
                
                // 将长度大于等于 3 的等差序列加入结果
                result += count;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        L0446_ArithmeticSlicesIISubsequence solution = new L0446_ArithmeticSlicesIISubsequence();

        // 测试用例 1
        int[] nums1 = {2, 4, 6, 8, 10};
        System.out.println("测试用例 1 结果：" + solution.numberOfArithmeticSlices(nums1)); // 预期输出：7

        // 测试用例 2
        int[] nums2 = {7, 7, 7, 7, 7};
        System.out.println("测试用例 2 结果：" + solution.numberOfArithmeticSlices(nums2)); // 预期输出：16
    }
} 
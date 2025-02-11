import java.util.*;

/**
 * https://leetcode.cn/problems/arithmetic-slices/description/
 * 
 * 如果一个数字序列至少有三个元素，并且任意两个相邻元素之差相同，则称该序列为等差序列。
 * 例如，[1,3,5,7,9]、[7,7,7,7] 和 [3,-1,-5,-9] 都是等差序列。
 * 给你一个整数数组 nums ，返回数组 nums 中所有为等差序列的子数组个数。
 * 子数组是数组中的一个连续序列。
 * 
 * 示例 1：
 * 输入：nums = [1,2,3,4]
 * 输出：3
 * 解释：nums 中有三个子等差数组：[1, 2, 3]、[2, 3, 4] 和 [1,2,3,4]
 * 
 * 示例 2：
 * 输入：nums = [1]
 * 输出：0
 */
public class L0413_ArithmeticSlices {

    public int numberOfArithmeticSlices(int[] nums) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        
        int n = nums.length;
        // dp[i] 表示以 nums[i] 结尾的等差数列的个数
        int[] dp = new int[n];
        int sum = 0;
        
        // 从第三个元素开始遍历
        for (int i = 2; i < n; i++) {
            // 如果当前三个数构成等差数列
            if (nums[i] - nums[i-1] == nums[i-1] - nums[i-2]) {
                // 新的等差数列个数等于前一个位置的个数加 1
                dp[i] = dp[i-1] + 1;
                // 累加到结果中
                sum += dp[i];
            }
        }
        
        return sum;
    }

    public static void main(String[] args) {
        L0413_ArithmeticSlices solution = new L0413_ArithmeticSlices();
        
        // 测试用例1
        int[] nums1 = {1,2,3,4};
        System.out.println("测试用例1：");
        System.out.println("输入：nums = " + Arrays.toString(nums1));
        System.out.println("输出：" + solution.numberOfArithmeticSlices(nums1));
        
        // 测试用例2
        int[] nums2 = {1};
        System.out.println("\n测试用例2：");
        System.out.println("输入：nums = " + Arrays.toString(nums2));
        System.out.println("输出：" + solution.numberOfArithmeticSlices(nums2));
        
        // 测试用例3
        int[] nums3 = {1,2,3,4,5};
        System.out.println("\n测试用例3：");
        System.out.println("输入：nums = " + Arrays.toString(nums3));
        System.out.println("输出：" + solution.numberOfArithmeticSlices(nums3));
    }
} 
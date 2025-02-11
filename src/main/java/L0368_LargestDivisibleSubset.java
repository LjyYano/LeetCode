import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.cn/problems/largest-divisible-subset/
 * 
 * 给你一个由 无重复 正整数组成的集合 nums ，请你找出并返回其中最大的整除子集 answer ，子集中每一对 (answer[i], answer[j]) 都应当满足：
 * - answer[i] % answer[j] == 0，或
 * - answer[j] % answer[i] == 0
 * 如果存在多个有效解子集，返回其中任何一个均可。
 * 
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：[1,2]
 * 解释：[1,3] 也会被视为正确答案。
 * 
 * 示例 2：
 * 输入：nums = [1,2,4,8]
 * 输出：[1,2,4,8]
 * 
 * 提示：
 * - 1 <= nums.length <= 1000
 * - 1 <= nums[i] <= 2 * 10⁹
 * - nums 中的所有整数 互不相同
 */
public class L0368_LargestDivisibleSubset {
    
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        // 结果列表
        List<Integer> result = new ArrayList<>();
        if (n == 0) {
            return result;
        }
        
        // 先将数组排序
        Arrays.sort(nums);
        
        // dp[i] 表示以 nums[i] 结尾的最大整除子集的长度
        int[] dp = new int[n];
        // prev[i] 记录前一个数的索引，用于重建最大整除子集
        int[] prev = new int[n];
        
        // 初始化 dp 和 prev 数组
        Arrays.fill(dp, 1);
        Arrays.fill(prev, -1);
        
        // 记录最大长度和对应的索引
        int maxLen = 1;
        int maxIndex = 0;
        
        // 动态规划过程
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                // 如果 nums[i] 能整除 nums[j]，则可以将 nums[i] 加入以 nums[j] 结尾的子集
                if (nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }
            // 更新最大长度和对应的索引
            if (dp[i] > maxLen) {
                maxLen = dp[i];
                maxIndex = i;
            }
        }
        
        // 重建最大整除子集
        while (maxIndex != -1) {
            result.add(0, nums[maxIndex]);
            maxIndex = prev[maxIndex];
        }
        
        return result;
    }

    public static void main(String[] args) {
        L0368_LargestDivisibleSubset solution = new L0368_LargestDivisibleSubset();
        
        // 测试用例 1
        int[] nums1 = {1, 2, 3};
        System.out.println("测试用例 1：");
        System.out.println("输入：" + Arrays.toString(nums1));
        System.out.println("输出：" + solution.largestDivisibleSubset(nums1));
        
        // 测试用例 2
        int[] nums2 = {1, 2, 4, 8};
        System.out.println("\n测试用例 2：");
        System.out.println("输入：" + Arrays.toString(nums2));
        System.out.println("输出：" + solution.largestDivisibleSubset(nums2));
    }
} 
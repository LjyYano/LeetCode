/**
 * https://leetcode.cn/problems/4sum-ii/
 * 
 * 给你四个整数数组 nums1、nums2、nums3 和 nums4 ，数组长度都是 n ，请你计算有多少个元组 (i, j, k, l) 能满足：
 * 
 * 0 <= i, j, k, l < n
 * nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
 * 
 * 示例 1：
 * 输入：nums1 = [1,2], nums2 = [-2,-1], nums3 = [-1,2], nums4 = [0,2]
 * 输出：2
 * 解释：
 * 两个元组如下：
 * 1. (0, 0, 0, 1) -> nums1[0] + nums2[0] + nums3[0] + nums4[1] = 1 + (-2) + (-1) + 2 = 0
 * 2. (1, 1, 0, 0) -> nums1[1] + nums2[1] + nums3[0] + nums4[0] = 2 + (-1) + (-1) + 0 = 0
 * 
 * 示例 2：
 * 输入：nums1 = [0], nums2 = [0], nums3 = [0], nums4 = [0]
 * 输出：1
 * 
 * 提示：
 * n == nums1.length
 * n == nums2.length
 * n == nums3.length
 * n == nums4.length
 * 1 <= n <= 200
 * -2²⁸ <= nums1[i], nums2[i], nums3[i], nums4[i] <= 2²⁸ - 1
 */
public class L0454_FourSumII {
    
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        // 使用哈希表存储前两个数组的和及其出现次数
        java.util.Map<Integer, Integer> sumMap = new java.util.HashMap<>();
        
        // 计算前两个数组的所有可能的和
        for (int num1 : nums1) {
            for (int num2 : nums2) {
                int sum = num1 + num2;
                sumMap.put(sum, sumMap.getOrDefault(sum, 0) + 1);
            }
        }
        
        // 计算结果
        int result = 0;
        // 计算后两个数组的和，并查找其相反数是否在哈希表中
        for (int num3 : nums3) {
            for (int num4 : nums4) {
                int sum = num3 + num4;
                // 如果 -(num3 + num4) 在哈希表中，说明找到了和为 0 的组合
                result += sumMap.getOrDefault(-sum, 0);
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        L0454_FourSumII solution = new L0454_FourSumII();
        
        // 测试用例 1
        int[] nums1 = {1, 2};
        int[] nums2 = {-2, -1};
        int[] nums3 = {-1, 2};
        int[] nums4 = {0, 2};
        System.out.println("测试用例 1 结果：" + solution.fourSumCount(nums1, nums2, nums3, nums4)); // 预期输出：2
        
        // 测试用例 2
        int[] nums5 = {0};
        int[] nums6 = {0};
        int[] nums7 = {0};
        int[] nums8 = {0};
        System.out.println("测试用例 2 结果：" + solution.fourSumCount(nums5, nums6, nums7, nums8)); // 预期输出：1
    }
} 
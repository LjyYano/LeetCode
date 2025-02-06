import java.util.HashMap;
import java.util.Map;

/**
 * 题目链接：https://leetcode.cn/problems/two-sum/
 * 
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出和为目标值 target 的那两个整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 */
public class L0001_TwoSum {
    
    /**
     * 使用哈希表存储遍历过的数字及其索引，实现 O(n) 的时间复杂度
     * 
     * @param nums 输入数组
     * @param target 目标值
     * @return 满足条件的下标数组
     * @throws IllegalArgumentException 无解时抛出异常
     */
    public int[] twoSum(int[] nums, int target) {
        // 创建哈希表，用于存储数字到索引的映射
        Map<Integer, Integer> numMap = new HashMap<>();
        
        // 遍历数组
        for (int i = 0; i < nums.length; i++) {
            // 计算当前数字的补数
            int complement = target - nums[i];
            
            // 如果补数存在于哈希表中，说明找到了答案
            if (numMap.containsKey(complement)) {
                return new int[] { numMap.get(complement), i };
            }
            
            // 将当前数字及其索引存入哈希表
            numMap.put(nums[i], i);
        }
        
        // 如果没有找到答案，抛出异常
        throw new IllegalArgumentException("No solution");
    }

    public static void main(String[] args) {
        // 创建测试用例
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        
        L0001_TwoSum solution = new L0001_TwoSum();
        
        try {
            // 测试用例 1: nums = [2,7,11,15], target = 9
            int[] result1 = solution.twoSum(nums, target);
            System.out.println("测试用例 1:");
            System.out.printf("输入: nums = [2,7,11,15], target = 9%n");
            System.out.printf("输出: [%d,%d]%n", result1[0], result1[1]);
            
            // 测试用例 2: nums = [3,2,4], target = 6
            int[] nums2 = {3, 2, 4};
            int[] result2 = solution.twoSum(nums2, 6);
            System.out.println("\n测试用例 2:");
            System.out.printf("输入: nums = [3,2,4], target = 6%n");
            System.out.printf("输出: [%d,%d]%n", result2[0], result2[1]);
            
            // 测试用例 3: nums = [3,3], target = 6
            int[] nums3 = {3, 3};
            int[] result3 = solution.twoSum(nums3, 6);
            System.out.println("\n测试用例 3:");
            System.out.printf("输入: nums = [3,3], target = 6%n");
            System.out.printf("输出: [%d,%d]%n", result3[0], result3[1]);
            
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
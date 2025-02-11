import java.util.*;

/**
 * https://leetcode.cn/problems/maximum-xor-of-two-numbers-in-an-array/description/
 * 
 * 给你一个整数数组 nums ，返回 nums[i] XOR nums[j] 的最大运算结果，其中 0 ≤ i ≤ j < n 。
 * 
 * 示例 1：
 * 输入：nums = [3,10,5,25,2,8]
 * 输出：28
 * 解释：最大运算结果是 5 XOR 25 = 28.
 * 
 * 示例 2：
 * 输入：nums = [14,70,53,83,49,91,36,80,92,51,66,70]
 * 输出：127
 */
public class L0421_MaximumXOROfTwoNumbersInAnArray {

    public int findMaximumXOR(int[] nums) {
        int maxResult = 0;
        int mask = 0;
        
        // 从最高位开始检查
        // 因为数字是非负的，所以从 31 位开始
        for (int bit = 31; bit >= 0; bit--) {
            // 当前要考虑的位
            mask = mask | (1 << bit);
            
            // 使用 HashSet 存储前缀
            Set<Integer> prefixes = new HashSet<>();
            for (int num : nums) {
                // 只保留从最高位到当前位的前缀
                prefixes.add(num & mask);
            }
            
            // 假设当前位的结果为 1
            int candidate = maxResult | (1 << bit);
            
            // 检查是否存在两个数的异或结果等于 candidate
            for (int prefix : prefixes) {
                // 如果存在另一个数，使得它们的异或等于 candidate
                if (prefixes.contains(prefix ^ candidate)) {
                    maxResult = candidate;
                    break;
                }
            }
        }
        
        return maxResult;
    }

    public static void main(String[] args) {
        L0421_MaximumXOROfTwoNumbersInAnArray solution = new L0421_MaximumXOROfTwoNumbersInAnArray();
        
        // 测试用例1
        int[] nums1 = {3, 10, 5, 25, 2, 8};
        System.out.println("测试用例1：");
        System.out.println("输入：nums = " + Arrays.toString(nums1));
        System.out.println("输出：" + solution.findMaximumXOR(nums1));
        
        // 测试用例2
        int[] nums2 = {14, 70, 53, 83, 49, 91, 36, 80, 92, 51, 66, 70};
        System.out.println("\n测试用例2：");
        System.out.println("输入：nums = " + Arrays.toString(nums2));
        System.out.println("输出：" + solution.findMaximumXOR(nums2));
        
        // 测试用例3
        int[] nums3 = {8, 10, 2};
        System.out.println("\n测试用例3：");
        System.out.println("输入：nums = " + Arrays.toString(nums3));
        System.out.println("输出：" + solution.findMaximumXOR(nums3));
    }
} 
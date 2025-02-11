import java.util.*;

/**
 * https://leetcode.cn/problems/find-all-duplicates-in-an-array/
 * 
 * 给你一个长度为 n 的整数数组 nums ，其中 nums 的所有整数都在范围 [1, n] 内，且每个整数出现 一次 或 两次 。
 * 请你找出所有出现 两次 的整数，并以数组形式返回。
 * 你必须设计并实现一个时间复杂度为 O(n) 且仅使用常量额外空间的算法解决此问题。
 * 
 * 示例 1：
 * 输入：nums = [4,3,2,7,8,2,3,1]
 * 输出：[2,3]
 * 
 * 示例 2：
 * 输入：nums = [1,1,2]
 * 输出：[1]
 * 
 * 示例 3：
 * 输入：nums = [1]
 * 输出：[]
 */
public class L0442_FindAllDuplicatesInAnArray {
    
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        
        // 使用数组元素的正负号来标记是否出现过
        // 因为数组中的数字范围是 [1, n]，所以可以用数组本身来标记
        for (int i = 0; i < nums.length; i++) {
            // 获取当前数字的绝对值（因为可能被之前的操作变成负数）
            int num = Math.abs(nums[i]);
            // nums[num - 1] 为负数说明 num 之前出现过
            if (nums[num - 1] > 0) {
                nums[num - 1] = -nums[num - 1];
            } else {
                result.add(num);
            }
        }
        
        // 恢复数组（可选）
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Math.abs(nums[i]);
        }
        
        return result;
    }

    public static void main(String[] args) {
        L0442_FindAllDuplicatesInAnArray solution = new L0442_FindAllDuplicatesInAnArray();
        
        // 测试用例1
        int[] nums1 = {4,3,2,7,8,2,3,1};
        System.out.println("测试用例1：");
        System.out.println("输入：nums = " + Arrays.toString(nums1));
        System.out.println("输出：" + solution.findDuplicates(nums1));
        
        // 测试用例2
        int[] nums2 = {1,1,2};
        System.out.println("\n测试用例2：");
        System.out.println("输入：nums = " + Arrays.toString(nums2));
        System.out.println("输出：" + solution.findDuplicates(nums2));
        
        // 测试用例3
        int[] nums3 = {1};
        System.out.println("\n测试用例3：");
        System.out.println("输入：nums = " + Arrays.toString(nums3));
        System.out.println("输出：" + solution.findDuplicates(nums3));
    }
} 
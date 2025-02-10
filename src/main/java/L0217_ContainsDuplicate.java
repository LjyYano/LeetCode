import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.cn/problems/contains-duplicate/
 * 
 * 给你一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，返回 true ；如果数组中每个元素互不相同，返回 false 。
 * 
 * 示例 1：
 * 输入：nums = [1,2,3,1]
 * 输出：true
 * 
 * 示例 2：
 * 输入：nums = [1,2,3,4]
 * 输出：false
 * 
 * 示例 3：
 * 输入：nums = [1,1,1,3,3,4,3,2,4,2]
 * 输出：true
 * 
 * 提示：
 * - 1 <= nums.length <= 10⁵
 * - -10⁹ <= nums[i] <= 10⁹
 */
public class L0217_ContainsDuplicate {
    
    public boolean containsDuplicate(int[] nums) {
        // 使用 HashSet 存储已经遍历过的数字
        Set<Integer> seen = new HashSet<>();
        
        // 遍历数组
        for (int num : nums) {
            // 如果当前数字已经在集合中，说明找到了重复元素
            if (!seen.add(num)) {
                return true;
            }
        }
        
        // 如果遍历完都没有找到重复元素，返回 false
        return false;
    }

    public static void main(String[] args) {
        L0217_ContainsDuplicate solution = new L0217_ContainsDuplicate();
        
        // 测试用例 1
        int[] nums1 = {1, 2, 3, 1};
        System.out.println("测试用例 1：");
        System.out.println("输入：[1,2,3,1]");
        System.out.println("输出：" + solution.containsDuplicate(nums1));  // 预期输出：true
        
        // 测试用例 2
        int[] nums2 = {1, 2, 3, 4};
        System.out.println("\n测试用例 2：");
        System.out.println("输入：[1,2,3,4]");
        System.out.println("输出：" + solution.containsDuplicate(nums2));  // 预期输出：false
        
        // 测试用例 3
        int[] nums3 = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        System.out.println("\n测试用例 3：");
        System.out.println("输入：[1,1,1,3,3,4,3,2,4,2]");
        System.out.println("输出：" + solution.containsDuplicate(nums3));  // 预期输出：true
    }
} 
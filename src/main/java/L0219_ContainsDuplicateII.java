import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/contains-duplicate-ii/
 * 
 * 给你一个整数数组 nums 和一个整数 k ，判断数组中是否存在两个不同的索引 i 和 j ，
 * 满足 nums[i] == nums[j] 且 abs(i - j) <= k 。如果存在，返回 true ；否则，返回 false 。
 * 
 * 示例 1：
 * 输入：nums = [1,2,3,1], k = 3
 * 输出：true
 * 
 * 示例 2：
 * 输入：nums = [1,0,1,1], k = 1
 * 输出：true
 * 
 * 示例 3：
 * 输入：nums = [1,2,3,1,2,3], k = 2
 * 输出：false
 * 
 * 提示：
 * - 1 <= nums.length <= 10⁵
 * - -10⁹ <= nums[i] <= 10⁹
 * - 0 <= k <= 10⁵
 */
public class L0219_ContainsDuplicateII {
    
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // 使用 HashMap 存储每个数字最后一次出现的位置
        Map<Integer, Integer> numMap = new HashMap<>();
        
        // 遍历数组
        for (int i = 0; i < nums.length; i++) {
            // 如果当前数字已经在 map 中，检查索引差是否小于等于 k
            if (numMap.containsKey(nums[i])) {
                int prevIndex = numMap.get(nums[i]);
                if (i - prevIndex <= k) {
                    return true;
                }
            }
            // 更新当前数字的位置
            numMap.put(nums[i], i);
        }
        
        return false;
    }

    public static void main(String[] args) {
        L0219_ContainsDuplicateII solution = new L0219_ContainsDuplicateII();
        
        // 测试用例 1
        int[] nums1 = {1, 2, 3, 1};
        int k1 = 3;
        System.out.println("测试用例 1：");
        System.out.println("输入：nums = [1,2,3,1], k = 3");
        System.out.println("输出：" + solution.containsNearbyDuplicate(nums1, k1));  // 预期输出：true
        
        // 测试用例 2
        int[] nums2 = {1, 0, 1, 1};
        int k2 = 1;
        System.out.println("\n测试用例 2：");
        System.out.println("输入：nums = [1,0,1,1], k = 1");
        System.out.println("输出：" + solution.containsNearbyDuplicate(nums2, k2));  // 预期输出：true
        
        // 测试用例 3
        int[] nums3 = {1, 2, 3, 1, 2, 3};
        int k3 = 2;
        System.out.println("\n测试用例 3：");
        System.out.println("输入：nums = [1,2,3,1,2,3], k = 2");
        System.out.println("输出：" + solution.containsNearbyDuplicate(nums3, k3));  // 预期输出：false
    }
} 
import java.util.Arrays;

/**
 * https://leetcode.cn/problems/minimum-moves-to-equal-array-elements-ii/
 * 
 * 给你一个长度为 n 的整数数组 nums ，返回使所有数组元素相等需要的最少移动数。
 * 
 * 在一步操作中，你可以使数组中的一个元素加 1 或者减 1 。
 * 
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：2
 * 解释：
 * 只需要两步操作（每步操作指南使一个元素加 1 或减 1）：
 * [1,2,3]  =>  [2,2,3]  =>  [2,2,2]
 * 
 * 示例 2：
 * 输入：nums = [1,10,2,9]
 * 输出：16
 * 
 * 提示：
 * n == nums.length
 * 1 <= nums.length <= 10⁵
 * -10⁹ <= nums[i] <= 10⁹
 */
public class L0462_MinimumMovesToEqualArrayElementsII {
    
    public int minMoves2(int[] nums) {
        // 对数组进行排序
        Arrays.sort(nums);
        
        // 找到中位数
        int median = nums[nums.length / 2];
        
        // 计算所有数字到中位数的距离之和
        int moves = 0;
        for (int num : nums) {
            moves += Math.abs(num - median);
        }
        
        return moves;
    }

    public static void main(String[] args) {
        L0462_MinimumMovesToEqualArrayElementsII solution = new L0462_MinimumMovesToEqualArrayElementsII();
        
        // 测试用例 1
        int[] nums1 = {1, 2, 3};
        System.out.println("测试用例 1：");
        System.out.println("输入：" + Arrays.toString(nums1));
        System.out.println("输出：" + solution.minMoves2(nums1));  // 预期输出：2
        System.out.println();
        
        // 测试用例 2
        int[] nums2 = {1, 10, 2, 9};
        System.out.println("测试用例 2：");
        System.out.println("输入：" + Arrays.toString(nums2));
        System.out.println("输出：" + solution.minMoves2(nums2));  // 预期输出：16
    }
} 
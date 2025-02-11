/**
 * https://leetcode.cn/problems/minimum-moves-to-equal-array-elements/
 * 
 * 给你一个长度为 n 的整数数组，每次操作将会使 n - 1 个元素增加 1。返回让数组所有元素相等的最小操作次数。
 * 
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：3
 * 解释：
 * 只需要3次操作（注意每次操作会增加两个元素的值）：
 * [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
 * 
 * 示例 2：
 * 输入：nums = [1,1,1]
 * 输出：0
 * 
 * 提示：
 * n == nums.length
 * 1 <= nums.length <= 10⁵
 * -10⁹ <= nums[i] <= 10⁹
 */
public class L0453_MinimumMovesToEqualArrayElements {
    
    public int minMoves(int[] nums) {
        // 找到数组中的最小值
        int min = nums[0];
        for (int num : nums) {
            min = Math.min(min, num);
        }
        
        // 计算将所有元素减到最小值需要的操作次数
        int moves = 0;
        for (int num : nums) {
            moves += num - min;
        }
        
        return moves;
    }

    public static void main(String[] args) {
        L0453_MinimumMovesToEqualArrayElements solution = new L0453_MinimumMovesToEqualArrayElements();
        
        // 测试用例 1
        int[] nums1 = {1, 2, 3};
        System.out.println("测试用例 1 结果：" + solution.minMoves(nums1)); // 预期输出：3
        
        // 测试用例 2
        int[] nums2 = {1, 1, 1};
        System.out.println("测试用例 2 结果：" + solution.minMoves(nums2)); // 预期输出：0
        
        // 测试用例 3：较大的数组
        int[] nums3 = {1, 2, 3, 4, 5};
        System.out.println("测试用例 3 结果：" + solution.minMoves(nums3)); // 预期输出：10
    }
} 
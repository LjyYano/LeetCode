/**
 * https://leetcode.cn/problems/find-all-numbers-disappeared-in-an-array/
 * 
 * 给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数字，并以数组的形式返回结果。
 * 
 * 示例 1：
 * 输入：nums = [4,3,2,7,8,2,3,1]
 * 输出：[5,6]
 * 
 * 示例 2：
 * 输入：nums = [1,1]
 * 输出：[2]
 * 
 * 提示：
 * n == nums.length
 * 1 <= n <= 10⁵
 * 1 <= nums[i] <= n
 * 
 * 进阶：你能在不使用额外空间且时间复杂度为 O(n) 的情况下解决这个问题吗? 你可以假定返回的数组不算在额外空间内。
 */
public class L0448_FindAllNumbersDisappearedInAnArray {

    // 使用原数组作为标记数组
    public java.util.List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        
        // 将每个数对应位置的数加上 n
        for (int i = 0; i < n; i++) {
            // 获取当前数字对应的索引（减 1 是因为数字范围是 1 到 n）
            int index = (nums[i] - 1) % n;
            // 在对应位置的数字上加 n
            nums[index] += n;
        }
        
        // 收集结果
        java.util.List<Integer> result = new java.util.ArrayList<>();
        for (int i = 0; i < n; i++) {
            // 如果某个位置的数字小于等于 n，说明没有数字映射到这个位置
            if (nums[i] <= n) {
                // 将索引加 1 得到消失的数字
                result.add(i + 1);
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        L0448_FindAllNumbersDisappearedInAnArray solution = new L0448_FindAllNumbersDisappearedInAnArray();

        // 测试用例 1
        int[] nums1 = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println("测试用例 1 结果：" + solution.findDisappearedNumbers(nums1)); // 预期输出：[5, 6]

        // 测试用例 2
        int[] nums2 = {1, 1};
        System.out.println("测试用例 2 结果：" + solution.findDisappearedNumbers(nums2)); // 预期输出：[2]
    }
} 
/**
 * https://leetcode.cn/problems/increasing-triplet-subsequence/
 * 
 * 给你一个整数数组 nums ，判断这个数组中是否存在长度为 3 的递增子序列。
 * 
 * 如果存在这样的三元组下标 (i, j, k) 且满足 i < j < k ，使得 nums[i] < nums[j] < nums[k] ，返回 true ；否则，返回 false 。
 * 
 * 示例 1：
 * 输入：nums = [1,2,3,4,5]
 * 输出：true
 * 解释：任何 i < j < k 的三元组都满足题意
 * 
 * 示例 2：
 * 输入：nums = [5,4,3,2,1]
 * 输出：false
 * 解释：不存在满足题意的三元组
 * 
 * 示例 3：
 * 输入：nums = [2,1,5,0,4,6]
 * 输出：true
 * 解释：三元组 (3, 4, 5) 满足题意，因为 nums[3] == 0 < nums[4] == 4 < nums[5] == 6
 * 
 * 提示：
 * 1 <= nums.length <= 5 * 10⁵
 * -2³¹ <= nums[i] <= 2³¹ - 1
 * 
 * 进阶：你能实现时间复杂度为 O(n) ，空间复杂度为 O(1) 的解决方案吗？
 */

public class L0334_IncreasingTripletSubsequence {
    
    /**
     * 查找递增的三元子序列
     * 时间复杂度：O(n)，其中 n 是数组的长度
     * 空间复杂度：O(1)，只使用了两个变量
     */
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        
        // first 记录最小的数，second 记录第二小的数
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        
        // 遍历数组，维护 first 和 second
        for (int num : nums) {
            if (num <= first) {
                // 更新最小值
                first = num;
            } else if (num <= second) {
                // 更新第二小的值
                second = num;
            } else {
                // 找到了一个大于 first 和 second 的值，存在递增三元组
                return true;
            }
        }
        
        return false;
    }

    public static void main(String[] args) {
        L0334_IncreasingTripletSubsequence solution = new L0334_IncreasingTripletSubsequence();
        
        // 测试用例 1
        int[] nums1 = {1, 2, 3, 4, 5};
        System.out.println("测试用例 1：");
        System.out.println("输入：[1,2,3,4,5]");
        System.out.println("输出：" + solution.increasingTriplet(nums1));
        System.out.println("预期输出：true");
        System.out.println();
        
        // 测试用例 2
        int[] nums2 = {5, 4, 3, 2, 1};
        System.out.println("测试用例 2：");
        System.out.println("输入：[5,4,3,2,1]");
        System.out.println("输出：" + solution.increasingTriplet(nums2));
        System.out.println("预期输出：false");
        System.out.println();
        
        // 测试用例 3
        int[] nums3 = {2, 1, 5, 0, 4, 6};
        System.out.println("测试用例 3：");
        System.out.println("输入：[2,1,5,0,4,6]");
        System.out.println("输出：" + solution.increasingTriplet(nums3));
        System.out.println("预期输出：true");
    }
} 
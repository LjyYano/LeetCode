/**
 * 题目链接：https://leetcode.cn/problems/first-missing-positive/
 * 
 * 给你一个未排序的整数数组 nums，请你找出其中没有出现的最小的正整数。
 * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
 * 
 * 示例 1：
 * 输入：nums = [1,2,0]
 * 输出：3
 * 解释：数字 1 和 2 都出现了，所以最小的缺失正数是 3
 * 
 * 示例 2：
 * 输入：nums = [3,4,-1,1]
 * 输出：2
 * 解释：数字 1、3、4 都出现了，所以最小的缺失正数是 2
 * 
 * 示例 3：
 * 输入：nums = [7,8,9,11,12]
 * 输出：1
 * 解释：最小的正数 1 没有出现，所以返回 1
 */
public class L0041_FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        
        // 第一步：将负数和零修改为 n+1
        // 因为我们只关心 1 到 n 范围内的数
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0) {
                nums[i] = n + 1;
            }
        }
        
        // 第二步：将数组中的每个数对应的位置标记为负数
        // 例如，如果遇到数字 5，就将 nums[4] 标记为负数
        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]);
            if (num <= n) {
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }
        
        // 第三步：找到第一个正数的位置
        // 如果位置 i 上的数是正数，说明数字 i+1 没有出现过
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        
        // 如果所有位置都是负数，说明 1 到 n 都出现了
        // 那么缺失的最小正数就是 n+1
        return n + 1;
    }

    public static void main(String[] args) {
        L0041_FirstMissingPositive solution = new L0041_FirstMissingPositive();
        
        // 测试用例 1
        int[] nums1 = {1, 2, 0};
        System.out.println("测试用例 1：");
        System.out.println("输入：nums = [1,2,0]");
        System.out.println("输出：" + solution.firstMissingPositive(nums1));
        // 预期输出：3
        
        // 测试用例 2
        int[] nums2 = {3, 4, -1, 1};
        System.out.println("\n测试用例 2：");
        System.out.println("输入：nums = [3,4,-1,1]");
        System.out.println("输出：" + solution.firstMissingPositive(nums2));
        // 预期输出：2
        
        // 测试用例 3
        int[] nums3 = {7, 8, 9, 11, 12};
        System.out.println("\n测试用例 3：");
        System.out.println("输入：nums = [7,8,9,11,12]");
        System.out.println("输出：" + solution.firstMissingPositive(nums3));
        // 预期输出：1
    }
} 
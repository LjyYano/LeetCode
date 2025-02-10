import java.util.Arrays;

/**
 * https://leetcode.cn/problems/wiggle-sort-ii/
 * 
 * 给你一个整数数组 nums，将它重新排列成 nums[0] < nums[1] > nums[2] < nums[3]... 的顺序。
 * 
 * 你可以假设所有输入数组都可以得到满足题目要求的结果。
 * 
 * 示例 1：
 * 输入：nums = [1,5,1,1,6,4]
 * 输出：[1,6,1,5,1,4]
 * 解释：[1,4,1,5,1,6] 同样是符合题目要求的结果，可以被判题程序接受。
 * 
 * 示例 2：
 * 输入：nums = [1,3,2,2,3,1]
 * 输出：[2,3,1,3,1,2]
 * 
 * 提示：
 * - 1 <= nums.length <= 5 * 10⁴
 * - 0 <= nums[i] <= 5000
 * - 题目数据保证，对于给定的输入 nums ，总能产生满足题目要求的结果
 * 
 * 进阶：你能用 O(n) 时间复杂度和 / 或原地 O(1) 额外空间来实现吗？
 */
public class L0324_WiggleSortII {
    
    public void wiggleSort(int[] nums) {
        // 先将数组复制一份
        int[] copy = nums.clone();
        // 对复制的数组进行排序
        Arrays.sort(copy);
        
        int n = nums.length;
        // 找到中位数的位置
        int mid = (n - 1) / 2;
        int right = n - 1;
        
        // 从大到小交替放置
        // 较小的一半放在奇数位置，较大的一半放在偶数位置
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                nums[i] = copy[mid--];
            } else {
                nums[i] = copy[right--];
            }
        }
    }

    public static void main(String[] args) {
        L0324_WiggleSortII solution = new L0324_WiggleSortII();
        
        // 测试用例 1
        int[] nums1 = {1, 5, 1, 1, 6, 4};
        solution.wiggleSort(nums1);
        System.out.println(Arrays.toString(nums1));  // 预期输出：[1,6,1,5,1,4]
        
        // 测试用例 2
        int[] nums2 = {1, 3, 2, 2, 3, 1};
        solution.wiggleSort(nums2);
        System.out.println(Arrays.toString(nums2));  // 预期输出：[2,3,1,3,1,2]
    }
}
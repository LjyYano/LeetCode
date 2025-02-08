/**
 * https://leetcode.cn/problems/search-insert-position/
 * 35. 搜索插入位置
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 请必须使用时间复杂度为 O(log n) 的算法。
 *
 * 示例 1:
 * 输入: nums = [1,3,5,6], target = 5
 * 输出: 2
 *
 * 示例 2:
 * 输入: nums = [1,3,5,6], target = 2
 * 输出: 1
 *
 * 示例 3:
 * 输入: nums = [1,3,5,6], target = 7
 * 输出: 4
 *
 * 提示:
 * 1 <= nums.length <= 10^4
 * -10^4 <= nums[i] <= 10^4
 * nums 为 无重复元素 的 升序 排列数组
 * -10^4 <= target <= 10^4
 */
public class L0035_SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        // 使用二分查找
        int left = 0;
        int right = nums.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        // 如果没找到目标值，left 就是它应该插入的位置
        return left;
    }

    public static void main(String[] args) {
        L0035_SearchInsertPosition solution = new L0035_SearchInsertPosition();
        
        // 测试用例 1
        int[] nums1 = {1, 3, 5, 6};
        int target1 = 5;
        System.out.println("测试用例 1：" + solution.searchInsert(nums1, target1)); // 预期输出：2
        
        // 测试用例 2
        int[] nums2 = {1, 3, 5, 6};
        int target2 = 2;
        System.out.println("测试用例 2：" + solution.searchInsert(nums2, target2)); // 预期输出：1
        
        // 测试用例 3
        int[] nums3 = {1, 3, 5, 6};
        int target3 = 7;
        System.out.println("测试用例 3：" + solution.searchInsert(nums3, target3)); // 预期输出：4
        
        // 测试用例 4：边界情况，目标值小于所有元素
        int[] nums4 = {1, 3, 5, 6};
        int target4 = 0;
        System.out.println("测试用例 4：" + solution.searchInsert(nums4, target4)); // 预期输出：0
    }
} 
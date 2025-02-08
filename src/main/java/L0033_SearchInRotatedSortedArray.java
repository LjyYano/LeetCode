/**
 * https://leetcode.cn/problems/search-in-rotated-sorted-array/
 * 
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 * 
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 * 
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
 * 
 * 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
 */
public class L0033_SearchInRotatedSortedArray {

    public static void main(String[] args) {
        // 测试用例
        L0033_SearchInRotatedSortedArray solution = new L0033_SearchInRotatedSortedArray();
        
        // 测试用例 1
        int[] nums1 = {4, 5, 6, 7, 0, 1, 2};
        int target1 = 0;
        System.out.println(solution.search(nums1, target1)); // 预期输出: 4
        
        // 测试用例 2
        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        int target2 = 3;
        System.out.println(solution.search(nums2, target2)); // 预期输出: -1
        
        // 测试用例 3
        int[] nums3 = {1};
        int target3 = 0;
        System.out.println(solution.search(nums3, target3)); // 预期输出: -1
    }

    public int search(int[] nums, int target) {
        // 特殊情况处理
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        int left = 0;
        int right = nums.length - 1;
        
        // 二分查找
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            // 找到目标值
            if (nums[mid] == target) {
                return mid;
            }
            
            // 判断哪部分是有序的
            if (nums[left] <= nums[mid]) {
                // 左半部分有序
                if (target >= nums[left] && target < nums[mid]) {
                    // target 在左半部分
                    right = mid - 1;
                } else {
                    // target 在右半部分
                    left = mid + 1;
                }
            } else {
                // 右半部分有序
                if (target > nums[mid] && target <= nums[right]) {
                    // target 在右半部分
                    left = mid + 1;
                } else {
                    // target 在左半部分
                    right = mid - 1;
                }
            }
        }
        
        return -1;
    }
} 
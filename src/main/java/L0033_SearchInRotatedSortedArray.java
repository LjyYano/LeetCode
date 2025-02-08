// 搜索旋转排序数组
// https://leetcode.cn/problems/search-in-rotated-sorted-array/
// 
// 整数数组 nums 按升序排列，数组中的值互不相同。
// 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了旋转，
// 使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]。
// 例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2]。
// 给你旋转后的数组 nums 和一个整数 target，如果 nums 中存在这个目标值 target，则返回它的下标，否则返回 -1。
// 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
//
// 示例 1：
// 输入：nums = [4,5,6,7,0,1,2], target = 0
// 输出：4
//
// 示例 2：
// 输入：nums = [4,5,6,7,0,1,2], target = 3
// 输出：-1
//
// 示例 3：
// 输入：nums = [1], target = 0
// 输出：-1
//
// 提示：
// 1 <= nums.length <= 5000
// -10^4 <= nums[i] <= 10^4
// nums 中的每个值都独一无二
// nums 肯定在某个点上旋转过
// -10^4 <= target <= 10^4

class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        int left = 0;
        int right = nums.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) {
                return mid;
            }
            
            // 判断左半部分是否有序
            if (nums[left] <= nums[mid]) {
                // 目标值在左半部分
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } 
            // 右半部分有序
            else {
                // 目标值在右半部分
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        
        return -1;
    }
} 
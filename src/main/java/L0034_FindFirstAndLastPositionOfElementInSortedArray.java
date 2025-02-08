/**
 * https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/
 * 
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 * 
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * 
 * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
 * 
 * 示例 1：
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * 
 * 示例 2：
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 * 
 * 示例 3：
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 * 
 * 提示：
 * 0 <= nums.length <= 10⁵
 * -10⁹ <= nums[i] <= 10⁹
 * nums 是一个非递减数组
 * -10⁹ <= target <= 10⁹
 */
public class L0034_FindFirstAndLastPositionOfElementInSortedArray {

    public static void main(String[] args) {
        // 测试用例 1
        int[] nums1 = {5, 7, 7, 8, 8, 10};
        int target1 = 8;
        int[] result1 = new L0034_FindFirstAndLastPositionOfElementInSortedArray().searchRange(nums1, target1);
        System.out.println("测试用例 1：" + result1[0] + ", " + result1[1]); // 预期输出：[3, 4]

        // 测试用例 2
        int[] nums2 = {5, 7, 7, 8, 8, 10};
        int target2 = 6;
        int[] result2 = new L0034_FindFirstAndLastPositionOfElementInSortedArray().searchRange(nums2, target2);
        System.out.println("测试用例 2：" + result2[0] + ", " + result2[1]); // 预期输出：[-1, -1]

        // 测试用例 3
        int[] nums3 = {};
        int target3 = 0;
        int[] result3 = new L0034_FindFirstAndLastPositionOfElementInSortedArray().searchRange(nums3, target3);
        System.out.println("测试用例 3：" + result3[0] + ", " + result3[1]); // 预期输出：[-1, -1]
    }

    public int[] searchRange(int[] nums, int target) {
        // 初始化结果数组
        int[] result = {-1, -1};
        
        // 处理边界情况
        if (nums == null || nums.length == 0) {
            return result;
        }
        
        // 查找第一个位置
        result[0] = findFirstPosition(nums, target);
        // 如果没找到第一个位置，直接返回 [-1, -1]
        if (result[0] == -1) {
            return result;
        }
        
        // 查找最后一个位置
        result[1] = findLastPosition(nums, target);
        
        return result;
    }
    
    // 查找目标值的第一个位置
    private int findFirstPosition(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) {
                // 如果是第一个位置或前一个数小于目标值，则找到第一个位置
                if (mid == 0 || nums[mid - 1] < target) {
                    return mid;
                }
                // 否则继续在左半部分查找
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return -1;
    }
    
    // 查找目标值的最后一个位置
    private int findLastPosition(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) {
                // 如果是最后一个位置或后一个数大于目标值，则找到最后一个位置
                if (mid == nums.length - 1 || nums[mid + 1] > target) {
                    return mid;
                }
                // 否则继续在右半部分查找
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return -1;
    }
} 
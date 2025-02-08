/**
 * https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/
 * 
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
 */
public class L0034_FindFirstAndLastPositionOfElementInSortedArray {

    public static int[] searchRange(int[] nums, int target) {
        // 分别查找左边界和右边界
        int leftBound = findBound(nums, target, true);
        int rightBound = findBound(nums, target, false);
        return new int[]{leftBound, rightBound};
    }

    // 查找边界的辅助函数
    // isLeft 为 true 时查找左边界，为 false 时查找右边界
    private static int findBound(int[] nums, int target, boolean isLeft) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) {
                if (isLeft) {
                    // 查找左边界时，即使找到了目标值也继续向左查找
                    if (mid == 0 || nums[mid - 1] != target) {
                        return mid;
                    }
                    right = mid - 1;
                } else {
                    // 查找右边界时，即使找到了目标值也继续向右查找
                    if (mid == nums.length - 1 || nums[mid + 1] != target) {
                        return mid;
                    }
                    left = mid + 1;
                }
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return -1;
    }

    public static void main(String[] args) {
        // 测试用例 1
        int[] nums1 = {5, 7, 7, 8, 8, 10};
        int target1 = 8;
        int[] result1 = searchRange(nums1, target1);
        System.out.println("Test case 1: [" + result1[0] + ", " + result1[1] + "]"); // 应输出 [3, 4]

        // 测试用例 2
        int[] nums2 = {5, 7, 7, 8, 8, 10};
        int target2 = 6;
        int[] result2 = searchRange(nums2, target2);
        System.out.println("Test case 2: [" + result2[0] + ", " + result2[1] + "]"); // 应输出 [-1, -1]

        // 测试用例 3
        int[] nums3 = {};
        int target3 = 0;
        int[] result3 = searchRange(nums3, target3);
        System.out.println("Test case 3: [" + result3[0] + ", " + result3[1] + "]"); // 应输出 [-1, -1]
    }
} 
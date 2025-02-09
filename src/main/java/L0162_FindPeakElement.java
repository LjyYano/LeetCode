/**
 * https://leetcode.cn/problems/find-peak-element/
 * 
 * 峰值元素是指其值严格大于左右相邻值的元素。
 * 
 * 给你一个整数数组 nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
 * 
 * 你可以假设 nums[-1] = nums[n] = -∞ 。
 * 
 * 你必须实现时间复杂度为 O(log n) 的算法来解决此问题。
 * 
 * 示例 1：
 * 输入：nums = [1,2,3,1]
 * 输出：2
 * 解释：3 是峰值元素，你的函数应该返回其索引 2。
 * 
 * 示例 2：
 * 输入：nums = [1,2,1,3,5,6,4]
 * 输出：1 或 5 
 * 解释：你的函数可以返回索引 1，其峰值元素为 2；或者返回索引 5，其峰值元素为 6。
 * 
 * 提示：
 * - 1 <= nums.length <= 1000
 * - -2³¹ <= nums[i] <= 2³¹ - 1
 * - 对于所有有效的 i 都有 nums[i] != nums[i + 1]
 */
public class L0162_FindPeakElement {
    
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        // 如果数组只有一个元素，它就是峰值
        if (nums.length == 1) {
            return 0;
        }
        
        // 如果第一个元素大于第二个元素，它就是峰值
        if (nums[0] > nums[1]) {
            return 0;
        }
        
        // 如果最后一个元素大于倒数第二个元素，它就是峰值
        if (nums[nums.length - 1] > nums[nums.length - 2]) {
            return nums.length - 1;
        }
        
        // 使用二分查找
        int left = 1;
        int right = nums.length - 2;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            // 如果中间元素大于其左右相邻元素，它就是峰值
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            }
            // 如果左边元素大于中间元素，说明左边一定有峰值
            else if (nums[mid - 1] > nums[mid]) {
                right = mid - 1;
            }
            // 否则右边一定有峰值
            else {
                left = mid + 1;
            }
        }
        
        return -1;  // 理论上不会到达这里
    }

    public static void main(String[] args) {
        L0162_FindPeakElement solution = new L0162_FindPeakElement();
        
        // 测试用例 1
        int[] nums1 = {1, 2, 3, 1};
        System.out.println("输入：[1, 2, 3, 1]");
        System.out.println("输出：" + solution.findPeakElement(nums1));  // 预期输出：2
        
        // 测试用例 2
        int[] nums2 = {1, 2, 1, 3, 5, 6, 4};
        System.out.println("\n输入：[1, 2, 1, 3, 5, 6, 4]");
        System.out.println("输出：" + solution.findPeakElement(nums2));  // 预期输出：1 或 5
    }
} 
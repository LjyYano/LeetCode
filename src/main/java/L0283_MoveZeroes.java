import java.util.Arrays;

/**
 * https://leetcode.cn/problems/move-zeroes/
 * 
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 
 * 请注意，必须在不复制数组的情况下原地对数组进行操作。
 * 
 * 示例 1:
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 
 * 示例 2:
 * 输入: nums = [0]
 * 输出: [0]
 * 
 * 提示:
 * - 1 <= nums.length <= 10⁴
 * - -2³¹ <= nums[i] <= 2³¹ - 1
 */
public class L0283_MoveZeroes {
    
    public void moveZeroes(int[] nums) {
        // 如果数组为空，直接返回
        if (nums == null || nums.length == 0) {
            return;
        }
        
        // 使用双指针，slow 指向当前需要填入非零元素的位置
        int slow = 0;
        // fast 用于遍历数组
        for (int fast = 0; fast < nums.length; fast++) {
            // 当遇到非零元素时，将其移动到 slow 位置
            if (nums[fast] != 0) {
                // 如果两个指针不相同，才需要交换
                if (slow != fast) {
                    nums[slow] = nums[fast];
                    nums[fast] = 0;
                }
                slow++;
            }
        }
    }

    public static void main(String[] args) {
        L0283_MoveZeroes solution = new L0283_MoveZeroes();
        
        // 测试用例 1
        int[] nums1 = {0, 1, 0, 3, 12};
        solution.moveZeroes(nums1);
        System.out.println(Arrays.toString(nums1));  // 预期输出：[1, 3, 12, 0, 0]
        
        // 测试用例 2
        int[] nums2 = {0};
        solution.moveZeroes(nums2);
        System.out.println(Arrays.toString(nums2));  // 预期输出：[0]
    }
} 
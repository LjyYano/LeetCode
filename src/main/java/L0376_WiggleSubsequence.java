/**
 * https://leetcode.cn/problems/wiggle-subsequence/
 * 
 * 如果连续数字之间的差严格地在正数和负数之间交替，则数字序列称为摆动序列。
 * 第一个差（如果存在的话）可能是正数或负数。仅有一个元素或者含两个不等元素的序列也视作摆动序列。
 * 
 * 例如， [1, 7, 4, 9, 2, 5] 是一个摆动序列，因为差值 (6, -3, 5, -7, 3) 是正负交替出现的。
 * 相反，[1, 4, 7, 2, 5] 和 [1, 7, 4, 5, 5] 不是摆动序列，第一个序列是因为它的前两个差值都是正数，
 * 第二个序列是因为它的最后一个差值为零。
 * 
 * 给你一个整数数组 nums ，返回 nums 中作为摆动序列的最长子序列的长度。
 * 
 * 示例 1：
 * 输入：nums = [1,7,4,9,2,5]
 * 输出：6
 * 解释：整个序列均为摆动序列，各元素之间的差值为 (6, -3, 5, -7, 3) 。
 * 
 * 示例 2：
 * 输入：nums = [1,17,5,10,13,15,10,5,16,8]
 * 输出：7
 * 解释：这个序列包含几个长度为 7 摆动序列。其中一个是 [1, 17, 10, 13, 10, 16, 8] ，各元素之间的差值为 (16, -7, 3, -3, 6, -8) 。
 * 
 * 示例 3：
 * 输入：nums = [1,2,3,4,5,6,7,8,9]
 * 输出：2
 * 
 * 提示：
 * - 1 <= nums.length <= 1000
 * - 0 <= nums[i] <= 1000
 */
public class L0376_WiggleSubsequence {
    
    public int wiggleMaxLength(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        
        // up[i] 表示以 nums[i] 结尾的最长上升摆动序列的长度
        // down[i] 表示以 nums[i] 结尾的最长下降摆动序列的长度
        int up = 1, down = 1;
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                // 当前数字大于前一个数字，可以接在一个下降序列后面形成上升序列
                up = down + 1;
            } else if (nums[i] < nums[i - 1]) {
                // 当前数字小于前一个数字，可以接在一个上升序列后面形成下降序列
                down = up + 1;
            }
        }
        
        return Math.max(up, down);
    }

    public static void main(String[] args) {
        L0376_WiggleSubsequence solution = new L0376_WiggleSubsequence();
        
        // 测试用例 1
        int[] nums1 = {1, 7, 4, 9, 2, 5};
        System.out.println(solution.wiggleMaxLength(nums1));  // 应该输出 6
        
        // 测试用例 2
        int[] nums2 = {1, 17, 5, 10, 13, 15, 10, 5, 16, 8};
        System.out.println(solution.wiggleMaxLength(nums2));  // 应该输出 7
        
        // 测试用例 3
        int[] nums3 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(solution.wiggleMaxLength(nums3));  // 应该输出 2
    }
} 
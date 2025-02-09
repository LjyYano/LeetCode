import java.util.*;

/**
 * https://leetcode.cn/problems/longest-consecutive-sequence/
 * 
 * 题目描述:
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * 
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 * 
 * 示例 1：
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * 
 * 示例 2：
 * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
 * 输出：9
 * 
 * 提示：
 * - 0 <= nums.length <= 10^5
 * - -10^9 <= nums[i] <= 10^9
 */
public class L0128_LongestConsecutiveSequence {
    static class Solution {
        public int longestConsecutive(int[] nums) {
            // 如果数组为空，直接返回 0
            if (nums == null || nums.length == 0) {
                return 0;
            }
            
            // 使用 HashSet 存储所有数字，方便快速查找
            Set<Integer> numSet = new HashSet<>();
            for (int num : nums) {
                numSet.add(num);
            }
            
            int maxLength = 0;
            
            // 遍历数组中的每个数字
            for (int num : numSet) {
                // 只有当 num-1 不存在时，才开始计算以 num 为起点的序列
                // 这样可以保证每个序列只会被计算一次
                if (!numSet.contains(num - 1)) {
                    int currentNum = num;
                    int currentLength = 1;
                    
                    // 不断查找下一个连续的数字
                    while (numSet.contains(currentNum + 1)) {
                        currentNum++;
                        currentLength++;
                    }
                    
                    // 更新最大长度
                    maxLength = Math.max(maxLength, currentLength);
                }
            }
            
            return maxLength;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // 测试用例 1
        int[] nums1 = {100, 4, 200, 1, 3, 2};
        System.out.println("测试用例 1:");
        System.out.println("输入: " + Arrays.toString(nums1));
        System.out.println("输出: " + solution.longestConsecutive(nums1));
        System.out.println();
        
        // 测试用例 2
        int[] nums2 = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        System.out.println("测试用例 2:");
        System.out.println("输入: " + Arrays.toString(nums2));
        System.out.println("输出: " + solution.longestConsecutive(nums2));
    }
} 
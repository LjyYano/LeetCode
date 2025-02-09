/*
 * https://leetcode.cn/problems/majority-element/
 * 
 * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * 
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * 
 * 示例 1：
 * 输入：nums = [3,2,3]
 * 输出：3
 * 
 * 示例 2：
 * 输入：nums = [2,2,1,1,1,2,2]
 * 输出：2
 * 
 * 提示：
 * - n == nums.length
 * - 1 <= n <= 5 * 10⁴
 * - -10⁹ <= nums[i] <= 10⁹
 * 
 * 进阶：
 * - 尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
 */

public class L0169_MajorityElement {
    
    public int majorityElement(int[] nums) {
        // 使用 Boyer-Moore 投票算法
        int candidate = nums[0];  // 候选众数
        int count = 1;  // 计数器
        
        // 遍历数组
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                // 如果计数器为 0，说明前面的数字已经相互抵消
                // 将当前数字作为新的候选众数
                candidate = nums[i];
                count = 1;
            } else if (nums[i] == candidate) {
                // 如果当前数字等于候选众数，计数器加 1
                count++;
            } else {
                // 如果当前数字不等于候选众数，计数器减 1
                count--;
            }
        }
        
        // 由于题目保证存在众数，所以最后的候选众数就是答案
        return candidate;
    }

    public static void main(String[] args) {
        L0169_MajorityElement solution = new L0169_MajorityElement();
        
        // 测试用例 1
        int[] nums1 = {3, 2, 3};
        System.out.println("测试用例 1：");
        System.out.print("输入：nums = [");
        printArray(nums1);
        System.out.println("]");
        System.out.println("输出：" + solution.majorityElement(nums1));
        System.out.println("预期：3");
        System.out.println();
        
        // 测试用例 2
        int[] nums2 = {2, 2, 1, 1, 1, 2, 2};
        System.out.println("测试用例 2：");
        System.out.print("输入：nums = [");
        printArray(nums2);
        System.out.println("]");
        System.out.println("输出：" + solution.majorityElement(nums2));
        System.out.println("预期：2");
    }
    
    // 打印数组的辅助方法
    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(",");
            }
        }
    }
} 
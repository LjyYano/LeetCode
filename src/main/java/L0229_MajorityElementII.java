import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/majority-element-ii/
 * 
 * 给定一个大小为 n 的整数数组 nums，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
 * 
 * 示例 1：
 * 输入：nums = [3,2,3]
 * 输出：[3]
 * 
 * 示例 2：
 * 输入：nums = [1]
 * 输出：[1]
 * 
 * 示例 3：
 * 输入：nums = [1,2]
 * 输出：[1,2]
 * 
 * 提示：
 * - 1 <= nums.length <= 5 * 10⁴
 * - -10⁹ <= nums[i] <= 10⁹
 * 
 * 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
 */
public class L0229_MajorityElementII {
    
    /**
     * 使用摩尔投票算法的扩展版本
     * 由于要找出现次数超过 n/3 的元素，最多只可能有两个这样的元素
     */
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        
        // 初始化两个候选人和它们的计票
        int candidate1 = nums[0], count1 = 0;
        int candidate2 = nums[0], count2 = 0;
        
        // 第一次遍历：投票阶段
        for (int num : nums) {
            // 如果当前数字是候选人 1，则计票 1 加 1
            if (num == candidate1) {
                count1++;
            }
            // 如果当前数字是候选人 2，则计票 2 加 1
            else if (num == candidate2) {
                count2++;
            }
            // 如果计票 1 为 0，则更换候选人 1
            else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            }
            // 如果计票 2 为 0，则更换候选人 2
            else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            }
            // 如果当前数字不是候选人，则两个计票都减 1
            else {
                count1--;
                count2--;
            }
        }
        
        // 第二次遍历：计数阶段
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            }
        }
        
        // 检查候选人是否超过 n/3
        if (count1 > nums.length / 3) {
            result.add(candidate1);
        }
        if (candidate1 != candidate2 && count2 > nums.length / 3) {
            result.add(candidate2);
        }
        
        return result;
    }

    public static void main(String[] args) {
        L0229_MajorityElementII solution = new L0229_MajorityElementII();
        
        // 测试用例 1
        int[] nums1 = {3, 2, 3};
        System.out.println("输入：" + java.util.Arrays.toString(nums1));
        System.out.println("输出：" + solution.majorityElement(nums1));  // 预期输出：[3]
        
        // 测试用例 2
        int[] nums2 = {1};
        System.out.println("\n输入：" + java.util.Arrays.toString(nums2));
        System.out.println("输出：" + solution.majorityElement(nums2));  // 预期输出：[1]
        
        // 测试用例 3
        int[] nums3 = {1, 2};
        System.out.println("\n输入：" + java.util.Arrays.toString(nums3));
        System.out.println("输出：" + solution.majorityElement(nums3));  // 预期输出：[1,2]
    }
} 
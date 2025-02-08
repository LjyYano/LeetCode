import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 题目链接：https://leetcode.cn/problems/3sum/
 * 
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，
 * 同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。
 * 
 * 注意：答案中不可以包含重复的三元组。
 * 
 * 示例 1：
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 解释：
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0
 * 不同的三元组是 [-1,0,1] 和 [-1,-1,2]
 * 注意，输出的顺序和三元组的顺序并不重要。
 * 
 * 示例 2：
 * 输入：nums = [0,1,1]
 * 输出：[]
 * 解释：唯一可能的三元组和不为 0 。
 * 
 * 示例 3：
 * 输入：nums = [0,0,0]
 * 输出：[[0,0,0]]
 * 解释：唯一可能的三元组和为 0 。
 */
public class L0015_ThreeSum {
    
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        
        // 如果数组为空或长度小于3，直接返回空列表
        if (nums == null || nums.length < 3) {
            return result;
        }
        
        // 对数组进行排序
        Arrays.sort(nums);
        
        // 固定第一个数，然后使用双指针寻找剩余两个数
        for (int i = 0; i < nums.length - 2; i++) {
            // 如果第一个数大于0，由于数组已排序，后面的数字都大于0，不可能和为0
            if (nums[i] > 0) {
                break;
            }
            
            // 跳过重复的第一个数
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            
            // 使用双指针寻找剩余两个数
            int left = i + 1;
            int right = nums.length - 1;
            
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                
                if (sum == 0) {
                    // 找到一组解
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    
                    // 跳过重复的数字
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    
                    // 继续寻找其他解
                    left++;
                    right--;
                } else if (sum < 0) {
                    // 和小于0，需要增大，左指针右移
                    left++;
                } else {
                    // 和大于0，需要减小，右指针左移
                    right--;
                }
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        L0015_ThreeSum solution = new L0015_ThreeSum();
        
        // 测试用例 1
        int[] nums1 = {-1, 0, 1, 2, -1, -4};
        System.out.println("测试用例 1 结果：" + solution.threeSum(nums1));
        // 预期输出：[[-1, -1, 2], [-1, 0, 1]]
        
        // 测试用例 2
        int[] nums2 = {0, 1, 1};
        System.out.println("测试用例 2 结果：" + solution.threeSum(nums2));
        // 预期输出：[]
        
        // 测试用例 3
        int[] nums3 = {0, 0, 0};
        System.out.println("测试用例 3 结果：" + solution.threeSum(nums3));
        // 预期输出：[[0, 0, 0]]
    }
} 
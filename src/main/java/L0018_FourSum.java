import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 题目链接：https://leetcode.cn/problems/4sum/
 * 
 * 给你一个由 n 个整数组成的数组 nums，和一个目标值 target。请你找出并返回满足下述全部条件且不重复的四元组 
 * [nums[a], nums[b], nums[c], nums[d]]（若两个四元组元素一一对应，则认为两个四元组重复）：
 * 
 * 0 <= a, b, c, d < n
 * a、b、c 和 d 互不相同
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * 你可以按 任意顺序 返回答案。
 */
public class L0018_FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        // 处理特殊情况
        if (nums == null || nums.length < 4) {
            return result;
        }
        
        // 先排序，方便去重和使用双指针
        Arrays.sort(nums);
        int n = nums.length;
        
        // 固定第一个数
        for (int i = 0; i < n - 3; i++) {
            // 去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            
            // 如果当前最小的四数之和大于 target，后面的更大，直接结束
            if ((long) nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }
            
            // 如果当前最大的四数之和小于 target，当前数太小，继续下一个
            if ((long) nums[i] + nums[n - 3] + nums[n - 2] + nums[n - 1] < target) {
                continue;
            }
            
            // 固定第二个数
            for (int j = i + 1; j < n - 2; j++) {
                // 去重
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                
                // 如果当前最小的四数之和大于 target，后面的更大，直接结束内层循环
                if ((long) nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }
                
                // 如果当前最大的四数之和小于 target，当前数太小，继续下一个
                if ((long) nums[i] + nums[j] + nums[n - 2] + nums[n - 1] < target) {
                    continue;
                }
                
                // 使用双指针寻找剩余两个数
                int left = j + 1;
                int right = n - 1;
                
                while (left < right) {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
                    
                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        
                        // 跳过重复元素
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        
                        left++;
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        L0018_FourSum solution = new L0018_FourSum();

        // 测试用例 1
        int[] nums1 = {1, 0, -1, 0, -2, 2};
        int target1 = 0;
        System.out.println("Input: nums = " + Arrays.toString(nums1) + ", target = " + target1);
        System.out.println("Output: " + solution.fourSum(nums1, target1));
        // 预期输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]

        // 测试用例 2
        int[] nums2 = {2, 2, 2, 2, 2};
        int target2 = 8;
        System.out.println("\nInput: nums = " + Arrays.toString(nums2) + ", target = " + target2);
        System.out.println("Output: " + solution.fourSum(nums2, target2));
        // 预期输出：[[2,2,2,2]]

        // 测试用例 3：处理整数溢出的情况
        int[] nums3 = {1000000000, 1000000000, 1000000000, 1000000000};
        int target3 = -294967296;
        System.out.println("\nInput: nums = " + Arrays.toString(nums3) + ", target = " + target3);
        System.out.println("Output: " + solution.fourSum(nums3, target3));
        // 预期输出：[]
    }
} 
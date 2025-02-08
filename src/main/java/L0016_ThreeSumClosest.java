import java.util.Arrays;

/**
 * 题目链接：https://leetcode.cn/problems/3sum-closest/
 * 
 * 给你一个长度为 n 的整数数组 nums 和一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
 * 返回这三个数的和。
 * 假定每组输入只存在恰好一个解。
 * 
 * 示例 1：
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 * 
 * 示例 2：
 * 输入：nums = [0,0,0], target = 1
 * 输出：0
 */
public class L0016_ThreeSumClosest {
    
    public int threeSumClosest(int[] nums, int target) {
        // 对数组进行排序
        Arrays.sort(nums);
        
        // 初始化最接近的和为前三个数的和
        int closestSum = nums[0] + nums[1] + nums[2];
        
        // 固定第一个数，然后使用双指针寻找剩余两个数
        for (int i = 0; i < nums.length - 2; i++) {
            // 使用双指针寻找剩余两个数
            int left = i + 1;
            int right = nums.length - 1;
            
            while (left < right) {
                int currentSum = nums[i] + nums[left] + nums[right];
                
                // 如果当前和等于目标值，直接返回
                if (currentSum == target) {
                    return currentSum;
                }
                
                // 更新最接近的和
                if (Math.abs(currentSum - target) < Math.abs(closestSum - target)) {
                    closestSum = currentSum;
                }
                
                // 根据当前和与目标值的大小关系移动指针
                if (currentSum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        
        return closestSum;
    }

    public static void main(String[] args) {
        L0016_ThreeSumClosest solution = new L0016_ThreeSumClosest();
        
        // 测试用例 1
        int[] nums1 = {-1, 2, 1, -4};
        int target1 = 1;
        System.out.println("测试用例 1 结果：" + solution.threeSumClosest(nums1, target1));
        // 预期输出：2
        
        // 测试用例 2
        int[] nums2 = {0, 0, 0};
        int target2 = 1;
        System.out.println("测试用例 2 结果：" + solution.threeSumClosest(nums2, target2));
        // 预期输出：0
        
        // 测试用例 3：更复杂的例子
        int[] nums3 = {1, 1, 1, 0};
        int target3 = 100;
        System.out.println("测试用例 3 结果：" + solution.threeSumClosest(nums3, target3));
        // 预期输出：3
    }
} 
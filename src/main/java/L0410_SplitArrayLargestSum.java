import java.util.*;

/**
 * https://leetcode.cn/problems/split-array-largest-sum/description/
 * 
 * 给定一个非负整数数组 nums 和一个整数 m ，你需要将这个数组分成 m 个非空的连续子数组。
 * 设计一个算法使得这 m 个子数组各自和的最大值最小。
 * 
 * 示例 1：
 * 输入：nums = [7,2,5,10,8], m = 2
 * 输出：18
 * 解释：
 * 一共有四种方法将 nums 分割为 2 个子数组。
 * 其中最好的方式是将其分为 [7,2,5] 和 [10,8] 。
 * 因为此时这两个子数组各自的和的最大值为18，在所有情况中最小。
 * 
 * 示例 2：
 * 输入：nums = [1,2,3,4,5], m = 2
 * 输出：9
 * 
 * 示例 3：
 * 输入：nums = [1,4,4], m = 3
 * 输出：4
 */
public class L0410_SplitArrayLargestSum {

    public int splitArray(int[] nums, int m) {
        // 计算二分查找的左右边界
        long left = 0, right = 0;
        for (int num : nums) {
            left = Math.max(left, num);  // 左边界为数组中的最大值
            right += num;  // 右边界为数组总和
        }
        
        // 二分查找
        while (left < right) {
            long mid = left + (right - left) / 2;
            
            // 如果可以将数组分成 m 个子数组，且每个子数组的和不超过 mid
            if (canSplit(nums, m, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return (int) left;
    }
    
    /**
     * 判断是否可以将数组分成 m 个子数组，且每个子数组的和不超过 maxSum
     */
    private boolean canSplit(int[] nums, int m, long maxSum) {
        int count = 1;  // 当前子数组的个数
        long sum = 0;   // 当前子数组的和
        
        for (int num : nums) {
            // 如果当前子数组的和加上当前数字超过 maxSum，需要开始一个新的子数组
            if (sum + num > maxSum) {
                count++;
                sum = num;
                // 如果子数组个数超过 m，返回 false
                if (count > m) {
                    return false;
                }
            } else {
                sum += num;
            }
        }
        
        return true;
    }

    public static void main(String[] args) {
        L0410_SplitArrayLargestSum solution = new L0410_SplitArrayLargestSum();
        
        // 测试用例1
        int[] nums1 = {7,2,5,10,8};
        int m1 = 2;
        System.out.println("测试用例1：");
        System.out.println("输入：nums = " + Arrays.toString(nums1) + ", m = " + m1);
        System.out.println("输出：" + solution.splitArray(nums1, m1));
        
        // 测试用例2
        int[] nums2 = {1,2,3,4,5};
        int m2 = 2;
        System.out.println("\n测试用例2：");
        System.out.println("输入：nums = " + Arrays.toString(nums2) + ", m = " + m2);
        System.out.println("输出：" + solution.splitArray(nums2, m2));
        
        // 测试用例3
        int[] nums3 = {1,4,4};
        int m3 = 3;
        System.out.println("\n测试用例3：");
        System.out.println("输入：nums = " + Arrays.toString(nums3) + ", m = " + m3);
        System.out.println("输出：" + solution.splitArray(nums3, m3));
    }
} 
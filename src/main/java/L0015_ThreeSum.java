import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.cn/problems/3sum/
 */
public class L0015_ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        // 存放结果
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        // 数组长度小于 3 时，直接返回空集合
        if (n < 3) {
            return result;
        }
        // 先对数组进行排序
        Arrays.sort(nums);
        // 固定第一个数，然后使用双指针
        for (int i = 0; i < n - 2; i++) {
            // 如果当前数字大于 0，由于已经排序，后面的数字都大于 0，不可能和为 0
            if (nums[i] > 0) {
                break;
            }
            // 去重：如果当前数字和前一个数字相同，跳过
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 双指针
            int left = i + 1;
            int right = n - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    // 找到一组解
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 去重：跳过重复的数字
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (sum < 0) {
                    // 和小于 0，说明需要更大的数，左指针右移
                    left++;
                } else {
                    // 和大于 0，说明需要更小的数，右指针左移
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
        System.out.println("测试用例 1：");
        System.out.println("输入：nums = " + Arrays.toString(nums1));
        System.out.println("输出：" + solution.threeSum(nums1));
        
        // 测试用例 2
        int[] nums2 = {0, 1, 1};
        System.out.println("\n测试用例 2：");
        System.out.println("输入：nums = " + Arrays.toString(nums2));
        System.out.println("输出：" + solution.threeSum(nums2));
        
        // 测试用例 3
        int[] nums3 = {0, 0, 0};
        System.out.println("\n测试用例 3：");
        System.out.println("输入：nums = " + Arrays.toString(nums3));
        System.out.println("输出：" + solution.threeSum(nums3));
    }
} 
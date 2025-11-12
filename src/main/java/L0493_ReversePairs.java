/**
 * https://leetcode.cn/problems/reverse-pairs/
 * 
 * 给定一个数组 nums ，如果 i < j 且 nums[i] > 2*nums[j] 我们就将 (i, j) 称作一个重要翻转对。
 * 你需要返回给定数组中的重要翻转对的数量。
 * 
 * 示例 1：
 * 输入：nums = [1,3,2,3,1]
 * 输出：2
 * 
 * 示例 2：
 * 输入：nums = [2,4,3,5,1]
 * 输出：3
 * 
 * 提示：
 * - 0 <= nums.length <= 5 * 10^4
 * - -2^31 <= nums[i] <= 2^31 - 1
 */
public class L0493_ReversePairs {
    
    /**
     * 归并排序解法
     * 在归并排序的过程中统计翻转对
     */
    public int reversePairs(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        return mergeSort(nums, 0, nums.length - 1);
    }
    
    private int mergeSort(int[] nums, int left, int right) {
        if (left >= right) {
            return 0;
        }
        
        int mid = left + (right - left) / 2;
        int count = mergeSort(nums, left, mid) + mergeSort(nums, mid + 1, right);
        
        // 统计翻转对
        int j = mid + 1;
        for (int i = left; i <= mid; i++) {
            while (j <= right && nums[i] > 2L * nums[j]) {
                j++;
            }
            count += j - (mid + 1);
        }
        
        // 合并两个有序数组
        merge(nums, left, mid, right);
        
        return count;
    }
    
    private void merge(int[] nums, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }
        
        while (i <= mid) {
            temp[k++] = nums[i++];
        }
        
        while (j <= right) {
            temp[k++] = nums[j++];
        }
        
        for (i = 0; i < temp.length; i++) {
            nums[left + i] = temp[i];
        }
    }

    public static void main(String[] args) {
        L0493_ReversePairs solution = new L0493_ReversePairs();
        
        // 测试用例 1
        int[] nums1 = {1, 3, 2, 3, 1};
        System.out.println(solution.reversePairs(nums1)); // 预期输出：2
        
        // 测试用例 2
        int[] nums2 = {2, 4, 3, 5, 1};
        System.out.println(solution.reversePairs(nums2)); // 预期输出：3
    }
}

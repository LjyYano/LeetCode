import java.util.Arrays;

/**
 * https://leetcode.cn/problems/find-minimum-in-rotated-sorted-array-ii/
 * 
 * 已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。例如，原数组 nums = [0,1,4,4,5,6,7] 在变化后可能得到：
 * - 若旋转 4 次，则可以得到 [4,5,6,7,0,1,4]
 * - 若旋转 7 次，则可以得到 [0,1,4,4,5,6,7]
 * 
 * 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
 * 
 * 给你一个可能存在 重复 元素值的数组 nums ，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。请你找出并返回数组中的 最小元素 。
 * 
 * 你必须尽可能减少整个过程的操作步骤。
 */
public class L0154_FindMinimumInRotatedSortedArrayII {

    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        int left = 0;
        int right = nums.length - 1;
        
        // 如果数组没有旋转或旋转了 n 次（相当于没旋转）
        if (nums[left] < nums[right]) {
            return nums[left];
        }
        
        // 使用二分查找
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            // 如果中间值大于右边值，说明最小值在右半部分
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            }
            // 如果中间值小于右边值，说明最小值在左半部分（包括 mid）
            else if (nums[mid] < nums[right]) {
                right = mid;
            }
            // 如果中间值等于右边值，无法判断最小值在哪个区间
            // 此时可以将右边界左移一位，因为即使 nums[right] 是最小值
            // nums[mid] 也同样是最小值
            else {
                right--;
            }
        }
        
        return nums[left];
    }

    public static void main(String[] args) {
        L0154_FindMinimumInRotatedSortedArrayII solution = new L0154_FindMinimumInRotatedSortedArrayII();
        
        // 测试用例 1
        int[] nums1 = {1, 3, 5};
        System.out.println("输入：" + Arrays.toString(nums1));
        System.out.println("输出：" + solution.findMin(nums1));  // 预期输出：1
        
        // 测试用例 2
        int[] nums2 = {2, 2, 2, 0, 1};
        System.out.println("输入：" + Arrays.toString(nums2));
        System.out.println("输出：" + solution.findMin(nums2));  // 预期输出：0
        
        // 测试用例 3
        int[] nums3 = {3, 3, 1, 3};
        System.out.println("输入：" + Arrays.toString(nums3));
        System.out.println("输出：" + solution.findMin(nums3));  // 预期输出：1
    }
} 
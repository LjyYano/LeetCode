/**
 * https://leetcode.cn/problems/kth-largest-element-in-an-array/
 * 
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * 
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * 
 * 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
 * 
 * 示例 1:
 * 输入: [3,2,1,5,6,4], k = 2
 * 输出: 5
 * 
 * 示例 2:
 * 输入: [3,2,3,1,2,4,5,5,6], k = 4
 * 输出: 4
 * 
 * 提示：
 * - 1 <= k <= nums.length <= 10⁵
 * - -10⁴ <= nums[i] <= 10⁴
 */
public class L0215_KthLargestElementInAnArray {
    
    public int findKthLargest(int[] nums, int k) {
        // 使用快速选择算法
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }
    
    private int quickSelect(int[] nums, int left, int right, int k) {
        // 如果左右指针相遇，返回当前元素
        if (left == right) {
            return nums[left];
        }
        
        // 选择基准元素并进行分区
        int pivotIndex = partition(nums, left, right);
        
        // 根据基准元素的位置决定在哪个分区继续搜索
        if (k == pivotIndex) {
            return nums[k];
        } else if (k < pivotIndex) {
            return quickSelect(nums, left, pivotIndex - 1, k);
        } else {
            return quickSelect(nums, pivotIndex + 1, right, k);
        }
    }
    
    private int partition(int[] nums, int left, int right) {
        // 选择最右边的元素作为基准
        int pivot = nums[right];
        int i = left;
        
        // 将小于基准的元素放到左边
        for (int j = left; j < right; j++) {
            if (nums[j] <= pivot) {
                swap(nums, i, j);
                i++;
            }
        }
        
        // 将基准元素放到正确的位置
        swap(nums, i, right);
        return i;
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        L0215_KthLargestElementInAnArray solution = new L0215_KthLargestElementInAnArray();
        
        // 测试用例 1
        int[] nums1 = {3, 2, 1, 5, 6, 4};
        System.out.println("输入：nums = [3, 2, 1, 5, 6, 4], k = 2");
        System.out.println("输出：" + solution.findKthLargest(nums1, 2));  // 预期输出：5
        
        // 测试用例 2
        int[] nums2 = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        System.out.println("\n输入：nums = [3, 2, 3, 1, 2, 4, 5, 5, 6], k = 4");
        System.out.println("输出：" + solution.findKthLargest(nums2, 4));  // 预期输出：4
    }
} 
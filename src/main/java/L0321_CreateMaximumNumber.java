/**
 * https://leetcode.cn/problems/create-maximum-number/
 * 
 * 给定长度分别为 m 和 n 的两个数组，其元素由 0-9 构成，表示两个自然数各位上的数字。
 * 现在从这两个数组中选出 k (k <= m + n) 个数字拼接成一个新的数，要求从同一个数组中取出的数字保持其在原数组中的相对顺序。
 * 
 * 求满足该条件的最大数。结果返回一个表示该最大数的长度为 k 的数组。
 * 
 * 说明: 请尽可能地优化你算法的时间和空间复杂度。
 * 
 * 示例 1:
 * 输入:
 * nums1 = [3, 4, 6, 5]
 * nums2 = [9, 1, 2, 5, 8, 3]
 * k = 5
 * 输出:
 * [9, 8, 6, 5, 3]
 * 
 * 示例 2:
 * 输入:
 * nums1 = [6, 7]
 * nums2 = [6, 0, 4]
 * k = 5
 * 输出:
 * [6, 7, 6, 0, 4]
 * 
 * 示例 3:
 * 输入:
 * nums1 = [3, 9]
 * nums2 = [8, 9]
 * k = 3
 * 输出:
 * [9, 8, 9]
 */
public class L0321_CreateMaximumNumber {
    
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        // 结果数组
        int[] result = new int[k];
        // 从 nums1 中选取的数字个数范围：[max(0, k-n2), min(k, n1)]
        for (int i = Math.max(0, k - n2); i <= Math.min(k, n1); i++) {
            // 从 nums1 中选 i 个数字，从 nums2 中选 k-i 个数字
            int[] candidate = merge(
                maxArray(nums1, i),
                maxArray(nums2, k - i)
            );
            // 更新结果数组
            if (greater(candidate, 0, result, 0)) {
                result = candidate;
            }
        }
        return result;
    }
    
    // 从数组 nums 中选择 k 个数字组成最大的数，保持相对顺序
    private int[] maxArray(int[] nums, int k) {
        int n = nums.length;
        // 使用单调栈
        int[] stack = new int[k];
        int top = -1;
        // 还可以丢弃的数字个数
        int drop = n - k;
        for (int i = 0; i < n; i++) {
            // 当栈不为空，且当前数字大于栈顶元素，且还可以丢弃数字时
            while (top >= 0 && stack[top] < nums[i] && drop > 0) {
                top--;
                drop--;
            }
            // 如果栈未满，将当前数字入栈
            if (top < k - 1) {
                stack[++top] = nums[i];
            } else {
                // 否则丢弃当前数字
                drop--;
            }
        }
        return stack;
    }
    
    // 合并两个数组，使得结果最大
    private int[] merge(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int[] result = new int[n1 + n2];
        int i = 0, j = 0, r = 0;
        while (r < n1 + n2) {
            if (greater(nums1, i, nums2, j)) {
                result[r++] = nums1[i++];
            } else {
                result[r++] = nums2[j++];
            }
        }
        return result;
    }
    
    // 比较两个数组从指定位置开始的子数组的大小
    private boolean greater(int[] nums1, int i, int[] nums2, int j) {
        while (i < nums1.length && j < nums2.length && nums1[i] == nums2[j]) {
            i++;
            j++;
        }
        return j == nums2.length || (i < nums1.length && nums1[i] > nums2[j]);
    }

    public static void main(String[] args) {
        L0321_CreateMaximumNumber solution = new L0321_CreateMaximumNumber();
        
        // 测试用例 1
        int[] nums1 = {3, 4, 6, 5};
        int[] nums2 = {9, 1, 2, 5, 8, 3};
        int k = 5;
        int[] result1 = solution.maxNumber(nums1, nums2, k);
        System.out.println(java.util.Arrays.toString(result1)); // 应输出 [9, 8, 6, 5, 3]
        
        // 测试用例 2
        int[] nums3 = {6, 7};
        int[] nums4 = {6, 0, 4};
        k = 5;
        int[] result2 = solution.maxNumber(nums3, nums4, k);
        System.out.println(java.util.Arrays.toString(result2)); // 应输出 [6, 7, 6, 0, 4]
        
        // 测试用例 3
        int[] nums5 = {3, 9};
        int[] nums6 = {8, 9};
        k = 3;
        int[] result3 = solution.maxNumber(nums5, nums6, k);
        System.out.println(java.util.Arrays.toString(result3)); // 应输出 [9, 8, 9]
    }
} 
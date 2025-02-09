/**
 * https://leetcode.cn/problems/rotate-array/
 * 
 * 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 * 
 * 示例 1:
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右轮转 1 步: [7,1,2,3,4,5,6]
 * 向右轮转 2 步: [6,7,1,2,3,4,5]
 * 向右轮转 3 步: [5,6,7,1,2,3,4]
 * 
 * 示例 2:
 * 输入：nums = [-1,-100,3,99], k = 2
 * 输出：[3,99,-1,-100]
 * 解释: 
 * 向右轮转 1 步: [99,-1,-100,3]
 * 向右轮转 2 步: [3,99,-1,-100]
 * 
 * 提示：
 * - 1 <= nums.length <= 10⁵
 * - -2³¹ <= nums[i] <= 2³¹ - 1
 * - 0 <= k <= 10⁵
 */
public class L0189_RotateArray {
    
    /**
     * 使用反转数组的方法
     * 1. 首先反转整个数组
     * 2. 然后反转前 k 个元素
     * 3. 最后反转剩余的元素
     */
    public void rotate(int[] nums, int k) {
        k = k % nums.length; // 处理 k 大于数组长度的情况
        
        // 反转整个数组
        reverse(nums, 0, nums.length - 1);
        // 反转前 k 个元素
        reverse(nums, 0, k - 1);
        // 反转剩余元素
        reverse(nums, k, nums.length - 1);
    }
    
    /**
     * 反转数组中指定范围的元素
     */
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        L0189_RotateArray solution = new L0189_RotateArray();
        
        // 测试用例 1
        int[] nums1 = {1, 2, 3, 4, 5, 6, 7};
        int k1 = 3;
        System.out.println("测试用例 1：");
        System.out.println("输入：nums = " + java.util.Arrays.toString(nums1) + ", k = " + k1);
        solution.rotate(nums1, k1);
        System.out.println("输出：" + java.util.Arrays.toString(nums1));
        
        // 测试用例 2
        int[] nums2 = {-1, -100, 3, 99};
        int k2 = 2;
        System.out.println("\n测试用例 2：");
        System.out.println("输入：nums = " + java.util.Arrays.toString(nums2) + ", k = " + k2);
        solution.rotate(nums2, k2);
        System.out.println("输出：" + java.util.Arrays.toString(nums2));
    }
} 
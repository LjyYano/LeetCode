/**
 * https://leetcode.cn/problems/range-sum-query-immutable/
 * 
 * 给定一个整数数组  nums，处理以下类型的多个查询:
 * 1. 计算索引 left 和 right （包含 left 和 right）之间的 nums 元素的 和 ，其中 left <= right
 * 
 * 实现 NumArray 类：
 * - NumArray(int[] nums) 使用数组 nums 初始化对象
 * - int sumRange(int left, int right) 返回数组 nums 中索引 left 和 right 之间的元素的 总和 ，包含 left 和 right 两点
 * （也就是 nums[left] + nums[left + 1] + ... + nums[right] ）
 * 
 * 示例 1：
 * 输入：
 * ["NumArray", "sumRange", "sumRange", "sumRange"]
 * [[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
 * 输出：
 * [null, 1, -1, -3]
 * 
 * 解释：
 * NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
 * numArray.sumRange(0, 2); // return 1 ((-2) + 0 + 3)
 * numArray.sumRange(2, 5); // return -1 (3 + (-5) + 2 + (-1)) 
 * numArray.sumRange(0, 5); // return -3 ((-2) + 0 + 3 + (-5) + 2 + (-1))
 * 
 * 提示：
 * - 1 <= nums.length <= 10⁴
 * - -10⁵ <= nums[i] <= 10⁵
 * - 0 <= left <= right < nums.length
 * - 最多调用 10⁴ 次 sumRange 方法
 */
public class L0303_RangeSumQueryImmutable {
    
    static class NumArray {
        private final int[] prefixSum;
        
        public NumArray(int[] nums) {
            // 计算前缀和数组
            prefixSum = new int[nums.length + 1];
            for (int i = 0; i < nums.length; i++) {
                prefixSum[i + 1] = prefixSum[i] + nums[i];
            }
        }
        
        public int sumRange(int left, int right) {
            // 返回区间和：prefixSum[right + 1] - prefixSum[left]
            return prefixSum[right + 1] - prefixSum[left];
        }
    }

    public static void main(String[] args) {
        // 测试用例 1
        System.out.println("测试用例 1：");
        int[] nums1 = {-2, 0, 3, -5, 2, -1};
        NumArray numArray1 = new NumArray(nums1);
        System.out.println("Input: nums = [-2, 0, 3, -5, 2, -1]");
        System.out.println("sumRange(0, 2) = " + numArray1.sumRange(0, 2) + " (Expected: 1)");
        System.out.println("sumRange(2, 5) = " + numArray1.sumRange(2, 5) + " (Expected: -1)");
        System.out.println("sumRange(0, 5) = " + numArray1.sumRange(0, 5) + " (Expected: -3)");
        
        // 测试用例 2 - 测试单个元素
        System.out.println("\n测试用例 2：");
        int[] nums2 = {5};
        NumArray numArray2 = new NumArray(nums2);
        System.out.println("Input: nums = [5]");
        System.out.println("sumRange(0, 0) = " + numArray2.sumRange(0, 0) + " (Expected: 5)");
        
        // 测试用例 3 - 测试连续正数
        System.out.println("\n测试用例 3：");
        int[] nums3 = {1, 2, 3, 4, 5};
        NumArray numArray3 = new NumArray(nums3);
        System.out.println("Input: nums = [1, 2, 3, 4, 5]");
        System.out.println("sumRange(1, 3) = " + numArray3.sumRange(1, 3) + " (Expected: 9)");
        System.out.println("sumRange(0, 4) = " + numArray3.sumRange(0, 4) + " (Expected: 15)");
    }
} 
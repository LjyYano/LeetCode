/**
 * https://leetcode.cn/problems/maximum-gap/
 * 
 * 给定一个无序的数组 nums，返回 数组在排序之后，相邻元素之间最大的差值 。如果数组元素个数小于 2，则返回 0 。
 * 
 * 您必须编写一个在「线性时间」复杂度内运行并使用「线性额外空间」的算法。
 * 
 * 示例 1:
 * 输入: nums = [3,6,9,1]
 * 输出: 3
 * 解释: 排序后的数组是 [1,3,6,9], 其中相邻元素 (3,6) 和 (6,9) 之间都存在最大差值 3。
 * 
 * 示例 2:
 * 输入: nums = [10]
 * 输出: 0
 * 解释: 数组元素个数小于 2，因此返回 0。
 * 
 * 提示:
 * - 1 <= nums.length <= 10⁵
 * - 0 <= nums[i] <= 10⁹
 */
public class L0164_MaximumGap {
    
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        
        // 找到数组中的最大值和最小值
        int min = nums[0], max = nums[0];
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        
        // 如果最大值等于最小值，说明所有元素相等，返回 0
        if (max == min) {
            return 0;
        }
        
        // 计算桶的大小和数量
        int n = nums.length;
        // 桶的大小至少为 1
        int bucketSize = Math.max(1, (max - min) / (n - 1));
        // 桶的数量
        int bucketCount = (max - min) / bucketSize + 1;
        
        // 创建桶数组，每个桶记录该范围内的最大值和最小值
        int[][] buckets = new int[bucketCount][2];
        for (int i = 0; i < bucketCount; i++) {
            // 初始化每个桶的最大值为最小整数，最小值为最大整数
            buckets[i][0] = Integer.MAX_VALUE;  // min
            buckets[i][1] = Integer.MIN_VALUE;  // max
        }
        
        // 将数字分配到对应的桶中
        for (int num : nums) {
            int idx = (num - min) / bucketSize;
            buckets[idx][0] = Math.min(buckets[idx][0], num);
            buckets[idx][1] = Math.max(buckets[idx][1], num);
        }
        
        // 计算相邻桶之间的最大差值
        int maxGap = 0;
        int prevMax = min;  // 前一个非空桶的最大值
        for (int[] bucket : buckets) {
            // 跳过空桶
            if (bucket[0] == Integer.MAX_VALUE) {
                continue;
            }
            // 计算当前桶的最小值与前一个非空桶的最大值之差
            maxGap = Math.max(maxGap, bucket[0] - prevMax);
            prevMax = bucket[1];
        }
        
        return maxGap;
    }

    public static void main(String[] args) {
        L0164_MaximumGap solution = new L0164_MaximumGap();
        
        // 测试用例 1
        int[] nums1 = {3, 6, 9, 1};
        System.out.println(solution.maximumGap(nums1));  // 预期输出：3
        
        // 测试用例 2
        int[] nums2 = {10};
        System.out.println(solution.maximumGap(nums2));  // 预期输出：0
        
        // 测试用例 3
        int[] nums3 = {1, 1, 1, 1};
        System.out.println(solution.maximumGap(nums3));  // 预期输出：0
    }
} 
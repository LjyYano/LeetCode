import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/contains-duplicate-iii/
 * 
 * 给你一个整数数组 nums 和两个整数 k 和 t 。请你判断是否存在 两个不同下标 i 和 j，
 * 使得 abs(nums[i] - nums[j]) <= t ，同时又满足 abs(i - j) <= k 。
 * 
 * 如果存在则返回 true，不存在返回 false。
 * 
 * 示例 1：
 * 输入：nums = [1,2,3,1], k = 3, t = 0
 * 输出：true
 * 
 * 示例 2：
 * 输入：nums = [1,0,1,1], k = 1, t = 2
 * 输出：true
 * 
 * 示例 3：
 * 输入：nums = [1,5,9,1,5,9], k = 2, t = 3
 * 输出：false
 * 
 * 提示：
 * - 0 <= nums.length <= 2 * 10⁴
 * - -2³¹ <= nums[i] <= 2³¹ - 1
 * - 0 <= k <= 10⁴
 * - 0 <= t <= 2³¹ - 1
 */
public class L0220_ContainsDuplicateIII {
    
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        // 特殊情况处理
        if (nums == null || nums.length == 0 || k <= 0 || t < 0) {
            return false;
        }
        
        // 使用桶排序的思想，每个桶的大小为 t + 1
        // 使用 long 类型避免整数溢出
        Map<Long, Long> bucket = new HashMap<>();
        long w = (long) t + 1;
        
        for (int i = 0; i < nums.length; i++) {
            // 将数字映射到桶中
            long id = getBucketId(nums[i], w);
            
            // 如果当前桶中已经有数字，说明找到了符合条件的值
            if (bucket.containsKey(id)) {
                return true;
            }
            
            // 检查相邻的桶
            if (bucket.containsKey(id - 1) && Math.abs(nums[i] - bucket.get(id - 1)) < w) {
                return true;
            }
            if (bucket.containsKey(id + 1) && Math.abs(nums[i] - bucket.get(id + 1)) < w) {
                return true;
            }
            
            // 将当前数字放入桶中
            bucket.put(id, (long) nums[i]);
            
            // 如果窗口超过了 k，移除最早的数字
            if (i >= k) {
                bucket.remove(getBucketId(nums[i - k], w));
            }
        }
        
        return false;
    }
    
    // 获取桶的 ID
    private long getBucketId(long num, long w) {
        // 对于负数要特殊处理
        return num < 0 ? (num + 1) / w - 1 : num / w;
    }

    public static void main(String[] args) {
        L0220_ContainsDuplicateIII solution = new L0220_ContainsDuplicateIII();
        
        // 测试用例 1
        int[] nums1 = {1, 2, 3, 1};
        int k1 = 3;
        int t1 = 0;
        System.out.println("测试用例 1：");
        System.out.println("输入：nums = [1,2,3,1], k = 3, t = 0");
        System.out.println("输出：" + solution.containsNearbyAlmostDuplicate(nums1, k1, t1));  // 预期输出：true
        
        // 测试用例 2
        int[] nums2 = {1, 0, 1, 1};
        int k2 = 1;
        int t2 = 2;
        System.out.println("\n测试用例 2：");
        System.out.println("输入：nums = [1,0,1,1], k = 1, t = 2");
        System.out.println("输出：" + solution.containsNearbyAlmostDuplicate(nums2, k2, t2));  // 预期输出：true
        
        // 测试用例 3
        int[] nums3 = {1, 5, 9, 1, 5, 9};
        int k3 = 2;
        int t3 = 3;
        System.out.println("\n测试用例 3：");
        System.out.println("输入：nums = [1,5,9,1,5,9], k = 2, t = 3");
        System.out.println("输出：" + solution.containsNearbyAlmostDuplicate(nums3, k3, t3));  // 预期输出：false
    }
} 
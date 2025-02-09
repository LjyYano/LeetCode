/**
 * https://leetcode.cn/problems/single-number-ii/
 * 
 * 给你一个整数数组 nums ，除了某个元素只出现一次以外，其余每个元素都出现三次。请你找出那个只出现一次的元素。
 * 
 * 你必须设计并实现线性时间复杂度的算法来解决此问题，且该算法只使用常量额外空间。
 * 
 * 示例 1：
 * 输入：nums = [2,2,3,2]
 * 输出：3
 * 
 * 示例 2：
 * 输入：nums = [0,1,0,1,0,1,99]
 * 输出：99
 * 
 * 提示：
 * - 1 <= nums.length <= 3 * 10⁴
 * - -2³¹ <= nums[i] <= 2³¹ - 1
 * - nums 中，除某个元素仅出现一次外，其余每个元素都恰出现三次
 */
public class L0137_SingleNumberII {
    
    /**
     * 使用位运算的方法来解决问题：
     * 1. 对于每个数字的每一位，统计所有数字在该位上出现的 1 的个数
     * 2. 对于出现三次的数字，它们在每一位上的 1 的个数一定是 3 的倍数
     * 3. 将每一位上的 1 的个数对 3 取余，结果就是只出现一次的数字在该位上的值
     */
    public int singleNumber(int[] nums) {
        int result = 0;
        
        // 遍历每一位（0-31，因为是 32 位整数）
        for (int i = 0; i < 32; i++) {
            // 统计当前位上 1 的个数
            int bitSum = 0;
            for (int num : nums) {
                // 统计第 i 位上是否为 1
                bitSum += (num >> i) & 1;
            }
            // 对 3 取余，结果就是只出现一次的数字在该位上的值
            result |= (bitSum % 3) << i;
        }
        
        return result;
    }

    public static void main(String[] args) {
        L0137_SingleNumberII solution = new L0137_SingleNumberII();
        
        // 测试用例 1
        int[] nums1 = {2, 2, 3, 2};
        System.out.println("测试用例 1：");
        System.out.println("输入：nums = [2,2,3,2]");
        System.out.println("输出：" + solution.singleNumber(nums1));
        System.out.println("预期：3");
        System.out.println();
        
        // 测试用例 2
        int[] nums2 = {0, 1, 0, 1, 0, 1, 99};
        System.out.println("测试用例 2：");
        System.out.println("输入：nums = [0,1,0,1,0,1,99]");
        System.out.println("输出：" + solution.singleNumber(nums2));
        System.out.println("预期：99");
    }
} 
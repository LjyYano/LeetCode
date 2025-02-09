/**
 * https://leetcode.cn/problems/single-number/
 * 
 * 给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现一次的元素。
 * 
 * 你必须设计并实现线性时间复杂度的算法来解决此问题，且该算法只使用常量额外空间。
 * 
 * 示例 1：
 * 输入：nums = [2,2,1]
 * 输出：1
 * 
 * 示例 2：
 * 输入：nums = [4,1,2,1,2]
 * 输出：4
 * 
 * 示例 3：
 * 输入：nums = [1]
 * 输出：1
 * 
 * 提示：
 * - 1 <= nums.length <= 3 * 10⁴
 * - -3 * 10⁴ <= nums[i] <= 3 * 10⁴
 * - 除了某个元素只出现一次以外，其余每个元素均出现两次。
 */
public class L0136_SingleNumber {
    
    /**
     * 使用异或运算的特性来解决问题：
     * 1. a ⊕ a = 0（任何数和自己异或等于 0）
     * 2. a ⊕ 0 = a（任何数和 0 异或等于它自己）
     * 3. 异或运算满足交换律和结合律
     * 
     * 因此，对数组中所有元素进行异或运算，最终结果就是只出现一次的数字
     */
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }

    public static void main(String[] args) {
        L0136_SingleNumber solution = new L0136_SingleNumber();
        
        // 测试用例 1
        int[] nums1 = {2, 2, 1};
        System.out.println("测试用例 1：");
        System.out.println("输入：nums = [2,2,1]");
        System.out.println("输出：" + solution.singleNumber(nums1));
        System.out.println("预期：1");
        System.out.println();
        
        // 测试用例 2
        int[] nums2 = {4, 1, 2, 1, 2};
        System.out.println("测试用例 2：");
        System.out.println("输入：nums = [4,1,2,1,2]");
        System.out.println("输出：" + solution.singleNumber(nums2));
        System.out.println("预期：4");
        System.out.println();
        
        // 测试用例 3
        int[] nums3 = {1};
        System.out.println("测试用例 3：");
        System.out.println("输入：nums = [1]");
        System.out.println("输出：" + solution.singleNumber(nums3));
        System.out.println("预期：1");
    }
} 
import java.util.Arrays;

/**
 * https://leetcode.cn/problems/single-number-iii/
 * 
 * 给你一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。
 * 找出只出现一次的那两个元素。你可以按任意顺序返回答案。
 * 
 * 你必须设计并实现线性时间复杂度的算法且仅使用常量额外空间来解决此问题。
 * 
 * 示例 1：
 * 输入：nums = [1,2,1,3,2,5]
 * 输出：[3,5]
 * 解释：[5,3] 也是有效的答案。
 * 
 * 示例 2：
 * 输入：nums = [-1,0]
 * 输出：[-1,0]
 * 
 * 示例 3：
 * 输入：nums = [0,1]
 * 输出：[1,0]
 * 
 * 提示：
 * - 2 <= nums.length <= 3 * 10⁴
 * - -2³¹ <= nums[i] <= 2³¹ - 1
 * - 除两个只出现一次的整数外，nums 中的其他数字都出现两次
 */
public class L0260_SingleNumberIII {
    
    /**
     * 使用位运算的方法来解决问题：
     * 1. 先对所有数字进行异或，得到两个只出现一次的数字的异或结果
     * 2. 找到异或结果中任意一个为 1 的位，这个位可以用来区分两个数字
     * 3. 根据这个位是否为 1，将数组分成两组，分别异或得到两个数字
     */
    public int[] singleNumber(int[] nums) {
        // 对所有数字进行异或
        int xorResult = 0;
        for (int num : nums) {
            xorResult ^= num;
        }
        
        // 找到异或结果中最右边的 1
        int rightmostBit = xorResult & (-xorResult);
        
        // 根据这个位是否为 1，将数字分成两组
        int x = 0;
        for (int num : nums) {
            if ((num & rightmostBit) != 0) {
                x ^= num;
            }
        }
        
        // 另一个数字就是 x 和异或结果的异或
        int y = xorResult ^ x;
        
        return new int[]{x, y};
    }
    
    public static void main(String[] args) {
        L0260_SingleNumberIII solution = new L0260_SingleNumberIII();
        
        // 测试用例 1
        int[] nums1 = {1, 2, 1, 3, 2, 5};
        int[] result1 = solution.singleNumber(nums1);
        System.out.println("测试用例 1：");
        System.out.println("输入：[1,2,1,3,2,5]");
        System.out.println("输出：[" + result1[0] + "," + result1[1] + "]");
        
        // 测试用例 2
        int[] nums2 = {-1, 0};
        int[] result2 = solution.singleNumber(nums2);
        System.out.println("\n测试用例 2：");
        System.out.println("输入：[-1,0]");
        System.out.println("输出：[" + result2[0] + "," + result2[1] + "]");
        
        // 测试用例 3
        int[] nums3 = {0, 1};
        int[] result3 = solution.singleNumber(nums3);
        System.out.println("\n测试用例 3：");
        System.out.println("输入：[0,1]");
        System.out.println("输出：[" + result3[0] + "," + result3[1] + "]");
    }
} 
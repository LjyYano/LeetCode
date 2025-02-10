/**
 * https://leetcode.cn/problems/missing-number/
 * 
 * 给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。
 * 
 * 示例 1：
 * 输入：nums = [3,0,1]
 * 输出：2
 * 解释：n = 3，因为有 3 个数字，所以所有的数字都在范围 [0,3] 内。2 是丢失的数字，因为它没有出现在 nums 中。
 * 
 * 示例 2：
 * 输入：nums = [0,1]
 * 输出：2
 * 解释：n = 2，因为有 2 个数字，所以所有的数字都在范围 [0,2] 内。2 是丢失的数字，因为它没有出现在 nums 中。
 * 
 * 示例 3：
 * 输入：nums = [9,6,4,2,3,5,7,0,1]
 * 输出：8
 * 解释：n = 9，因为有 9 个数字，所以所有的数字都在范围 [0,9] 内。8 是丢失的数字，因为它没有出现在 nums 中。
 * 
 * 示例 4：
 * 输入：nums = [0]
 * 输出：1
 * 解释：n = 1，因为有 1 个数字，所以所有的数字都在范围 [0,1] 内。1 是丢失的数字，因为它没有出现在 nums 中。
 * 
 * 提示：
 * n == nums.length
 * 1 <= n <= 10⁴
 * 0 <= nums[i] <= n
 * nums 中的所有数字都 独一无二
 */
public class L0268_MissingNumber {
    
    public int missingNumber(int[] nums) {
        // 使用异或运算的性质：
        // 1. a ^ a = 0
        // 2. a ^ 0 = a
        // 3. 异或运算满足交换律和结合律
        int result = nums.length;
        for (int i = 0; i < nums.length; i++) {
            // 将数组中的每个数和它的下标异或
            // 再和 n 异或
            result ^= i ^ nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        L0268_MissingNumber solution = new L0268_MissingNumber();
        
        // 测试用例 1
        System.out.println(solution.missingNumber(new int[]{3, 0, 1}));  // 应该输出 2
        
        // 测试用例 2
        System.out.println(solution.missingNumber(new int[]{0, 1}));     // 应该输出 2
        
        // 测试用例 3
        System.out.println(solution.missingNumber(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}));  // 应该输出 8
        
        // 测试用例 4
        System.out.println(solution.missingNumber(new int[]{0}));        // 应该输出 1
    }
} 
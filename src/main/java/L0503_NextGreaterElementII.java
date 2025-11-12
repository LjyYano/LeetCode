/**
 * https://leetcode.cn/problems/next-greater-element-ii/
 * 
 * 给定一个循环数组 nums （ nums[nums.length - 1] 的下一个元素是 nums[0] ），
 * 返回 nums 中每个元素的 下一个更大元素 。
 * 
 * 数字 x 的 下一个更大的元素 是按数组遍历顺序，这个数字之后的第一个比它更大的数，
 * 这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1 。
 * 
 * 示例 1：
 * 输入: nums = [1,2,1]
 * 输出: [2,-1,2]
 * 解释: 第一个 1 的下一个更大的数是 2；
 * 数字 2 找不到下一个更大的数； 
 * 第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
 * 
 * 示例 2：
 * 输入: nums = [1,2,3,4,3]
 * 输出: [2,3,4,-1,4]
 * 
 * 提示：
 * - 1 <= nums.length <= 10^4
 * - -10^9 <= nums[i] <= 10^9
 */
import java.util.*;

public class L0503_NextGreaterElementII {
    
    /**
     * 单调栈 + 循环数组
     * 遍历两次数组来模拟循环
     */
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);
        
        Deque<Integer> stack = new ArrayDeque<>();
        
        // 遍历两次数组
        for (int i = 0; i < 2 * n; i++) {
            int num = nums[i % n];
            
            while (!stack.isEmpty() && nums[stack.peek()] < num) {
                result[stack.pop()] = num;
            }
            
            // 只在第一次遍历时将索引入栈
            if (i < n) {
                stack.push(i);
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        L0503_NextGreaterElementII solution = new L0503_NextGreaterElementII();
        
        // 测试用例 1
        int[] nums1 = {1, 2, 1};
        System.out.println(Arrays.toString(solution.nextGreaterElements(nums1))); 
        // 预期输出：[2, -1, 2]
        
        // 测试用例 2
        int[] nums2 = {1, 2, 3, 4, 3};
        System.out.println(Arrays.toString(solution.nextGreaterElements(nums2))); 
        // 预期输出：[2, 3, 4, -1, 4]
    }
}

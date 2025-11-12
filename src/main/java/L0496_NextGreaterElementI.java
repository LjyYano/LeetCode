/**
 * https://leetcode.cn/problems/next-greater-element-i/
 * 
 * nums1 中数字 x 的 下一个更大元素 是指 x 在 nums2 中对应位置 右侧 的 第一个 比 x 大的元素。
 * 
 * 给你两个 没有重复元素 的数组 nums1 和 nums2 ，下标从 0 开始计数，其中nums1 是 nums2 的子集。
 * 
 * 对于每个 0 <= i < nums1.length ，找出满足 nums1[i] == nums2[j] 的下标 j ，
 * 并且在 nums2 确定 nums2[j] 的 下一个更大元素 。如果不存在下一个更大元素，那么本次查询的答案是 -1 。
 * 
 * 返回一个长度为 nums1.length 的数组 ans 作为答案，满足 ans[i] 是如上所述的 下一个更大元素 。
 * 
 * 示例 1：
 * 输入：nums1 = [4,1,2], nums2 = [1,3,4,2]
 * 输出：[-1,3,-1]
 * 解释：nums1 中每个值的下一个更大元素如下所述：
 * - 4 ，用加粗斜体标识，nums2 = [1,3,4,2]。不存在下一个更大元素，所以答案是 -1 。
 * - 1 ，用加粗斜体标识，nums2 = [1,3,4,2]。下一个更大元素是 3 。
 * - 2 ，用加粗斜体标识，nums2 = [1,3,4,2]。不存在下一个更大元素，所以答案是 -1 。
 * 
 * 示例 2：
 * 输入：nums1 = [2,4], nums2 = [1,2,3,4]
 * 输出：[3,-1]
 * 解释：nums1 中每个值的下一个更大元素如下所述：
 * - 2 ，用加粗斜体标识，nums2 = [1,2,3,4]。下一个更大元素是 3 。
 * - 4 ，用加粗斜体标识，nums2 = [1,2,3,4]。不存在下一个更大元素，所以答案是 -1 。
 * 
 * 提示：
 * - 1 <= nums1.length <= nums2.length <= 1000
 * - 0 <= nums1[i], nums2[i] <= 10^4
 * - nums1和nums2中所有整数 互不相同
 * - nums1 中的所有整数同样出现在 nums2 中
 */
import java.util.*;

public class L0496_NextGreaterElementI {
    
    /**
     * 单调栈解法
     * 使用单调栈预处理 nums2，找出每个元素的下一个更大元素
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // 存储每个数字的下一个更大元素
        Map<Integer, Integer> map = new HashMap<>();
        // 单调递减栈
        Deque<Integer> stack = new ArrayDeque<>();
        
        // 遍历 nums2，构建每个元素的下一个更大元素映射
        for (int num : nums2) {
            // 当前元素大于栈顶元素时，说明找到了栈顶元素的下一个更大元素
            while (!stack.isEmpty() && stack.peek() < num) {
                map.put(stack.pop(), num);
            }
            stack.push(num);
        }
        
        // 栈中剩余的元素没有下一个更大元素
        while (!stack.isEmpty()) {
            map.put(stack.pop(), -1);
        }
        
        // 构建结果数组
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.get(nums1[i]);
        }
        
        return result;
    }

    public static void main(String[] args) {
        L0496_NextGreaterElementI solution = new L0496_NextGreaterElementI();
        
        // 测试用例 1
        int[] nums1_1 = {4, 1, 2};
        int[] nums2_1 = {1, 3, 4, 2};
        int[] result1 = solution.nextGreaterElement(nums1_1, nums2_1);
        System.out.println(Arrays.toString(result1)); // 预期输出：[-1, 3, -1]
        
        // 测试用例 2
        int[] nums1_2 = {2, 4};
        int[] nums2_2 = {1, 2, 3, 4};
        int[] result2 = solution.nextGreaterElement(nums1_2, nums2_2);
        System.out.println(Arrays.toString(result2)); // 预期输出：[3, -1]
    }
}

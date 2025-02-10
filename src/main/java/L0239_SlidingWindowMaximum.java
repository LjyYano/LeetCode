import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode.cn/problems/sliding-window-maximum/
 * 
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
 * 你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * 
 * 返回 滑动窗口中的最大值。
 * 
 * 示例 1：
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------             -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 * 
 * 示例 2：
 * 输入：nums = [1], k = 1
 * 输出：[1]
 * 
 * 提示：
 * - 1 <= nums.length <= 10⁵
 * - -10⁴ <= nums[i] <= 10⁴
 * - 1 <= k <= nums.length
 */
public class L0239_SlidingWindowMaximum {
    
    /**
     * 使用双端队列实现滑动窗口最大值
     * 队列中存储的是数组下标，并且保持队列中的元素单调递减
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[0];
        }
        
        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        
        // 处理第一个窗口
        for (int i = 0; i < k; i++) {
            // 保持队列单调递减
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }
        
        // 记录第一个窗口的最大值
        result[0] = nums[deque.peekFirst()];
        
        // 处理后续窗口
        for (int i = k; i < n; i++) {
            // 移除不在当前窗口范围内的元素
            while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            
            // 保持队列单调递减
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            
            // 记录当前窗口的最大值
            result[i - k + 1] = nums[deque.peekFirst()];
        }
        
        return result;
    }

    public static void main(String[] args) {
        L0239_SlidingWindowMaximum solution = new L0239_SlidingWindowMaximum();
        
        // 测试用例 1
        int[] nums1 = {1, 3, -1, -3, 5, 3, 6, 7};
        int k1 = 3;
        int[] result1 = solution.maxSlidingWindow(nums1, k1);
        System.out.print("Test Case 1: [");
        for (int i = 0; i < result1.length; i++) {
            System.out.print(result1[i]);
            if (i < result1.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
        
        // 测试用例 2
        int[] nums2 = {1};
        int k2 = 1;
        int[] result2 = solution.maxSlidingWindow(nums2, k2);
        System.out.print("Test Case 2: [");
        for (int i = 0; i < result2.length; i++) {
            System.out.print(result2[i]);
            if (i < result2.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
} 
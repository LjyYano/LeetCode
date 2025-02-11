import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * https://leetcode.cn/problems/top-k-frequent-elements/
 * 
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按任意顺序返回答案。
 * 
 * 示例 1:
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 
 * 示例 2:
 * 输入: nums = [1], k = 1
 * 输出: [1]
 * 
 * 提示：
 * 1 <= nums.length <= 10⁵
 * k 的取值范围是 [1, 数组中不相同的元素的个数]
 * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的
 * 
 * 进阶：你所设计算法的时间复杂度必须优于 O(n log n) ，其中 n 是数组大小。
 */
public class L0347_TopKFrequentElements {
    
    public int[] topKFrequent(int[] nums, int k) {
        // 使用 HashMap 统计每个元素出现的频率
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        
        // 使用优先队列（小顶堆）来找出前 k 个高频元素
        // 小顶堆中维护 k 个元素，堆顶是这 k 个元素中频率最小的
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
            (a, b) -> a.getValue() - b.getValue()
        );
        
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (pq.size() < k) {
                pq.offer(entry);
            } else if (entry.getValue() > pq.peek().getValue()) {
                pq.poll();
                pq.offer(entry);
            }
        }
        
        // 构建结果数组
        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = pq.poll().getKey();
        }
        
        return result;
    }

    public static void main(String[] args) {
        L0347_TopKFrequentElements solution = new L0347_TopKFrequentElements();
        
        // 测试用例 1
        int[] nums1 = {1, 1, 1, 2, 2, 3};
        int k1 = 2;
        System.out.print("测试用例 1 输出：");
        printArray(solution.topKFrequent(nums1, k1));  // 应该输出 [1, 2]
        
        // 测试用例 2
        int[] nums2 = {1};
        int k2 = 1;
        System.out.print("测试用例 2 输出：");
        printArray(solution.topKFrequent(nums2, k2));  // 应该输出 [1]
        
        // 测试用例 3
        int[] nums3 = {4, 1, -1, 2, -1, 2, 3};
        int k3 = 2;
        System.out.print("测试用例 3 输出：");
        printArray(solution.topKFrequent(nums3, k3));  // 应该输出 [-1, 2]
    }
    
    // 辅助方法：打印数组
    private static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
} 
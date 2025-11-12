import java.util.*;

public class L0480_SlidingWindowMedian {
    // 小根堆：存储较大的一半
    private PriorityQueue<Integer> small = new PriorityQueue<>();
    // 大根堆：存储较小的一半
    private PriorityQueue<Integer> large = new PriorityQueue<>(Collections.reverseOrder());
    // 延迟删除的元素
    private Map<Integer, Integer> delayed = new HashMap<>();
    private int smallSize = 0;
    private int largeSize = 0;
    
    public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        double[] result = new double[n - k + 1];
        
        // 初始化前 k 个元素
        for (int i = 0; i < k; i++) {
            addNum(nums[i]);
        }
        result[0] = getMedian(k);
        
        // 滑动窗口
        for (int i = k; i < n; i++) {
            // 添加新元素
            addNum(nums[i]);
            // 删除旧元素
            removeNum(nums[i - k]);
            // 计算中位数
            result[i - k + 1] = getMedian(k);
        }
        
        return result;
    }
    
    private void addNum(int num) {
        if (large.isEmpty() || num <= large.peek()) {
            large.offer(num);
            largeSize++;
        } else {
            small.offer(num);
            smallSize++;
        }
        rebalance();
    }
    
    private void removeNum(int num) {
        delayed.put(num, delayed.getOrDefault(num, 0) + 1);
        if (num <= large.peek()) {
            largeSize--;
        } else {
            smallSize--;
        }
        rebalance();
    }
    
    private void rebalance() {
        // 调整堆的平衡
        if (largeSize > smallSize + 1) {
            small.offer(large.poll());
            smallSize++;
            largeSize--;
            prune(large);
        } else if (smallSize > largeSize) {
            large.offer(small.poll());
            largeSize++;
            smallSize--;
            prune(small);
        }
        prune(large);
        prune(small);
    }
    
    private void prune(PriorityQueue<Integer> heap) {
        while (!heap.isEmpty() && delayed.getOrDefault(heap.peek(), 0) > 0) {
            int num = heap.poll();
            delayed.put(num, delayed.get(num) - 1);
            if (delayed.get(num) == 0) {
                delayed.remove(num);
            }
        }
    }
    
    private double getMedian(int k) {
        if (k % 2 == 1) {
            return large.peek();
        } else {
            return ((long) large.peek() + (long) small.peek()) / 2.0;
        }
    }
} 
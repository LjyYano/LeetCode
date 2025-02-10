/**
 * https://leetcode.cn/problems/find-median-from-data-stream/
 * 
 * 中位数是有序整数列表中的中间值。如果列表的大小是偶数，则没有中间值，中位数是两个中间值的平均值。
 * 
 * 例如 arr = [2,3,4] 的中位数是 3 。
 * 例如 arr = [2,3] 的中位数是 (2 + 3) / 2 = 2.5 。
 * 
 * 实现 MedianFinder 类:
 * - MedianFinder() 初始化 MedianFinder 对象。
 * - void addNum(int num) 从数据流中添加一个整数 num
 * - double findMedian() 返回到目前为止所有元素的中位数。与实际答案相差 10⁻⁵ 以内的答案将被接受。
 * 
 * 示例 1：
 * 输入
 * ["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
 * [[], [1], [2], [], [3], []]
 * 输出
 * [null, null, null, 1.5, null, 2.0]
 * 
 * 解释
 * MedianFinder medianFinder = new MedianFinder();
 * medianFinder.addNum(1);    // arr = [1]
 * medianFinder.addNum(2);    // arr = [1, 2]
 * medianFinder.findMedian(); // 返回 1.5 ((1 + 2) / 2)
 * medianFinder.addNum(3);    // arr = [1, 2, 3]
 * medianFinder.findMedian(); // 返回 2.0
 * 
 * 提示:
 * - -10⁵ <= num <= 10⁵
 * - 在调用 findMedian 之前，数据结构中至少有一个元素
 * - 最多调用 5 * 10⁴ 次 addNum 和 findMedian
 */

import java.util.PriorityQueue;

public class L0295_FindMedianFromDataStream {
    
    // 大顶堆，存储较小的一半数字
    private final PriorityQueue<Integer> maxHeap;
    // 小顶堆，存储较大的一半数字
    private final PriorityQueue<Integer> minHeap;
    
    public L0295_FindMedianFromDataStream() {
        // 初始化两个堆
        maxHeap = new PriorityQueue<>((a, b) -> b - a);  // 大顶堆
        minHeap = new PriorityQueue<>();  // 小顶堆
    }
    
    public void addNum(int num) {
        // 先将数字加入大顶堆
        maxHeap.offer(num);
        // 将大顶堆的最大值移到小顶堆
        minHeap.offer(maxHeap.poll());
        
        // 保持两个堆的大小平衡
        // 如果小顶堆的大小大于大顶堆，将小顶堆的最小值移到大顶堆
        if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }
    
    public double findMedian() {
        // 如果两个堆大小相等，取两个堆顶的平均值
        if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
        // 否则大顶堆的大小比小顶堆大1，直接返回大顶堆的堆顶
        return maxHeap.peek();
    }

    public static void main(String[] args) {
        // 测试用例 1
        L0295_FindMedianFromDataStream medianFinder1 = new L0295_FindMedianFromDataStream();
        medianFinder1.addNum(1);
        medianFinder1.addNum(2);
        System.out.println("Test case 1 - Expected: 1.5, Actual: " + medianFinder1.findMedian());
        medianFinder1.addNum(3);
        System.out.println("Test case 1 - Expected: 2.0, Actual: " + medianFinder1.findMedian());

        // 测试用例 2 - 测试偶数个数字
        L0295_FindMedianFromDataStream medianFinder2 = new L0295_FindMedianFromDataStream();
        medianFinder2.addNum(4);
        medianFinder2.addNum(2);
        medianFinder2.addNum(3);
        medianFinder2.addNum(1);
        System.out.println("Test case 2 - Expected: 2.5, Actual: " + medianFinder2.findMedian());

        // 测试用例 3 - 测试奇数个数字
        L0295_FindMedianFromDataStream medianFinder3 = new L0295_FindMedianFromDataStream();
        medianFinder3.addNum(5);
        medianFinder3.addNum(3);
        medianFinder3.addNum(1);
        medianFinder3.addNum(4);
        medianFinder3.addNum(2);
        System.out.println("Test case 3 - Expected: 3.0, Actual: " + medianFinder3.findMedian());
    }
} 
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.Arrays;

/**
 * https://leetcode.cn/problems/data-stream-as-disjoint-intervals/
 * 
 * 给你一个数据流。你需要实现一个数据结构支持两个操作：
 * 
 * 1. addNum(val) - 向数据流中加入整数 val
 * 2. getIntervals() - 返回数据流中已有的数字的所有不相交区间
 * 
 * 实现 SummaryRanges 类：
 * - SummaryRanges() 使用空数据流初始化对象
 * - void addNum(int val) 向数据流中加入整数 val
 * - int[][] getIntervals() 以不相交区间 [starti, endi] 的列表形式返回对数据流中整数的总结
 * 
 * 示例：
 * 输入：
 * ["SummaryRanges", "addNum", "getIntervals", "addNum", "getIntervals", "addNum", "getIntervals", "addNum", "getIntervals", "addNum", "getIntervals"]
 * [[], [1], [], [3], [], [7], [], [2], [], [6], []]
 * 输出：
 * [null, null, [[1, 1]], null, [[1, 1], [3, 3]], null, [[1, 1], [3, 3], [7, 7]], null, [[1, 3], [7, 7]], null, [[1, 3], [6, 7]]]
 * 
 * 解释：
 * SummaryRanges summaryRanges = new SummaryRanges();
 * summaryRanges.addNum(1);      // arr = [1]
 * summaryRanges.getIntervals(); // 返回 [[1, 1]]
 * summaryRanges.addNum(3);      // arr = [1, 3]
 * summaryRanges.getIntervals(); // 返回 [[1, 1], [3, 3]]
 * summaryRanges.addNum(7);      // arr = [1, 3, 7]
 * summaryRanges.getIntervals(); // 返回 [[1, 1], [3, 3], [7, 7]]
 * summaryRanges.addNum(2);      // arr = [1, 2, 3, 7]
 * summaryRanges.getIntervals(); // 返回 [[1, 3], [7, 7]]
 * summaryRanges.addNum(6);      // arr = [1, 2, 3, 6, 7]
 * summaryRanges.getIntervals(); // 返回 [[1, 3], [6, 7]]
 * 
 * 提示：
 * - 0 <= val <= 10⁴
 * - 最多调用 addNum 和 getIntervals 方法 3 * 10⁴ 次
 */
public class L0352_DataStreamAsDisjointIntervals {
    // 使用 TreeMap 存储区间的起点和终点
    TreeMap<Integer, Integer> intervals;

    public L0352_DataStreamAsDisjointIntervals() {
        intervals = new TreeMap<>();
    }
    
    public void addNum(int val) {
        // 获取小于等于 val 的最大键
        Integer start = intervals.floorKey(val);
        // 获取大于 val 的最小键
        Integer end = intervals.ceilingKey(val);
        
        // 如果当前值已经在某个区间内，直接返回
        if (start != null && intervals.get(start) >= val) {
            return;
        }
        
        // 是否可以与前一个区间合并
        boolean mergeWithPrev = start != null && intervals.get(start) + 1 == val;
        // 是否可以与后一个区间合并
        boolean mergeWithNext = end != null && val + 1 == end;
        
        if (mergeWithPrev && mergeWithNext) {
            // 与前后区间都可以合并
            intervals.put(start, intervals.get(end));
            intervals.remove(end);
        } else if (mergeWithPrev) {
            // 只与前一个区间合并
            intervals.put(start, val);
        } else if (mergeWithNext) {
            // 只与后一个区间合并
            intervals.put(val, intervals.get(end));
            intervals.remove(end);
        } else {
            // 无法合并，创建新区间
            intervals.put(val, val);
        }
    }
    
    public int[][] getIntervals() {
        List<int[]> result = new ArrayList<>();
        for (Integer start : intervals.keySet()) {
            result.add(new int[]{start, intervals.get(start)});
        }
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        L0352_DataStreamAsDisjointIntervals summaryRanges = new L0352_DataStreamAsDisjointIntervals();
        
        // 测试用例 1
        summaryRanges.addNum(1);
        System.out.println("添加 1 后的区间：" + Arrays.deepToString(summaryRanges.getIntervals()));
        
        summaryRanges.addNum(3);
        System.out.println("添加 3 后的区间：" + Arrays.deepToString(summaryRanges.getIntervals()));
        
        summaryRanges.addNum(7);
        System.out.println("添加 7 后的区间：" + Arrays.deepToString(summaryRanges.getIntervals()));
        
        summaryRanges.addNum(2);
        System.out.println("添加 2 后的区间：" + Arrays.deepToString(summaryRanges.getIntervals()));
        
        summaryRanges.addNum(6);
        System.out.println("添加 6 后的区间：" + Arrays.deepToString(summaryRanges.getIntervals()));
        
        // 测试用例 2：测试连续数字
        L0352_DataStreamAsDisjointIntervals test2 = new L0352_DataStreamAsDisjointIntervals();
        for (int i = 1; i <= 5; i++) {
            test2.addNum(i);
        }
        System.out.println("\n连续添加 1-5 后的区间：" + Arrays.deepToString(test2.getIntervals()));
    }
} 
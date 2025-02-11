import java.util.*;

/**
 * https://leetcode.cn/problems/non-overlapping-intervals/description/
 * 
 * 给定一个区间的集合 intervals ，其中 intervals[i] = [starti, endi] 。返回需要移除区间的最小数量，使剩余区间互不重叠。
 * 
 * 示例 1：
 * 输入: intervals = [[1,2],[2,3],[3,4],[1,3]]
 * 输出: 1
 * 解释: 移除 [1,3] 后，剩下的区间没有重叠。
 * 
 * 示例 2：
 * 输入: intervals = [[1,2],[1,2],[1,2]]
 * 输出: 2
 * 解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
 * 
 * 示例 3：
 * 输入: intervals = [[1,2],[2,3]]
 * 输出: 0
 * 解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
 */
public class L0435_NonOverlappingIntervals {

    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        
        // 按区间结尾排序
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        
        // 记录需要移除的区间数量
        int count = 0;
        // 记录当前选择的区间的结尾
        int end = Integer.MIN_VALUE;
        
        // 遍历所有区间
        for (int[] interval : intervals) {
            // 如果当前区间的开始大于等于上一个选择的区间的结尾，说明不重叠
            if (interval[0] >= end) {
                // 更新结尾
                end = interval[1];
            } else {
                // 否则需要移除当前区间
                count++;
            }
        }
        
        return count;
    }

    public static void main(String[] args) {
        L0435_NonOverlappingIntervals solution = new L0435_NonOverlappingIntervals();
        
        // 测试用例1
        int[][] intervals1 = {{1,2}, {2,3}, {3,4}, {1,3}};
        System.out.println("测试用例1：");
        System.out.println("输入：intervals = " + Arrays.deepToString(intervals1));
        System.out.println("输出：" + solution.eraseOverlapIntervals(intervals1));
        
        // 测试用例2
        int[][] intervals2 = {{1,2}, {1,2}, {1,2}};
        System.out.println("\n测试用例2：");
        System.out.println("输入：intervals = " + Arrays.deepToString(intervals2));
        System.out.println("输出：" + solution.eraseOverlapIntervals(intervals2));
        
        // 测试用例3
        int[][] intervals3 = {{1,2}, {2,3}};
        System.out.println("\n测试用例3：");
        System.out.println("输入：intervals = " + Arrays.deepToString(intervals3));
        System.out.println("输出：" + solution.eraseOverlapIntervals(intervals3));
    }
} 
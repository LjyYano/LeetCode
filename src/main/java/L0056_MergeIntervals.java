/**
 * https://leetcode.cn/problems/merge-intervals/
 * 
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 * 
 * 示例 1：
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 
 * 示例 2：
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * 
 * 提示：
 * 1 <= intervals.length <= 10⁴
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 10⁴
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L0056_MergeIntervals {
    
    public int[][] merge(int[][] intervals) {
        // 如果数组为空或只有一个区间，直接返回
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }
        
        // 按照区间的起始位置排序
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        
        // 用于存储合并后的区间
        List<int[]> merged = new ArrayList<>();
        // 将第一个区间加入结果集
        merged.add(intervals[0]);
        
        // 遍历剩余的区间
        for (int i = 1; i < intervals.length; i++) {
            // 获取当前区间
            int[] current = intervals[i];
            // 获取结果集中的最后一个区间
            int[] last = merged.get(merged.size() - 1);
            
            // 如果当前区间的起始位置小于等于最后一个区间的结束位置
            // 说明两个区间重叠，需要合并
            if (current[0] <= last[1]) {
                // 更新最后一个区间的结束位置
                last[1] = Math.max(last[1], current[1]);
            } else {
                // 如果不重叠，直接将当前区间加入结果集
                merged.add(current);
            }
        }
        
        // 将 List 转换为数组返回
        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {
        L0056_MergeIntervals solution = new L0056_MergeIntervals();
        
        // 测试用例 1
        int[][] intervals1 = {{1,3}, {2,6}, {8,10}, {15,18}};
        int[][] result1 = solution.merge(intervals1);
        System.out.println(Arrays.deepToString(result1)); // 预期输出：[[1,6],[8,10],[15,18]]
        
        // 测试用例 2
        int[][] intervals2 = {{1,4}, {4,5}};
        int[][] result2 = solution.merge(intervals2);
        System.out.println(Arrays.deepToString(result2)); // 预期输出：[[1,5]]
        
        // 测试用例 3：单个区间
        int[][] intervals3 = {{1,4}};
        int[][] result3 = solution.merge(intervals3);
        System.out.println(Arrays.deepToString(result3)); // 预期输出：[[1,4]]
    }
} 
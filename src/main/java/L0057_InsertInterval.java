/**
 * https://leetcode.cn/problems/insert-interval/
 * 
 * 给你一个 无重叠的 ，按照区间起始端点排序的区间列表。
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 * 
 * 示例 1：
 * 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出：[[1,5],[6,9]]
 * 
 * 示例 2：
 * 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出：[[1,2],[3,10],[12,16]]
 * 解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 * 
 * 示例 3：
 * 输入：intervals = [], newInterval = [5,7]
 * 输出：[[5,7]]
 * 
 * 示例 4：
 * 输入：intervals = [[1,5]], newInterval = [2,3]
 * 输出：[[1,5]]
 * 
 * 示例 5：
 * 输入：intervals = [[1,5]], newInterval = [2,7]
 * 输出：[[1,7]]
 * 
 * 提示：
 * 0 <= intervals.length <= 10⁴
 * intervals[i].length == 2
 * 0 <= intervals[i][0] <= intervals[i][1] <= 10⁵
 * intervals 根据 intervals[i][0] 按 升序 排列
 * newInterval.length == 2
 * 0 <= newInterval[0] <= newInterval[1] <= 10⁵
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L0057_InsertInterval {
    
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // 如果原区间列表为空，直接返回新区间
        if (intervals == null || intervals.length == 0) {
            return new int[][] {newInterval};
        }
        
        // 用于存储结果的列表
        List<int[]> result = new ArrayList<>();
        // 当前处理到的位置
        int i = 0;
        // 区间数组的长度
        int n = intervals.length;
        
        // 将所有在新区间之前的区间加入结果集
        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }
        
        // 合并所有与新区间重叠的区间
        while (i < n && intervals[i][0] <= newInterval[1]) {
            // 更新新区间的起始和结束位置
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        // 将合并后的新区间加入结果集
        result.add(newInterval);
        
        // 将所有在新区间之后的区间加入结果集
        while (i < n) {
            result.add(intervals[i]);
            i++;
        }
        
        // 将列表转换为数组返回
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        L0057_InsertInterval solution = new L0057_InsertInterval();
        
        // 测试用例 1
        int[][] intervals1 = {{1,3}, {6,9}};
        int[] newInterval1 = {2,5};
        System.out.println(Arrays.deepToString(solution.insert(intervals1, newInterval1))); // 预期输出：[[1,5],[6,9]]
        
        // 测试用例 2
        int[][] intervals2 = {{1,2}, {3,5}, {6,7}, {8,10}, {12,16}};
        int[] newInterval2 = {4,8};
        System.out.println(Arrays.deepToString(solution.insert(intervals2, newInterval2))); // 预期输出：[[1,2],[3,10],[12,16]]
        
        // 测试用例 3
        int[][] intervals3 = {};
        int[] newInterval3 = {5,7};
        System.out.println(Arrays.deepToString(solution.insert(intervals3, newInterval3))); // 预期输出：[[5,7]]
        
        // 测试用例 4
        int[][] intervals4 = {{1,5}};
        int[] newInterval4 = {2,3};
        System.out.println(Arrays.deepToString(solution.insert(intervals4, newInterval4))); // 预期输出：[[1,5]]
        
        // 测试用例 5
        int[][] intervals5 = {{1,5}};
        int[] newInterval5 = {2,7};
        System.out.println(Arrays.deepToString(solution.insert(intervals5, newInterval5))); // 预期输出：[[1,7]]
    }
} 
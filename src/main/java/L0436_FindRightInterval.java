import java.util.*;

/**
 * https://leetcode.cn/problems/find-right-interval/description/
 * 
 * 给你一个区间数组 intervals ，其中 intervals[i] = [starti, endi] ，且每个 starti 都不同。
 * 区间 i 的右侧区间可以记作区间 j ，并满足 startj >= endi ，且 startj 最小化。
 * 返回一个由每个区间 i 的右侧区间的最小起始位置组成的数组。如果某个区间 i 不存在对应的右侧区间，则下标 i 处的值设为 -1 。
 * 
 * 示例 1：
 * 输入：intervals = [[1,2]]
 * 输出：[-1]
 * 解释：集合中只有一个区间，所以输出-1。
 * 
 * 示例 2：
 * 输入：intervals = [[3,4],[2,3],[1,2]]
 * 输出：[-1,0,1]
 * 解释：对于 [3,4] ，没有满足条件的"右侧"区间。
 * 对于 [2,3] ，区间[3,4]具有最小的"右"起点;
 * 对于 [1,2] ，区间[2,3]具有最小的"右"起点。
 * 
 * 示例 3：
 * 输入：intervals = [[1,4],[2,3],[3,4]]
 * 输出：[-1,2,-1]
 * 解释：对于区间 [1,4] ，没有满足条件的"右侧"区间。
 * 对于 [2,3] ，区间 [3,4] 有最小的"右"起点。
 * 对于 [3,4] ，没有满足条件的"右侧"区间。
 */
public class L0436_FindRightInterval {

    public int[] findRightInterval(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[0];
        }
        
        int n = intervals.length;
        // 如果只有一个区间，直接返回 [-1]
        if (n == 1) {
            return new int[]{-1};
        }
        
        // 创建一个数组存储每个区间的起始位置和原始索引
        int[][] starts = new int[n][2];
        for (int i = 0; i < n; i++) {
            starts[i][0] = intervals[i][0];  // 起始位置
            starts[i][1] = i;  // 原始索引
        }
        
        // 按照起始位置排序
        Arrays.sort(starts, (a, b) -> a[0] - b[0]);
        
        // 对每个区间，在排序后的数组中二分查找其右区间
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            int end = intervals[i][1];  // 当前区间的结束位置
            
            // 二分查找大于等于 end 的最小起始位置
            int left = 0, right = n - 1;
            int ans = -1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (starts[mid][0] >= end) {
                    ans = starts[mid][1];  // 记录当前找到的索引
                    right = mid - 1;  // 继续在左半部分查找更小的起始位置
                } else {
                    left = mid + 1;
                }
            }
            
            result[i] = ans;
        }
        
        return result;
    }

    public static void main(String[] args) {
        L0436_FindRightInterval solution = new L0436_FindRightInterval();
        
        // 测试用例1
        int[][] intervals1 = {{1,2}};
        System.out.println("测试用例1：");
        System.out.println("输入：intervals = " + Arrays.deepToString(intervals1));
        System.out.println("输出：" + Arrays.toString(solution.findRightInterval(intervals1)));
        
        // 测试用例2
        int[][] intervals2 = {{3,4}, {2,3}, {1,2}};
        System.out.println("\n测试用例2：");
        System.out.println("输入：intervals = " + Arrays.deepToString(intervals2));
        System.out.println("输出：" + Arrays.toString(solution.findRightInterval(intervals2)));
        
        // 测试用例3
        int[][] intervals3 = {{1,4}, {2,3}, {3,4}};
        System.out.println("\n测试用例3：");
        System.out.println("输入：intervals = " + Arrays.deepToString(intervals3));
        System.out.println("输出：" + Arrays.toString(solution.findRightInterval(intervals3)));
    }
} 
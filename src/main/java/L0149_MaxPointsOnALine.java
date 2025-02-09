import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/max-points-on-a-line/
 * 
 * 给你一个数组 points ，其中 points[i] = [xi, yi] 表示 X-Y 平面上的一个点。求最多有多少个点在同一条直线上。
 * 
 * 示例 1：
 * 输入：points = [[1,1],[2,2],[3,3]]
 * 输出：3
 * 
 * 示例 2：
 * 输入：points = [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
 * 输出：4
 * 
 * 提示：
 * - 1 <= points.length <= 300
 * - points[i].length == 2
 * - -10⁴ <= xi, yi <= 10⁴
 * - points 中的所有点 互不相同
 */
public class L0149_MaxPointsOnALine {
    
    public int maxPoints(int[][] points) {
        int n = points.length;
        // 如果点的数量小于等于 2，直接返回点的数量
        if (n <= 2) {
            return n;
        }
        
        int maxPoints = 2;
        // 遍历每个点，计算它与其他点构成的直线
        for (int i = 0; i < n; i++) {
            // 用 Map 存储斜率及其对应的点的数量
            Map<Double, Integer> slopeCount = new HashMap<>();
            
            // 计算当前点与其他点的斜率
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    // 计算斜率
                    double slope = getSlope(points[i], points[j]);
                    // 更新斜率对应的点的数量
                    slopeCount.put(slope, slopeCount.getOrDefault(slope, 1) + 1);
                    // 更新最大点数
                    maxPoints = Math.max(maxPoints, slopeCount.get(slope));
                }
            }
        }
        
        return maxPoints;
    }
    
    // 计算两点之间的斜率
    private double getSlope(int[] point1, int[] point2) {
        int x1 = point1[0], y1 = point1[1];
        int x2 = point2[0], y2 = point2[1];
        
        // 如果 x 坐标相同，返回 Double.POSITIVE_INFINITY 表示垂直线
        if (x1 == x2) {
            return Double.POSITIVE_INFINITY;
        }
        // 如果 y 坐标相同，返回 0.0 表示水平线
        if (y1 == y2) {
            return 0.0;
        }
        // 计算斜率
        return (double) (y2 - y1) / (x2 - x1);
    }

    public static void main(String[] args) {
        L0149_MaxPointsOnALine solution = new L0149_MaxPointsOnALine();
        
        // 测试用例 1
        int[][] points1 = {{1,1},{2,2},{3,3}};
        System.out.println(solution.maxPoints(points1)); // 预期输出：3
        
        // 测试用例 2
        int[][] points2 = {{1,1},{3,2},{5,3},{4,1},{2,3},{1,4}};
        System.out.println(solution.maxPoints(points2)); // 预期输出：4
    }
} 
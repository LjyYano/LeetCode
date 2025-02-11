/**
 * https://leetcode.cn/problems/minimum-number-of-arrows-to-burst-balloons/
 * 
 * 有一些球形气球贴在一堵用 XY 平面表示的墙面上。墙面上的气球记录在整数数组 points ，其中 points[i] = [xstart, xend] 表示水平直径在 xstart 和 xend 之间的气球。你不知道气球的确切 y 坐标。
 * 
 * 一支弓箭可以沿着 x 轴从不同点完全垂直地射出。在坐标 x 处射出一支箭，若有一个气球的直径的开始和结束坐标为 xstart，xend， 且满足  xstart ≤ x ≤ xend，则该气球会被引爆。可以射出的弓箭的数量没有限制。 弓箭一旦被射出之后，可以无限地前进。
 * 
 * 给你一个数组 points ，返回引爆所有气球所需的 最小 弓箭数。
 * 
 * 示例 1：
 * 输入：points = [[10,16],[2,8],[1,6],[7,12]]
 * 输出：2
 * 解释：气球可以用2支箭来爆破:
 * -在x = 6处射出箭，击破气球[2,8]和[1,6]
 * -在x = 11处射出箭，击破气球[10,16]和[7,12]
 * 
 * 示例 2：
 * 输入：points = [[1,2],[3,4],[5,6],[7,8]]
 * 输出：4
 * 解释：每个气球需要射出一支箭，总共需要4支箭
 * 
 * 示例 3：
 * 输入：points = [[1,2],[2,3],[3,4],[4,5]]
 * 输出：2
 * 解释：气球可以用2支箭来爆破:
 * - 在x = 2处发射箭，击破气球[1,2]和[2,3]
 * - 在x = 4处发射箭，击破气球[3,4]和[4,5]
 * 
 * 提示:
 * 1 <= points.length <= 10⁵
 * points[i].length == 2
 * -2³¹ <= xstart < xend <= 2³¹ - 1
 */
public class L0452_MinimumNumberOfArrowsToBurstBalloons {
    
    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        
        // 按照气球的结束位置排序
        java.util.Arrays.sort(points, (a, b) -> {
            // 注意这里不能直接用减法，因为可能会溢出
            return a[1] < b[1] ? -1 : (a[1] > b[1] ? 1 : 0);
        });
        
        // 至少需要一支箭
        int arrows = 1;
        // 当前箭能够到达的最远位置（第一个气球的结束位置）
        int currentEnd = points[0][1];
        
        // 遍历所有气球
        for (int i = 1; i < points.length; i++) {
            // 如果当前气球的开始位置大于当前箭能到达的位置
            // 说明需要一支新的箭
            if (points[i][0] > currentEnd) {
                arrows++;
                currentEnd = points[i][1];
            }
        }
        
        return arrows;
    }

    public static void main(String[] args) {
        L0452_MinimumNumberOfArrowsToBurstBalloons solution = new L0452_MinimumNumberOfArrowsToBurstBalloons();
        
        // 测试用例 1
        int[][] points1 = {{10,16}, {2,8}, {1,6}, {7,12}};
        System.out.println("测试用例 1 结果：" + solution.findMinArrowShots(points1)); // 预期输出：2
        
        // 测试用例 2
        int[][] points2 = {{1,2}, {3,4}, {5,6}, {7,8}};
        System.out.println("测试用例 2 结果：" + solution.findMinArrowShots(points2)); // 预期输出：4
        
        // 测试用例 3
        int[][] points3 = {{1,2}, {2,3}, {3,4}, {4,5}};
        System.out.println("测试用例 3 结果：" + solution.findMinArrowShots(points3)); // 预期输出：2
    }
} 
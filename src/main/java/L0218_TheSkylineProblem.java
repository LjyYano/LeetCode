import java.util.*;

/**
 * https://leetcode.cn/problems/the-skyline-problem/
 * 
 * 城市的 天际线 是从远处观看该城市中所有建筑物形成的轮廓的外部轮廓。给你所有建筑物的位置和高度，请返回 由这些建筑物形成的 天际线 。
 * 
 * 每个建筑物的几何信息由数组 buildings 表示，其中三元组 buildings[i] = [lefti, righti, heighti] 表示：
 * - lefti 是第 i 座建筑物左边缘的 x 坐标。
 * - righti 是第 i 座建筑物右边缘的 x 坐标。
 * - heighti 是第 i 座建筑物的高度。
 * 
 * 你可以假设所有的建筑都是完美的矩形，在高度为 0 的绝对平坦的表面上。
 * 
 * 天际线 应该表示为由 "关键点" 组成的列表，格式 [[x1,y1],[x2,y2],...] ，并按 x 坐标 进行 排序 。关键点是水平线段的左端点。
 * 列表中最后一个点是最右边建筑物的终点，y 坐标始终为 0 ，仅用于标记天际线的终点。此外，任何两个相邻建筑物之间的地面都应被视为天际线轮廓的一部分。
 * 
 * 注意：输出天际线中不得有连续的相同高度的水平线。例如 [...[2 3], [4 5], [7 5], [11 5], [12 7]...] 是不正确的答案；
 * 三个高度为 5 的线应该在最终输出中合并为一个：[...[2 3], [4 5], [12 7], ...]
 * 
 * 示例 1：
 * ![img](https://assets.leetcode.com/uploads/2020/12/01/merged.jpg)
 * 输入：buildings = [[2,9,10],[3,7,15],[5,12,12],[15,20,10],[19,24,8]]
 * 输出：[[2,10],[3,15],[7,12],[12,0],[15,10],[20,8],[24,0]]
 * 解释：
 * 图 A 显示输入的所有建筑物的位置和高度，
 * 图 B 显示由这些建筑物形成的天际线。图 B 中的红点表示输出列表中的关键点。
 * 
 * 示例 2：
 * 输入：buildings = [[0,2,3],[2,5,3]]
 * 输出：[[0,3],[5,0]]
 * 
 * 提示：
 * - 1 <= buildings.length <= 10⁴
 * - 0 <= lefti < righti <= 2³¹ - 1
 * - 1 <= heighti <= 2³¹ - 1
 * - buildings 按 lefti 非递减排序
 */
public class L0218_TheSkylineProblem {
    
    public List<List<Integer>> getSkyline(int[][] buildings) {
        // 存储结果
        List<List<Integer>> result = new ArrayList<>();
        
        // 存储所有的边界点（包括左边界和右边界）
        List<int[]> points = new ArrayList<>();
        for (int[] building : buildings) {
            // 左边界用负高度表示，右边界用正高度表示
            points.add(new int[]{building[0], -building[2]});
            points.add(new int[]{building[1], building[2]});
        }
        
        // 按照横坐标排序，如果横坐标相同，则按照高度排序
        // 对于左边界（负高度），高的在前；对于右边界（正高度），低的在前
        Collections.sort(points, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });
        
        // 使用优先队列（最大堆）存储当前位置的所有高度
        PriorityQueue<Integer> heights = new PriorityQueue<>((a, b) -> b - a);
        heights.offer(0); // 初始高度为 0
        int prevHeight = 0; // 前一个高度
        
        // 遍历所有边界点
        for (int[] point : points) {
            if (point[1] < 0) {
                // 左边界，加入高度
                heights.offer(-point[1]);
            } else {
                // 右边界，移除高度
                heights.remove(point[1]);
            }
            
            // 当前最大高度
            int currentHeight = heights.peek();
            
            // 如果当前最大高度不等于前一个高度，说明这是一个转折点
            if (currentHeight != prevHeight) {
                result.add(Arrays.asList(point[0], currentHeight));
                prevHeight = currentHeight;
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        L0218_TheSkylineProblem solution = new L0218_TheSkylineProblem();
        
        // 测试用例 1
        int[][] buildings1 = {{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}};
        System.out.println("测试用例 1：");
        System.out.println("输入：" + Arrays.deepToString(buildings1));
        System.out.println("输出：" + solution.getSkyline(buildings1));
        
        // 测试用例 2
        int[][] buildings2 = {{0,2,3},{2,5,3}};
        System.out.println("\n测试用例 2：");
        System.out.println("输入：" + Arrays.deepToString(buildings2));
        System.out.println("输出：" + solution.getSkyline(buildings2));
    }
} 
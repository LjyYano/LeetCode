/**
 * https://leetcode.cn/problems/random-point-in-non-overlapping-rectangles/
 * 
 * 给定一个由非重叠的轴对齐矩形的数组 rects ，其中 rects[i] = [ai, bi, xi, yi] 
 * 表示 (ai, bi) 是第 i 个矩形的左下角点，(xi, yi) 是第 i 个矩形的右上角点。
 * 设计一个算法来随机挑选一个被某一矩形覆盖的整数点。
 * 矩形周边上的点也算做是被矩形覆盖。所有满足要求的点必须等概率被返回。
 * 
 * 在给定的矩形覆盖的空间内的任何整数点都有可能被返回。
 * 
 * 请注意 ，整数点是具有整数坐标的点。
 * 
 * 实现 Solution 类:
 * - Solution(int[][] rects) 用给定的矩形数组 rects 初始化对象。
 * - int[] pick() 返回一个随机的整数点 [u, v] 在给定的矩形所覆盖的空间内。
 * 
 * 示例 1：
 * 输入: 
 * ["Solution", "pick", "pick", "pick", "pick", "pick"]
 * [[[[-2, -2, 1, 1], [2, 2, 4, 6]]], [], [], [], [], []]
 * 输出: 
 * [null, [1, -2], [1, -1], [-1, -2], [-2, -2], [0, 0]]
 * 
 * 解释：
 * Solution solution = new Solution([[-2, -2, 1, 1], [2, 2, 4, 6]]);
 * solution.pick(); // 返回 [1, -2]
 * solution.pick(); // 返回 [1, -1]
 * solution.pick(); // 返回 [-1, -2]
 * solution.pick(); // 返回 [-2, -2]
 * solution.pick(); // 返回 [0, 0]
 * 
 * 提示：
 * - 1 <= rects.length <= 100
 * - rects[i].length == 4
 * - -10^9 <= ai < xi <= 10^9
 * - -10^9 <= bi < yi <= 10^9
 * - xi - ai <= 2000
 * - yi - bi <= 2000
 * - 所有的矩形不重叠。
 * - pick 最多被调用 10^4 次。
 */
import java.util.Random;

public class L0497_RandomPointInNonOverlappingRectangles {
    
    private int[][] rects;
    private int[] prefixSum;
    private Random random;
    
    /**
     * 前缀和 + 二分查找
     * 根据每个矩形包含的点数进行加权随机
     */
    public L0497_RandomPointInNonOverlappingRectangles(int[][] rects) {
        this.rects = rects;
        this.random = new Random();
        this.prefixSum = new int[rects.length];
        
        // 计算前缀和，每个矩形包含的点数
        for (int i = 0; i < rects.length; i++) {
            int count = (rects[i][2] - rects[i][0] + 1) * (rects[i][3] - rects[i][1] + 1);
            prefixSum[i] = (i > 0 ? prefixSum[i - 1] : 0) + count;
        }
    }
    
    public int[] pick() {
        // 随机选择一个点
        int target = random.nextInt(prefixSum[prefixSum.length - 1]) + 1;
        
        // 二分查找确定在哪个矩形中
        int left = 0, right = prefixSum.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (prefixSum[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        int rectIndex = left;
        int[] rect = rects[rectIndex];
        
        // 计算在当前矩形中的偏移量
        int offset = target - (rectIndex > 0 ? prefixSum[rectIndex - 1] : 0) - 1;
        int width = rect[2] - rect[0] + 1;
        
        // 计算具体坐标
        int x = rect[0] + offset % width;
        int y = rect[1] + offset / width;
        
        return new int[]{x, y};
    }

    public static void main(String[] args) {
        int[][] rects = {{-2, -2, 1, 1}, {2, 2, 4, 6}};
        L0497_RandomPointInNonOverlappingRectangles solution = 
            new L0497_RandomPointInNonOverlappingRectangles(rects);
        
        // 测试多次随机选点
        for (int i = 0; i < 5; i++) {
            int[] point = solution.pick();
            System.out.println("[" + point[0] + ", " + point[1] + "]");
        }
    }
}

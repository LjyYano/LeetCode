/**
 * https://leetcode.cn/problems/perfect-rectangle/
 * 
 * 给你一个数组 rectangles ，其中 rectangles[i] = [xi, yi, ai, bi] 表示一个坐标轴平行的矩形。
 * 这个矩形的左下顶点是 (xi, yi) ，右上顶点是 (ai, bi) 。
 * 
 * 如果所有矩形一起精确覆盖了某个矩形区域，则返回 true ；否则，返回 false 。
 * 
 * 示例 1：
 * 输入：rectangles = [[1,1,3,3],[3,1,4,2],[3,2,4,4],[1,3,2,4],[2,3,3,4]]
 * 输出：true
 * 解释：5 个矩形一起可以精确地覆盖一个矩形区域。
 * 
 * 示例 2：
 * 输入：rectangles = [[1,1,2,3],[1,3,2,4],[3,1,4,2],[3,2,4,4]]
 * 输出：false
 * 解释：两个矩形之间有间隔，无法覆盖成一个矩形。
 * 
 * 示例 3：
 * 输入：rectangles = [[1,1,3,3],[3,1,4,2],[1,3,2,4],[2,2,4,4]]
 * 输出：false
 * 解释：因为中间有相交区域，虽然形成了矩形，但不是精确覆盖。
 * 
 * 提示：
 * - 1 <= rectangles.length <= 2 * 10⁴
 * - rectangles[i].length == 4
 * - -10⁵ <= xi, yi, ai, bi <= 10⁵
 */
public class L0391_PerfectRectangle {
    
    public boolean isRectangleCover(int[][] rectangles) {
        // 使用点的出现次数来判断是否是完美矩形
        // 完美矩形的特点：
        // 1. 除了四个顶点外，其他点都应该出现偶数次
        // 2. 所有小矩形的面积和等于最大矩形的面积
        
        // 记录最大矩形的四个顶点坐标
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;
        
        // 使用 String 来存储点的坐标，格式为 "x,y"
        java.util.Set<String> points = new java.util.HashSet<>();
        
        // 计算所有小矩形的面积和
        long area = 0L;
        
        for (int[] rect : rectangles) {
            // 更新最大矩形的顶点坐标
            minX = Math.min(minX, rect[0]);
            minY = Math.min(minY, rect[1]);
            maxX = Math.max(maxX, rect[2]);
            maxY = Math.max(maxY, rect[3]);
            
            // 计算当前矩形的面积
            area += (long) (rect[2] - rect[0]) * (rect[3] - rect[1]);
            
            // 记录当前矩形的四个顶点
            String[] points_rect = new String[]{
                rect[0] + "," + rect[1],  // 左下
                rect[0] + "," + rect[3],  // 左上
                rect[2] + "," + rect[1],  // 右下
                rect[2] + "," + rect[3]   // 右上
            };
            
            // 如果点已经存在，则删除（相当于计数为偶数次）
            // 如果点不存在，则添加（相当于计数为奇数次）
            for (String p : points_rect) {
                if (!points.add(p)) {
                    points.remove(p);
                }
            }
        }
        
        // 检查最终剩下的点是否正好是最大矩形的四个顶点
        if (points.size() != 4) {
            return false;
        }
        
        // 检查这四个点是否是最大矩形的顶点
        return points.contains(minX + "," + minY) &&
               points.contains(minX + "," + maxY) &&
               points.contains(maxX + "," + minY) &&
               points.contains(maxX + "," + maxY) &&
               // 检查面积是否相等
               area == (long) (maxX - minX) * (maxY - minY);
    }

    public static void main(String[] args) {
        L0391_PerfectRectangle solution = new L0391_PerfectRectangle();
        
        // 测试用例 1
        int[][] rectangles1 = {{1,1,3,3},{3,1,4,2},{3,2,4,4},{1,3,2,4},{2,3,3,4}};
        System.out.println("测试用例 1：");
        System.out.println("输入：rectangles = [[1,1,3,3],[3,1,4,2],[3,2,4,4],[1,3,2,4],[2,3,3,4]]");
        System.out.println("输出：" + solution.isRectangleCover(rectangles1));
        System.out.println();
        
        // 测试用例 2
        int[][] rectangles2 = {{1,1,2,3},{1,3,2,4},{3,1,4,2},{3,2,4,4}};
        System.out.println("测试用例 2：");
        System.out.println("输入：rectangles = [[1,1,2,3],[1,3,2,4],[3,1,4,2],[3,2,4,4]]");
        System.out.println("输出：" + solution.isRectangleCover(rectangles2));
        System.out.println();
        
        // 测试用例 3
        int[][] rectangles3 = {{1,1,3,3},{3,1,4,2},{1,3,2,4},{2,2,4,4}};
        System.out.println("测试用例 3：");
        System.out.println("输入：rectangles = [[1,1,3,3],[3,1,4,2],[1,3,2,4],[2,2,4,4]]");
        System.out.println("输出：" + solution.isRectangleCover(rectangles3));
    }
} 
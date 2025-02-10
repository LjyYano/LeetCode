/**
 * https://leetcode.cn/problems/rectangle-area/
 * 
 * 在二维平面上实现一个函数，计算其中两个由直线构成的矩形重叠后形成的总面积。
 * 
 * 每个矩形由其左下顶点和右上顶点坐标表示。
 * 
 * 示例 1：
 * 输入：ax1 = -3, ay1 = 0, ax2 = 3, ay2 = 4, bx1 = 0, by1 = -1, bx2 = 9, by2 = 2
 * 输出：45
 * 
 * 示例 2：
 * 输入：ax1 = -2, ay1 = -2, ax2 = 2, ay2 = 2, bx1 = -2, by1 = -2, bx2 = 2, by2 = 2
 * 输出：16
 * 
 * 提示：
 * -10^4 <= ax1, ay1, ax2, ay2, bx1, by1, bx2, by2 <= 10^4
 */
public class L0223_RectangleArea {

    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        // 计算两个矩形的面积
        int area1 = (ax2 - ax1) * (ay2 - ay1);
        int area2 = (bx2 - bx1) * (by2 - by1);
        
        // 计算重叠区域的坐标
        int overlapX1 = Math.max(ax1, bx1);
        int overlapY1 = Math.max(ay1, by1);
        int overlapX2 = Math.min(ax2, bx2);
        int overlapY2 = Math.min(ay2, by2);
        
        // 计算重叠区域的面积
        int overlapArea = 0;
        if (overlapX2 > overlapX1 && overlapY2 > overlapY1) {
            overlapArea = (overlapX2 - overlapX1) * (overlapY2 - overlapY1);
        }
        
        // 返回总面积 = 两个矩形的面积和 - 重叠区域的面积
        return area1 + area2 - overlapArea;
    }

    public static void main(String[] args) {
        L0223_RectangleArea solution = new L0223_RectangleArea();
        
        // 测试用例 1
        System.out.println(solution.computeArea(-3, 0, 3, 4, 0, -1, 9, 2)); // 预期输出：45
        
        // 测试用例 2
        System.out.println(solution.computeArea(-2, -2, 2, 2, -2, -2, 2, 2)); // 预期输出：16
    }
} 
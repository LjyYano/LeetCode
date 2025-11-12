/**
 * https://leetcode.cn/problems/construct-the-rectangle/
 * 
 * 作为一位web开发者， 懂得怎样去规划一个页面的尺寸是很重要的。
 * 所以，现给定一个具体的矩形页面面积，你的任务是设计一个长度为 L 和宽度为 W 且满足以下要求的矩形的页面。
 * 
 * 要求：
 * 1. 你设计的矩形页面必须等于给定的目标面积。
 * 2. 宽度 W 不应大于长度 L ，换言之，要求 L >= W 。
 * 3. 长度 L 和宽度 W 之间的差距应当尽可能小。
 * 
 * 返回一个 数组 [L, W]，其中 L 和 W 是你按照顺序设计的网页的长度和宽度。
 * 
 * 示例 1：
 * 输入: area = 4
 * 输出: [2,2]
 * 解释: 目标面积是 4， 所有可能的构造方案有 [1,4], [2,2], [4,1]。
 * 但是根据要求2，[1,4] 不符合要求; 根据要求3，[2,2] 比 [4,1] 更能符合要求。所以输出长度 L 为 2， 宽度 W 为 2。
 * 
 * 示例 2：
 * 输入: area = 37
 * 输出: [37,1]
 * 
 * 示例 3：
 * 输入: area = 122122
 * 输出: [427,286]
 * 
 * 提示：
 * - 1 <= area <= 10^7
 */
public class L0492_ConstructTheRectangle {
    
    /**
     * 从平方根开始向下找最接近的因子
     */
    public int[] constructRectangle(int area) {
        // 从 sqrt(area) 开始向下找，找到的第一个因子就是最接近的
        int w = (int) Math.sqrt(area);
        
        // 从 w 开始向下找，找到第一个能整除 area 的数
        while (area % w != 0) {
            w--;
        }
        
        // w 是宽度，area / w 是长度
        return new int[]{area / w, w};
    }

    public static void main(String[] args) {
        L0492_ConstructTheRectangle solution = new L0492_ConstructTheRectangle();
        
        // 测试用例 1
        int[] result1 = solution.constructRectangle(4);
        System.out.println("[" + result1[0] + "," + result1[1] + "]"); // 预期输出：[2,2]
        
        // 测试用例 2
        int[] result2 = solution.constructRectangle(37);
        System.out.println("[" + result2[0] + "," + result2[1] + "]"); // 预期输出：[37,1]
        
        // 测试用例 3
        int[] result3 = solution.constructRectangle(122122);
        System.out.println("[" + result3[0] + "," + result3[1] + "]"); // 预期输出：[427,286]
    }
}

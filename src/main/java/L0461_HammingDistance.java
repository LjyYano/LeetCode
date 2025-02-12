/**
 * https://leetcode.cn/problems/hamming-distance/
 * 
 * 两个整数之间的 汉明距离 指的是这两个数字对应二进制位不同的位置的数目。
 * 给你两个整数 x 和 y，计算并返回它们之间的汉明距离。
 * 
 * 示例 1：
 * 输入：x = 1, y = 4
 * 输出：2
 * 解释：
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 *        ↑   ↑
 * 上面的箭头指出了对应二进制位不同的位置。
 * 
 * 示例 2：
 * 输入：x = 3, y = 1
 * 输出：1
 * 
 * 提示：
 * 0 <= x, y <= 2³¹ - 1
 */
public class L0461_HammingDistance {
    
    public int hammingDistance(int x, int y) {
        // 使用异或运算找出不同的位
        int xor = x ^ y;
        
        // 计算异或结果中 1 的个数
        int distance = 0;
        while (xor != 0) {
            // 如果最后一位是 1，计数加 1
            if ((xor & 1) == 1) {
                distance++;
            }
            // 右移一位
            xor >>= 1;
        }
        
        return distance;
    }

    public static void main(String[] args) {
        L0461_HammingDistance solution = new L0461_HammingDistance();
        
        // 测试用例 1
        int x1 = 1, y1 = 4;
        System.out.println("测试用例 1：");
        System.out.println("输入：x = " + x1 + ", y = " + y1);
        System.out.println("输出：" + solution.hammingDistance(x1, y1));
        System.out.println("预期：2");
        System.out.println();
        
        // 测试用例 2
        int x2 = 3, y2 = 1;
        System.out.println("测试用例 2：");
        System.out.println("输入：x = " + x2 + ", y = " + y2);
        System.out.println("输出：" + solution.hammingDistance(x2, y2));
        System.out.println("预期：1");
    }
} 
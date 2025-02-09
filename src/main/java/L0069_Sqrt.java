/**
 * https://leetcode.cn/problems/sqrtx/
 * 
 * 给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
 * 
 * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
 * 
 * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
 * 
 * 示例 1：
 * 输入：x = 4
 * 输出：2
 * 
 * 示例 2：
 * 输入：x = 8
 * 输出：2
 * 解释：8 的算术平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。
 * 
 * 提示：
 * 0 <= x <= 2³¹ - 1
 */
public class L0069_Sqrt {

    // 使用二分查找法求平方根
    public int mySqrt(int x) {
        // 特殊情况处理
        if (x == 0) {
            return 0;
        }
        if (x == 1) {
            return 1;
        }

        // 二分查找的左右边界
        int left = 1;
        int right = x;

        // 记录结果
        int result = 0;

        // 二分查找
        while (left <= right) {
            // 取中间值
            int mid = left + (right - left) / 2;

            // 计算中间值的平方
            // 注意：这里使用除法而不是乘法，避免溢出
            if (mid <= x / mid) {
                // mid² <= x，记录这个可能的结果
                result = mid;
                // 继续在右半部分查找
                left = mid + 1;
            } else {
                // mid² > x，在左半部分查找
                right = mid - 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        L0069_Sqrt solution = new L0069_Sqrt();

        // 测试用例 1
        int x1 = 4;
        System.out.println("Input: x = " + x1);
        System.out.println("Output: " + solution.mySqrt(x1));
        System.out.println();

        // 测试用例 2
        int x2 = 8;
        System.out.println("Input: x = " + x2);
        System.out.println("Output: " + solution.mySqrt(x2));
        System.out.println();

        // 测试用例 3：边界情况
        int x3 = 0;
        System.out.println("Input: x = " + x3);
        System.out.println("Output: " + solution.mySqrt(x3));
        System.out.println();

        // 测试用例 4：大数
        int x4 = 2147395600;
        System.out.println("Input: x = " + x4);
        System.out.println("Output: " + solution.mySqrt(x4));
    }
} 
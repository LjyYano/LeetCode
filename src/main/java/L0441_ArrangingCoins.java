/**
 * https://leetcode.cn/problems/arranging-coins/
 * 
 * 你总共有 n 枚硬币，并计划将它们按阶梯状排列。对于一个由 k 行组成的阶梯，其第 i 行必须正好有 i 枚硬币。阶梯的最后一行 可能 是不完整的。
 * 给你一个数字 n ，计算并返回可形成 完整阶梯行 的总行数。
 * 
 * 示例 1：
 * 输入：n = 5
 * 输出：2
 * 解释：因为第三行不完整，所以返回 2 。
 * 
 * 示例 2：
 * 输入：n = 8
 * 输出：3
 * 解释：因为第四行不完整，所以返回 3 。
 */
public class L0441_ArrangingCoins {
    
    public int arrangeCoins(int n) {
        // 使用二分查找
        // 第 k 行需要 k 个硬币
        // 前 k 行总共需要 (1 + k) * k / 2 个硬币
        long left = 1, right = n;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            long coins = (1 + mid) * mid / 2;
            
            if (coins == n) {
                return (int) mid;
            } else if (coins < n) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        // 返回 right，因为我们要找的是最后一个完整的行
        return (int) right;
    }

    public static void main(String[] args) {
        L0441_ArrangingCoins solution = new L0441_ArrangingCoins();
        
        // 测试用例1
        int n1 = 5;
        System.out.println("测试用例1：");
        System.out.println("输入：n = " + n1);
        System.out.println("输出：" + solution.arrangeCoins(n1));
        
        // 测试用例2
        int n2 = 8;
        System.out.println("\n测试用例2：");
        System.out.println("输入：n = " + n2);
        System.out.println("输出：" + solution.arrangeCoins(n2));
        
        // 测试用例3：大数测试
        int n3 = 1804289383;
        System.out.println("\n测试用例3：");
        System.out.println("输入：n = " + n3);
        System.out.println("输出：" + solution.arrangeCoins(n3));
    }
} 
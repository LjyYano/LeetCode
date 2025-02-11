/**
 * https://leetcode.cn/problems/elimination-game/
 * 
 * 列表 arr 由在范围 [1, n] 中的所有整数组成，并按严格递增排序。请你对 arr 应用下述算法：
 * 
 * 从左到右，删除第一个数字，然后每隔一个数字删除一个，直到到达列表末尾。
 * 重复上面的步骤，但这次是从右到左。也就是，删除最右侧的数字，然后剩下的数字每隔一个删除一个。
 * 不断重复这两步，从左到右和从右到左交替进行，直到只剩下一个数字。
 * 给你整数 n ，返回 arr 最后剩下的数字。
 * 
 * 示例 1：
 * 输入：n = 9
 * 输出：6
 * 解释：
 * arr = [1, 2, 3, 4, 5, 6, 7, 8, 9]
 * arr = [2, 4, 6, 8]
 * arr = [2, 6]
 * arr = [6]
 * 
 * 示例 2：
 * 输入：n = 1
 * 输出：1
 * 
 * 提示：
 * - 1 <= n <= 10⁹
 */
public class L0390_EliminationGame {
    
    public int lastRemaining(int n) {
        // 使用递归解决
        // 从左到右删除时，第一个数字一定会被删除
        // 从右到左删除时，当数字个数为奇数时，第一个数字一定会被删除
        return leftToRight(n);
    }
    
    private int leftToRight(int n) {
        // 如果只有一个数字，直接返回
        if (n == 1) {
            return 1;
        }
        
        // 从左到右删除后，数字个数减半，每个数字都是原来的 2 倍
        // 然后从右到左进行操作
        return 2 * rightToLeft(n / 2);
    }
    
    private int rightToLeft(int n) {
        // 如果只有一个数字，直接返回
        if (n == 1) {
            return 1;
        }
        
        // 从右到左删除后，如果 n 为奇数，第一个数字会被删除
        // 如果 n 为偶数，第一个数字会保留
        // 然后从左到右进行操作
        if (n % 2 == 0) {
            return 2 * leftToRight(n / 2) - 1;
        } else {
            return 2 * leftToRight(n / 2);
        }
    }

    public static void main(String[] args) {
        L0390_EliminationGame solution = new L0390_EliminationGame();
        
        // 测试用例 1
        int n1 = 9;
        System.out.println("测试用例 1：");
        System.out.println("输入：n = " + n1);
        System.out.println("输出：" + solution.lastRemaining(n1));
        System.out.println();
        
        // 测试用例 2
        int n2 = 1;
        System.out.println("测试用例 2：");
        System.out.println("输入：n = " + n2);
        System.out.println("输出：" + solution.lastRemaining(n2));
        System.out.println();
        
        // 测试用例 3
        int n3 = 100000;
        System.out.println("测试用例 3：");
        System.out.println("输入：n = " + n3);
        System.out.println("输出：" + solution.lastRemaining(n3));
    }
} 
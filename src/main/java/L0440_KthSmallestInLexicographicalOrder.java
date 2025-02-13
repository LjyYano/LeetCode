/**
 * https://leetcode.cn/problems/k-th-smallest-in-lexicographical-order/
 * 
 * 给定整数 n 和 k，返回 [1, n] 中字典序第 k 小的数字。
 * 
 * 示例 1：
 * 输入: n = 13, k = 2
 * 输出: 10
 * 解释: 字典序的排列是 [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9]，所以第二小的数字是 10。
 * 
 * 示例 2：
 * 输入: n = 1, k = 1
 * 输出: 1
 */
public class L0440_KthSmallestInLexicographicalOrder {
    
    public int findKthNumber(int n, int k) {
        // 从 1 开始，因为字典序最小的数字是 1
        int curr = 1;
        // k 需要减 1，因为我们从 1 开始
        k = k - 1;
        
        while (k > 0) {
            // 计算以 curr 为前缀的数字个数
            int steps = calSteps(n, curr, curr + 1);
            
            // 如果 steps <= k，说明第 k 小的数不在以 curr 为前缀的数中
            if (steps <= k) {
                curr++; // 移动到下一个前缀
                k -= steps;
            } else {
                // 如果 steps > k，说明第 k 小的数在以 curr 为前缀的数中
                curr *= 10; // 向下一层移动
                k--;
            }
        }
        
        return curr;
    }
    
    /**
     * 计算在 n 的范围内，以 n1 为前缀的数字个数
     * 例如：n = 100, n1 = 1, n2 = 2
     * 返回的是以 1 为前缀且不超过 100 的数字个数
     */
    private int calSteps(int n, long n1, long n2) {
        int steps = 0;
        
        // 同一层的数字比较
        while (n1 <= n) {
            // 如果 n2 <= n，则当前层的数字都可以取到
            steps += Math.min(n + 1, n2) - n1;
            // 进入下一层
            n1 *= 10;
            n2 *= 10;
        }
        
        return steps;
    }

    public static void main(String[] args) {
        L0440_KthSmallestInLexicographicalOrder solution = new L0440_KthSmallestInLexicographicalOrder();
        
        // 测试用例 1
        int n1 = 13, k1 = 2;
        System.out.println("测试用例 1：");
        System.out.println("输入：n = " + n1 + ", k = " + k1);
        System.out.println("输出：" + solution.findKthNumber(n1, k1));
        
        // 测试用例 2
        int n2 = 1, k2 = 1;
        System.out.println("\n测试用例 2：");
        System.out.println("输入：n = " + n2 + ", k = " + k2);
        System.out.println("输出：" + solution.findKthNumber(n2, k2));
    }
} 
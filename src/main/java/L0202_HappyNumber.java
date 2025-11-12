/**
 * https://leetcode.cn/problems/happy-number/
 * 
 * 编写一个算法来判断一个数 n 是不是快乐数。
 * 
 * 「快乐数」定义为：
 * - 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
 * - 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
 * - 如果这个过程 结果为 1，那么这个数就是快乐数。
 * 
 * 如果 n 是 快乐数 就返回 true ；不是，则返回 false 。
 * 
 * 示例 1：
 * 输入：n = 19
 * 输出：true
 * 解释：
 * 1² + 9² = 82
 * 8² + 2² = 68
 * 6² + 8² = 100
 * 1² + 0² + 0² = 1
 * 
 * 示例 2：
 * 输入：n = 2
 * 输出：false
 * 
 * 提示：
 * - 1 <= n <= 2^31 - 1
 */
import java.util.HashSet;
import java.util.Set;

public class L0202_HappyNumber {
    
    /**
     * 哈希集合解法
     * 使用哈希集合记录已经出现过的数字，如果出现重复说明进入循环
     */
    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        
        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = getNext(n);
        }
        
        return n == 1;
    }
    
    /**
     * 计算各位数字的平方和
     */
    private int getNext(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }
    
    /**
     * 快慢指针解法（推荐）
     * 类似于链表找环，使用快慢指针检测循环
     */
    public boolean isHappyOptimized(int n) {
        int slow = n;
        int fast = getNext(n);
        
        // 快指针每次走两步，慢指针每次走一步
        while (fast != 1 && slow != fast) {
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }
        
        return fast == 1;
    }

    public static void main(String[] args) {
        L0202_HappyNumber solution = new L0202_HappyNumber();
        
        // 测试用例 1
        System.out.println(solution.isHappy(19)); // 预期输出：true
        
        // 测试用例 2
        System.out.println(solution.isHappy(2)); // 预期输出：false
        
        // 使用优化解法测试
        System.out.println(solution.isHappyOptimized(19)); // 预期输出：true
        System.out.println(solution.isHappyOptimized(2)); // 预期输出：false
    }
}

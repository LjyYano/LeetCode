/**
 * https://leetcode.cn/problems/can-i-win/
 * 
 * 在 "100 game" 这个游戏中，两名玩家轮流选择从 1 到 10 的任意整数，累计整数和，先使得累计整数和 达到或超过 100 的玩家，即为胜者。
 * 
 * 如果我们将游戏规则改为 "玩家 不能 重复使用整数" 呢？
 * 
 * 例如，两个玩家可以轮流从公共整数池中抽取从 1 到 15 的整数（不放回），直到累计整数和 >= 100。
 * 
 * 给定两个整数 maxChoosableInteger （整数池中可选择的最大数）和 desiredTotal（累计和），若先出手的玩家是否能稳赢则返回 true ，否则返回 false 。
 * 假设两位玩家游戏时都表现 最佳 。
 * 
 * 示例 1：
 * 输入：maxChoosableInteger = 10, desiredTotal = 11
 * 输出：false
 * 解释：
 * 无论第一个玩家选择哪个整数，他都会失败。
 * 第一个玩家可以选择从 1 到 10 的整数。
 * 如果第一个玩家选择 1，那么第二个玩家只需要选择 10。
 * 第一个玩家必须选择大于等于 2 的整数，因为他选择 1 的话，第二个玩家可以选择 10，然后就会赢。
 * 第二个玩家可以通过选择剩下的任意大于等于 11 - 第一个玩家选择的整数 的整数赢得游戏。
 * 
 * 示例 2：
 * 输入：maxChoosableInteger = 10, desiredTotal = 0
 * 输出：true
 * 
 * 示例 3：
 * 输入：maxChoosableInteger = 10, desiredTotal = 1
 * 输出：true
 * 
 * 提示：
 * 1 <= maxChoosableInteger <= 20
 * 0 <= desiredTotal <= 300
 */
public class L0464_CanIWin {
    
    private Boolean[] memo;
    private int maxChoosableInteger;
    private int desiredTotal;
    
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        this.maxChoosableInteger = maxChoosableInteger;
        this.desiredTotal = desiredTotal;
        
        // 如果所有数字的和都小于目标值，那么没有人能赢
        int sum = (1 + maxChoosableInteger) * maxChoosableInteger / 2;
        if (sum < desiredTotal) {
            return false;
        }
        
        // 如果目标值为 0，先手必胜
        if (desiredTotal <= 0) {
            return true;
        }
        
        // 使用一个整数的二进制位表示数字是否被使用
        // 例如：如果使用了 1 和 3，那么二进制表示为 0b0000...0101
        memo = new Boolean[1 << maxChoosableInteger];
        return dfs(0, 0);
    }
    
    private boolean dfs(int state, int currentSum) {
        // 如果当前状态已经计算过，直接返回结果
        if (memo[state] != null) {
            return memo[state];
        }
        
        // 尝试选择每个数字
        for (int i = 1; i <= maxChoosableInteger; i++) {
            // 计算当前数字对应的二进制位
            int curr = 1 << (i - 1);
            
            // 如果这个数字已经被使用了，跳过
            if ((state & curr) != 0) {
                continue;
            }
            
            // 如果选择这个数字就能达到目标，当前玩家胜利
            if (currentSum + i >= desiredTotal) {
                memo[state] = true;
                return true;
            }
            
            // 如果选择这个数字后，对方不能赢，那么当前玩家胜利
            if (!dfs(state | curr, currentSum + i)) {
                memo[state] = true;
                return true;
            }
        }
        
        // 如果所有选择都不能让当前玩家胜利，那么当前玩家失败
        memo[state] = false;
        return false;
    }

    public static void main(String[] args) {
        L0464_CanIWin solution = new L0464_CanIWin();
        
        // 测试用例 1
        System.out.println("测试用例 1 结果：" + solution.canIWin(10, 11));  // 预期输出：false
        
        // 测试用例 2
        System.out.println("测试用例 2 结果：" + solution.canIWin(10, 0));   // 预期输出：true
        
        // 测试用例 3
        System.out.println("测试用例 3 结果：" + solution.canIWin(10, 1));   // 预期输出：true
    }
} 
/**
 * https://leetcode.cn/problems/nim-game/
 * 
 * 你和你的朋友，两个人一起玩 Nim 游戏：
 * - 桌子上有一堆石头。
 * - 你们轮流进行自己的回合， 你作为先手 。
 * - 每一回合，轮到的人拿掉 1 - 3 块石头。
 * - 拿掉最后一块石头的人就是获胜者。
 * 
 * 假设你们每一步都是最优解。请编写一个函数，来判断你是否可以在给定石头数量为 n 的情况下赢得游戏。如果可以赢，返回 true；否则，返回 false 。
 * 
 * 示例 1：
 * 输入：n = 4
 * 输出：false 
 * 解释：以下是可能的结果:
 * 1. 你移除 1 颗石头。你的朋友移除了 3 颗石头，包括最后一颗。你的朋友赢了。
 * 2. 你移除 2 颗石头。你的朋友移除了 2 颗石头，包括最后一颗。你的朋友赢了。
 * 3. 你移除 3 颗石头。你的朋友移除了 1 颗石头，包括最后一颗。你的朋友赢了。
 * 在所有结果中，你的朋友都赢了。
 * 
 * 示例 2：
 * 输入：n = 1
 * 输出：true
 * 
 * 示例 3：
 * 输入：n = 2
 * 输出：true
 * 
 * 提示：
 * 1 <= n <= 2³¹ - 1
 */
public class L0292_NimGame {
    
    public boolean canWinNim(int n) {
        // 如果石头数量是 4 的倍数，先手必输
        // 否则先手必胜
        return n % 4 != 0;
    }

    public static void main(String[] args) {
        L0292_NimGame solution = new L0292_NimGame();
        
        // 测试用例 1
        System.out.println("n = 4, 是否能赢：" + solution.canWinNim(4));  // 预期输出：false
        
        // 测试用例 2
        System.out.println("n = 1, 是否能赢：" + solution.canWinNim(1));  // 预期输出：true
        
        // 测试用例 3
        System.out.println("n = 2, 是否能赢：" + solution.canWinNim(2));  // 预期输出：true
    }
} 
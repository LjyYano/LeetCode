/**
 * https://leetcode.cn/problems/zuma-game/
 * 
 * 你正在参与祖玛游戏的一个变种。
 * 
 * 在这个祖玛游戏变体中，桌面上有 一排 彩球，每个球的颜色可能是：红色 'R'、黄色 'Y'、
 * 蓝色 'B'、绿色 'G' 或白色 'W' 。你的手中也有一些彩球。
 * 
 * 你的目标是 清空 桌面上所有的球。每一回合：
 * - 从你手上的彩球中选出 任意一颗 ，然后将其插入桌面上那一排球中：两球之间或这一排球的任一端。
 * - 接着，如果有出现 三个或者三个以上 且 颜色相同 的球相连的话，就把它们移除掉。
 *   - 如果这种移除操作同样导致出现三个或者三个以上且颜色相同的球相连，则可以继续移除这些球，直到不再满足移除条件。
 * - 如果桌面上所有球都被移除，则认为你赢得本场游戏。
 * - 重复这个过程，直到你赢了游戏或者手中没有更多的球。
 * 
 * 给你一个字符串 board ，表示桌面上最开始的那排球。另给你一个字符串 hand ，表示手里的彩球。
 * 请你按上述操作步骤移除掉桌上所有球，计算并返回所需的 最少 球数。如果不能移除桌上所有的球，返回 -1 。
 * 
 * 示例 1：
 * 输入：board = "WRRBBW", hand = "RB"
 * 输出：-1
 * 解释：无法移除桌面上的所有球。可以得到的最好局面是：
 * - 插入一个 'R' ，使桌面变为 WRRRBBW 。WRRRBBW -> WBBW
 * - 插入一个 'B' ，使桌面变为 WBBBW 。WBBBW -> WW
 * 还剩下桌面上有球，且手上已经没有球可以插入。
 * 
 * 示例 2：
 * 输入：board = "WWRRBBWW", hand = "WRBRW"
 * 输出：2
 * 解释：要想清空桌面上所有的球，可以按下述步骤：
 * - 插入一个 'R' ，使桌面变为 WWRRRBBWW 。WWRRRBBWW -> WWBBWW
 * - 插入一个 'B' ，使桌面变为 WWBBBWW 。WWBBBWW -> WWWW -> empty
 * 只需从手中出 2 个球就可以清空桌面。
 * 
 * 示例 3：
 * 输入：board = "G", hand = "GGGGG"
 * 输出：2
 * 解释：要想清空桌面上所有的球，可以按下述步骤：
 * - 插入一个 'G' ，使桌面变为 GG
 * - 插入一个 'G' ，使桌面变为 GGG 。GGG -> empty
 * 只需从手中出 2 个球就可以清空桌面。
 * 
 * 提示：
 * - 1 <= board.length <= 16
 * - 1 <= hand.length <= 5
 * - board 和 hand 由字符 'R'、'Y'、'B'、'G' 和 'W' 组成
 * - 桌面上一开始的球中，不会有三个及三个以上颜色相同且连续的球
 */
import java.util.*;

public class L0488_ZumaGame {
    
    public int findMinStep(String board, String hand) {
        // 统计手中每种颜色的球的数量
        int[] handCount = new int[26];
        for (char c : hand.toCharArray()) {
            handCount[c - 'A']++;
        }
        
        int result = dfs(board, handCount);
        return result == Integer.MAX_VALUE ? -1 : result;
    }
    
    private int dfs(String board, int[] hand) {
        // 先消除当前桌面上可以消除的球
        board = eliminate(board);
        
        // 如果桌面为空，返回0
        if (board.isEmpty()) {
            return 0;
        }
        
        int minSteps = Integer.MAX_VALUE;
        
        // 尝试在每个位置插入手中的球
        for (int i = 0; i <= board.length(); i++) {
            for (int j = 0; j < 26; j++) {
                if (hand[j] == 0) continue;
                
                char color = (char) ('A' + j);
                
                // 优化：只在有意义的位置插入
                // 1. 如果当前位置前后字符相同，插入该颜色可能形成连续
                // 2. 如果当前位置是开头或结尾
                boolean shouldInsert = false;
                if (i == 0 || i == board.length()) {
                    shouldInsert = true;
                } else if (i > 0 && board.charAt(i - 1) == color) {
                    shouldInsert = true;
                } else if (i < board.length() && board.charAt(i) == color) {
                    shouldInsert = true;
                }
                
                if (!shouldInsert) continue;
                
                // 插入球
                String newBoard = board.substring(0, i) + color + board.substring(i);
                hand[j]--;
                
                int steps = dfs(newBoard, hand);
                if (steps != Integer.MAX_VALUE) {
                    minSteps = Math.min(minSteps, steps + 1);
                }
                
                hand[j]++;
            }
        }
        
        return minSteps;
    }
    
    /**
     * 消除桌面上三个或以上连续相同颜色的球
     */
    private String eliminate(String board) {
        while (true) {
            StringBuilder sb = new StringBuilder(board);
            boolean eliminated = false;
            
            int i = 0;
            while (i < sb.length()) {
                int j = i;
                while (j < sb.length() && sb.charAt(j) == sb.charAt(i)) {
                    j++;
                }
                
                if (j - i >= 3) {
                    sb.delete(i, j);
                    eliminated = true;
                    break;
                }
                i = j;
            }
            
            if (!eliminated) {
                break;
            }
            board = sb.toString();
        }
        
        return board;
    }

    public static void main(String[] args) {
        L0488_ZumaGame solution = new L0488_ZumaGame();
        
        // 测试用例 1
        System.out.println(solution.findMinStep("WRRBBW", "RB")); // 预期输出：-1
        
        // 测试用例 2
        System.out.println(solution.findMinStep("WWRRBBWW", "WRBRW")); // 预期输出：2
        
        // 测试用例 3
        System.out.println(solution.findMinStep("G", "GGGGG")); // 预期输出：2
    }
}

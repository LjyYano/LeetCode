/**
 * https://leetcode.cn/problems/ipo/
 * 
 * 假设 力扣（LeetCode）即将开始 IPO 。为了以更高的价格将股票卖给风险投资公司，
 * 力扣 希望在 IPO 之前开展一些项目以增加其资本。 由于资源有限，它只能在 IPO 之前完成最多 k 个不同的项目。
 * 帮助 力扣 设计完成最多 k 个不同项目后得到最大总资本的方式。
 * 
 * 给你 n 个项目。对于每个项目 i ，它都有一个纯利润 profits[i] ，和启动该项目需要的最小资本 capital[i] 。
 * 
 * 最初，你的资本为 w 。当你完成一个项目时，你将获得纯利润，且利润将被添加到你的总资本中。
 * 
 * 总而言之，从给定项目中选择 最多 k 个不同项目的列表，以 最大化最终资本 ，并输出最终可获得的最多资本。
 * 
 * 答案保证在 32 位有符号整数范围内。
 * 
 * 示例 1：
 * 输入：k = 2, w = 0, profits = [1,2,3], capital = [0,1,1]
 * 输出：4
 * 解释：
 * 由于你的初始资本为 0，你仅可以从 0 号项目开始。
 * 在完成后，你将获得 1 的利润，你的总资本将变为 1。
 * 此时你可以选择开始 1 号或 2 号项目。
 * 由于你最多可以选择两个项目，所以你需要完成 2 号项目以获得最大的资本。
 * 因此，输出最后最大化的资本，为 0 + 1 + 3 = 4。
 * 
 * 示例 2：
 * 输入：k = 3, w = 0, profits = [1,2,3], capital = [0,1,2]
 * 输出：6
 * 
 * 提示：
 * - 1 <= k <= 10^5
 * - 0 <= w <= 10^9
 * - n == profits.length
 * - n == capital.length
 * - 1 <= n <= 10^5
 * - 0 <= profits[i] <= 10^4
 * - 0 <= capital[i] <= 10^9
 */
import java.util.*;

public class L0502_IPO {
    
    /**
     * 贪心 + 优先队列（堆）
     * 按照资本排序，每次选择当前可以做的项目中利润最大的
     */
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        
        // 创建项目数组，按资本排序
        int[][] projects = new int[n][2];
        for (int i = 0; i < n; i++) {
            projects[i][0] = capital[i];
            projects[i][1] = profits[i];
        }
        Arrays.sort(projects, (a, b) -> a[0] - b[0]);
        
        // 大顶堆，存储利润
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        
        int current = 0;
        for (int i = 0; i < k; i++) {
            // 将所有可以启动的项目的利润加入堆
            while (current < n && projects[current][0] <= w) {
                maxHeap.offer(projects[current][1]);
                current++;
            }
            
            // 如果没有可以做的项目，退出
            if (maxHeap.isEmpty()) {
                break;
            }
            
            // 选择利润最大的项目
            w += maxHeap.poll();
        }
        
        return w;
    }

    public static void main(String[] args) {
        L0502_IPO solution = new L0502_IPO();
        
        // 测试用例 1
        int[] profits1 = {1, 2, 3};
        int[] capital1 = {0, 1, 1};
        System.out.println(solution.findMaximizedCapital(2, 0, profits1, capital1)); 
        // 预期输出：4
        
        // 测试用例 2
        int[] profits2 = {1, 2, 3};
        int[] capital2 = {0, 1, 2};
        System.out.println(solution.findMaximizedCapital(3, 0, profits2, capital2)); 
        // 预期输出：6
    }
}

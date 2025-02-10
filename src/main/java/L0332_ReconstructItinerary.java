/**
 * https://leetcode.cn/problems/reconstruct-itinerary/
 * 
 * 给你一份航线列表 tickets ，其中 tickets[i] = [fromi, toi] 表示飞机出发和降落的机场地点。请你对该行程进行重新规划排序。
 * 
 * 所有这些机票都属于一个从 JFK（肯尼迪国际机场）出发的先生，所以该行程必须从 JFK 开始。如果存在多种有效的行程，请你按字典排序返回最小的行程组合。
 * 
 * 例如，行程 ["JFK", "LGA"] 与 ["JFK", "LGB"] 相比就更小，排序更靠前。
 * 假定所有机票至少存在一种合理的行程。且所有的机票 必须都用一次 且 只能用一次。
 * 
 * 示例 1：
 * 输入：tickets = [["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]]
 * 输出：["JFK","MUC","LHR","SFO","SJC"]
 * 
 * 示例 2：
 * 输入：tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
 * 输出：["JFK","ATL","JFK","SFO","ATL","SFO"]
 * 
 * 提示：
 * 1 <= tickets.length <= 300
 * tickets[i].length == 2
 * fromi.length == 3
 * toi.length == 3
 * fromi 和 toi 由大写英文字母组成
 * fromi != toi
 */

import java.util.*;

public class L0332_ReconstructItinerary {
    
    /**
     * 使用 Hierholzer 算法重建行程
     * 时间复杂度：O(m * log m)，其中 m 是机票的数量
     * 空间复杂度：O(m)，其中 m 是机票的数量
     */
    public List<String> findItinerary(List<List<String>> tickets) {
        // 构建图的邻接表，使用优先队列保证字典序最小
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            graph.computeIfAbsent(from, k -> new PriorityQueue<>()).offer(to);
        }
        
        List<String> itinerary = new ArrayList<>();
        
        // DFS 遍历图
        dfs("JFK", graph, itinerary);
        
        // 由于 DFS 是逆序添加结果，需要反转
        Collections.reverse(itinerary);
        return itinerary;
    }
    
    /**
     * DFS 遍历图，使用 Hierholzer 算法找到欧拉路径
     */
    private void dfs(String curr, Map<String, PriorityQueue<String>> graph, List<String> itinerary) {
        // 遍历当前节点的所有邻居
        PriorityQueue<String> neighbors = graph.get(curr);
        while (neighbors != null && !neighbors.isEmpty()) {
            String next = neighbors.poll();
            dfs(next, graph, itinerary);
        }
        // 将当前节点加入结果
        itinerary.add(curr);
    }

    public static void main(String[] args) {
        L0332_ReconstructItinerary solution = new L0332_ReconstructItinerary();
        
        // 测试用例 1
        System.out.println("测试用例 1：");
        List<List<String>> tickets1 = Arrays.asList(
            Arrays.asList("MUC", "LHR"),
            Arrays.asList("JFK", "MUC"),
            Arrays.asList("SFO", "SJC"),
            Arrays.asList("LHR", "SFO")
        );
        System.out.println("输入：" + tickets1);
        System.out.println("输出：" + solution.findItinerary(tickets1));
        System.out.println("预期输出：[JFK, MUC, LHR, SFO, SJC]");
        System.out.println();
        
        // 测试用例 2
        System.out.println("测试用例 2：");
        List<List<String>> tickets2 = Arrays.asList(
            Arrays.asList("JFK", "SFO"),
            Arrays.asList("JFK", "ATL"),
            Arrays.asList("SFO", "ATL"),
            Arrays.asList("ATL", "JFK"),
            Arrays.asList("ATL", "SFO")
        );
        System.out.println("输入：" + tickets2);
        System.out.println("输出：" + solution.findItinerary(tickets2));
        System.out.println("预期输出：[JFK, ATL, JFK, SFO, ATL, SFO]");
    }
} 
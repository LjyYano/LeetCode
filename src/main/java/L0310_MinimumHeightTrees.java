/*
 * https://leetcode.cn/problems/minimum-height-trees/
 * 
 * 树是一个无向图，其中任何两个顶点只通过一条路径连接。 换句话说，一个任何没有简单环路的连通图都是一棵树。
 * 
 * 给你一棵包含 n 个节点的树，标记为 0 到 n - 1 。给定数字 n 和一个有 n - 1 条无向边的 edges 列表（每一个边都是一对标签），
 * 其中 edges[i] = [ai, bi] 表示树中节点 ai 和 bi 之间存在一条无向边。
 * 
 * 可选择树中任何一个节点作为根。当选择节点 x 作为根节点时，设结果树的高度为 h 。在所有可能的树中，具有最小高度的树（即，min(h)）被称为 最小高度树 。
 * 
 * 请你找到所有的 最小高度树 并按 任意顺序 返回它们的根节点标签列表。
 * 
 * 树的 高度 是指根节点和叶子节点之间最长向下路径上边的数量。
 * 
 * 示例 1：
 * 输入：n = 4, edges = [[1,0],[1,2],[1,3]]
 * 输出：[1]
 * 解释：如图所示，当根是标签为 1 的节点时，树的高度是 1 ，这是唯一的最小高度树。
 * 
 * 示例 2：
 * 输入：n = 6, edges = [[3,0],[3,1],[3,2],[3,4],[5,4]]
 * 输出：[3,4]
 * 
 * 提示：
 * 1 <= n <= 2 * 10⁴
 * edges.length == n - 1
 * 0 <= ai, bi < n
 * ai != bi
 * 所有 (ai, bi) 互不相同
 * 给定的输入 保证 是一棵树，并且 不会有重复的边
 */

import java.util.*;

public class L0310_MinimumHeightTrees {
    
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        // 如果只有一个节点，直接返回该节点
        if (n == 1) {
            return Collections.singletonList(0);
        }
        
        // 构建邻接表
        List<Set<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new HashSet<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        
        // 找到所有叶子节点（度为 1 的节点）
        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (adj.get(i).size() == 1) {
                leaves.add(i);
            }
        }
        
        // 不断删除叶子节点，直到剩下 1 或 2 个节点
        int remainingNodes = n;
        while (remainingNodes > 2) {
            remainingNodes -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            
            // 删除当前所有叶子节点
            for (int leaf : leaves) {
                // 获取叶子节点的邻居（只有一个）
                int neighbor = adj.get(leaf).iterator().next();
                // 从邻居的邻接表中删除该叶子节点
                adj.get(neighbor).remove(leaf);
                // 如果邻居变成了叶子节点，加入新的叶子节点列表
                if (adj.get(neighbor).size() == 1) {
                    newLeaves.add(neighbor);
                }
            }
            
            leaves = newLeaves;
        }
        
        return leaves;
    }

    public static void main(String[] args) {
        L0310_MinimumHeightTrees solution = new L0310_MinimumHeightTrees();
        
        // 测试用例 1
        int[][] edges1 = {{1,0}, {1,2}, {1,3}};
        System.out.println(solution.findMinHeightTrees(4, edges1)); // 应输出 [1]
        
        // 测试用例 2
        int[][] edges2 = {{3,0}, {3,1}, {3,2}, {3,4}, {5,4}};
        System.out.println(solution.findMinHeightTrees(6, edges2)); // 应输出 [3,4]
        
        // 测试用例 3
        int[][] edges3 = {{0,1}};
        System.out.println(solution.findMinHeightTrees(2, edges3)); // 应输出 [0,1]
        
        // 测试用例 4
        System.out.println(solution.findMinHeightTrees(1, new int[][]{})); // 应输出 [0]
    }
} 
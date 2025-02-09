import java.util.*;

/**
 * https://leetcode.cn/problems/clone-graph/
 * 
 * 给你无向 连通 图中一个节点的引用，请你返回该图的 深拷贝（克隆）。
 * 
 * 图中的每个节点都包含它的值 val（int） 和其邻居的列表（list[Node]）。
 * 
 * class Node {
 *     public int val;
 *     public List<Node> neighbors;
 * }
 * 
 * 测试用例格式：
 * 
 * 简单起见，每个节点的值都和它的索引相同。例如，第一个节点值为 1（val = 1），第二个节点值为 2（val = 2），以此类推。该图在测试用例中使用邻接列表表示。
 * 
 * 邻接列表 是用于表示有限图的无序列表的集合。每个列表都描述了图中节点的邻居集。
 * 
 * 给定节点将始终是图中的第一个节点（值为 1）。你必须将 给定节点的拷贝 作为对克隆图的引用返回。
 * 
 * 示例 1：
 * ![img](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2020/02/01/133_clone_graph_question.png)
 * 输入：adjList = [[2,4],[1,3],[2,4],[1,3]]
 * 输出：[[2,4],[1,3],[2,4],[1,3]]
 * 解释：
 * 图中有 4 个节点。
 * 节点 1 的值是 1，它有两个邻居：节点 2 和 4 。
 * 节点 2 的值是 2，它有两个邻居：节点 1 和 3 。
 * 节点 3 的值是 3，它有两个邻居：节点 2 和 4 。
 * 节点 4 的值是 4，它有两个邻居：节点 1 和 3 。
 * 
 * 示例 2：
 * ![img](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2020/02/01/graph.png)
 * 输入：adjList = [[]]
 * 输出：[[]]
 * 解释：输入包含一个空列表。该图仅仅只有一个值为 1 的节点，它没有任何邻居。
 * 
 * 示例 3：
 * 输入：adjList = []
 * 输出：[]
 * 解释：这个图是空的，它不含任何节点。
 * 
 * 示例 4：
 * ![img](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2020/02/01/graph-1.png)
 * 输入：adjList = [[2],[1]]
 * 输出：[[2],[1]]
 * 
 * 提示：
 * - 节点数不超过 100
 * - 每个节点值 Node.val 都是唯一的，1 <= Node.val <= 100
 * - 无向图是一个简单图，这意味着图中没有重复的边，也没有自环。
 * - 由于图是无向的，如果节点 p 是节点 q 的邻居，那么节点 q 也必须是节点 p 的邻居。
 * - 图是连通图，你可以从给定节点访问到所有节点。
 */
public class L0133_CloneGraph {
    
    // 节点定义
    static class Node {
        public int val;
        public List<Node> neighbors;
        
        public Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }
        
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<>();
        }
        
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
    
    // 用于存储已克隆的节点，避免重复克隆
    private Map<Node, Node> visited = new HashMap<>();
    
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        
        // 如果节点已经被访问过，直接返回其克隆节点
        if (visited.containsKey(node)) {
            return visited.get(node);
        }
        
        // 创建新节点
        Node cloneNode = new Node(node.val);
        // 将原节点和克隆节点的对应关系存入 HashMap
        visited.put(node, cloneNode);
        
        // 递归克隆邻居节点
        for (Node neighbor : node.neighbors) {
            cloneNode.neighbors.add(cloneGraph(neighbor));
        }
        
        return cloneNode;
    }

    public static void main(String[] args) {
        L0133_CloneGraph solution = new L0133_CloneGraph();
        
        // 测试用例 1：创建一个简单的无向图
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        
        node1.neighbors.add(node2);
        node1.neighbors.add(node4);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);
        node4.neighbors.add(node1);
        node4.neighbors.add(node3);
        
        Node clonedNode = solution.cloneGraph(node1);
        System.out.println("测试用例 1:");
        System.out.println("原图的第一个节点值: " + node1.val);
        System.out.println("克隆图的第一个节点值: " + clonedNode.val);
        System.out.println("克隆图的第一个节点的邻居数量: " + clonedNode.neighbors.size());
        System.out.println("克隆图的第一个节点的邻居值: " + 
            clonedNode.neighbors.get(0).val + ", " + clonedNode.neighbors.get(1).val);
        System.out.println();
        
        // 测试用例 2：空图
        Node emptyNode = null;
        Node clonedEmptyNode = solution.cloneGraph(emptyNode);
        System.out.println("测试用例 2:");
        System.out.println("空图克隆结果: " + clonedEmptyNode);
        System.out.println();
        
        // 测试用例 3：只有一个节点的图
        Node singleNode = new Node(1);
        Node clonedSingleNode = solution.cloneGraph(singleNode);
        System.out.println("测试用例 3:");
        System.out.println("单节点图的节点值: " + clonedSingleNode.val);
        System.out.println("单节点图的邻居数量: " + clonedSingleNode.neighbors.size());
    }
} 